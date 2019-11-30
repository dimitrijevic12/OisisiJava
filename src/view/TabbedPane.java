package view;

import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	public TabbedPane() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		this.addTab("Studenti", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		this.addTab("Profesori", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		this.addTab("Predmeti", null, panel_2, null);
	}

	public TabbedPane(int tabPlacement, int tabLayoutPolicy) {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		this.addTab("Studenti", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		this.addTab("Profesori", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		this.addTab("Predmeti", null, panel_2, null);
		this.setTabPlacement(tabPlacement);
		this.setTabLayoutPolicy(tabLayoutPolicy);
	}

	public TabbedPane(int tabPlacement) {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		this.addTab("Studenti", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		this.addTab("Profesori", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		this.addTab("Predmeti", null, panel_2, null);
		this.setTabPlacement(tabPlacement);
	}

	@Override
	public void addTab(String title, Component component) {
		super.addTab(title, component);
	}
	
	
	
}
