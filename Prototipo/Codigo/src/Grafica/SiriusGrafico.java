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
	public SiriusGrafico(int velocidad, int x, int y) { //Sin implementacion completa, no fue utilizada en esta entrega del proyecto
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource(""));
		this.image[1] = new ImageIcon(this.getClass().getResource(""));
		this.image[2] = new ImageIcon(this.getClass().getResource(""));
		this.image[3] = new ImageIcon(this.getClass().getResource(""));
	}
}
