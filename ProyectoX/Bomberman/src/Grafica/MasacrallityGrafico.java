package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase gráfica del enemigo Sirius
 *
 */
public class MasacrallityGrafico extends ObjetoGrafico{
	
	/** Setea la imagen del power up - Masacrallity
	 *
	 * @param x Columna donde se encuentra power up
	 * @param y Fila donde se enceuntra power up
	 */
	public MasacrallityGrafico(int x, int y) {
		super(x, y);		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/masacarality.jpg"));
	}
}
