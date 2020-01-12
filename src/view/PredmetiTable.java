package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

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
	
	private TableRowSorter<AbstractTableModelPredmeti> sorter;
	
	private PredmetiTable() {
		this.setModel(new AbstractTableModelPredmeti());
		new ButtonColumnPredmeti(this, 5);
		sorter = new TableRowSorter<>((AbstractTableModelPredmeti) getModel());
		this.setRowSorter(sorter);
	}
	
	public void search(String query) {
		String[] parts = query.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("šifra", "");
		map.put("naziv", "");
		map.put("semestar", "");
		map.put("godina", "");
		map.put("profesor", "");
		
		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		rfs.add(RowFilter.regexFilter(".*" + map.get("šifra") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("naziv") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("profesor") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("semestar") + ".*", 3));
		rfs.add(RowFilter.regexFilter(".*" + map.get("godina") + ".*", 4));
		
		
		sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
}
