package _5_Singleton_Calculadora;

import _3_StatePattern.Jugador;
import _4_AbstractFactory_Enemies.Enemigo;
import _4_AbstractFactory_Enemies.Guerrero;
import _4_AbstractFactory_Enemies.GuerreroMundoFuego;
import _4_AbstractFactory_Enemies.Mago;
import _4_AbstractFactory_Enemies.MagoMundoFuego;

public class Calculador {

	private static Calculador calculador;
	private Jugador jugador = Jugador.getInstance();

	public static Calculador getInstance() {
		if (calculador != null) {
			return calculador;
		} else {
			return (calculador = new Calculador());
		}
	}

	/**
	 * 
	 * @param enemigo
	 * @param jugador
	 * @param atacante si es false el enemigo ataca, si es true el jugador ataca
	 */
	public void contraataque(Enemigo enemigo, boolean atacante) {
		//
		if (!atacante) {
			if (enemigo instanceof Guerrero) {

				int dano = ((Guerrero) enemigo).getFuerza() - (jugador.getFuerza()) / 4;
				if (dano > 0) {
					if (dano * 3 > jugador.getEscudo()) {

						jugador.setVidaActual(jugador.getEscudo() + (jugador.getVidaActual()) - (dano * 3));
						jugador.setEscudo(0);

					} else {
						jugador.setEscudo(jugador.getEscudo() - dano * 3);
					}

					((Guerrero) enemigo).setVidaActual(((Guerrero) enemigo).getVidaActual() - dano);
					((Guerrero) enemigo).setManaActual(((Guerrero) enemigo).getManaActual() - 2);
				}
				if (enemigo instanceof MagoMundoFuego) {
					jugador.quemarse();
				}

			}

			System.out.println("-----------------------------------------------");
			System.out.println("El enemigo realizo un contraataque");
			System.out.println("-----------------------------------------------");

		} else {

			int dano = (jugador.getFuerza()) - ((enemigo).getFuerza() / 4);
			if (dano > 0) {

				if (dano * 3 > enemigo.getEscudo()) {

					(enemigo).setVidaActual((enemigo).getVidaActual() - (dano * 3));
					enemigo.setEscudo(0);

				} else {
					enemigo.setEscudo(enemigo.getEscudo() - dano * 3);
				}

				jugador.setVidaActual(jugador.getVidaActual() - dano);
				jugador.setManaActual(jugador.getManaActual() - 2);
			}

		}

	}

	public void basico(Enemigo enemigo, boolean atacante) {
		//
		if (!atacante) {

			if (enemigo instanceof Mago) {

				int dano = ((Mago) enemigo).getInteligencia() - (jugador.getInteligencia()) / 4;
				if (dano > 0) {
					if (dano > jugador.getEscudo()) {

						jugador.setVidaActual(jugador.getEscudo() + (jugador.getVidaActual()) - (dano));
						jugador.setEscudo(0);

					} else {
						jugador.setEscudo(jugador.getEscudo() - dano);
					}

				}
				if (enemigo instanceof MagoMundoFuego) {
					jugador.quemarse();
				}

			} else if (enemigo instanceof Guerrero) {

				int dano = ((Guerrero) enemigo).getFuerza() - (jugador.getFuerza()) / 4;
				if (dano > 0) {

					if (dano > jugador.getEscudo()) {

						jugador.setVidaActual(jugador.getEscudo() + jugador.getVidaActual() - dano);
						jugador.setEscudo(0);

					} else {
						jugador.setEscudo(jugador.getEscudo() - dano);
					}

				}
				if (enemigo instanceof GuerreroMundoFuego) {
					jugador.quemarse();
				}

			}

			System.out.println("-----------------------------------------------");
			System.out.println("El enemigo realizo un basico");
			System.out.println("-----------------------------------------------");

		} else {
			int dano = (jugador.getFuerza()) - ((enemigo).getFuerza() / 4);
			if (dano > 0) {

				if (dano > enemigo.getEscudo()) {

					(enemigo).setVidaActual((enemigo).getVidaActual() - dano);
					enemigo.setEscudo(0);

				} else {
					enemigo.setEscudo(enemigo.getEscudo() - dano);
				}

			}

		}

	}

