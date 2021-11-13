package _3_StatePattern;

public class Quemado implements Estados{

	@Override
	public void quemarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Ya estaba quemado, que triste :(");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void normalizarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("se pasa de quemado a normal");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void aturdirse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Ya esta quemado no se puede pasar a aturdido");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "QUEMADO";
	}

}
