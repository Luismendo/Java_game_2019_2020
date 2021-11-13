package _4_AbstractFactory_Enemies;

public class FactoryMundoNormal implements AbstractEnemyFactory{
	
	

	@Override
	public Guerrero crearGuerrero() {

		System.out.println("Es del mundo NORMAL");
		System.out.println("-----------------------------------------------");
		return new GuerreroMundoNormal();
			
	}

	@Override
	public Mago crearMago() {

		System.out.println("Es del mundo de NORMAL");
		System.out.println("-----------------------------------------------");
		return new MagoMundoNormal();
		
	}

	
	
	
	
}
