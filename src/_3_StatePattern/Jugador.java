package _3_StatePattern;

import java.util.Scanner;

import _2_Decorator_Weapons.ArmasComponent;
import _4_AbstractFactory_Enemies.Enemigo;
import _5_Singleton_Calculadora.Calculador;

public class Jugador {

	private int fuerza;
	private int agilidad;
	private int resistencia;
	private int inteligencia;

	private int vida;
	private int vidaActual;
	private int mana;
	private int manaActual;

	private int puntos;
	private int experienciaActual;
	private int experienciaNecesaria;
	private int escudo = 0;
	
	private ArmasComponent arma;
	
	static Jugador jugador;

	
	
//	private TiposEstado estado;
	private Estados estado;
	
	Quemado quemado = new Quemado();
	Normal normal = new Normal();
	Aturdido aturdido = new Aturdido();

	
	

	public Jugador(int fuerza, int agilidad, int inteligencia, int resistencia) {
		super();
		this.fuerza = fuerza;
		this.agilidad = agilidad;
		this.resistencia = resistencia;
		this.vida = resistencia * 10;
		this.vidaActual = vida;
		this.inteligencia = inteligencia;
		this.mana = inteligencia * 10;
		this.manaActual = mana;
		this.puntos = 16;
		this.experienciaActual = 0;
		this.experienciaNecesaria = 10;
		this.arma = null;
//		this.estado = new Normal();
		this.estado = normal;
	}

	public Jugador() {
		super();
		this.fuerza = 1;
		this.agilidad = 1;
		this.inteligencia = 1;
		this.resistencia = 1;
		this.vida = resistencia * 10;
		this.vidaActual = vida;
		this.mana = inteligencia * 10;
		this.manaActual = mana;
		this.puntos = 16;
		this.experienciaActual = 0;
		this.experienciaNecesaria = 10;
		this.arma = null;
//		this.estado = new Normal();
		this.estado =  normal;
	}

	public static Jugador getInstance() {
		if (jugador != null) {
			return jugador;
		} else {
			return (jugador = new Jugador());
		}
	}

	public void estadoJugador() {

		System.out.println("Estado: " + getEstado());
		System.out.println("vida: " + getVidaActual() + "/" + getVida());
		System.out.println("mana: " + getManaActual() + "/" + getMana());
		System.out.println("escudo: " + getEscudo());
		System.out.println("fuerza: " + getFuerza());
		System.out.println("agilidad: " + getAgilidad());
		System.out.println("resistencia: " + getResistencia());
		System.out.println("inteligencia: " + getInteligencia());
		System.out.println("experiencia:" + experienciaActual + "/" + experienciaNecesaria);

	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = getFuerza() + fuerza;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = getAgilidad() + agilidad;
	}

	public int getMana() {
		return mana;
	}

	public void setMana() {
		this.mana = getInteligencia() * 10;
		setManaActual(this.mana);

	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = getResistencia() + resistencia;
		setVida();
	}

	public int getVida() {
		return vida;
	}

	public void setVida() {
		this.vida = getResistencia() * 10;
		setVidaActual(this.vida);
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = getInteligencia() + inteligencia;
		setMana();
	}

	public int getPuntos() {
		return puntos;
	}

	public int getExperienciaActual() {
		return experienciaActual;
	}

	public int getExperienciaNecesaria() {
		return experienciaNecesaria;
	}

