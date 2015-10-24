package Mapa;

import Personajes.*;
import Grafica.*;

/**
 * Clase logica de Pared
 *
 */
public class NoDestruible extends Pared {
	
	/**
	 * 
	 * @param c Celda que contiene a la pared no destruible
	 */
    public  NoDestruible(Celda c) {
    	celda=c;
    	grafico = new NoDestruiblesGrafico(celda.getX(), celda.getY());
    }
    
    /**
     *  Metodo que no implementa NoDestruible
     */
 
    public void recibirBomberman(Bomberman p, int dir) {
       
    }
    
    /**
     *  Metodo que no implementa NoDestruible
     */
    public void recibirEnemigo(Enemigo p, int dir) {
        
    }
    
    


}