package Model;

import java.util.*;

/**
 * 
 */
public abstract class Personaje {

    /**
     * Default constructor
     */
    public Personaje() {
    }

    /**
     * 
     */
    protected int velocidad;

    /**
     * 
     */
    protected boolean modoDios;


    /**
     * 
     */
    protected Celda celda;

    /**
     * @param Mapa m 
     * @param int v
     */
    protected void Personaje(Mapa m,int v) {
        // TODO implement here
    }

    /**
     * @return
     */
    public abstract void mover();

    /**
     * @return
     */
    public int getVelocidad() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean getModoDios() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Celda getCelda() {
        // TODO implement here
        return null;
    }

    /**
     * @param Celda c 
     * @return
     */
    public void setCelda(Celda c) {
        // TODO implement here
    }

    /**
     * @param int pos 
     * @return
     */

}