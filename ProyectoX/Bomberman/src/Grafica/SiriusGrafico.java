package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase gráfica del enemigo Sirius
 *
 */
public class SiriusGrafico extends PersonajeGrafico{
	
	/**
	 * 
	 * @param velocidad que tiene Sirus
	 * @param x Columna donde se encuentra Sirius
	 * @param y Fila donde se enceuntra Sirius
	 */
	public SiriusGrafico(int velocidad, int x, int y) { 
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/siriusEspalda.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/siriusFrente.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/siriusIzquierda.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/siriusDerecha.gif"));
	}
}
