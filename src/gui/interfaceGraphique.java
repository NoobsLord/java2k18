package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.*;

public class interfaceGraphique extends JFrame {
	private JButton b_quitter= new JButton("Quitter");
	private JButton b_ajouter= new JButton("Ajouter");
	private JButton b_trier= new JButton("Trier");
	private JButton b_rechercher= new JButton("Rechercher");
	private JButton b_rechercher2= new JButton("Rechercher2");
	private JButton b_favoris= new JButton("Favoris");
	private JButton b_album= new JButton("Album");
	private JButton b_suppr= new JButton("Supprimé");
	private JButton b_rotation= new JButton("Rotation");
	private JButton b_export= new JButton("Exporter");
	private JButton b_info= new JButton("Informations");

	private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
	private JComboBox combo3 = new JComboBox();
	private JComboBox combo4 = new JComboBox();
	private JComboBox combo5 = new JComboBox();
	private JLabel mocle1 = new JLabel("Mots clé 1");
	private JLabel mocle2 = new JLabel("Mots clé 2");
	private JLabel mocle3 = new JLabel("Mots clé 3");
	private JLabel mocle4 = new JLabel("Mots clé 4");
	private JLabel mocle5 = new JLabel("Mots clé 5");

	private JButton b_valider= new JButton("Valider");

	public static int pas=120;


	public interfaceGraphique() {

		// Titre de la fenetre 
		this.setTitle("Gestion d'Images");
		// taille de la fenetre
		this.setSize(900,700);
		// Emplacement de la fenetre
		this.setLocationRelativeTo(null);
		//Quitter le programme lorsqu'on ferme la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new Paneau());

		//boutton quitter
		//Emplacement du boutton
		this.setLayout(null);
		int x=this.getWidth()-60;
		int y=this.getHeight()/2;
		this.getContentPane().add(b_quitter);
		b_quitter.setBounds(this.getWidth()-820,this.getHeight()-80,100,30);
		// couleur du texte du boutton
		b_quitter.setForeground(Color.BLACK);
		// Couleur du boutton
		b_quitter.setBackground(Color.PINK);
		//bordure du boutton
		b_quitter.setBorderPainted(true);
		b_quitter.setFocusPainted(true);
		Font f=new Font("Arial", Font.BOLD, 12);
		b_quitter.setFont(f);
		b_quitter.addActionListener(new actionListener());


		//Boutton ajouter

		int x2=this.getWidth();
		b_ajouter.setBounds(this.getWidth()-110, this.getHeight()-310, 90, 20);
		b_ajouter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				//modele.Controleur.ajouter_image(e);
				try {
					afficher_tout();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

        });


		//Favoris
		this.getContentPane().add(b_favoris);
		int fx1=this.getWidth()/2;
		int fy1=this.getHeight()/2;
		b_favoris.setBounds(this.getWidth()/2, 10, 90, 50);

		//Album
		this.getContentPane().add(b_album);
		b_album.setBounds(fy1-30, 10, 100, 50);

		//Rechercher
		this.getContentPane().add(b_rechercher);
		b_rechercher.setBounds(fy1+210,10, 100, 50);

		//Supprimer
		this.getContentPane().add(b_suppr);
		b_suppr.setBounds(fy1-80, 90, 100, 30);
		// couleur du texte du boutton
		b_suppr.setForeground(Color.BLACK);
		// Couleur du boutton
		b_suppr.setBackground(Color.CYAN);
		//bordure du boutton
		b_suppr.setBorderPainted(true);
		b_suppr.setFocusPainted(true);
		Font f_suppr=new Font("Arial", Font.ITALIC, 12);
		b_suppr.setFont(f_suppr);


		//Rotation 
		this.getContentPane().add(b_rotation);
		b_rotation.setBounds(fy1+40, 90, 100, 30);
		// couleur du texte du boutton
		b_rotation.setForeground(Color.BLACK);
		// Couleur du boutton
		b_rotation.setBackground(Color.CYAN);
		//bordure du boutton
		b_rotation.setBorderPainted(true);
		b_rotation.setFocusPainted(true);
		Font f_rotation=new Font("Arial", Font.ITALIC, 12);
		b_rotation.setFont(f_rotation);

		//Exporter
		this.getContentPane().add(b_export);
		b_export.setBounds(fy1+160, 90, 100, 30);
		// couleur du texte du boutton
		b_export.setForeground(Color.BLACK);
		// Couleur du boutton
		b_export.setBackground(Color.CYAN);
		//bordure du boutton
		b_export.setBorderPainted(true);
		b_export.setFocusPainted(true);
		Font f_export=new Font("Arial", Font.ITALIC, 12);
		b_export.setFont(f_export);

