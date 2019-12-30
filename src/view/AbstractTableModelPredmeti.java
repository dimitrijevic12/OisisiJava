package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3261024513031285602L;

	
	public static String kolonaStudenti = "Studenti";

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 5;
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount() + 1;
	}

	@Override
	public String getColumnName(int column) {
		if (column >= BazaPredmeta.getInstance().getColumnCount()) {
			return kolonaStudenti;
		}
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 5)
			return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 5) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
		if (columnIndex != 5) {
			return;
		}
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
			return JButton.class;
		default:
			return null;
		}
	}
	
	
	


}
