package _4_AbstractFactory_Enemies;

import _5_Singleton_Calculadora.Calculador;

public class MagoMundoFuego extends Mago{
	
	Calculador calculadora = Calculador.getInstance();

	public MagoMundoFuego() {

		super.calcularPuntos();

	}

	@Override
	public void atacar(int agresividad) {

		int random = (int) (Math.random() * 100);

		if (random < agresividad) {

			random = (int) (Math.random() * 100);
			// getVida()/15 son un 7.5% de la vida
			if ((getManaActual() >= 7) && (random < 75)) {
				calculadora.esferaMana(this, false);

			} else if (getManaActual() >= 15) {

				calculadora.rayoAturdidor(this, false);

			}

			else {
				calculadora.basico(this, false);
			}

		} else {
			calculadora.basico(this, false);
		}

	}

	@Override
	public void defenderse(int defensivo) {

		int random = (int) (Math.random() * defensivo);

		if (random <= (defensivo/2)) {

			calculadora.escudos(this, false);

		}else {

			if ((getVidaActual() <= getVida() * 0.9) && (getManaActual() >=8)) {
				calculadora.curacion(this, false);
			} else {

				calculadora.escudos(this, false);
			}

		}

	}

	@Override
	public void estado() {
		super.estadoMago();

	}
	
	
}
