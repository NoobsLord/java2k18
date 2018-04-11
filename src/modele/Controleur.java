package modele;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Controleur {

	Modele modele=new Modele();

	public void ajouter_image(String path, String nom)throws ExceptionNomUtilise{
		//modele.paths.add(path);
		for (int i=0;i<modele.all.size();i++){
			if (modele.all.get(i).Nom == nom){
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");

			}
		}
		Images plop = new Images();

		try{

			File chemin = new File(path);

			plop.img = ImageIO.read(chemin);
			plop.Nom=nom;
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
					Color color = new Color(plop.img.getRGB(i, j));
					red += color.getRed();
					green += color.getGreen();
					blue += color.getBlue();
				}
			}
			red = red/x*y;
			green = green/x*y;
			blue = blue/x*y;
			Color color = new Color(red,green,blue);
			plop.couleur=color;
			modele.all.add(plop);

		}catch (IOException e){
			e.printStackTrace();
		}
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

		for (int i=0;i<modele.albums.size();i++){

			if (modele.albums.get(i).Nom == nom){
				throw new ExceptionNomUtilise("Ce nom est déjà utilise");	
			}

		}
		Album plop=new Album();
		plop.Nom=nom;
		modele.albums.add(plop);
	}

	public void ajouter_album(Album alb, Images img)/*throws ExceptionIntrouvable*/{
		if (modele.albums.contains(alb)){
			alb.contenu.add(img);
		}
		/*else{
			throw new ExceptionIntrouvable("Cet album n'existe pas");
		}*/
	}

	public void toggle_favoris(Images img){
		img.favori=!img.favori;
	}
	
	/*public static void recup_dim(Images img){
		int x = ((RenderedImage) img).getWidth();
		int y = ((RenderedImage) img).getHeight();
		img.dim_x = x;
		img.dim_y = y;
	}*/

	



}


