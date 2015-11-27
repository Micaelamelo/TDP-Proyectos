package Grafica;

import javax.swing.ImageIcon;

/**
 * 
 * Clase grafica de Rugulo
 *
 */
public class RuguloGrafico extends PersonajeGrafico{
	
	/**
	 * Setea las imagenes al Rugulo depenidendo la direccion que tome
	 * @param velocidad que tiene Rugulo
	 * @param x columna donde se encuentra Rugulo
	 * @param y Fila donde se encuentra Rugulo
	 */
	public RuguloGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/rugulo.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/rugulo.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/rugulo.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/rugulo.png"));
	}
}