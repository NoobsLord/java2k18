package ui;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	ConteneurFenetre pan= new ConteneurFenetre();
	
	
	
	public Fenetre(){
		super();
		proprietefenetre();
		
	}
	
	
		
	

	private void proprietefenetre(){
		this.setSize(1200, 850);
		this.setTitle("Gestion d'Image");
		this.getContentPane().setBackground(new Color(200,200,200));
		this.setResizable(false); // non redimensionner
		this.setLocationRelativeTo(null); // centrer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture du programme lorsqu'on ferme la fenetre
		
		
		this.add(pan);
		
	}
	
	
	
	
}



