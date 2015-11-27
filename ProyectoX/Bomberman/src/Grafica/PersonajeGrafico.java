package Grafica;


import java.awt.Point;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
/**
 * 
 * Clase grafica de los personajes
 *
 */
public abstract class PersonajeGrafico{
	

	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	
	protected JLabel grafico;
	protected Icon image[];
	protected Icon mDestroyedImage;

	protected final int width = 32;
	protected final int height = 32;
	
	protected int velocidad;
	
	protected Point pos;
	/**
	 * 
	 * @param velo Velocidad que tiene el personaje
	 * @param x Columna donde se encuentra el personaje
	 * @param y Fila donde se encuentra el personaje
	 */
	protected PersonajeGrafico(int velo, int x, int y) {
		pos = new Point(x * width, y * height);
		velocidad = velo;
		image = new Icon[4];
	}
	
	/**
	 * 
	 * @return velocidad que tiene el personaje
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * 
	 * @return Punto del mapa donde se encuentra el personaje
	 */
	public Point getPos() {
		return pos;
	}
	
	/**
	 * Dependiendo de la direccion que tome el personaje, la imagen cambiara
	 * @param dir Direccion hacia donde se mueve el personaje
	 */
	
	protected void changeIcon(int dir){
		int direccion = -1;
		
		switch (dir){
			case UP : 
				direccion = 0;
				break;
			case DOWN : 
				direccion = 1;
				break;
			case LEFT : 
				direccion = 2;
				break;
			case RIGHT : 
				direccion = 3;
				break;
		}
		
		this.grafico.setIcon(this.image[direccion]);
	}

	
	/**
	 * Acciones que se realizan y controlan a la hora de que el personaje se mueva en una direccion determinada
	 * @param dir Direccion hacia donde se mueve el personaje
	 */
	public void mover(int dir){
		if(this.grafico != null){
			 this.changeIcon(dir);
			
			try {
				switch (dir){
					case UP : // Arriba
						for(int i = 0; i < this.height; i += this.velocidad){
							this.grafico.setBounds(pos.x, pos.y -= velocidad, width, height);
							Thread.sleep(100);
						}
						break;
					case DOWN : // Abajo
						for(int i = 0; i < this.height; i += this.velocidad){
							this.grafico.setBounds(this.pos.x, this.pos.y += this.velocidad, width, height);
							Thread.sleep(100);
						}
						break;
					case RIGHT : // Derecha
						for(int i = 0; i < this.width; i += this.velocidad){
							this.grafico.setBounds(this.pos.x += this.velocidad, this.pos.y, width, height);
							Thread.sleep(100);
						}
						break;
					case LEFT : // Izquierda
						for(int i = 0; i < this.width; i += this.velocidad){
							this.grafico.setBounds(this.pos.x -= this.velocidad, this.pos.y, width, height);
							Thread.sleep(100);
						}
						break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	 * @return Imagen que tiene el personaje
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	/**
	 * Imagen que aparece en una determinada posicion en el momento que el Bomberman muere
	 * @return JLabel de la imagen en destruccion
	 */
	public JLabel destruir() {
		if(grafico != null){
			grafico.setIcon(this.mDestroyedImage);
			grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		}
		return this.grafico;
	}

}
