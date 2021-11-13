package _2_Decorator_Weapons;


public class Hacha implements ArmasComponent{

	
	@Override
	public int getFuerza() {
		return 10;
	}

	@Override
	public int getResistencia() {
		return 0;
	}

	@Override
	public int getInteligencia() {
		return 0;
	}

}
