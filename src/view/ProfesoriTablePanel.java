package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

public class ProfesoriTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1515538612334146715L;
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	public ProfesoriTablePanel() {
		super();
		this.setBackground(Color.WHITE);
	}
	
	public ProfesoriTablePanel(Component c) {
		setLayout(new BorderLayout());
		this.add(leftPanel, BorderLayout.WEST);
		this.add(rightPanel, BorderLayout.EAST);
		this.setBackground(Color.WHITE);
		add(c);
	}
	
}
