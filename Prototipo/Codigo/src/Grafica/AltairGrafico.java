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
		//El fondo de las imagenes es verda por lo que cuando pasa por arriba de las paredes destruibles habra fondo verde
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/altairespalda.jpg"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/altairfrente.jpg"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/altairizquierda.jpg"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/altairderecha.jpg"));
	}
}
