package ui;

import java.awt.*;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Modele;

public class Pano extends JLabel{
	public static int ind;
	
	public Pano(int indice) {
		JLabel test = new JLabel();
		test.setPreferredSize(new Dimension(150,150));
		
		test.setIcon((Icon) Modele.all.get(indice).img);
	}

}