		//Info
		this.getContentPane().add(b_info);
		b_info.setBounds(fy1+280, 90, 100, 30);
		// couleur du texte du boutton
		b_info.setForeground(Color.BLACK);
		// Couleur du boutton
		b_info.setBackground(Color.CYAN);
		//bordure du boutton
		b_info.setBorderPainted(true);
		b_info.setFocusPainted(true);
		Font f_info=new Font("Arial", Font.ITALIC, 12);
		b_info.setFont(f_info);

		//Ajouter
		this.getContentPane().add(b_ajouter);
		b_ajouter.setBounds(fy1-345, 150, 80, 30);

		//Trier
		this.getContentPane().add(b_trier);
		b_trier.setBounds(fy1-265, 150, 80, 30);

		//Rechercher2
		this.getContentPane().add(b_rechercher2);
		b_rechercher2.setBounds(fy1-185,150,80,30);
		b_rechercher2.addActionListener(new actionListener());

		//Combobox_ mots clé 1
		/*     mocle1.setBounds(23, 130, 150, 200);
		combo1.setBounds(100, 218, 120, 25);
	    combo1.addItem("Option 1");
	    combo1.addItem("Option 2");
	    combo1.addItem("Option 3");
	    combo1.addItem("Option 4");
	    this.getContentPane().add(combo1);
	    this.getContentPane().add(mocle1);

	    //mot clé 2
	    mocle2.setBounds(23, 180, 150, 200);
		combo2.setBounds(100, 268, 120, 25);
	    combo2.addItem("Option 1");
	    combo2.addItem("Option 2");
	    combo2.addItem("Option 3");
	    combo2.addItem("Option 4");
	    this.getContentPane().add(combo2);
	    this.getContentPane().add(mocle2);

        //mot clé 3
	    mocle3.setBounds(23, 230, 150, 200);
		combo3.setBounds(100, 318, 120, 25);
	    combo3.addItem("Option 1");
	    combo3.addItem("Option 2");
	    combo3.addItem("Option 3");
	    combo3.addItem("Option 4");
	    this.getContentPane().add(combo3);
	    this.getContentPane().add(mocle3);

        //mot clé 4
	    mocle4.setBounds(23, 280, 150, 200);
		combo4.setBounds(100, 368, 120, 25);
	    combo4.addItem("Option 1");
	    combo4.addItem("Option 2");
	    combo4.addItem("Option 3");
	    combo4.addItem("Option 4");
	    this.getContentPane().add(combo4);
	    this.getContentPane().add(mocle4);

	    //mot clé 5
	    mocle5.setBounds(23, 330, 150, 200);
		combo5.setBounds(100, 418, 120, 25);
	    combo5.addItem("Option 1");
	    combo5.addItem("Option 2");
	    combo5.addItem("Option 3");
	    combo5.addItem("Option 4");
	    this.getContentPane().add(combo5);
	    this.getContentPane().add(mocle5);

        // Valider
	    this.getContentPane().add(b_valider);
	    b_valider.setBounds(this.getWidth()-810,this.getHeight()-225,80,30);
	    // couleur du texte du boutton
        b_valider.setForeground(Color.BLACK);
        // Couleur du boutton
        b_valider.setBackground(Color.WHITE);
        //bordure du boutton
        b_valider.setBorderPainted(true);
        b_valider.setFocusPainted(true);
        Font f2=new Font("Arial", Font.ITALIC, 11);
        b_valider.setFont(f2); */

		this.setVisible(true);

	}
	public void paint (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		for (int i=0;i<modele.Modele.all.size();i++){
			g.drawImage(modele.Modele.all.get(i).img, 280+pas*i, 190, 200,200,this);
		}

	}
	public void afficher_tout() throws IOException{
		/*for (int i=0;i<modele.Modele.all.size();i++){
			BufferedImage bi = ImageIO.read(modele.Modele.all.get(i).path);	
			Graphics g = bi.getGraphics();
			g.drawImage(modele.Modele.all.get(i).img, pas*i, pas*i, null);
	}*/
		repaint();
	}


	public static void main(String[] args) throws ExceptionNomUtilise, IOException {
		Modele modele=new Modele();
		Controleur ctrl=new Controleur();
		ctrl.ajouter_image("icon.jpeg", "icon1");
		ctrl.ajouter_image("icon.jpeg", "icon2");
		ctrl.ajouter_image("icon.jpeg", "icon3");
		ctrl.ajouter_image("icon.jpeg", "icon4");

		interfaceGraphique inter = new interfaceGraphique();
		//afficher_tout();
		

	}

}










