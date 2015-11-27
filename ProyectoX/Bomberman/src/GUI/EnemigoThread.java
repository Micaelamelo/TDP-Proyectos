package GUI;
import Personajes.*;

/**
 * 
 * Hilo de los movimientos del enemigo mientras estan vivos
 *
 */
public class EnemigoThread extends Thread {
	
	private Enemigo enemigoLogica;
	
	private volatile boolean eDetener;
	
	/**Constructor del hilo
	 * 
	 * @param logica clase Logica del enemigo
	 */
	public EnemigoThread(Enemigo logica){
		enemigoLogica=logica;
		eDetener=false;
	}
	
	/**
	 * Metodo run del hilo
	 */
	public void run(){
		while(!this.eDetener){
			 try {
				Thread.sleep(1000);
				enemigoLogica.mover();
			} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * Detencion del hilo
	 */
	public void detener(){
		eDetener=true;
		interrupt();
	}
	
	/**
	 * 
	 * @return Enemigo que está usando el hilo
	 */
	
	public Enemigo getEnemigo(){
		return enemigoLogica;
	}
	
}
