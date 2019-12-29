package view;

import javax.swing.JTable;

public class ProfesoriTable extends JTable {
	
	public ProfesoriTable() {
		this.setModel(new AbstractTableModelProfesor());
	}
}
