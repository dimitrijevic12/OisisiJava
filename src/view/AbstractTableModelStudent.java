package view;


import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5957678127438776392L;

	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getStudenti().size();
	}
	
	@Override
	public String getColumnName(int col) {
		return BazaStudent.getInstance().getColumnName(col);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaStudent.getInstance().getValueAt(row, column);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	/*@Override
	public void setValueAt(Object value, int row, int col) {
		super.setValueAt(value, row, col);
	}*/

}