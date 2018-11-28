package modele;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Controleur {

	public static Modele modele=new Modele();

	public static void ajouter_image(String path) throws ExceptionNomUtilise{
		//modele.paths.add(path);
		for (int i=0;i<Modele.all.size();i++){
			if (modele.all.get(i).path == path){
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");
			}
		}
		Images plop = new Images();

		try{

			File chemin = new File(path);

			plop.img = ImageIO.read(chemin);
			//plop.Nom=nom;
			plop.path=chemin.getAbsolutePath();

			int x = plop.img.getWidth();
			int y = plop.img.getHeight();
			plop.dim_x = x;
			plop.dim_y = y;

			int red=0;
			int green=0;
			int blue=0;
			for (int i=0;i<x;i++) {
				for (int j = 0;j<y;j++) {
					int color = plop.img.getRGB(i, j);
					red += (color >> 16) & 0x000000FF;
					green += (color >> 8) & 0x000000FF;
					blue += (color) & 0x000000FF;

				}
			}

			red = red/(plop.dim_x * plop.dim_y);
			green = green/(plop.dim_x * plop.dim_y);
			blue = blue/(plop.dim_x * plop.dim_y);

			plop.couleur_moyenne=new Color(red,green,blue);
			if(red==green && red==blue && blue==green) {
				plop.couleur_dominante=Color.gray;
			}
			else {
				plop.couleur_dominante=max(red,green,blue);
			}
			

			plop.favori = false;

			modele.all.add(plop);

		}catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void display(ArrayList<Images> all) {
		for(int i=0;i<all.size();i++) {
			System.out.println("");
			System.out.println(i);
			System.out.println("chemin :"+all.get(i).path);
			System.out.println("hauteur :"+all.get(i).dim_y);
			System.out.println("largeur :"+all.get(i).dim_x);
			System.out.println("moyenne :"+all.get(i).couleur_moyenne);
			System.out.println("dominante :"+all.get(i).couleur_dominante);
		}
	}

	public static ArrayList<Images> tri_couleur(Color coul) {
		ArrayList<Images> res = new ArrayList<Images>();
		for(int i=0;i<Modele.all.size();i++) {
			if (Modele.all.get(i).couleur_dominante == coul) {
				res.add(Modele.all.get(i));
			}
		}
		return res;
	}

	public static ArrayList<Images> afficherFavoris(){
		ArrayList<Images> res = new ArrayList<Images>();
		for(int i=0;i<Modele.all.size();i++) {
			if (Modele.all.get(i).favori) {
				res.add(Modele.all.get(i));
			}
		}

		return res;
	}

	public static Color max(int r,int g,int b){
		int coul[]={r,g,b};
		int imax=0;
		int max=0;
		Color dom;
		for (int i=0;i<coul.length;i++){
			if (coul[i] > max){
				max = coul[i];
				imax = i;
			}
		}
		if (imax==0){
			//signifie que la couleur dominante est rouge
			dom = Color.red;
		}
		else if (imax==1){
			//signifie que la couleur dominante est vert
			dom = Color.green;
		}
		else{
			//signifie que la couleur dominante est bleu
			dom = Color.blue;
		}

		return dom;
	}

	public static void supprimer_image(Images img){
		Modele.all.remove(img);
	}

	public void ajouter_mc(Images img, String str){
		if (!Modele.mots_clefs.contains(str)){
			Modele.mots_clefs.add(str);
		}

		if (!img.motsclefs.contains(str)){
			img.motsclefs.add(str);
		}
	}

	public static void creer_album(String nom)throws ExceptionNomUtilise{
		boolean flag=true;
		for (int i=0;i<Modele.albums.size();i++){
			if (Modele.albums.get(i).nom == nom){
				flag=false;
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");	
			}
		}
		if (flag) {
			Album plop=new Album();
			plop.nom=nom;
			Modele.albums.add(plop);
		}
	}

	public static void ajouter_album(Album alb, Images img)throws ExceptionIntrouvable{
		if (Modele.albums.contains(alb)){
			if (!alb.contenu.contains(img)) {
				alb.contenu.add(img);
			}
		}
		else{
			throw new ExceptionIntrouvable("Cet album n'existe pas");
		}
	}

	public static void toggle_favoris(Images img){
		img.favori=!img.favori;
	}



	public static void getFiles() throws ExceptionNomUtilise{
		String tempath;
		String dirPath = "C:/Users/NoobsLord-p�c�/Documents/GitHub/java2k18/Bibliotheque";
		File dir = new File(dirPath);
		String[] files = dir.list();
		if (files.length == 0) {
			System.out.println("Bibliotheque vide");
		} else {
			for (String aFile : files) {
				tempath = dirPath + "/" + aFile;
				System.out.println(aFile);
				ajouter_image(tempath);
			}
		}
	}
	
	public static Dimension dimension_ratio(Dimension dim) {
		int objectif = 650;
		int largeur = dim.width;
		int hauteur = dim.height;
		int newlargeur = largeur;
		int newhauteur = hauteur;
		
		if (largeur > objectif) {
			newlargeur = objectif;
			newhauteur = (newlargeur * hauteur) / largeur;
		}
		if (newhauteur > objectif) {
			newhauteur = objectif;
			newlargeur = (newhauteur * largeur) / hauteur;
		}
		
		return new Dimension(newlargeur,newhauteur);
	}


}


