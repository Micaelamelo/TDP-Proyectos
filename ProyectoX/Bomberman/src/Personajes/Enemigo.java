package Personajes;

import Mapa.*;
import java.util.*;
import java.util.Random.*;

/**
 * Clase logica abstracta de Enemigo
 *
 */
public abstract class Enemigo extends Personaje {

    protected int puntosAOtorgar;

    /**Constructor de enemigo
     * 
     * @param m Mapa
     * @param c Celda
     */
    protected Enemigo(Mapa m, Celda c) {
        super(m,c);    	
    }
    
    /**
     * 
     * @return cantidad de puntos a otrogarle al bomberman cuando enemigo muere
     */
    public int getPuntosAOtorgar() {
        return puntosAOtorgar;
    }

    /**
     * Metodo logico de mover del enemigo
     */
    public abstract void mover();
   

}