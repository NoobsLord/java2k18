package modele;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Controleur {

	public static Modele modele=new Modele();

	public static void ajouter_image(String path)throws ExceptionNomUtilise{
		//modele.paths.add(path);
		/*for (int i=0;i<modele.all.size();i++){
			if (modele.all.get(i).Nom == nom){
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");
			}
		}*/
		Images plop = new Images();

		try{

			File chemin = new File(path);

			plop.img = ImageIO.read(chemin);
			//plop.Nom=nom;
			plop.path=chemin;

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
			plop.couleur_dominante=max(red,green,blue);

			//double[] gps = plop.img.getGPSCoordinate();

			modele.all.add(plop);
			display(modele.all);

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

	public static void display_color(ArrayList<Images> all,Color coul) {
		System.out.println("--------------------------");
		for(int i=0;i<all.size();i++) {
			if (all.get(i).couleur_dominante == coul) {
				System.out.println("");
				System.out.println(i);
				System.out.println("chemin :"+all.get(i).path);
				System.out.println("hauteur :"+all.get(i).dim_y);
				System.out.println("largeur :"+all.get(i).dim_x);
				System.out.println("moyenne :"+all.get(i).couleur_moyenne);
				System.out.println("dominante :"+all.get(i).couleur_dominante);
			}
		}
		System.out.println("--------------------------");
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

	public void supprimer_image(Images img){
		modele.all.remove(img);
	}

	public void ajouter_mc(Images img, String str){
		if (!modele.mots_clefs.contains(str)){
			modele.mots_clefs.add(str);
		}

		if (!img.motsclefs.contains(str)){
			img.motsclefs.add(str);
		}
	}

	public void creer_album(String nom)throws ExceptionNomUtilise{
		boolean flag=true;
		for (int i=0;i<modele.albums.size();i++){
			if (modele.albums.get(i).Nom == nom){
				flag=false;
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");	
			}
		}
		if (flag) {
			Album plop=new Album();
			plop.Nom=nom;
			modele.albums.add(plop);
		}
	}

	public void ajouter_album(Album alb, Images img)throws ExceptionIntrouvable{
		if (modele.albums.contains(alb)){
			if (!alb.contenu.contains(img)) {
				alb.contenu.add(img);
			}
		}
		/*else{
			throw new ExceptionIntrouvable("Cet album n'existe pas");
		}*/
	}

	public void toggle_favoris(Images img){
		img.favori=!img.favori;
	}

}


