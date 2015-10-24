package Juego;
import java.util.Random;

import javax.swing.JFrame;
import Personajes.*;
import Mapa.*;
import GUI.*;

/**
 * 
 * Clase grafica del juego Bomberman
 *
 */
public class Juego {
	
	private Bomberman bomberman;
	private EnemigoThread sirius; //No es utilizada en esta entrega
	private EnemigoThread altair[];
	private EnemigoThread rugulos[];
	
	private int cantEnemigos=6;
	
	private Mapa mapa;
	
	/**
	 * Constructor de la clase Juego
	 * Setea el bomberman en la posicion 1,1
	 * Setea de manera aleatoria a los enemigos Altair y Rugulo
	 * Inserta imagen a las paredes destruibles y no destruibles
	 * Inserta imagen a los enemigos
	 * @param gui Interfaz que se utiliza para construir el juego
	 */
	public Juego(GUI gui){
		mapa= new Mapa();
		
		Celda c= mapa.getCelda(1, 1);
		bomberman= new Bomberman(mapa,c);
		gui.add(bomberman.getGrafico());
		
		altair= new EnemigoThread[2];
		rugulos= new EnemigoThread[3];
		
		//Random Altair
		Random r = new Random();
		Altair a;
		EnemigoThread e;
		int k=0;
		while(k<2){
			int x = r.nextInt(28)+2;
			int y = r.nextInt(10)+2;
			
			c = mapa.getCelda(x, y);
			
			if( c.getPared()==null){
				
				a = new Altair(mapa,c);
				e= new EnemigoThread(a);
			
			altair[k] = e;
			
			c.setEnemigo(a);
			
			gui.add(a.getGrafico());	
			altair[k].start();
			k++;
			}
		}
		
		//Random Rugulo
		Rugulo rug;
		int q=0;
		while(q<3){
			int x = r.nextInt(28)+2;
			int y = r.nextInt(10)+2;
			
			c = mapa.getCelda(x, y);
			
			if(c.getPared()==null){			
				rug = new Rugulo(mapa,c);
				e= new EnemigoThread(rug);
			
				rugulos[q] = e;
			
				c.setEnemigo(rug);
			
				gui.add(rug.getGrafico());	
				rugulos[q].start();
				q++;
			}
		}
			
			//Agrega imagen a paredes no destruibles
			
			for(Celda celd: mapa.getNDestruibles()){
				gui.add(celd.getPared().getGrafico());
			}
			
			//Agrega imagen a paredes destruibles
			
			for(Celda celd: mapa.getDestruibles()){
				gui.add(celd.getPared().getGrafico());
			}
			
			
	}
	/** Metodo que llama al metodo mover de la clase Bomberman
	 * 
	 * @param dir Direccion hacia donde se mueve el personaje que recibe el mensaje
	 */
	
	public void mover(int dir){
		bomberman.mover(dir);
	}
}
