package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProfesoriTab extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8864686452389354830L;

	public ProfesoriTab() {
		JScrollPane scrollProf= new JScrollPane();
		JTable profesoriTabela = new JTable(new AbstractTableModelProfesor());
		this.add(scrollProf);
		scrollProf.setViewportView(profesoriTabela);
	}
	
}