package Model;


import java.util.*;

/**
 * 
 */
public class Mapa {

    /**
     * Default constructor
     */
    public Mapa() {
    }

    /**
     * 
     */
    protected int cantEnemigos;

    /**
     * 
     */
    protected Celda grilla;

    /**
     * 
     */
    protected Tiempo miTiempo;

    /**
     * 
     */
    protected Bomberman miBomberman;

    /**
     * 
     */
    public void Mapa() {
        // TODO implement here
    }

    /**
     * @param Celda d 
     * @return
     */
    public void destruirJugador(Celda d) {
        // TODO implement here
    }

    /**
     * @param Celda d 
     * @return
     */
    public void destruirEnemigo(Celda d) {
        // TODO implement here
    }

    /**
     * @param Celda d 
     * @return
     */
    public void destruirPowerUp(Celda d) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void ganoJuego() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void crearPowerUp() {
        // TODO implement here
    }

    /**
     * @param Celda d 
     * @param int alcance 
     * @return
     */
    public void generarExplosion(Celda d, int alcance) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Tiempo getTiempo() {
        // TODO implement here
        return null;
    }

    /**
     * @param Pared d 
     * @return
     */
    public void destruirPared(Pared d) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getCantEnemigos() {
        // TODO implement here
        return 0;
    }

}