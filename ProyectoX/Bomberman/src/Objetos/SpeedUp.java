package Objetos;
import Grafica.MasacrallityGrafico;
import Grafica.SpeedUpGrafico;
import Mapa.*;
import Personajes.*;

/**
 * 
 * Clase lógica del power up SpeedUp
 *
 */
public class SpeedUp extends PowerUp {

	/**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    public SpeedUp ( Mapa m, Celda c) {
    	super(m,c);
    	puntosAOtorgar=30;
    	grafico= new SpeedUpGrafico(c.getX(),c.getY());
    }
    
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    
    public void activar(Bomberman b) {
    	b.duplicarVelocidad();
    	System.out.println(b.getVelocidad());
    	mapa.destruirPowerUp(celda);
    	celda=null;
    	b.aumentarPuntaje(puntosAOtorgar);
    }

   
}