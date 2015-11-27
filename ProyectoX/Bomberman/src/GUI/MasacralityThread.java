package GUI;

import Juego.Juego;
import Mapa.Celda;
import Personajes.Bomberman;
/**
 * 
 * Hilo del power up Masacrality 
 *
 */
public class MasacralityThread extends Thread {
	
	private Juego juego;
	protected Bomberman miBomberman;
	
	/**
	 * Constructor del hilo
	 * @param b Bomberman
	 * @param j Juego
	 */
	public MasacralityThread (Bomberman b, Juego j) {
		miBomberman = b;
		juego = j;
	}
	
	/**
	 * Metodo run del hilo - Duerme por 5 segundos
	 */

	public void run() {
			try {
				int bombas = miBomberman.bombasDisponibles();
				miBomberman.masacrallity();
				Thread.sleep(5000);
				miBomberman.setModoDios(false);
				miBomberman.setBombas(bombas);
				this.interrupt();
			}catch (InterruptedException e) { 
			}		
		}
}