package Personajes;
import Objetos.*;
import Mapa.*;
import Grafica.*;


import java.util.*;


/**
 *  Clase lógica del enemigo Sirius
 */

public class Sirius extends Enemigo {

	//Necesito saber donde esta bomberman en todo momento para saber adonde ir
	protected Bomberman heroe;
		
	/**
	 * 
	 * @param m Mapa donde esta contenido Sirius
	 * @param c Celda donde estará insertado al comienzo del juego el Sirius
	 */
    public Sirius(Mapa m, Celda c) {
    	super(m,c);
    	velocidad=8;
    	modoDios=false;
    	heroe=m.getBomberman();

        puntosAOtorgar=50;
		grafico = new SiriusGrafico(velocidad, celda.getX(), celda.getY());
    }
    

    /**
     * Movimiento del Sirius, persigue al Bomberman y no puede atravesar paredes
     */
    public void mover() {
    	int dir;
    	int cont;
    	
    	Random rnd= new Random();
    	cont=rnd.nextInt(2);		//Para que el sirius se mueva por si esta siempre queriendo ir al mismo lugar y esta encerrado
    	if(cont==0){
    		dir=obtenerSiguienteCelda();
    	}
    	else {
    		dir=rnd.nextInt(4);
    	}
    		
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
    	
    	//Analizo a la celda vecina
    	Celda next = celda.getVecina(direccion);
	
		if(next != null){
			if(next.getPared()==null)
				next.recibirEnemigo(this,direccion);
			
		}
	}
    /**
     * Calcula la celda mas conveniente para acercarse al heroe
     * @return Un entero con la direccion mas conveniente para acercarse al heroe
     */
    private int obtenerSiguienteCelda(){
    	int aRetornar=0;
    	Celda posB=heroe.getCelda();
    	
    	int compX=posB.getX()-celda.getX();// (+) si heroe esta a la izquierda de Sirius
    	int compY=posB.getY()-celda.getY();// (+) si heroe esta abajo de Sirius
    	
    	//Comparo magnitudes para saber que direccion conviene elegir
    	
    	if(Math.abs(compX)>=Math.abs(compY)){
    		if (compX>=0)
    			aRetornar=3;
    		else
    			aRetornar=2;
    	}
    	else{
    		if(compY>=0)
    			aRetornar=1;
    	}
    	return aRetornar;
    }
    
   /**Setea nueva celda al sirius dependiendo la direccion que tome
    * 
    * @param c Celda nueva a setear
    * @param d direccion que tomara el sirius
    */
	public void setCelda(Celda c, int d) {
		celda=c;
    	this.grafico.mover(d);		
	}

}