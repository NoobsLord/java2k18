import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ConteneurFenetre extends JPanel {
	
	private JButton album;
	private JButton favoris;
	private JButton rechercher;
	private JButton quitter;
	
	public ConteneurFenetre(){
		super();
		this.proprieteConteneur();
		
		
	}
	
	private void proprieteConteneur(){
		this.setLayout(null);
		this.boutonAlbum();
		this.boutonFavoris();
		this.bouttonRechercher();
		this.bouttonQuitter();
		
		
	}
	
		
	private void boutonAlbum(){
		album= new JButton();
		this.album.setBounds(400, 10, 100, 50);
		this.album.setText("Album");
		this.add(album);
		this.setVisible(true);
		
		
	}
	
	private void boutonFavoris(){
		favoris= new JButton();
		this.favoris.setBounds(520, 10, 100, 50);
		this.favoris.setText("Favoris");
		this.add(favoris);
	}
	
	private void bouttonRechercher(){
		rechercher=new JButton();
		this.rechercher.setBounds(640,10,100,50);
		this.rechercher.setText("Rechercher");
		this.add(rechercher);
		
	}
	
	private void bouttonQuitter(){
		quitter= new JButton();
		this.quitter.setBounds(269, 600, 100, 50);
		this.quitter.setText("Quitter");
		quitter.setForeground(Color.BLACK);
		quitter.setBackground(Color.PINK);
		quitter.setBorderPainted(true);
		quitter.setFocusPainted(true);
		Font f=new Font("Arial", Font.BOLD, 12);
		quitter.setFont(f);
		this.add(quitter);
	}
}
