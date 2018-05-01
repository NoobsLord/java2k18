package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ShowImage extends JPanel {
	
	BufferedImage  image;
	
	public ShowImage(String chemin_de_limage) {
		    try {
		 
		  File input = new File(chemin_de_limage);
		      image = ImageIO.read(input);
		    } catch (IOException ie) {
		      System.out.println("Error:"+ie.getMessage());
		    }
		  }
		 
		// cette méthode c'est elle qui va afficher l'image
		  public void paint(Graphics g) {
		    g.drawImage( image, 0, 0, null);
		  }
		
}
