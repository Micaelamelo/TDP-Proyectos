package Objetos;

import Grafica.BombalityGrafico;
import Grafica.MasacrallityGrafico;
import Mapa.*;
import Personajes.*;

/**
 * 
 * Clase lógica del power up Bombality
 *
 */
public class Bombality extends PowerUp {

	/**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    public Bombality(Mapa m, Celda c) {
    	super(m,c);
    	puntosAOtorgar=35;
    	 grafico= new BombalityGrafico(c.getX(),c.getY());
    }
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public void activar(Bomberman b) {
    	b.aumentarBombas();   	
    	mapa.destruirPowerUp(celda);
    	celda=null;
    	b.aumentarPuntaje(puntosAOtorgar);
    }

}