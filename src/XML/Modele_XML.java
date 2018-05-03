package XML;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Observable;

import modele.Images;
import modele.Modele;

public class Modele_XML extends Modele { 

	
	public Modèle_XML() {}
	
	public void chargerDonnées(String dir) {
		
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("images.xml")));
			this.images = (ArrayList<Images>) decoder.readObject();
		} catch (FileNotFoundException e) {
			super.chargerDonnées(dir);
		} finally {
			if (decoder != null) {
				decoder.close();
			}
		}
	}

	public void enregistrement() {

		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("images.xml")));
			encoder.writeObject(this.images);
			encoder.flush();
		} catch (final java.io.IOException err) {
			err.printStackTrace();
		} finally {
			if (encoder != null) {
				encoder.close();
			}