package ui;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import modele.*;


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
	private JButton valider;

	private JComboBox combo1;
	private JComboBox combo2;
	private JComboBox combo3;
	private JComboBox combo4;
	private JComboBox combo5;

	private JLabel mocle1;
	private JLabel mocle2;
	private JLabel mocle3;
	private JLabel mocle4; 
	private JLabel mocle5; 

	private JTextField champText;





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
		this.bouttonValider();
		this.proprieteMocle();
		this.proprieteComboBox();
		this.proprieteChampText();

	}


	private void boutonAlbum(){
		album= new JButton();
		this.album.setBounds(420, 10, 100, 50);
		this.album.setText("Album");
		this.add(album);
		this.album.addActionListener(this);



	}

	private void boutonFavoris(){
		favoris= new JButton();
		this.favoris.setBounds(540, 10, 100, 50);
		this.favoris.setText("Favoris");
		this.add(favoris);
	}

	private void bouttonAjouter(){
		ajouter=new JButton();
		this.ajouter.setBounds(660,10,100,50);
		this.ajouter.setText("Ajouter");
		this.add(ajouter);
		this.ajouter.addActionListener(this);

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

	private void bouttonRechercher(){
		rechercher= new JButton();
		this.rechercher.setBounds(30, 150, 120, 30);
		this.rechercher.setText("Rechercher");
		this.add(rechercher);
		this.rechercher.addActionListener(this);
	}

	private void bouttonTrier(){
		trier= new JButton();
		this.trier.setBounds(160, 150, 120, 30);
		this.trier.setText("Tier");
		this.add(trier);
		this.trier.addActionListener(this);
	}

	private void bouttonValider(){
		valider= new JButton();
		this.add(valider);
	}

	private void proprieteChampText(){
		champText= new JTextField();
		this.add(champText);

	}

	private void proprieteComboBox(){
		combo1= new JComboBox();
		combo2= new JComboBox();
		combo3= new JComboBox();
		combo4= new JComboBox();
		combo5= new JComboBox();

		this.add(combo1);
		this.add(combo2);
		this.add(combo3);
		this.add(combo4);
		this.add(combo5);

	}

	private void proprieteMocle(){
		mocle1= new JLabel();
		mocle2= new JLabel();
		mocle3= new JLabel();
		mocle4= new JLabel();
		mocle5= new JLabel();

		this.mocle1.setBounds(50, 220, 120, 25);
		this.add(mocle1);

		this.mocle2.setBounds(50, 270, 120, 25);
		this.add(mocle2);

		this.mocle3.setBounds(50, 320, 120, 25);
		this.add(mocle3);

		this.mocle4.setBounds(50, 370, 120, 25);
		this.add(mocle4);

		this.mocle5.setBounds(50, 420, 120, 25);
		this.add(mocle5);

	}










	public void actionPerformed(ActionEvent e) {

		if(e.getSource()== this.album){
			this.mocle1.setVisible(false);
			this.mocle2.setVisible(false);
			this.mocle3.setVisible(false);
			this.mocle4.setVisible(false);
			this.mocle5.setVisible(false);

			this.combo1.setVisible(false);
			this.combo2.setVisible(false);
			this.combo3.setVisible(false);
			this.combo4.setVisible(false);
			this.combo5.setVisible(false);

			this.champText.setVisible(false);

			this.valider.setVisible(false);
		}
		else if(e.getSource()== this.trier){
			this.mocle1.setText("Mot Clé 1");
			this.mocle2.setText("Mot Clé 2");
			this.mocle3.setText("Mot Clé 3");
			this.mocle4.setText("Mot Clé 4");
			this.mocle5.setText("Mot Clé 5");

			this.mocle1.setVisible(true);
			this.mocle2.setVisible(true);
			this.mocle3.setVisible(true);
			this.mocle4.setVisible(true);
			this.mocle5.setVisible(true);

			combo1.setBounds(140, 220, 120, 25);
			combo1.addItem("Option 1");
			combo1.addItem("Option 2");
			combo1.addItem("Option 3");
			combo1.addItem("Option 4");
			this.combo1.setVisible(true);


			combo2.setBounds(140, 270, 120, 25);
			combo2.addItem("Option 1");
			combo2.addItem("Option 2");
			combo2.addItem("Option 3");
			combo2.addItem("Option 4");
			this.combo2.setVisible(true);

			combo3.setBounds(140, 320, 120, 25);
			combo3.addItem("Option 1");
			combo3.addItem("Option 2");
			combo3.addItem("Option 3");
			combo3.addItem("Option 4");
			this.combo3.setVisible(true);

			combo4.setBounds(140, 370, 120, 25);
			combo4.addItem("Option 1");
			combo4.addItem("Option 2");
			combo4.addItem("Option 3");
			combo4.addItem("Option 4");
			this.combo4.setVisible(true);

			combo5.setBounds(140, 420, 120, 25);
			combo5.addItem("Option 1");
			combo5.addItem("Option 2");
			combo5.addItem("Option 3");
			combo5.addItem("Option 4");
			this.combo5.setVisible(true);

			this.valider.setBounds(105, 490, 80, 30);
			this.valider.setText("Valider");
			this.valider.setForeground(Color.BLACK);
			this.valider.setBackground(Color.WHITE);
			this.valider.setBorderPainted(true);
			this.valider.setFocusPainted(true);
			Font f=new Font("Arial", Font.ITALIC, 11);
			this.valider.setFont(f);
			this.valider.setVisible(true);

			this.champText.setVisible(false);


		}
		else if(e.getSource()== this.rechercher){
			this.champText.setBounds(50, 220, 190, 30);
			this.champText.setBackground(Color.WHITE);
			this.champText.setVisible(true);

			this.valider.setBounds(105, 260, 80, 30);
			this.valider.setText("Valider");
			this.valider.setForeground(Color.BLACK);
			this.valider.setBackground(Color.WHITE);
			this.valider.setBorderPainted(true);
			this.valider.setFocusPainted(true);
			Font f=new Font("Arial", Font.ITALIC, 11);
			this.valider.setFont(f);
			this.valider.setVisible(true);


			this.mocle1.setVisible(false);
			this.mocle2.setVisible(false);
			this.mocle3.setVisible(false);
			this.mocle4.setVisible(false);
			this.mocle5.setVisible(false);


			this.combo1.setVisible(false);
			this.combo2.setVisible(false);
			this.combo3.setVisible(false);
			this.combo4.setVisible(false);
			this.combo5.setVisible(false);

		}
		else if(e.getSource()== this.ajouter){
			JFileChooser fic = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif","png");
			fic.setFileFilter(filter);
			if (fic.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
				try {
					Controleur.ajouter_image(fic.getSelectedFile().getPath());
				} catch (ExceptionNomUtilise e1) {
					e1.printStackTrace();
				}
		}


	}


}

