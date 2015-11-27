package Grafica;


import javax.swing.ImageIcon;
/**
 * 
 * Clase grafica para Pared Destruible
 *
 */
public class DestruiblesGrafico extends ObjetoGrafico{
	/**
	 * 
	 * @param x Columna donde se encuentra la pared determinada
	 * @param y Fila donde se enceuntra la pared determinada
	 */
	public  DestruiblesGrafico(int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/pared destruible.jpg"));
		}
}
