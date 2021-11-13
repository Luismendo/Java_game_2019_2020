package _2_Decorator_Weapons;

public class AgregarResistenciaComponentDecorator implements ArmaComponenDecorator{

	private final ArmasComponent arma;
	
	public AgregarResistenciaComponentDecorator() {
		arma = null;
	}
	
	public AgregarResistenciaComponentDecorator(ArmasComponent arma){
		this.arma = arma;
	}

	@Override
	public int getFuerza() {
		// TODO Auto-generated method stub
		return arma.getFuerza();
	}

	@Override
	public int getResistencia() {
		// TODO Auto-generated method stub
		return arma.getResistencia()+ 10;
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
