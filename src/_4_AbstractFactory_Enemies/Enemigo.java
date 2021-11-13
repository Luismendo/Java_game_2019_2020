package _4_AbstractFactory_Enemies;

public interface Enemigo {
	

	
	public void atacar(int agresividad);
	public void defenderse(int defensivo);
	public void estado();
	
	
	public int getFuerza();
	public void setFuerza(int fuerza);
	public int getAgilidad();
	public void setAgilidad(int agilidad);
	public int getMana();
	public void setMana();
	public int getResistencia();
	public void setResistencia(int resistencia);
	public int getVida();
	public void setVida();
	public int getInteligencia();
	public void setInteligencia(int inteligencia);
	public int getVidaActual();
	public void setVidaActual(int vidaActual);
	public int getManaActual();
	public void setManaActual(int manaActual);
	public void setEscudo(int escudo);
	public int getEscudo();
	
}
