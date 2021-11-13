package _4_AbstractFactory_Enemies;

import _3_StatePattern.Jugador;

public abstract class Guerrero implements Enemigo{
	
	private Jugador jugador = Jugador.getInstance();
	
	
	
	private int fuerza;
	private int agilidad;
	private int resistencia;
	private int inteligencia;

	private int vida;
	private int vidaActual;
	private int mana;
	private int manaActual;
	private int escudo;
	
	

	public void calcularPuntos() {
		
		int puntosTotales = jugador.getFuerza() + jugador.getAgilidad() + jugador.getInteligencia() + jugador.getResistencia() + jugador.getPuntos();
		int puntosPrincipales = (int) (puntosTotales *0.8);
		
		
		this.fuerza = (puntosPrincipales*randomNumBetweenValues(40,60))/100;
		puntosPrincipales -= fuerza;
		this.resistencia = puntosPrincipales;
		puntosTotales -= puntosPrincipales + fuerza;
		this.agilidad = (puntosTotales*randomNumBetweenValues(50,70))/100;
		puntosTotales -= agilidad;
		this.inteligencia = puntosTotales;
		this.vida = this.resistencia*10;
		this.vidaActual = vida;
		this.mana = this.inteligencia*10;
		this.manaActual = mana;
		this.escudo = 0;
	}
	
	
	private int randomNumBetweenValues(int val1, int val2) {
		int num = (int) (Math.random()*100);
		
		if(num < val1 || num > val2) {
			num = randomNumBetweenValues(val1, val2);
		}
		
		return num;
	}
	
	
	public void estadoGuerrero() {

		System.out.println("vida: " + getVidaActual() + "/" + getVida());
		System.out.println("mana: " + getManaActual() + "/" + getMana());
		System.out.println("escudo: " + getEscudo());
		System.out.println("fuerza: " + getFuerza());
		System.out.println("agilidad: " + getAgilidad());
		System.out.println("resistencia: " + getResistencia());
		System.out.println("inteligencia: " + getInteligencia());

	}
	
	
	
	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = getFuerza() + fuerza;
	}

	public int getAgilidad() {
		return agilidad;
	}

	public void setAgilidad(int agilidad) {
		this.agilidad = getAgilidad() + agilidad;
	}

	public int getMana() {
		return mana;
	}

	public void setMana() {
		this.mana = getInteligencia() * 10;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = getResistencia() + resistencia;
		setVida();
	}

	public int getVida() {
		return vida;
	}

	public void setVida() {
		this.vida = getResistencia() * 10;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = getInteligencia() + inteligencia;
		setMana();
	}


	public int getVidaActual() {
		return vidaActual;
	}


	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}


	public int getManaActual() {
		return manaActual;
	}


	public void setManaActual(int manaActual) {
		this.manaActual = manaActual;
	}

	public int getEscudo() {
		return this.escudo;
	}


	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	
}
