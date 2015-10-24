package Objetos;
import Personajes.*;
import Mapa.*;

/**
 * 
 * Clase lógica del power up Fatallity
 *
 */
public class Fatallity extends PowerUp {


	/**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    public Fatallity(Mapa m, Celda c) {
    	super(m,c);
    	puntosAOtorgar=35;
    }
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public void activar(Bomberman b) {
      mapa.destruirPowerUp(celda);
      celda=null;
      b.duplicarAlcance();
      b.aumentarPuntaje(puntosAOtorgar);
    }

}