package Model;


import java.util.*;

/**
 * 
 */
public abstract class Enemigo extends Personaje {

    /**
     * Default constructor
     */
    public Enemigo() {
    }

    /**
     * 
     */
    protected int puntosAOtorgar;

    /**
     * @param Mapa m 
     * @param int v
     */
    protected void Enemigo(Mapa m, int v) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getPuntosAOtorgar() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public abstract void mover();

}