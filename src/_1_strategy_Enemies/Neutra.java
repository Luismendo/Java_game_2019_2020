package _1_strategy_Enemies;

import _4_AbstractFactory_Enemies.Enemigo;

public class Neutra implements TiposEstrategiaEnemigos {

	@Override
	public void estrategia(Enemigo enemigo) {

		int random = (int) (Math.random() * 100);

		if (random >= 50) {

			enemigo.defenderse(random);

		} else {

			enemigo.atacar(random);
		}

	}

}
