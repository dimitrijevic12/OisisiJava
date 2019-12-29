package view;

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
		this.addTab("Studenti", null, panel, null);
		
		ProfesoriTab profesori = new ProfesoriTab();
		this.addTab("Profesori", null, profesori, null);
		
		PredmetiTab predmeti = new PredmetiTab();
		this.addTab("Predmeti", null, predmeti, null);
	}

	public TabbedPane(int tabPlacement, int tabLayoutPolicy) {
		JPanel panel = new JPanel();
		this.addTab("Studenti", null, panel, null);
		
		ProfesoriTab profesori = new ProfesoriTab();
		this.addTab("Profesori", null, profesori, null);
		
		PredmetiTab predmeti = new PredmetiTab();
		this.addTab("Predmeti", null, predmeti, null);
		this.setTabPlacement(tabPlacement);
		this.setTabLayoutPolicy(tabLayoutPolicy);
	}

	public TabbedPane(int tabPlacement) {
		JPanel panel = new JPanel();
		this.addTab("Studenti", null, panel, null);
		
		ProfesoriTab profesori = new ProfesoriTab();
		this.addTab("Profesori", null, profesori, null);
		
		PredmetiTab predmeti = new PredmetiTab();
		this.addTab("Predmeti", null, predmeti, null);
		this.setTabPlacement(tabPlacement);
	}

	@Override
	public void addTab(String title, Component component) {
		super.addTab(title, component);
	}
	
	
}
