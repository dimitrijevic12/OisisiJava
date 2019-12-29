package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -545990780982120727L;

	public TabbedPane() {
		
		JPanel panel = new JPanel();
		this.addTab("Studenti", panel);
		
		ProfesoriTab profesori = new ProfesoriTab();
		this.addTab("Profesori", profesori);
		
		PredmetiTab predmeti = new PredmetiTab();
		this.addTab("Predmeti", predmeti);
	}
	
}