	public void suicida(Enemigo enemigo, boolean atacante) {
		//
		if (!atacante) {

			if (enemigo instanceof Guerrero) {

				int dano = (((Guerrero) enemigo).getFuerza() - jugador.getFuerza()) + (((Guerrero) enemigo).getVida())
						- ((Guerrero) enemigo).getVidaActual();
				if (dano > 0) {

					if (dano > jugador.getEscudo()) {

						jugador.setVidaActual(jugador.getEscudo() + jugador.getVidaActual() - dano);
						jugador.setEscudo(0);

					} else {
						jugador.setEscudo(jugador.getEscudo() - dano);
					}

					((Guerrero) enemigo).setVidaActual(0);

				}

			}

		}

		System.out.println("-----------------------------------------------");
		System.out.println("El enemigo se suicido");
		System.out.println("-----------------------------------------------");

	}

	public void esferaMana(Enemigo enemigo, boolean atacante) {

		if (!atacante) {

			if (enemigo instanceof Mago) {

				int dano = ((Mago) enemigo).getInteligencia() - (jugador.getInteligencia()) / 4;
				if (dano > 0) {

					if (dano * 3 > jugador.getEscudo()) {

						jugador.setVidaActual(jugador.getEscudo() + jugador.getVidaActual() - (dano * 3));
						jugador.setEscudo(0);

					} else {
						jugador.setEscudo(jugador.getEscudo() - dano * 3);
					}

					((Mago) enemigo).setManaActual(((Mago) enemigo).getManaActual() - 7);

				}
				
				if (enemigo instanceof MagoMundoFuego) {
					jugador.quemarse();
				}

			}

			System.out.println("-----------------------------------------------");
			System.out.println("El enemigo lanzo una esfera de mana");
			System.out.println("-----------------------------------------------");

			

		} else {
			int dano = jugador.getInteligencia() - ((enemigo).getInteligencia()) / 4;
			if (dano > 0) {

				if (dano * 3 > (enemigo).getEscudo()) {

					(enemigo).setVidaActual(
							(enemigo).getEscudo() + (enemigo).getVidaActual() - (dano * 3));
					(enemigo).setEscudo(0);

				} else {
					(enemigo).setEscudo(enemigo.getEscudo() - dano * 3);
				}

				jugador.setManaActual(jugador.getManaActual() - 7);

			}
		}

	}

	public void rayoAturdidor(Enemigo enemigo, boolean atacante) {

		if (!atacante) {

			int dano = ((Mago) enemigo).getInteligencia() - (jugador.getInteligencia()) / 4;

			if (dano > 0) {

				if (dano * 2 > jugador.getEscudo()) {
					jugador.aturdirse();
					jugador.setVidaActual(jugador.getEscudo() + jugador.getVidaActual() - (dano * 2));
					jugador.setEscudo(0);

				} else {
					jugador.setEscudo(jugador.getEscudo() - dano * 2);
				}

				((Mago) enemigo).setManaActual(((Mago) enemigo).getManaActual() - 15);
			}

		}

		System.out.println("-----------------------------------------------");
		System.out.println("El enemigo lanzo un rayo aturdidor");
		System.out.println("-----------------------------------------------");

	}

	public void curacion(Enemigo enemigo, boolean atacante) {

		// Ataca enemigo
		if (!atacante) {
			int curacion = (int) (enemigo.getVida() * 0.1);
			enemigo.setVidaActual(enemigo.getVidaActual() + curacion);
			enemigo.setManaActual(enemigo.getManaActual() - 8);

			System.out.println("-----------------------------------------------");
			System.out.println("El enemigo se ha curado");
			System.out.println("-----------------------------------------------");

		} else {// El jugador solo usara la curacion cuando use pociones por eso no gasta mana
			int curacion = (int) (jugador.getVida() * 0.2);
			jugador.setVidaActual(jugador.getVidaActual() + curacion);
		}

	}

	public void escudos(Enemigo enemigo, boolean atacante) {

		if (!atacante) {

			enemigo.setEscudo((int) (enemigo.getEscudo() + (enemigo.getFuerza() + enemigo.getInteligencia()) * 1.5));

			System.out.println("-----------------------------------------------");
			System.out.println("El enemigo se puso escudo");
			System.out.println("-----------------------------------------------");

		} else {

			jugador.setEscudo((int) (jugador.getEscudo() + (jugador.getFuerza() + jugador.getInteligencia()) * 2));

		}

	}

}
