package view;


import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesor extends AbstractTableModel{

	private static final long serialVersionUID = 8802202392787526904L;
	
	@Override
	public int getColumnCount() {
//		return columnNames.length;
		return BazaProfesora.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}
	
	@Override
	public String getColumnName(int col) {
//		return columnNames[col];
		return BazaProfesora.getInstance().getColumnName(col);
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaProfesora.getInstance().getValueAt(row, column);
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		super.setValueAt(value, row, col);
	}

}