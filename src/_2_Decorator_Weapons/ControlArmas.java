package _2_Decorator_Weapons;

import java.util.Scanner;

import _3_StatePattern.Jugador;

public class ControlArmas {

	Jugador jugador = Jugador.getInstance();
	
	
	
	public ControlArmas() {
		elegirArma();
	}
	
	
	public void elegirArma() {
		int opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione arma:");

		System.out.println("1) Hacha (+10 daño)");
		System.out.println("2) Espada(+5 daño y +5 resistencia)");
		System.out.println("3) Varita Magica(+10 inteligencia)");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			jugador.setArma(new Hacha());
			jugador.setFuerza(jugador.getArma().getFuerza());
			
			break;

		case 2:

			jugador.setArma(new Espada());
			jugador.setFuerza(jugador.getArma().getFuerza());
			jugador.setResistencia(jugador.getArma().getResistencia());
			break;

		case 3:

			jugador.setArma(new VaritaMagica());
			jugador.setInteligencia(jugador.getArma().getInteligencia());
			break;

		default:
			elegirArma();
		}
		
		
	}
	
	
	public void mejorarArma() {
		int opcion;
		Scanner sc = new Scanner(System.in);
		System.out.println("Seleccione mejora del arma:");

		System.out.println("1) Aumentar daño (+10)");
		System.out.println("2) Aumentar resistencia (+10)");
		System.out.println("3) Aumentar inteligencia (+10)");
		opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			
			jugador.setFuerza(- jugador.getArma().getFuerza());
			jugador.setArma(new AgregarFuerzaComponentDecorator(jugador.getArma()));
			jugador.setFuerza(jugador.getArma().getFuerza());
			break;

		case 2:

			jugador.setResistencia(- jugador.getArma().getResistencia());
			jugador.setArma(new AgregarResistenciaComponentDecorator(jugador.getArma()));
			jugador.setResistencia(jugador.getArma().getResistencia());
			break;

		case 3:

			jugador.setInteligencia(- jugador.getArma().getInteligencia());
			jugador.setArma(new AgregarInteligenciaComponentDecorator(jugador.getArma()));
			jugador.setInteligencia(jugador.getArma().getInteligencia());
			break;

		default:
			mejorarArma();
		}
		
		
	}
	
	
	
}
