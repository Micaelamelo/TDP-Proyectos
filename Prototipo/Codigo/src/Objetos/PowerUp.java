package Objetos;
import Mapa.*;
import Personajes.*;

/**
 * 
 * Clase lógica del power up PowerUp
 *
 */
public abstract class PowerUp{

    protected int puntosAOtorgar;

    protected Celda celda;

    protected Mapa mapa;
    
    /**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    protected PowerUp(Mapa m, Celda c) {
        mapa=m;
        celda=c;
    }
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public abstract void activar(Bomberman b);

    /**
     * 
     * @return cantidad de puntos que otorga el power up al Bomberman
     */
    public int getPuntosAOtorgar() {
        return puntosAOtorgar;
    }
    
    /**
     * 
     * @return Celda donde se encuentra el power up
     */
    public Celda getCelda() {
        return celda;
    }
}