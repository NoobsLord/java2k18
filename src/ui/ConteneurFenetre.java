import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ConteneurFenetre extends JPanel implements ActionListener {
	
	private JButton album;
	private JButton favoris;
	private JButton rechercher;
	private JButton quitter;
	private JButton supprimer;
	private JButton rotation;
	private JButton exporter;
	private JButton information;
	private JButton ajouter;
	private JButton trier;
	
	
	
	
	public ConteneurFenetre(){
		super();
		this.proprieteConteneur();
		
		
	}
	
	public void paintComponent(Graphics g){
		// Couleur de fond fenetre
		super.paintComponent(g);
		this.setBackground(new Color(200,200,200));
		int x1=this.getWidth()/4;
		int y1=this.getHeight()/4;
		int y2=this.getHeight()-130;
		System.out.println("cliqué");
		g.drawLine(0,80,this.getWidth(),80);
		g.drawLine(0, 130, this.getWidth(), 130);
		g.drawLine(this.getWidth()-890, this.getHeight()-y2, this.getWidth()-890, this.getHeight());
		this.setVisible(true);
		
	}
	private void proprieteConteneur(){
		this.setLayout(null);
		this.boutonAlbum();
		this.boutonFavoris();
		this.bouttonRechercher();
		this.bouttonQuitter();
		this.bouttonSupprimer();
		this.boutonRotation();
		this.bouttonExporter();
		this.bouttonInformation();
		this.bouttonAjouter();
		this.bouttonTrier();
	}
	
		
	private void boutonAlbum(){
		album= new JButton();
		this.album.setBounds(420, 10, 100, 50);
		this.album.setText("Album");
		this.add(album);
		
		
		
	}
	
	private void boutonFavoris(){
		favoris= new JButton();
		this.favoris.setBounds(540, 10, 100, 50);
		this.favoris.setText("Favoris");
		this.add(favoris);
	}
	
	private void bouttonRechercher(){
		rechercher=new JButton();
		this.rechercher.setBounds(660,10,100,50);
		this.rechercher.setText("Rechercher");
		this.add(rechercher);
		
	}
	
	private void bouttonQuitter(){
		quitter= new JButton();
		this.quitter.setBounds(100, 755, 100, 35);
		this.quitter.setText("Quitter");
		quitter.setForeground(Color.BLACK);
		quitter.setBackground(Color.PINK);
		quitter.setBorderPainted(true);
		quitter.setFocusPainted(true);
		Font f=new Font("Time New Roman", Font.ITALIC, 12);
		quitter.setFont(f);
		this.add(quitter);
		//Evenement
		this.quitter.addActionListener(this);
	}
	
	private void bouttonSupprimer(){
		supprimer= new JButton();
		this.supprimer.setBounds(420, 90, 100, 30);
		this.supprimer.setForeground(Color.BLACK);
		this.supprimer.setBackground(Color.CYAN);
		this.supprimer.setText("Supprimer");
		//bordure du boutton
		this.supprimer.setBorderPainted(true);
		this.supprimer.setFocusPainted(true);
		Font f=new Font("Arial", Font.ITALIC, 12);
		this.supprimer.setFont(f);
		this.add(supprimer);
	}
	
	private void boutonRotation(){
		rotation= new JButton();
		this.rotation.setBounds(540, 90, 100, 30);
		this.rotation.setForeground(Color.BLACK);
		this.rotation.setBackground(Color.CYAN);
		this.rotation.setText("Rotation");
		//bordure du boutton
		this.rotation.setBorderPainted(true);
		this.rotation.setFocusPainted(true);
		Font f=new Font("Arial", Font.ITALIC, 12);
		this.rotation.setFont(f);
		this.add(rotation);
	}
	
	private void bouttonExporter(){
		exporter= new JButton();
		this.exporter.setBounds(660, 90,100,30);
		this.exporter.setForeground(Color.BLACK);
		this.exporter.setBackground(Color.CYAN);
		this.exporter.setText("Exporter");
		this.exporter.setBorderPainted(true);
		this.exporter.setFocusPainted(true);
		Font f= new Font("Arial", Font.ITALIC, 12);
		this.exporter.setFont(f);
		this.add(exporter);
	}
	
	private void bouttonInformation(){
		information= new JButton();
		this.information.setBounds(780, 90, 110, 30);
		this.information.setForeground(Color.BLACK);
		this.information.setBackground(Color.CYAN);
		this.information.setText("Information");
		this.information.setBorderPainted(true);
		this.information.setFocusPainted(true);
		Font f= new Font("Arial", Font.ITALIC, 12);
		this.information.setFont(f);
		this.add(information);
	}
	
	private void bouttonAjouter(){
		ajouter= new JButton();
		this.ajouter.setBounds(40, 150, 100, 30);
		this.ajouter.setText("Ajouter");
		this.add(ajouter);
	}
	
	private void bouttonTrier(){
		trier= new JButton();
		this.trier.setBounds(160, 150, 100, 30);
		this.trier.setText("Tier");
		this.add(trier);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== this.quitter){
			this.setVisible(false);
		}
		
		
	
			
		}
		
	}

