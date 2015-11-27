package GUI;
import Juego.*;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GUI extends GUIinicio{
	
	private static final long serialVersionUID = 1L;
	public static final int SPACE = KeyEvent.VK_SPACE;
	
	private JLabel tiempo;
	private JLabel puntaje;
	
	protected BombermanThread bt;
	protected TiempoThread tiem;
	protected SonidoPrincipal musica;
	
	private int key = -1;
	private boolean lock = false;
	
	private Juego j;
	
	private JLabel gameover;
	private JLabel win;
	
	
	
	/**
	* Create the frame.
	*/
	public GUI() {

		addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==SPACE)
					j.getBomberman().crearBomba();
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					arg0.consume();
					
				}
				mover(arg0);
				
			}
		});
		
		getContentPane().remove(etiqueta);
		
		//Configuraciones de la GUI
		setTitle("Bomberman");
		setBounds(100, 100, 1024, 480);
		Color green1=new Color(0x00, 0xC0, 0x00);
		getContentPane().setBackground(green1);
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		
		etiqueta=new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/bomber logo.jpg")));
		etiqueta.setBounds(100, 100, 1024, 480);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(32*31,32*15);
		setResizable(false);	
		
		//Etiqueta tiempo
		tiempo = new JLabel("Tiempo : 00 : 00 : 00");
		tiempo.setFont(new java.awt.Font("Arial", 1, 20));
		tiempo.setForeground(Color.BLACK);
		tiempo.setBounds(0, 417, 172, 25);		
		getContentPane().add(tiempo);
		
		//Etiqueta puntaje
		puntaje= new JLabel("Puntaje: 0");
		puntaje.setFont(new java.awt.Font("Arial",1,20));
		puntaje.setForeground(Color.BLACK);
		puntaje.setBounds(32*27, 417, 172, 25);
		getContentPane().add(puntaje);
		
		//Comienzo de hilos
		j = new Juego(this);
		
		musica= new SonidoPrincipal();
		musica.empezar();
		
		bt = new BombermanThread(this, j);
		bt.start();
		
		tiem= new TiempoThread(this);
		tiem.start();
	
	}
	
	protected void mover(KeyEvent key){
		if(!lock){
			this.key = key.getKeyCode();
			this.lock = true;
		}
	}
	
	public int getNextMov(){
		if(this.lock){
			this.lock = false;
			return this.key;
		}else{
			return -1;
		}
	}
	
	public void cambiarTiempo(int h, int m, int s){
		tiempo.setText("Tiempo:  "+h+" : "+m+" : "+s);	
	}
	
	public void cambiarPuntaje(int i){
		puntaje.setText("Puntaje:"+i);
	}
	
	public BombermanThread getBombermanThread(){
		return bt;
	}
	
	public TiempoThread getTiempoThread(){
		return tiem;
	}
	
	public void gameOver(){
		

		getContentPane().removeAll();
		getContentPane().repaint();
		
		gameover= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/gameover.jpg")));
		
		
		setBounds(100, 100, 1024, 480);
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(32*31,32*15);
		setResizable(false);	
		
		
		getContentPane().setBackground(Color.WHITE);
		gameover.setBounds(0, 0, 1024, 480);
		gameover.setVisible(true);
		getContentPane().add(gameover);
	}
	
	public void win(){
		getContentPane().removeAll();
		getContentPane().repaint();
		
		win= new JLabel(new ImageIcon(this.getClass().getResource("/Imagenes/win.gif")));
		
		
		setBounds(100, 100, 1024, 480);
		((JComponent) getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(32*31,32*15);
		setResizable(false);	
		
		
		getContentPane().setBackground(Color.BLACK);
		win.setBounds(0, 0, 1024, 480);
		win.setVisible(true);
		getContentPane().add(win);
	}
	
	public SonidoPrincipal getSonidoP(){
		return musica;
	}
}

