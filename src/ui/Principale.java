package ui;

import modele.Controleur;

public class Principale {

	public static void main(String[] args) {
		Fenetre fenetrePrincipale= new Fenetre(); 
		fenetrePrincipale.setVisible(true);
		
		Controleur.getFiles();
	}

}
