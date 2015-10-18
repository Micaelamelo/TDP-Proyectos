package Model;


import java.util.*;

/**
 * 
 */
public abstract class Pared {

    /**
     * Default constructor
     */
    public Pared() {
    }

    /**
     * 
     */
    protected Celda celda;

    /**
     * 
     */
    protected void Pared() {
        // TODO implement here
    }

    /**
     * @param Personaje p 
     * @return
     */
    public abstract void recibirPersonaje(Personaje p);

    /**
     * @return
     */
    public abstract void destruirPared();

}