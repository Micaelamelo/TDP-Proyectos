package Grafica;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 
 * Clase grafica de los Objetos (Pared destruible y no destruible)
 *
 */
public abstract class ObjetoGrafico {

	protected JLabel grafico;
	protected Icon image[];
	protected Point pos;
	protected final int width = 32;
	protected final int height = 32;
	
	/**
	 * 
	 * @param x Columna donde se encuentra el objeto
	 * @param y Fila donde se encuentra el objeto
	 */
	protected ObjetoGrafico(int x, int y){
		pos = new Point(x * width, y * height);	
		image = new Icon[4];	
	}
	
	/**
	 * 
	 * @return Punto del mapa donde se encuentra el objeto
	 */
	public Point getPos() {
		return pos;
	}
	
	/**
	 * 
	 * @return Imagen del objeto en la determinada posicion
	 */
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}
	
	/**
	 * 
	 * Imagen del objeto cuando se destruye
	 */
	
	public void destruir() {
		if(grafico != null){
			grafico.setIcon(image[1]);
			grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		}
	}
	
	/**
	 * Imagen de la explosion de la bomba cuando hay una imagen (sentido horizontal)
	 */
	public void cambiarHorizontal(){
		
			grafico.setIcon(image[2]);
			grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		
	}
	
	/**
	 * Imagen de la explosion de la bomba cuando no hay una imagen (sentido horizontal)
	 * @return Jlabel de la explosion
	 */
	public JLabel agregarHorizontal(){
		
			grafico= new JLabel(image[2]);
			grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);

		return this.grafico;
	}
	
	/**
	 * Imagen de la explosion de la bomba cuando hay una imagen (sentido vertical)
	 */
	public void cambiarVertical(){
		grafico.setIcon(image[3]);
		grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		
	}
	
	/**
	 * Imagen de la explosion de la bomba cuando no hay una imagen (sentido vertical)
	 * @return Jlabel de la explosion 
	 */
	public JLabel agregarVertical(){
		
			grafico= new JLabel(image[3]);
			grafico.setBounds(this.pos.x, this.pos.y, this.width, this.height);
		
		return grafico;
	}
	
}
	



