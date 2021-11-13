package _4_AbstractFactory_Enemies;

public class FactoryMundoFuego implements AbstractEnemyFactory{

	@Override
	public Guerrero crearGuerrero() {
		System.out.println("Es del mundo de FUEGO");
		System.out.println("-----------------------------------------------");
		return new GuerreroMundoFuego();
			
	}

	@Override
	public Mago crearMago() {

		System.out.println("Es del mundo de FUEGO");
		System.out.println("-----------------------------------------------");
		return new MagoMundoFuego();
		
	}

	
	
	
	
}
