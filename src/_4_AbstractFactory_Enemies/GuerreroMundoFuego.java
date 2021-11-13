package _4_AbstractFactory_Enemies;

import _5_Singleton_Calculadora.Calculador;

public class GuerreroMundoFuego extends Guerrero{
	

	private String caracteristicaEspecial = "";
	Calculador calculadora = Calculador.getInstance();
	
	public GuerreroMundoFuego() {
		
		super.calcularPuntos();
		
	}

	@Override
	public void atacar(int agresividad) {
		
		int random = (int) (Math.random()*100);
		
		if(random < agresividad) {
			//getVida()/15 son un 7.5% de la vida
			if((getVidaActual() < getVida()/15) && (getManaActual()>=3)){
				
				calculadora.suicida(this, false);
				
			}else if(getManaActual()>=2) {
				
				calculadora.contraataque(this, false);
				
			}
			
			else {
				calculadora.basico(this, false);
			}
			
		}else {
			calculadora.basico(this, false);
		}
		
	}

	@Override
	public void defenderse(int defensivo) {
		
		
		int random = (int) (Math.random()*defensivo);
		
		
		if (random >= defensivo/2) {
			
			calculadora.escudos(this, false);
			
		}else {
			
			if((getVidaActual() < getVida()*0.9) && (getManaActual() > 8))
			calculadora.curacion(this, false);
			
		}
		
		
		
	}


	@Override
	public void estado() {
		super.estadoGuerrero();
		
	}

	public String getCaracteristicaEspecial() {
		return caracteristicaEspecial;
	}
	
	
}
