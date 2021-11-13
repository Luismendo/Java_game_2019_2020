package _4_AbstractFactory_Enemies;

public class ManagerFactoryEnemigo {


	AbstractEnemyFactory factoryEnemy;
	private static ManagerFactoryEnemigo manager = new ManagerFactoryEnemigo(new FactoryMundoNormal());

	public ManagerFactoryEnemigo(AbstractEnemyFactory factoryEnemy) {
		this.factoryEnemy = factoryEnemy;
	}

	public static ManagerFactoryEnemigo getManager() {
		return manager;
	}

	public void setManager(AbstractEnemyFactory factoryEnemy) {
		this.factoryEnemy = factoryEnemy;
	}

	public static ManagerFactoryEnemigo getInstance() {
		return manager;
	}

	public Enemigo crearEnemigo() {
		
		int random = (int) (Math.random() * 100);
		if (random >= 50) {

			System.out.println("-----------------------------------------------");
			System.out.println("Ha aparecido un guerrero");
			
			return crearGuerrero();
		} else {
			System.out.println("-----------------------------------------------");
			System.out.println("Ha aparecido un mago");
			return crearMago();
		}
		
	}

	private Guerrero crearGuerrero() {

		return this.factoryEnemy.crearGuerrero();
	}

	private Mago crearMago() {

		return this.factoryEnemy.crearMago();
	}

}
