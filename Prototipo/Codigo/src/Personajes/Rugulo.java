package Personajes;

import Objetos.*;
import Grafica.*;
import Mapa.*;
import java.util.*;

/**
 * Clase lógica del enemigo Rugulo
 */
public class Rugulo extends Enemigo {
	/**
	 * 
	 * @param m Mapa donde está contenido Rugulo
	 * @param c Celda donde estará Rugulo al comienzo del juego
	 */
    public Rugulo(Mapa m, Celda c) {
        super(m,c);
    	modoDios=false;
        velocidad=1;
       grafico = new RuguloGrafico(velocidad, celda.getX(), celda.getY());

    }
    

    /**
     *  Recibe por parametro la celda nueva a setear y la direccion hacia donde se moverá Rugulo.
     *  Setea la nueva celda al Rugulo dependiendo hacia que dirección se mueva.
     */ 
    
    public void setCelda(Celda c,int dir){
    	celda=c;
    	celda.getEnemigos().remove(this);
    	grafico.mover(dir);
    	
    }
    
    /**
     *  Mueve de manera aleatoria al Rugulo, setea su nueva celda dependiendo la direccion hacia donde se mueva.
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