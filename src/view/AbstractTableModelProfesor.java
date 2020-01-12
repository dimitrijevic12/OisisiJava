package view;


import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableModelProfesor extends AbstractTableModel{

	private static final long serialVersionUID = 8802202392787526904L;
	
	public static String kolonaPredmeti = "Predmeti";
	
	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount() + 1;
	}

	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}
	
	@Override
	public String getColumnName(int col) {
		if(col >= BazaProfesora.getInstance().getColumnCount()) {
			return kolonaPredmeti;
		}else return BazaProfesora.getInstance().getColumnName(col);	
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column < 10) {
			return BazaProfesora.getInstance().getValueAt(row, column);
		}else if(column == 10){
			JButton btn = new JButton("" + row);
			return btn;
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return col >= 10;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		super.setValueAt(value, row, col);
		if(col != 10) return;
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
		case 8:
		case 9:
		case 10:
			return JButton.class;
		default:
			return null;
		}
	}

}