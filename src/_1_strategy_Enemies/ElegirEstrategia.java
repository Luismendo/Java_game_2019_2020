package _1_strategy_Enemies;

import _4_AbstractFactory_Enemies.Enemigo;

public class ElegirEstrategia {
	 private static TiposEstrategiaEnemigos strategy;

	public static TiposEstrategiaEnemigos getStrategy() {
		return strategy;
	}

	public static void setStrategy(TiposEstrategiaEnemigos strategy) {
		ElegirEstrategia.strategy = strategy;
	}

	public static TiposEstrategiaEnemigos crearEstrategiaEnemigo(Enemigo enemigo) {

		int random = (int) (Math.random() * 100);
		

		if (random < 33) {
			System.out.println("Tipo: SUICIDA");
			System.out.println("------------------------");
			strategy = new Suicida();
//			strategy.estrategia(enemigo);
		} else if (random <= 66) {
			System.out.println("Tipo: NEUTRA");
			System.out.println("------------------------");
			strategy = new Neutra();
//			strategy.estrategia(enemigo);
		} else {
			System.out.println("Tipo: DEFENSIVA");
			System.out.println("------------------------");
			strategy = new Defensiva();
//			strategy.estrategia(enemigo);
		}

		return strategy;
		
	}

}
