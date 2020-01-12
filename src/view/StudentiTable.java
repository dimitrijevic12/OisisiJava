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
	private TableRowSorter<AbstractTableModelStudent> sorter;
	
	private StudentiTable() {
		this.setModel(new AbstractTableModelStudent());
		sorter = new TableRowSorter<>((AbstractTableModelStudent) getModel());
		this.setRowSorter(sorter);
	}
	
	public void search(String query) {
		String[] parts = query.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("broj indeksa", "");
		map.put("ime", "");
		map.put("prezime", "");
		map.put("datum rođenja", "");
		map.put("trenutna godina studija", "");
		map.put("status", "");
		map.put("prosečna ocena", "");

		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			System.out.println("Kljuc: " + splited[0].toLowerCase() + "\nVrednost: " + splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		
		rfs.add(RowFilter.regexFilter(".*" + map.get("broj indeksa") + ".*", 0));
		rfs.add(RowFilter.regexFilter(".*" + map.get("ime") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("prezime") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("datum rođenja") + ".*", 3));
		rfs.add(RowFilter.regexFilter(".*" + map.get("trenutna godina studija") + ".*", 4));
		rfs.add(RowFilter.regexFilter(".*" + map.get("status") + ".*", 5));
		rfs.add(RowFilter.regexFilter(".*" + map.get("prosečna ocena") + ".*", 6));
		
		sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
	

}
