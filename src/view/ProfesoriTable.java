package view;

import javax.swing.JTable;

public class ProfesoriTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2696405798928324610L;

	public ProfesoriTable() {
		this.setModel(new AbstractTableModelProfesor());
	}
}
