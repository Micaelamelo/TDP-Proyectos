package Mapa;

import Objetos.*;
import Personajes.*;
import Grafica.*;

import java.util.ArrayList;

/**
 * 
 * Clase lógica de Celda
 *
 */
public class Celda{

    protected PowerUp powerUp;
    protected Pared pared;
    protected Bomberman miBomberman;
    protected ArrayList<Enemigo> Enemigos;
    protected Mapa mapa;
    protected Bomba bomba;
    protected int X;
    protected int Y;
 
    /**
     * 
     * @param m Mapa donde se encuentra la celda
     * @param x Numero de columna donde se encuentra la celda
     * @param y Numero de fila donde se encuentra la celda
     */
    public Celda(Mapa m, int x, int y) {
        mapa=m;
        miBomberman=null;
        Enemigos= new ArrayList<Enemigo>();
        pared=null;
        bomba=null;
        powerUp=null;
        X=x;
        Y=y;
    }
    
    /**
     * 
     * @return la columna donde se encuentra la celda
     */
    public int getX(){
    	return X;
    }
    
    /**
     * 
     * @return null si la celda no contiene pared, caso contrario retorna pared destruible o no destruible segun corresponda
     */
    public Pared getPared(){
    	return pared;
    }
    /**
     * 
     * @return la fila donde se encuentra la celda
     */
    public int getY(){
    	return Y;
    }
   
    /**
     * 
     * @return verdadero si la celda contiene power up, caso contrario falso
     */
    public boolean tienePowerUp() {
        return powerUp!=null;
    }

    /** Acciones que controla y realiza la celda a la hora de recibir al jugador Bomberman
     * 
     * @param b Bomberman
     * @param dir Direccion hacia donde se mueve el bomberman
     */
    public void recibirBomberman(Bomberman b,int dir) {
               
    	if(pared==null){
    		if(bomba==null){
    			
    			miBomberman=b;
    			b.getCelda().setBomberman(null);
    			b.setCelda(this,dir);
    			
    			if(powerUp!=null){
    				powerUp.activar(b);
    				powerUp=null;
    			}
    		
    			if(!Enemigos.isEmpty()){
    				mapa.destruirJugador(this);
    				System.out.println("Ha perdido el juego");
    			}
    		}
    	}
    	else{
    		pared.recibirBomberman(b,dir);
    	}
    	
    }
    
    /**
     *  Acciones que controla y realiza la celda a la hora de recibir un enemigo
     * @param e Enemigo que recibe la celda
     * @param dir Direccion hacia donde se mueve el enemigo
     */
    public void recibirEnemigo(Enemigo e,int dir) {
    	if(pared==null){
    		if(bomba==null){
    			Enemigos.add(e);
    			e.getCelda().eliminarEnemigo(e);
    			e.setCelda(this,dir);
    			
 		
    			if(miBomberman!=null){
    				mapa.destruirJugador(this);
    			}
    		}
    	}
    	else
    		pared.recibirEnemigo(e,dir);
    }

    /**
     * 
     * @return power up que contiene la celda, si no contiene power up retorna null
     */
    public PowerUp getPowerUp() {
        return powerUp;
    }
    
    /**
     * 
     * @param p Power up a setear en la celda
     */
    public void setPowerUp(PowerUp p){
    	powerUp=p;
    }
    
    /**
     * 
     * @param e Enemigo a setear en la celda
     */
    public void setEnemigo(Enemigo e){
    	Enemigos.add(e);
    }
    
    public void setBomberman(Bomberman b){
    	miBomberman=b;
    }
    
    /**
     * 
     * @return Bomberman si la celda contiene al jugador, null caso contrario
     */

    public Bomberman getBomberman() {
        return miBomberman;
    }
    
    /**
     * 
     * @return verdadero si la celda no contiene enemigos, falso caso contrario
     */
    public boolean estaVacia(){
    	return Enemigos.isEmpty();
    }
    
    /**
     * 
     * @param e Enemigo a eliminar de la celda
     */
    public void eliminarEnemigo(Enemigo e){
    	
    	Enemigos.remove(e);
    }
    
    /**
     * 
     * @param b Bomba a setear en la celda
     */
    public void setBomba(Bomba b){
    	if(b!=null){
    		bomba=b;
    		mapa.getJuego().añadirBomba(b);
    	}
    	else{
    		 bomba=null;
    	}
    	
    }
    
    /**
     * 
     * @return Arreglo de enemigos que se encuentran en la celda
     */
    
    public ArrayList<Enemigo> getEnemigos(){
    	return Enemigos;
    }
    
    /** Setea el estado de la pared a null, destruible o no destruible
     * 
     * @param p Pared
     */
    public void setPared(Pared p) {
        pared=p;
    }
    
    /**
     * 
     * @param dir Direccion (up, down, right, left)
     * @return Celda que se encuentra en la direccion pasada por parametro
     */
    
    public Celda getVecina(int dir){
		switch (dir){
			case PersonajeGrafico.UP :
				return mapa.getCelda(X, Y - 1);
			case PersonajeGrafico.DOWN :
				return mapa.getCelda(X, Y + 1);
			case PersonajeGrafico.LEFT :
				return mapa.getCelda(X - 1, Y);
			case PersonajeGrafico.RIGHT :
				return mapa.getCelda(X + 1, Y);
		}
		return null;
	}
   
    /**
     * 
     * @return Bomba
     */
    public Bomba getBomba(){
    	return bomba;
    }
    
    /**
     * 
     * @return Mapa
     */
    public Mapa getMapa(){
    	return mapa;
    }
    
    /** Devuelve el primer enemigo de la lista, si esta vacia devolvera el unico elemento de la lista
     * 
     * @return Enemigo
     */
    public Enemigo getPrimerEnemigo(){
    	return Enemigos.get(0);
    }
}