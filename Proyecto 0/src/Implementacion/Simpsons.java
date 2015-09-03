package Implementacion;
import java.awt.Color;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Simpsons extends JFrame  {
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel imagen;
	
	public class PnlFondo extends javax.swing.JPanel{
		
		public PnlFondo(){
			this.setSize(678,410);
		}
		
		public void paintComponent(Graphics g){
			Dimension tamanio= getSize();
			ImageIcon imagenFondo= new ImageIcon(getClass().getResource("/Imagenes/simpsons.jpg"));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Simpsons frame= new Simpsons("Los Simpsons");
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Simpsons(String s) {
		super(s);
		
		PnlFondo pnlFondo= new PnlFondo();
		setContentPane(pnlFondo);
		
		btnNewButton = new JButton("Aprete boton");
		
		textField = new JTextField();
		textField.setBackground(new Color(153, 204, 255));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setColumns(10);
		
		imagen = new JLabel();
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().setBackground(new Color(102, 204, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(678,410);	
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random rnd = new Random();
				int entero= rnd.nextInt(3);
				if(entero==0){
					imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lisa.jpg")));
					textField.setText(" Plan dental, Lisa necesita frenos, plan dental, lisa necesita frenos" );
				}
				else {
					if(entero==1){
						imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/homero.jpg")));
						textField.setText("¿De quien fue la brillante idea de crucificar a un tio que volvia el agua vino?");
					}
					else{
						imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/coco.jpg")));
						textField.setText("¿¡Alguien quiere por favor pensar en los niños?!");
					}
				}
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(118)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(imagen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(251)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imagen, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
}
