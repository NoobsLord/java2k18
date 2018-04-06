package gui;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JPanel;

import modele.Images;

public class Panel_Image {
	public static void main(String[] args){
		for (int i=0;i<modele.Modele.all.size();i++){
			Image panel = modele.Modele.all.get(i).img;
			Panel_Image wesh = new Panel_Image(i);
		}
	}

	public  Panel_Image(int i){
		Images temp_img = modele.Modele.all.get(i);
		Dimension size = new Dimension(temp_img.dim_x,temp_img.dim_y);
		JPanel temp = new JPanel();
		temp.setPreferredSize(size);
		temp.setMinimumSize(size);
		temp.setMaximumSize(size);
	}




}
