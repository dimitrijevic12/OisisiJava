package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import model.BazaPredmeta;

public class PredmetiTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3478162967519031093L;

	private static PredmetiTable instance = null;
	
	public static PredmetiTable getInstance() {
		if(instance == null) {
			instance = new PredmetiTable();
		}
		return instance;
	}
	
	private PredmetiTable() {
		this.setModel(new AbstractTableModelPredmeti());
	}
}
