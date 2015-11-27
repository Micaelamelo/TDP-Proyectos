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
	    		b.getCelda().setBomberman(null);
	 			b.setCelda(celda, dir);
	 			celda.setBomberman(b);
	 		}
	 	}
	    /**
	     * La celda recibe al Enemigo, que si se encuentra en modo diois(true) puede atrabesar las paredes destruibles
	     * @param e Enemigo que recibe la celda
	     * @param dir Dieccion hacia donde se mueve el enemigo
	     */
	 	public void recibirEnemigo(Enemigo e, int dir) {
	 		if(e.getModoDios()){	
	 			e.getCelda().eliminarEnemigo(e);
	 			e.setCelda(celda, dir);
	 			celda.setEnemigo(e);
	 		} 		
	 	}
	 	
	 	/**
	 	 * Acciones que realiza la pared al momento en que una explosion de la bomba la destruye
	 	 * Envia mensaje a la gui para remover su imagen
	 	 * Suma puntos al bomberman
	 	 * Celda setea a la pared nula
	 	 * La pared tiene celda nula
	 	 */
	 	
	 	 public void destruirPared() {
	 		 if(celda.getMapa().getBomberman()!=null)
	 			 celda.getMapa().getBomberman().aumentarPuntaje(10);
	         celda.getMapa().getJuego().eliminarPared(celda);
	         celda.setPared(null);
	         celda=null;
	     }
	 	
}