package Objetos;

import javax.swing.JLabel;

import GUI.BombaThread;
import Grafica.BombaGrafico;
import Grafica.ObjetoGrafico;
import Mapa.*;

/**
 * 
 * Clase lógica de la Bomba
 *
 */
public class Bomba{


    protected int alcanceBomba;
    protected Mapa mapa;
    protected Celda celda;
    protected ObjetoGrafico bombaGrafica;
   
    /**
     * 
     * @param m Mapa donde se encontrará la bomba
     * @param alcance Alcance de la bomba 
     * @param c Celda donde se crea la bomba
     */
    public Bomba(Mapa m, int alcance, Celda c) {  	
       mapa=m;
       celda=c;
       bombaGrafica= new BombaGrafico(c.getX(),c.getY());
       alcanceBomba=alcance;
       celda.setBomba(this);
       BombaThread bombahilo= new BombaThread(this);
       bombahilo.start();

    }
    
    /**
     * 
     * @return Mapa
     */
    public Mapa getMapa(){
    	return mapa;
    }
    
   /**
    * 
    * @return Alcance de la explosion de la bomba
    */
    public int getAlcance() {
        return alcanceBomba;
    }
    
    /**
     * 
     * @return Celda donde se creó la bomba
     */
 
    public Celda getCelda() {
    	return celda;
    }
    
    /**
     * 
     * @return JLabel de la bomba
     */
    
    public JLabel getGrafico(){
    	return bombaGrafica.getGrafico();
    	
    }
    
    
    /**
     * 
     * @return ObjetoGrafico objeto grafico de la bomba
     */
    public ObjetoGrafico getBGrafico(){
    	return bombaGrafica;
    }
}