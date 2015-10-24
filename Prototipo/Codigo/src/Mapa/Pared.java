package Mapa;
import Grafica.*;

import java.util.*;

import javax.swing.JLabel;
import Personajes.*;

/***
 * 
 * Clase lógica de Pared
 *
 */
public abstract class Pared {

    protected Celda celda;
    protected ObjetoGrafico grafico;  
    
    /**
     * Constructor de pared sin parametros
     */
    protected Pared(){
    	grafico=null;
    }
    
    /**
     * 
     * @return Celda que contiene a pared
     */
    
    public Celda getCelda(){
    	return celda;
    }
    
    /**
     * Setea el estado de la celda
     * @param c Celda
     */
    public void setCelda(Celda c){
    	celda=c;
    }
    
    /**
     * 
     * @return Imagen de la pared
     */
    public JLabel getGrafico(){
    	return grafico.getGrafico();
    }
    
    /**
     * 
     * @param b Bomberman que recibe la celda
     * @param dir Direccion hacia donde se mueve el bomberman
     */
    public abstract void recibirBomberman(Bomberman b, int dir);
    
    /**
     * 
     * @param e Enemigo que recibe la celda
     * @param dir Direccion hacia donde se mueve el enemigo
     */
    public abstract void recibirEnemigo(Enemigo e, int dir);
}