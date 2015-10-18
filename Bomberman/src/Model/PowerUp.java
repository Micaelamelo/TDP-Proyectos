package Model;


import java.util.*;

/**
 * 
 */
public abstract class PowerUp{

    /**
     * Default constructor
     */
    public PowerUp() {
    }

    /**
     * 
     */
    protected int puntosAOtorgar;




    /**
     * @param Mapa m
     */
    protected void PowerUp(Mapa m) {
        // TODO implement here
    }

    /**
     * @param Bomberman b 
     * @return
     */
    public abstract void activar(Bomberman b);

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
    public Celda getCelda() {
        // TODO implement here
        return null;
    }

}