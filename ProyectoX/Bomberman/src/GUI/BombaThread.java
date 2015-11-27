package GUI;

import java.util.ArrayList;

import javax.swing.JLabel;

import Mapa.Celda;
import Objetos.Bomba;
/**
 * 
 * Hilo de la bomba al momento de la explosion
 *
 */
public class BombaThread extends Thread {
	
	protected Bomba bom;
	
	/** Constructor del hilo
	 * 
	 * @param b Bomba a explotar
	 */
	public BombaThread(Bomba b){
		bom=b;
	}
	
	/**
	 * Metodo run del hilo
	 */
	
	public void run(){
		try {
			
			sleep(5000);
			
			ArrayList<JLabel> labels= bom.getMapa().generarExplosion(bom.getCelda(), bom.getAlcance());
			
			sleep(800);
			
			bom.getMapa().getJuego().eliminarExplosiones(labels);
			
			
		} catch (InterruptedException e) {}
	}
	
}
