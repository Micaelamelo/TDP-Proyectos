package Objetos;
import Grafica.ObjetoGrafico;
import Mapa.*;
import Personajes.*;

/**
 * 
 * Clase lógica del power up PowerUp
 *
 */
public abstract class PowerUp{

    protected int puntosAOtorgar;

    protected Celda celda;

    protected Mapa mapa;
    
    protected ObjetoGrafico grafico;
    
    /**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    protected PowerUp(Mapa m, Celda c) {
        mapa=m;
        celda=c;
        grafico=null;
    }
    
    
    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public abstract void activar(Bomberman b);

    /**
     * 
     * @return cantidad de puntos que otorga el power up al Bomberman
     */
    public int getPuntosAOtorgar() {
        return puntosAOtorgar;
    }
    
    /**
     * 
     * @return Celda donde se encuentra el power up
     */
    public Celda getCelda() { 
        return celda;
    }
    
    /**Setea nueva celda
     * 
     * @param c Celda nueva a setearle al atributo celda
     */
    public void setCelda(Celda c){
    	celda=c;
    }
    
    /**
     * 
     * @return ObjetoGrafico objeto grafico de la bomba
     */
    public ObjetoGrafico getOGrafico(){
    	return grafico;
    }
}