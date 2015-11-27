package Objetos;

import GUI.MasacralityThread;
import Grafica.MasacrallityGrafico;
import Mapa.*;
import Personajes.*;

import java.util.*;
/**
 * 
 * Clase lógica del power up Masacrallity
 *
 */
public class Masacrallity extends PowerUp {

	/**
	 * 
	 * @param m Mapa donde se encuentra el power up
	 * @param c Celda donde se crea el power up
	 */
    public Masacrallity( Mapa m, Celda c) {
       super(m,c);
       puntosAOtorgar=50;
       grafico= new MasacrallityGrafico(c.getX(),c.getY());
    }

    /** 
     * Acciones que realiza el power up sobre el Bomberman al momento de recogerlo
     * 
     * @param b Bomberman 
     */
    public void activar(Bomberman b) {
    	MasacralityThread hilo= new MasacralityThread(mapa.getBomberman(),mapa.getJuego());
    	hilo.start();
    	mapa.destruirPowerUp(celda);
    	celda=null;
    	b.aumentarPuntaje(puntosAOtorgar);
    }

}