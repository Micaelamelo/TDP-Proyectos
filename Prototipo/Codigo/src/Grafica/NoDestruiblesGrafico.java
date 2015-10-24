package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase grafica de pared no destruible
 *
 */
public class NoDestruiblesGrafico extends ObjetoGrafico{
	
	/**
	 * 
	 * @param x Columna donde se encuentra la pared determinada
	 * @param y Fila donde se encunetra la pared determinada
	 */
	public  NoDestruiblesGrafico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/pared nodestruible.jpg"));
		}
}
