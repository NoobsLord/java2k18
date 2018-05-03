package ui;

import modele.Controleur;
import modele.ExceptionNomUtilise;
import modele.Modele;

public class Principale {

	public static void main(String[] args) throws ExceptionNomUtilise {
		Fenetre fenetrePrincipale= new Fenetre(); 
		fenetrePrincipale.setVisible(true);
		
		Controleur.getFiles();
		ConteneurFenetre.active = Modele.all;
	}

}
