package modele;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

public class Images {
	
	public String Nom;
	public BufferedImage img;
	public int dim_x;
	public int dim_y;
	public int Poids;
	public int Date;
	public boolean favori;
	//public boolean visible;
	public Color couleur_moyenne;
	public Color couleur_dominante;
	public String localisation;
	public String path;
	public ArrayList<String> motsclefs = new ArrayList<String>();
	
}
