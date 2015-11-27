
package Grafica;
import javax.swing.ImageIcon;
/**
 * 
 * Clase gráfica del enemigo Sirius
 *
 */
public class FatalityGrafico extends ObjetoGrafico{
	
	/** Setea la imagen del power up - Fatality
	 *
	 * @param x Columna donde se encuentra power up
	 * @param y Fila donde se enceuntra power up
	 */
	public FatalityGrafico(int x, int y) {
		super(x, y);		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/fatality.jpg"));
	}
}
