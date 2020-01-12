package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfesoriTab extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8864686452389354830L;

	public ProfesoriTab() {
		
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollProf= new JScrollPane();
		ProfesoriTable profesoriTabela = ProfesoriTable.getInstance();
		this.add(scrollProf, BorderLayout.CENTER);
		scrollProf.setViewportView(profesoriTabela);
	}
	
}