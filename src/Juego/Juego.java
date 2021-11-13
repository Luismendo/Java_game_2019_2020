package Juego;

import _2_Decorator_Weapons.ControlArmas;
import _3_StatePattern.Jugador;
import _4_AbstractFactory_Enemies.Enemigo;
import _4_AbstractFactory_Enemies.FactoryMundoFuego;
import _4_AbstractFactory_Enemies.ManagerFactoryEnemigo;
import _6_TemplateMethod.Combate;
import _6_TemplateMethod.EnemigoCombateEstrategia;

public class Juego {

	public Jugador player;
	public EnemigoCombateEstrategia combate;
	public ManagerFactoryEnemigo manager;
	public ControlArmas control;
	int ronda;

	public Juego() {
		// TODO Auto-generated constructor stub

		player = Jugador.getInstance();
		manager = ManagerFactoryEnemigo.getInstance();// En teoria se inicializa en el mundo normal
		ronda = 1;
	}

	@SuppressWarnings("static-access")
	public void Start() {
		player.estadoJugador();
		this.player.aplicarEstadisticas();
		control = new ControlArmas();
		this.player.estadoJugador();

		do{

			Enemigo enemy;
			if(ronda == 3) {
				manager.setManager(new FactoryMundoFuego());
				enemy = manager.crearEnemigo();
			}else {

				enemy = manager.crearEnemigo();
			}
			this.combate = new Combate(enemy, this.player);

			if (((Combate)this.combate).isVencedor()) {
				System.out.println("Termino el combate, GANASTE");
				control.mejorarArma();
				player.ganarExperiencia(5*ronda);
			} else {
				System.out.println("Termino el combate, PERDISTE");
			}
			ronda++;
		}while (((Combate)this.combate).isVencedor() && ronda < 6);
		if(ronda > 5) {

			System.out.println("Has ganado el juego");
		}else {

			System.out.println("Has perdido el juego."
					+ "YOU ARE A LOOSER, GAME OVER");
		}
	}

}