	public int getEscudo() {
		return escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public int getManaActual() {
		return manaActual;
	}

	public void setManaActual(int manaActual) {
		this.manaActual = manaActual;
	}
	
	
	
	
	public ArmasComponent getArma() {
		return arma;
	}

	public void setArma(ArmasComponent arma) {
		this.arma = arma;
	}
	
	
	
	
	
	
	

	public void atacar(Enemigo enemigo) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Calculador calc = Calculador.getInstance();

		System.out.println("Selecciona el ataque");

		System.out.println("1) Basico");
		System.out.println("2) Contraataque");
		System.out.println("3) Esfera de mana");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			calc.basico(enemigo, true);
			break;
		case 2:
			if(getManaActual() < 2) {
				System.out.println("No tienes mana suficiente");
				atacar(enemigo);
			}else {
				calc.contraataque(enemigo, true);
			}
			break;
		case 3:
			if(getManaActual() > 7) {
				calc.esferaMana(enemigo, true);
			}else {
				System.out.println("No tienes suficiente mana");
				atacar(enemigo);
			}
			break;

		default:
			accion(enemigo);
		}

	}
	
	
	
	public void defender() {

		Calculador c = Calculador.getInstance();
		
		c.escudos(null, true);
		
		
	}
	
	
	
	

	public void accion(Enemigo enemigo) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Selecciona la accion");

		System.out.println("1) Atacar");
		System.out.println("2) Defender");
		System.out.println("3) Otros");
		System.out.println("4) Escapar");

		int opcion = sc.nextInt();

		switch (opcion) {
		case 1:
			atacar(enemigo);
			break;
		case 2:
			defender();
			break;
		case 3:
			otros();
			break;
		case 4:
			//Esta hecho asi para trollear a los jugadores en modo easter egg y que nunca puedan huir de su destino
			System.out.println("¡Vaya...!, el escape ha sido fallido, intentalo de nuevo");
			break;

		default:
			accion(enemigo);
		}

	}
	
	public void otros() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Selecciona la accion");

		System.out.println("1) Pocion de mana");
		int opcion = sc.nextInt();
		
		if(opcion == 1) {
			setManaActual(getMana());
		}else {
			otros();
		}
		
	}

	public void aplicarEstadisticas() {
		Scanner sc = new Scanner(System.in);
		int puntosAtributos;
		boolean salir = false;
		do {
			System.out.println("Selecciona el atributo que quieres aumentar (Te quedan: " + this.puntos + ")");

			System.out.println("1) Fuerza");
			System.out.println("2) Agilidad");
			System.out.println("3) Resistencia");
			System.out.println("4) Inteligencia");
			System.out.println("5) Salir");

			int opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("Cuantos puntos de fuerza quieres meter?");
				puntosAtributos = sc.nextInt();
				if (puntosAtributos <= this.puntos) {
					setFuerza(puntosAtributos);
					this.puntos -= puntosAtributos;
				} else {
					System.err.println("Error: No tienes tantos puntos");
				}
				break;
			case 2:
				System.out.println("Cuantos puntos de agilidad quieres meter?");
				puntosAtributos = sc.nextInt();
				if (puntosAtributos <= this.puntos) {
					setAgilidad(puntosAtributos);
					this.puntos -= puntosAtributos;
				} else {
					System.err.println("Error: No tienes tantos puntos");
				}
				break;
			case 3:
				System.out.println("Cuantos puntos de resistencia quieres meter?");
				puntosAtributos = sc.nextInt();
				if (puntosAtributos <= this.puntos) {
					setResistencia(puntosAtributos);
					this.puntos -= puntosAtributos;
				} else {
					System.err.println("Error: No tienes tantos puntos");
				}
				break;
			case 4:
				System.out.println("Cuantos puntos de inteligencia quieres meter?");
				puntosAtributos = sc.nextInt();
				if (puntosAtributos <= this.puntos) {
					setInteligencia(puntosAtributos);
					this.puntos -= puntosAtributos;
				} else {
					System.err.println("Error: No tienes tantos puntos");
				}
				break;
			case 5:
				salir = true;
				break;

			default:
				break;
			}
		} while (this.puntos > 0 && !salir);

	}

	public void ganarExperiencia(int experiencia) {

		this.experienciaActual += experiencia;
		if (this.experienciaActual >= this.experienciaNecesaria) {
			System.out.println("Subiste de nivel desgraciao");
			if (this.puntos > 10) {
				this.puntos *= 2;
			} else {
				this.puntos += 5;
			}
			aplicarEstadisticas();
			experienciaActual = experienciaActual - experienciaNecesaria;
			experienciaNecesaria *= 1.25;
			setVidaActual(getVida());
		}
	}
	
	
	//-------------------------------------------------------------------------------------//
	
	
	
	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	
	public void quemarse() {
			this.estado.quemarse();
			setEstado(quemado);
	}
	
	public void aturdirse() {

			this.estado.aturdirse();
			setEstado(aturdido);
	}
	
	public void normalizarse() {
			this.estado.normalizarse();
			setEstado(normal);
	}
	

}
