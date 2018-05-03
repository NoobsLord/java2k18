package ui;


import package modele;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import color ;
public abstract class Mod�le  extends Observable { 

	public ArrayList<Image> images;

	int indexImageSelectionn�e = 0;

	public Mod�le() {}

	
	public void chargerDonn�es(String dir) {
		
		File repImages = new File(dir);
		File[] imagesListe = repImages.listFiles();
		this.images = new ArrayList<>();
		for (File file : imagesListe) {
			String nomImage = file.getName().split("\\.")[0];
			this.images.add(new ImageMod�le(nomImage, 0));
		}
	}

	public void s�lection(int item) {
		this.indexImageSelectionn�e = item;
		this.setChanged();this.notifyObservers(this.images.get(this.indexImageSelectionn�e));
	}
	public images (string nom )		{
		
		this.nom = nom;
	}
	public string getnom()
				{
			return nom 
				}
	
	public Images (Color coleur ) {
		
	this.Color = coleur ;
    }
	public Color getcolor()
	{
		return coleur 
	}
		
	}
		
		
	}
	
	
	public abstract void enregistrement();

	}

	
	