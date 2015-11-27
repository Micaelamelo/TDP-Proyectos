package Grafica;

import javax.swing.ImageIcon;
/**
 * 
 * Clase grafica de Altair
 *
 */
public class BombaGrafico extends ObjetoGrafico{
	
	/**
	 * Setea las imagenes de la bomba y sus explosiones
	 * @param x columna donde se encuentra la bomba
	 * @param y Fila donde se encuentra la bomba
	 */
	
	public BombaGrafico (int x, int y) {
		super(x, y);
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanbomba.png"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/explosioncentral.png"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/explosionhorizontal.png"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/explosionvertical.png"));
		
	}
}
