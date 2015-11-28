package Juego;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Objetos.Bomba;
import Objetos.PowerUp;
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
	private EnemigoThread altair[];
	private EnemigoThread rugulos[];
	private EnemigoThread sirius;
	private SonidoPrincipal sonido;
	
	private int cantEnemigos=6;
	
	private Mapa mapa;
	
	private GUI manejador;
	
	/**
	 * Constructor de la clase Juego
	 * Setea el bomberman en la posicion 1,1
	 * Setea de manera aleatoria a los enemigos Altair y Rugulo
	 * Inserta imagen a las paredes destruibles y no destruibles
	 * Inserta imagen a los enemigos
	 * @param gui Interfaz que se utiliza para construir el juego
	 */
	public Juego(GUI gui){
		mapa= new Mapa(this);
		
		manejador= gui;
			
		Celda c= mapa.getCelda(1, 1);
		bomberman= mapa.getBomberman();
		c.setBomberman(bomberman);
		
		Celda c2=mapa.getCelda(29,11);
		Enemigo sir= new Sirius(mapa,c2);
		sirius= new EnemigoThread(sir);
		c2.setEnemigo(sir);
		
		gui.add(sir.getGrafico());
		gui.add(bomberman.getGrafico());
		
		sirius.start();
		
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
	/** Metodo que devuelve el hilo del enemigo pasado por parametro
	 * 
	 * @param e Enemigo 
	 * @return hilo del enemigo pasado por parametro
	 */
	
	public EnemigoThread getEnemigoThread(Enemigo e){
	EnemigoThread enemigo= null;
	
		if(e.equals(sirius.getEnemigo()))
			enemigo=sirius;
		
		
		for(int i=0; i<altair.length; i++){
			if(altair[i].getEnemigo().equals(e))
				enemigo= altair[i];
		}
		
		for(int i=0; i<rugulos.length; i++){
			if(rugulos[i].getEnemigo().equals(e))
				enemigo= rugulos[i];
		}
		
		
		return enemigo;
	}
	
	/**Envia mensaje a bomberman indicandole la direccion hacia donde se movera
	 * 
	 * @param dir Direccion hacia donde se movera el Bomberman
	 */
	public void mover(int dir){
		bomberman.mover(dir);
	}
	
	/**Devuelve el bomberman del juego
	 * 
	 * @return Bomberman
	 */
	public Bomberman getBomberman(){
		return bomberman;
	}
	
	/**Envia mensaje a la gui para agregar la imagen de la bomba sin explotar
	 * 
	 * @param bomba Bomba que se creo
	 */
	public void añadirBomba(Bomba bomba){
		manejador.add(bomba.getGrafico());
	}
	
	/**Envia mensaje a la gui para agregar la imagen del power up que ha sido encontrado
	 * 
	 * @param p Power up que se encontro
	 */
	public void añadirPowerUp(PowerUp p){
		manejador.add(p.getOGrafico().getGrafico());
	}
	
	/**Envia mensaje a la gui para eliminar la imagen del power up que ha sido tomado por el bomberman
	 * 
	 * @param p Power up que fue tomado
	 */
	public void eliminarPowerUp(PowerUp p){
		manejador.remove(p.getOGrafico().getGrafico());
	}
	
	/**
	 * 
	 * @return GUI
	 */
	
	public GUI getGUI(){
		return manejador;
	}
	
	/**Envia mensaje a la gui
	 * Añade la imagen del bomberman muerto
	 */
	public void bombermanMuerto(){
		manejador.add(bomberman.getPGrafico().destruir());
		bomberman=null;
	}
	
	/**Envia mensaje a la gui para eliminar la imagen de la pared que ha sido destruida
	 * 
	 * @param c Celda a eliminar
	 */
	public void eliminarPared(Celda c){
		manejador.remove(c.getPared().getGrafico());
	}
	
	/**Envia mensaje a la gui para eliminar la imagen del enemigo que ha sido destruido
	 * 
	 * @param e Enemigo a eliminar
	 */
	public void eliminarEnemigo(Enemigo e){
		manejador.remove((e.getGrafico()));
	}
	
	/** Envia mensaje a la gui para agregar imagen de la explosion de la bomba (central y sus adyacentes)
	 * 
	 * @param central Celda central donde esta ubicada la bomba
	 * @param celdas Celdas adyacentes a la central, indicando hasta donde llega la explosion de la bomba
	 * @return Lista de imagenes de la explosion central y sus adyacentes
	 */
	public ArrayList<JLabel> explosionBomba(Celda central, ArrayList<Celda> celdas){
		ArrayList<JLabel> labels= new ArrayList<JLabel>();
		
		central.getBomba().getBGrafico().destruir();
		labels.add(central.getBomba().getGrafico());
		
		sonido= new SonidoPrincipal();
		sonido.bomba();
			
		for(Celda c: celdas){

			if(c.getY()==central.getY() )
				dibujarExplosionH(labels, c, 32,32);
			if(c.getX()==central.getX())
				dibujarExplosionV(labels, c, 32, 32);
		}
		
		return labels;
	}
	
	/**Envia mensaje a la gui para añadir la imagen horizontal de la explosion en la celda c
	 * 
	 * @param labels Lista donde se agrega la nueva imagen añadida
	 * @param c celda a añadir la nueva imagen
	 * @param ancho ancho de la celda
	 * @param alto alto de la celda
	 */
	private void dibujarExplosionH(ArrayList<JLabel> labels, Celda c, int ancho, int alto){
		JLabel etiqueta=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/explosionhorizontal.png")));
		labels.add(etiqueta);
		manejador.add(etiqueta);
		etiqueta.setBounds(c.getX()*alto, c.getY()*ancho, ancho, alto);	
	}
	
	/**Envia mensaje a la gui para añadir la imagen vertical de la explosion en la celda c
	 * 
	 * @param labels Lista donde se agrega la nueva imagen añadida
	 * @param c celda a añadir la nueva imagen
	 * @param ancho ancho de la celda
	 * @param alto alto de la celda
	 */
	private void dibujarExplosionV(ArrayList<JLabel> labels, Celda c, int ancho, int alto){
		
		JLabel etiqueta=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/explosionvertical.png")));
		labels.add(etiqueta);
		manejador.add(etiqueta);
		etiqueta.setBounds(c.getX()*alto, c.getY()*ancho, ancho, alto);	
	}
	
	/**Envia mensaje a la gui para eliminar todos los elementos de la lista celdas
	 * 
	 * @param celdas ArrayList de JLabel 
	 */
	
	public void eliminarExplosiones(ArrayList<JLabel> celdas){
		for(JLabel label: celdas){
			manejador.remove(label);
		}
		manejador.repaint();
	}
	
	/**
	 * 
	 * @return Mapa
	 */
	public Mapa getMapa(){
		return mapa;
	}
}

