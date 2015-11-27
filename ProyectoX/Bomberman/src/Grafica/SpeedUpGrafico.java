package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase gráfica del enemigo Sirius
 *
 */
public class SpeedUpGrafico extends ObjetoGrafico{
	
	/** Setea la imagen del power up - SpeedUp
	 *
	 * @param x Columna donde se encuentra power up
	 * @param y Fila donde se enceuntra power up
	 */
	public SpeedUpGrafico(int x, int y) {
		super(x, y);		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/speedup.jpg"));
	}
}
