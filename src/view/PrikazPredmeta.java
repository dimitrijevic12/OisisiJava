package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

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
		d.setSize(d.width/5, d.height/5);
		setSize(d); 
		
		JScrollPane scroll = new JScrollPane();
		this.add(scroll, BorderLayout.CENTER);
		
		DefaultListModel<String> listData = new DefaultListModel<String>();
		String string = new String();
		
		for(Predmet p : prof.getPredmeti()) {
			string = p.getSifra() + "  |  " + p.getNaziv();
			listData.addElement(string);
		}
		
		JList<String> lista = new JList<String>();
		
		lista.setModel(listData);
		lista.setFont(new Font("Tahoma", Font.PLAIN, 16));
	
		scroll.setViewportView(lista);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
