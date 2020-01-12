package view;


import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;
import model.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5957678127438776392L;

	public int getRowCount() {
		return BazaStudent.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCount() ;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 7)
			return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 7) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		
		return null;
		
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		super.setValueAt(value, rowIndex, columnIndex);
		if (columnIndex != 7) {
			return;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 7;
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			return JButton.class;
		default:
			return null;
		}
	}
}