package _1_strategy_Enemies;

import _4_AbstractFactory_Enemies.Enemigo;

public class Suicida implements TiposEstrategiaEnemigos {

	@Override
	public void estrategia(Enemigo enemigo) {
		

		enemigo.atacar(90);

	}

}
