package Model;


import java.util.*;

/**
 * 
 */
public class Celda{

    /**
     * Default constructor
     */
    public Celda() {
    }


    /**
     * 
     */
    protected PowerUp powerUp;


    /**
     * @param Mapa m 
     * @param PowerUp p
     */
    public void Celda(Mapa m, PowerUp p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean tienePowerUp() {
        // TODO implement here
        return false;
    }

    /**
     * @param Bomberman b 
     * @return
     */
    public void recibirBomberman(Bomberman b) {
        // TODO implement here
    }

    /**
     * @param Enemigo e 
     * @return
     */
    public void recibirEnemigo(Enemigo e) {
        // TODO implement here
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Bomberman getBomberman() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Enemigo getEnemigo() {
        // TODO implement here
        return null;
    }

    /**
     * @param Pared p 
     * @return
     */
    public void setPared(Pared p) {
        // TODO implement here
    }

}