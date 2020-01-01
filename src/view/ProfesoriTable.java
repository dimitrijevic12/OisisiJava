package view;

import javax.swing.JTable;

public class ProfesoriTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2696405798928324610L;
	
	private static ProfesoriTable instance = null;
	
	public static ProfesoriTable getInstance() {
		if(instance == null) {
			instance = new ProfesoriTable();
		}
		return instance;
	}
	
	private ProfesoriTable() {
		this.setModel(new AbstractTableModelProfesor());
	}
}
