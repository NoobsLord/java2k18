package gui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class actionListener extends JFrame implements ActionListener {
	 
	
	public actionListener(){
		super();
		
	}

	
	public void actionPerformed(ActionEvent e) {
		/*System.out.println("jjk");
		JOptionPane jop=new JOptionPane();
		int option = jop.showConfirmDialog(null, 
		        "Voulez-vous vraiment quitter ?", 
		        "Confirmation", 
		        JOptionPane.YES_NO_OPTION, 
		        JOptionPane.QUESTION_MESSAGE);
		JComboBox combo = new JComboBox();
		JLabel label = new JLabel("Une ComboBox");
		combo.setPreferredSize(new Dimension(100, 20));
	    combo.addItem("Option 1");
	    combo.addItem("Option 2");
	    combo.addItem("Option 3");
	    combo.addItem("Option 4");
	    this.getContentPane().add(combo);
	    this.getContentPane().add(label);
		this.setVisible(true);*/
		
		Criteres C=new Criteres();
		
		
	}

}
