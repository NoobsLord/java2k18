package gui;
import javax.swing.JButton;

public class Boutton extends JButton{
	String nom;
	float x1,y1,x2,y2;
	
	public Boutton(String bNom, int bx1, int by1, int bx2, int by2){
		this.nom=bNom;
		this.x1=bx1;
		this.y1=by1;
		this.x2=bx2;
		this.y2=by2;
		
	}

}
