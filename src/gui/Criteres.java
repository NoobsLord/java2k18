package gui;
import java.awt.Color;
import modele.*;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import modele.Modele;

public class Criteres extends interfaceGraphique{
	private JComboBox combo1 = new JComboBox();
	private JComboBox combo2 = new JComboBox();
	private JComboBox combo3 = new JComboBox();
	private JComboBox combo4 = new JComboBox();
	private JComboBox combo5 = new JComboBox();
	private JLabel mocle1 = new JLabel("Mots clé 1");
	private JLabel mocle2 = new JLabel("Mots clé 2");
	private JLabel mocle3 = new JLabel("Mots clé 3");
	private JLabel mocle4 = new JLabel("Mots clé 4");
	private JLabel mocle5 = new JLabel("Mots clé 5");
	
	private JButton b_valider= new JButton("Valider");
	
	//interfaceGraphique A= new interfaceGraphique();
	
	
	public Criteres(){
		
		//Combobox_ mots clé 1
		  //Création de ta JComboBox
		 
		for(int i=0; i<modele.Modele.mots_clefs.size(); i++)
		{
		    combo1.addItem(modele.Modele.mots_clefs.get(i));  //Remplissage avec les noms stockés dans un ArrayList
		}
		/*
	
        mocle1.setBounds(23, 130, 150, 200);
		combo1.setBounds(100, 218, 120, 25);
	    combo1.addItem("Option 1");
	    combo1.addItem("Option 2");
	    combo1.addItem("Option 3");
	    combo1.addItem("Option 4");
	    this.getContentPane().add(combo1);
	    this.getContentPane().add(mocle1); */
	    
	    //mot clé 2
		for(int i=0; i<modele.Modele.mots_clefs.size(); i++)
		{
		    combo2.addItem(modele.Modele.mots_clefs.get(i));  //Remplissage avec les noms stockés dans un ArrayList
		}
		/*
	    mocle2.setBounds(23, 180, 150, 200);
		combo2.setBounds(100, 268, 120, 25);
	    combo2.addItem("Option 1");
	    combo2.addItem("Option 2");
	    combo2.addItem("Option 3");
	    combo2.addItem("Option 4");
	    this.getContentPane().add(combo2);
	    this.getContentPane().add(mocle2);*/
		
        //mot clé 3
		for(int i=0; i<modele.Modele.mots_clefs.size(); i++)
		{
		    combo1.addItem(modele.Modele.mots_clefs.get(i));  //Remplissage avec les noms stockés dans un ArrayList
		}
		
	    /*mocle3.setBounds(23, 230, 150, 200);
		combo3.setBounds(100, 318, 120, 25);
	    combo3.addItem("Option 1");
	    combo3.addItem("Option 2");
	    combo3.addItem("Option 3");
	    combo3.addItem("Option 4");
	    this.getContentPane().add(combo3);
	    this.getContentPane().add(mocle3); */
        
        //mot clé 4
		for(int i=0; i<modele.Modele.mots_clefs.size(); i++)
		{
		    combo1.addItem(modele.Modele.mots_clefs.get(i));  //Remplissage avec les noms stockés dans un ArrayList
		}
		
	    /*mocle4.setBounds(23, 280, 150, 200);
		combo4.setBounds(100, 368, 120, 25);
	    combo4.addItem("Option 1");
	    combo4.addItem("Option 2");
	    combo4.addItem("Option 3");
	    combo4.addItem("Option 4");
	    this.getContentPane().add(combo4);
	    this.getContentPane().add(mocle4); */
	    
	    //mot clé 5
		for(int i=0; i<modele.Modele.mots_clefs.size(); i++)
		{
		    combo1.addItem(modele.Modele.mots_clefs.get(i));  //Remplissage avec les noms stockés dans un ArrayList
		}
	    /*mocle5.setBounds(23, 330, 150, 200);
		combo5.setBounds(100, 418, 120, 25);
	    combo5.addItem("Option 1");
	    combo5.addItem("Option 2");
	    combo5.addItem("Option 3");
	    combo5.addItem("Option 4");
	    this.getContentPane().add(combo5);
	    this.getContentPane().add(mocle5);*/
        
        // Valider
	    this.getContentPane().add(b_valider);
	    b_valider.setBounds(this.getWidth()-810,this.getHeight()-225,80,30);
	    // couleur du texte du boutton
        b_valider.setForeground(Color.BLACK);
        // Couleur du boutton
        b_valider.setBackground(Color.WHITE);
        //bordure du boutton
        b_valider.setBorderPainted(true);
        b_valider.setFocusPainted(true);
        Font f2=new Font("Arial", Font.ITALIC, 11);
        b_valider.setFont(f2);
        
        this.setVisible(true);
	}

}
