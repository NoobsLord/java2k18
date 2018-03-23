package v0;

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

		plop.Nom=nom;
		plop.path=path;

		try{

			File chemin = new File(path);
			plop.img = ImageIO.read(chemin);
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





}


