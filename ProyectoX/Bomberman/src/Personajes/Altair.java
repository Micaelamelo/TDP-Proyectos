package Personajes;
import Mapa.*;
import Grafica.*;
import java.util.Random;

/**
 * 
 * Clase lógica del enemigo Altair
 *
 */
public class Altair extends Enemigo {

	/**
	 * 
	 * @param m Mapa donde se encuentra el enemigo Altair
	 * @param c Celda donde se encontrará Altair a la hora de iniciar el juego.
	 */
    public Altair(Mapa m, Celda c) {
       super(m,c);
       velocidad=2;
       puntosAOtorgar=20;
       modoDios=true;
       grafico = new AltairGrafico(velocidad, celda.getX(), celda.getY());

    }
    
   /**Setea la nueva celda del Altair dependiendo la direccion que tome
    * 
    * @param c Celda hacia donde se movera el Altair
    * @param dir Direccion hacia donde se movera el Altair
    */
   
    public void setCelda(Celda c,int dir){
    
    	celda.getEnemigos().remove(this);
    	celda=c;
    	grafico.mover(dir);
    	
    }
    
    /**
     * Movimiento logico del enemigo Altair
     */
    
    public void mover() {
	Random r = new Random();
		
		int dir = r.nextInt(4);
		
		int direccion = -1;
		switch (dir) {
			case 0 : //Arriba
				direccion = PersonajeGrafico.UP;
				break;
			case 1 : //Abajo
				direccion = PersonajeGrafico.DOWN;
				break;
			case 2 : //Izquierda
				direccion = PersonajeGrafico.LEFT;
				break;
			case 3 : //Derecha
				direccion = PersonajeGrafico.RIGHT;
				break;
		}
		
		Celda next = celda.getVecina(direccion);
		if(next != null){
			next.recibirEnemigo(this,direccion);
		}
		
    }
    
   
}