package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class GUIinicio extends JFrame {

	protected JLabel etiqueta;
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIinicio frame = new GUIinicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	public GUIinicio(){
	
		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){				
					GUI gui= new GUI();
					gui.setVisible(true);
			}
				
			}
		});

		
		setBounds(100, 100, 1024, 480);
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		setSize(32*31,32*15);
		((JComponent) getContentPane()).setBackground(Color.black);
		
		etiqueta=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/bomber logo.jpg")));
		etiqueta.setBounds(100, 100, 1024, 480);
		etiqueta.setVisible(true);
		
		getContentPane().add(etiqueta);
		
		setResizable(false);	
		
	}
}

