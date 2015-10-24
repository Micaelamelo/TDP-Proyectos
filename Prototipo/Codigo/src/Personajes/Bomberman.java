package Personajes;

import java.awt.event.KeyEvent;
import java.util.*;

import Mapa.*;
import Grafica.*;
import Objetos.*;

/**
 * 
 * Clase lógica del personaje Bomberman
 *
 */
public class Bomberman extends Personaje {

    protected int cantBombas;
    protected int alcanceExplosion;
    protected int puntaje;
    
    /**
     * 
     * @param m Mapa donde se encuentra el Bomberman
     * @param c Celda donde se encontrara el Bomberman al inicio del juego
     */
    public Bomberman(Mapa m, Celda c) {
        super(m,c);
        cantBombas=1;
        puntaje=0;
        alcanceExplosion=1;
        modoDios=false;
        velocidad=8;
		grafico = new BombermanGrafico(velocidad, celda.getX(), celda.getY());

    }
    
    /** 
     * 	Crea una bomba en una celda con un determinado alcance de explosion
     * 	Dismiunye la cantidad de bombas en 1
     * 	Luego de la explosion cantidad bombas se incrementa en 1
     */
    public void crearBomba() {
    	cantBombas--;
        Bomba b= new Bomba(mapa,alcanceExplosion,celda);
        celda.setBomba(b);
    }
    
    /**
     * Duplica la velocidad del Bomberman
     */
    public void duplicarVelocidad() {
        velocidad=velocidad*2;
    }
    
    /**
     * Aumenta la cantida de bombas en uno (1)
     * 
     */

    public void aumentarBombas() {
       cantBombas++;
    }
    
    /**
     *  Duplica el alcance de la explosion de la bomba
     */
    public void duplicarAlcance() {
        alcanceExplosion=2*alcanceExplosion;
    }

    /**
     * Cambio de atributos al momento que el Bomberman consiga atrapar el power up Masacrallity
     */
    public void masacrallity() {
        modoDios=true;
        cantBombas=99999;
        //No se encuentra totalmente implementado
    }
    
    /**
     * 
     * @return cantidad de bombas disponibles que tiene el Bomberman
     */
    public int bombasDisponibles() {
        return cantBombas;
    }
    
    /**
     * @param c Celda donde se seteara el Bomberman
     * @param dir Direccion hacia donde se movera el Bomberman
     */
    public void setCelda(Celda c, int dir){
    	celda=c;
    	this.grafico.mover(dir);    	
    }

    /**
     * Movimiento lógico del jugador Bomberman
     * 
     * @param dir Direccion hacia donde se movera el Bomberman
     */
    public void mover(int dir){
    Celda next;
		switch (dir){
		case KeyEvent.VK_UP : //Arriba
			next = celda.getVecina(dir);
			
			if(next != null){
				next.recibirBomberman(this,KeyEvent.VK_UP);				
			}
			
			break;
		case KeyEvent.VK_DOWN : //Abajo
			next = celda.getVecina(dir);
			
			if(next != null){
				next.recibirBomberman(this,KeyEvent.VK_DOWN);
			}
			break;
		case KeyEvent.VK_LEFT : //Izquierda
			next = celda.getVecina(dir);
			
			if(next != null){
				next.recibirBomberman(this,KeyEvent.VK_LEFT);
			}
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			
			next = celda.getVecina(dir);
			
			if(next != null){
				next.recibirBomberman(this,KeyEvent.VK_RIGHT);
			}
			
			break;
		}
	}
    
    /**
     * 
     * @return puntaje del Bomberman
     */
	
    public int getPuntaje() {
        return puntaje;
    }
    
    /**
     * 
     * @param p Entero en el cual se incrementara el atributo puntaje
     */

    public void aumentarPuntaje(int p) {
        puntaje=puntaje+p;
    }
    
    /**
     * 
     * @param b setea a verdadero o falso el atributo modoDios
     */
    public void setModoDios(boolean b){
    	modoDios=b;
    }

    
}