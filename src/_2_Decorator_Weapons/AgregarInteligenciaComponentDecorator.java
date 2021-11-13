package _2_Decorator_Weapons;

public class AgregarInteligenciaComponentDecorator implements ArmaComponenDecorator {
	private final ArmasComponent arma;

	public AgregarInteligenciaComponentDecorator() {
		arma = null;
	}

	public AgregarInteligenciaComponentDecorator(ArmasComponent arma) {
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
		return arma.getResistencia();
	}

	@Override
	public int getInteligencia() {
		// TODO Auto-generated method stub
		return arma.getInteligencia() + 10;
	}

	@Override
	public ArmasComponent getComponent() {
		// TODO Auto-generated method stub
		return arma;
	}

}
