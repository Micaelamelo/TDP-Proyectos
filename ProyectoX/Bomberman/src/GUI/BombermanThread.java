package GUI;

import Juego.Juego;
import Personajes.Enemigo;

/**
 * 
 * Hilo de los movimientos del bomberman mientras esta vivo 
 *
 */
public class BombermanThread extends Thread {
	
	private GUI gui;
	private Juego juego;
	
	private volatile boolean eDetener;
	
	/** Constructor del hilo 
	 * 
	 * @param gui GUI 
	 * @param juego	Juego
	 */
	public BombermanThread(GUI gui, Juego juego){
		this.gui = gui;
		this.juego = juego;
	}
		
	/**
	 * Metodo run del hilo
	 */
	public void run(){
		try {
			
			while(!this.eDetener){
				int dir = this.gui.getNextMov();
				 if(dir != -1){
					 this.juego.mover(dir);
				 }	 
			}
			Thread.sleep(1000);
			
			if(juego.getMapa().getBomberman()==null){
				gui.gameOver();
				gui.getSonidoP().parar();
			}
			else{
				gui.win();
				gui.getSonidoP().parar();
			}
			
			
		} catch (InterruptedException e) {
			
		}
	}
	
	/**
	 * Detiene el hilo
	 */
	public void detener(){
		//interrupt();
		eDetener=true;
	}

}
