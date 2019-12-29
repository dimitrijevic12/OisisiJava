package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetiTab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 414200236974886159L;

	public PredmetiTab() {
		
		JScrollPane scrollPred= new JScrollPane();
		PredmetiTable predmetiTabela = new PredmetiTable();
		this.add(scrollPred);
		scrollPred.setViewportView(predmetiTabela);
		
	}
}
