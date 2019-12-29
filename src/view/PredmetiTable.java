package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PredmetiTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3478162967519031093L;

	public PredmetiTable() {
		this.setModel(new AbstractTableModelPredmeti());
	}
}
