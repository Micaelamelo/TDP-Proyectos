package Mapa;
import Grafica.*;
import Personajes.*;

/**
 * 
 * Clase lógica de Destruible que extiende a pared
 *
 */
public class Destruible extends Pared {

	/**
	 * 
	 * @param c Celda que contiene a la pared
	 */
	   public Destruible(Celda c) {
	    	celda=c;
	    	grafico = new DestruiblesGrafico(celda.getX(), celda.getY());
	    }

	  /**
	   * La celda recibe a Bomberman, que si se encuentra en modo dios (true) puede atravesar las paredes destruibles
	   * @param b Bomberman que recibe la celda 
	   * @param dir Direccion hacia donde se mueve la celda
	   */
	    public void recibirBomberman(Bomberman b, int dir) {
	    	if(b.getModoDios()){
	    		//No esta implementado completamente porque no utilizamos esta clase para este proyecto
	 			celda.setBomberman(b);
	 			b.setCelda(celda, dir);
	 		}
	 		
	 	}
	    /**
	     * La celda recibe al Enemigo, que si se encuentra en modo diois(true) puede atrabesar las paredes destruibles
	     * @param e Enemigo que recibe la celda
	     * @param dir Dieccion hacia donde se mueve el enemigo
	     */
	 	public void recibirEnemigo(Enemigo e, int dir) {
	 		if(e.getModoDios()){
	 			
	 			celda.setEnemigo(e);
	 			e.setCelda(celda, dir);
	 		} 		
	 	}
}