package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase grafica de Altair
 *
 */
public class AltairGrafico extends PersonajeGrafico{
	
	/**
	 * Setea las imagenes al Altair depenidendo la direccion que tome
	 * @param velocidad que tiene Altair
	 * @param x columna donde se encuentra Altair
	 * @param y Fila donde se encuentra Altair
	 */
	
	public AltairGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/altairatrassinfondo.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/altairfrente sinfondo.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/izquierdasinfondo.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/altairderechasinfondo.png"));
	}
}
