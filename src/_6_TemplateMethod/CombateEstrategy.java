package _6_TemplateMethod;

public interface CombateEstrategy extends EnemigoCombateEstrategia{

	public boolean empezarCombate();
	public void turnoJugador();
	public void turnoEnemigo();
	public void imprimirEstados();
	public void mostrarGanador();
	public Boolean isVencedor();
		
	
	
}
