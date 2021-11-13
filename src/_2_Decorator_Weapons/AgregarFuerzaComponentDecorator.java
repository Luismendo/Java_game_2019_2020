package _2_Decorator_Weapons;

public class AgregarFuerzaComponentDecorator implements ArmaComponenDecorator{

	
	private final ArmasComponent arma;
	
	public AgregarFuerzaComponentDecorator() {
		arma = null;
	}
	
	public AgregarFuerzaComponentDecorator(ArmasComponent arma){
		this.arma = arma;
	}

	@Override
	public int getFuerza() {
		// TODO Auto-generated method stub
		return arma.getFuerza()+ 10;
	}

	@Override
	public int getResistencia() {
		// TODO Auto-generated method stub
		return arma.getResistencia();
	}

	@Override
	public int getInteligencia() {
		// TODO Auto-generated method stub
		return arma.getInteligencia();
	}

	@Override
	public ArmasComponent getComponent() {
		// TODO Auto-generated method stub
		return arma;
	}
	
	
	
	
	
}
