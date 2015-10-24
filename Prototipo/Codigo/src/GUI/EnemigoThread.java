package GUI;


import Personajes.*;
import Mapa.*;

public class EnemigoThread extends Thread {
	
	private Enemigo enemigoLogica;
	
	private volatile boolean eDetener;
	
	public EnemigoThread(Enemigo logica){
		enemigoLogica=logica;
		eDetener=false;
	}
	
	public void run(){
		while(!this.eDetener){
			 try {
				 Thread.sleep(1000);
				
				enemigoLogica.mover();
			} catch (InterruptedException e) { }
		}
	}
	
	public void detener(){
		interrupt();
		eDetener=true;
	}
	
	public void destruir(){
		detener();
		enemigoLogica.getMapa().destruirEnemigo(enemigoLogica);
	}
	
	public Enemigo getEnemigo(){
		return enemigoLogica;
	}
	

}
