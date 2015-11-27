package Objetos;
import Personajes.*;
import Grafica.FatalityGrafico;
import Grafica.MasacrallityGrafico;
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
    	 grafico= new FatalityGrafico(c.getX(),c.getY());
    }
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public void activar(Bomberman b) {
        b.duplicarAlcance();
    	mapa.destruirPowerUp(celda);
    	celda=null;
    	b.aumentarPuntaje(puntosAOtorgar);
    }

}