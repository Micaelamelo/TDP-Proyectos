package GUI;
import Juego.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	private Juego j;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

	/**
	 * Create the frame.
	 */
	public GUI() {

		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				mover(arg0);
			}
		});
		
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(32*31,32*13);
		setResizable(false);
		
		Color green1=new Color(0x00, 0xC0, 0x00);
		
		
		contentPane = new JPanel();
		contentPane.setSize(32*31,32*13);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(green1);
		
		
		j = new Juego(this);
	}
	
	protected void mover(KeyEvent key){
		j.mover(key.getKeyCode());
	}
	

}

