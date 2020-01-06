package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class StudentiTab extends JPanel {
	private static final long serialVersionUID = -4281405776800745685L;
	
	
	public StudentiTab() {
		
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollStud= new JScrollPane();
		StudentiTable studentiTabela = StudentiTable.getInstance();
		this.add(scrollStud, BorderLayout.CENTER);
		scrollStud.setViewportView(studentiTabela);
	}

	/**
	 * 
	 */
	

	
			
	
}
