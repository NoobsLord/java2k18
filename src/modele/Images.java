package modele;

import java.util.ArrayList;
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
	public boolean visible;
	public String couleur;
	public String localisation;
	public File path;
	public ArrayList<String> motsclefs = new ArrayList<String>();
	
}
