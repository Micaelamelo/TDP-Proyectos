package Personajes;
import Objetos.*;
import Mapa.*;
import Grafica.*;


import java.util.*;


/**
 *  Clase lógica del enemigo Sirius
 */

public class Sirius extends Bomberman {


	/** 
	 * Alcance explosion de la bomba
	 */
	protected static int alcanceExplosion=1;
	

	/** cantidad de bombas que Sirius puede poner, siempre va a poner de a una (1) bomba
	 *  
	 */
	protected int cantBombas;
	/**
	 * 
	 * @param m Mapa donde esta contenido Sirius
	 * @param c Celda donde estará insertado al comienzo del juego el Sirius
	 */
    public Sirius(Mapa m, Celda c) {
    	super(m,c);
    	velocidad=3;
    	modoDios=false;
    	cantBombas=1;
		grafico = new SiriusGrafico(velocidad, celda.getX(), celda.getY());

    }
    

    /**
     * Movimiento del Sirius, persigue al Bomberman y no puede atravesar paredes
     */
    public void mover() {
    	//No realizado para la entrega de este proyecto
    }
    

    /**
     * Crea bomba cuyo alcance de explosion siempre será uno (1), cantidad bombas se reduce a 0 y luego de explotar
     * cantidad bombas vuelve a ser uno (1).  
     */ 

    public void crearBomba() {
        Bomba b= new Bomba(mapa,alcanceExplosion,celda);
        celda.setBomba(b);
        cantBombas--;
    }

}