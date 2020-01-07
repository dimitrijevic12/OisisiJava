package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Predmet;
import model.Profesor;

public class PrikazPredmeta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8426010216433710116L;
	public PrikazPredmeta(Profesor prof) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/3);
		setSize(d); 
		
		JScrollPane scroll = new JScrollPane();
		this.add(scroll);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(Predmet p : prof.getPredmeti()) {
			stringBuilder.append(p.getSifra() + " | " + p.getNaziv() + "\n");
		}
		
		JTextArea textArea = new JTextArea(stringBuilder.toString());
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textArea.setEditable(false);
		scroll.setViewportView(textArea);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
