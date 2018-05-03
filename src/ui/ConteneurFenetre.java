package ui;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
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
	public static int indice=0;

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
	private JButton suivant;
	private JButton precedent;

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
	private ArrayList<JPanel> wesh = new ArrayList<JPanel>();
	
	private int center_width;
	private int center_height;




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
		System.out.println("repaint");
		g.drawLine(0,80,this.getWidth(),80);
		g.drawLine(0, 130, this.getWidth(), 130);
		g.drawLine(this.getWidth()-890, this.getHeight()-y2, this.getWidth()-890, this.getHeight());
		g.drawLine(this.getWidth()-200, 130, this.getWidth()-200, this.getHeight());
		this.setVisible(true);

		/*for (int i =0;i<wesh.size();i++) {
			g.drawImage(Modele.all.get(i).img, wesh.get(i).getWidth(), wesh.get(i).getHeight(), this);
		}*/
		if (Modele.all.size() > 0) {
			JPanel pan = new JPanel();
			
			center_width = (this.getWidth()/2)+(310/2);
			center_height = (this.getHeight()/2)+(130/2)-50;
			this.boutonSuivant();
			this.boutonPrecedent();
			Images ancour = Modele.all.get(indice);
			Dimension vanilla = new Dimension(Modele.all.get(indice).dim_x,Modele.all.get(indice).dim_y);
			Dimension dim = Controleur.dimension_ratio(vanilla);
			
			Image current = Modele.all.get(indice).img.getScaledInstance(dim.width, dim.height, Image.SCALE_SMOOTH);
			g.drawImage(current, center_width-(dim.width/2)-100,center_height-(dim.height/2),this);
			g.drawString("dimensions : "+ancour.dim_x+" x "+ancour.dim_y, this.getWidth()-190, 180);
			g.drawString("couleur moyenne : ", this.getWidth()-190, 230);
			g.setColor(ancour.couleur_moyenne);
			g.fillRect(this.getWidth()-75, 200, 50, 50);
			g.setColor(Color.black);
			g.drawRect(this.getWidth()-75, 200, 50, 50);
			g.drawString("couleur dominante : ", this.getWidth()-190, 300);
			g.setColor(ancour.couleur_dominante);
			g.fillRect(this.getWidth()-75, 270, 50, 50);
			g.setColor(Color.black);
			g.drawRect(this.getWidth()-75, 270, 50, 50);
		}
	}

	public void affichement() {
		/*wesh = new ArrayList<JPanel>();
		for (int i=0;i<Modele.all.size();i++) {
			System.out.println(Modele.all.get(i).path);
			JPanel test = new JPanel();
			test.setPreferredSize(new Dimension(150,150));
			if(i<=5) {
				test.setBounds((150 + 28)*i,130, 150, 150);
			}
			else if (i<=10) {
				test.setBounds((150 + 28)*i,300, 150, 150);
			}

			this.add(test);
			wesh.add(test);
		}
		 */
		indice = 0;
		repaint();
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
	
	private void boutonSuivant() {
		suivant = new JButton();
		this.suivant.setBounds(center_width-70,this.getHeight()-70,50,50);
		this.suivant.setText(">>");
		this.add(suivant);
		this.suivant.addActionListener(next());
	}
	
	private void boutonPrecedent() {
		precedent = new JButton();
		this.precedent.setBounds(center_width-130,this.getHeight()-70,50,50);
		this.precedent.setText("<<");
		this.add(precedent);
		this.precedent.addActionListener(prev());
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
	
	public static ActionListener next() {
		indice += 1;
		return null;
	}
	
	public static ActionListener prev() {
		indice -= 1;
		return null;
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

			//#######################

			//affichement();

			//#######################
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

			Controleur.tri_couleur(Color.red);

		}
		else if(e.getSource()== this.ajouter){
			JFileChooser fic = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif","png");
			fic.setFileFilter(filter);
			if (fic.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
				//try {
					Controleur.ajouter_image(fic.getSelectedFile().getPath());
				/*} catch (ExceptionNomUtilise e1) {
					e1.printStackTrace();
				}*/
		}
		repaint();


	}


}

