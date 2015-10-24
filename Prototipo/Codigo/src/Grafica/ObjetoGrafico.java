package Grafica;
import java.awt.Point;
import javax.swing.Icon;
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
		image = new Icon[1];	
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
}
