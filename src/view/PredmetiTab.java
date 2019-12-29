package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetiTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 414200236974886159L;

	public PredmetiTab() {
		
		BorderLayout bLayout = new BorderLayout();
		this.setLayout(bLayout);
		JScrollPane scrollPred= new JScrollPane();
		PredmetiTable predmetiTabela = new PredmetiTable();
		this.add(scrollPred, BorderLayout.CENTER);
		scrollPred.setViewportView(predmetiTabela);
		
	}
}
