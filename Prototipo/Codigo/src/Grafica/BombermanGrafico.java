package Grafica;
import javax.swing.ImageIcon;
/**
 * 
 * Clase grafica del Bomberman
 *
 */
public class BombermanGrafico extends PersonajeGrafico{

	/**
	 * Setea las imagenes al Bomberman depenidendo la direccion que tome
	 * @param velocidad que tiene Bomberman
	 * @param x columna donde se encuentra Bomberman
	 * @param y Fila donde se encuentra Bomberman
	 */
	public BombermanGrafico(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.image[0] = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanespaldagif.gif"));
		this.image[1] = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanfrentegif.gif"));
		this.image[2] = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanizquiedagif.gif"));
		this.image[3] = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanderechagif.gif"));
		
		mDestroyedImage = new ImageIcon(this.getClass().getResource("/Imagenes/bombermanmuerto.jpg"));

	}
}
