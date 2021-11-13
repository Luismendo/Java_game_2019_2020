package _6_TemplateMethod;

import _1_strategy_Enemies.ElegirEstrategia;
import _1_strategy_Enemies.TiposEstrategiaEnemigos;
import _3_StatePattern.Aturdido;

import _3_StatePattern.Jugador;

import _3_StatePattern.Quemado;

import _4_AbstractFactory_Enemies.Enemigo;

public class Combate implements CombateEstrategy {

	Enemigo enemigo;
	Jugador jugador;
	TiposEstrategiaEnemigos estrategia;
	Boolean vencedor; // 1 jugador 0 enemigo
	Boolean inicio;

	String tipo;

	public Combate(Enemigo enemigo, Jugador jugador) {
		this.enemigo = enemigo;
		this.jugador = jugador;
		this.estrategia = ElegirEstrategia.crearEstrategiaEnemigo(enemigo);
		this.vencedor = null;
		gestionCombate();

	}

	public Boolean isVencedor() {
		return vencedor;
	}

	/**
	 *
	 * 
	 */
	public boolean empezarCombate() {

		if (enemigo.getAgilidad() > jugador.getAgilidad()) {
			return true;
		} else {
			return false;
		}

	}

	private void comprobarEstado() {
		if (jugador.getEstado() instanceof Aturdido) {
			int rand = (int) (Math.random() * 100);

			if (rand < 50) {
				turnoJugador();
			}else {
				System.out.println("-----------------------------------------------");
				System.out.println("Estas aturdido no puedes atacar");
				System.out.println("-----------------------------------------------");
				if(rand > 70) {
					jugador.normalizarse();
				}
			}

		}
		
		else if (jugador.getEstado() instanceof Quemado) {
			int rand = (int) (Math.random() * 100);

			if (rand < 50) {
				turnoJugador();
			}else {
				jugador.setVidaActual(jugador.getVidaActual()-5);
				System.out.println("-----------------------------------------------");
				System.out.println("Te has quemado -5HP");
				System.out.println("-----------------------------------------------");
				turnoJugador();
				if(rand > 70) {
					jugador.normalizarse();
				}
			}

		}else {
			turnoJugador();
		}
		
		
	}

	@Override
	public void turnoJugador() {

		System.out.println("Turno del JUGADOR");
		System.out.println();
		System.out.println("-----------------------------------------------");
		jugador.accion(enemigo);
		inicio = true;

	}

	@Override
	public void turnoEnemigo() {
		System.out.println("Turno del ENEMIGO");
		System.out.println();
		System.out.println("-----------------------------------------------");
		estrategia.estrategia(enemigo);
		inicio = false;

	}

	@Override
	public void imprimirEstados() {

		System.out.println("Estado del jugador: ");
		jugador.estadoJugador();
		System.out.println("-----------------------------------------------");

		System.out.println("Estado del enemigo: ");
		enemigo.estado();
		System.out.println("-----------------------------------------------");

	}

	@Override
	public void mostrarGanador() {

		if (jugador.getVidaActual() <= 0) {
			this.vencedor = false;
		} else {
			this.vencedor = true;
		}

	}

	public void gestionCombate() {

		this.inicio = empezarCombate();

		do {
			imprimirEstados();
			if (this.inicio) {
				turnoEnemigo();
			} else {
				comprobarEstado();
			}

		} while ((enemigo.getVidaActual() > 0) && (jugador.getVidaActual() > 0));

		imprimirEstados();
		mostrarGanador();

	}

}
