package GUI;
/**
 * 
 * Hilo del tiempo
 *
 */
public class TiempoThread extends Thread {

	public boolean inssuspended =false;
	int hora, min, seg;
	private GUI gui;
	
	/**Constructor del hilo
	 * 
	 * @param g GUI
	 */
	public TiempoThread(GUI g){
		gui=g;
		hora=00;
		min=00;
		seg=00;
	}
	
	/**
	 * Metodo run del hilo
	 */
	public void run(){
		try{
			while(true){
				if(seg==59){
					seg=0;
					min++;
				}
				if(min==59){
					min=0;
					hora++;
				}
				seg++;
				
				gui.cambiarTiempo(hora, min, seg);
				sleep(1000);
			}
			
		}catch(InterruptedException ie){
			System.out.println("");
		}
	}
	
	
	
}
