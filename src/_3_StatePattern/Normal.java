package _3_StatePattern;

public class Normal implements Estados{

	@Override
	public void quemarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Se pasa de normal a quemado");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void normalizarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("ya esta normal");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void aturdirse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Se pasa de normal a aturdido");
		System.out.println("-----------------------------------------------");

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "NORMAL";
	}


}
