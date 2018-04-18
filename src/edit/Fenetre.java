import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	ConteneurFenetre pan;
	Graphisme graph;
	
	
	
	public Fenetre(){
		super();
		proprietefenetre();
		
	}
	
	
		
	

	private void proprietefenetre(){
		this.setSize(1200, 900);
		this.setTitle("Gestion d'Image");
		this.getContentPane().setBackground(new Color(200,200,200));
		this.setResizable(false); // non redimensionner
		this.setLocationRelativeTo(null); // centrer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fermeture du programme lorsqu'on ferme la fenetre
		
		pan= new ConteneurFenetre();
		this.add(pan);
		
		graph= new Graphisme();
		
	}
	
	
	
	
}



