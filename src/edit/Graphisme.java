import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Graphisme extends JPanel {
	
	public void paintComponent(Graphics g){
		// Couleur de fond fenetre
		super.paintComponent(g);
		this.setBackground(new Color(200,200,200));
		int x1=this.getWidth()/4;
		int y1=this.getHeight()/4;
		int y2=this.getHeight()-130;
		System.out.println("cliqué");
		g.drawLine(0,80,this.getWidth(),80);
		g.drawLine(0, 130, this.getWidth(), 130);
		g.drawLine(this.getWidth()-890, this.getHeight()-y2, this.getWidth()-890, this.getHeight());
		this.setVisible(true);
		
	}
}