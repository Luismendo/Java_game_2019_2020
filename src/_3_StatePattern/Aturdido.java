package _3_StatePattern;

public class Aturdido implements Estados{

	@Override
	public void quemarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Ya esta aturdido no se puede pasar a quemado");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void normalizarse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Se pasa de aturdido a normal");
		System.out.println("-----------------------------------------------");
	}

	@Override
	public void aturdirse() {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------------------------");
		System.out.println("Ya estaba aturdido");
		System.out.println("-----------------------------------------------");
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ATURDIDO";
	}
	

}
