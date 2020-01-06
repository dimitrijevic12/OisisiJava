package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class StudentiTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2696405798928324610L;
	
	private static StudentiTable instance = null;
	
	public static StudentiTable getInstance() {
		if(instance == null) {
			instance = new StudentiTable();
		}
		return instance;
	}
	
	
	private StudentiTable() {
		this.setModel(new AbstractTableModelStudent());
	}
	
	

}
