package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ProfesoriTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2696405798928324610L;
	
	private static ProfesoriTable instance = null;
	
	public static ProfesoriTable getInstance() {
		if(instance == null) {
			instance = new ProfesoriTable();
		}
		return instance;
	}
	
	private TableRowSorter<AbstractTableModelProfesor> sorter;
	
	private ProfesoriTable() {
		this.setModel(new AbstractTableModelProfesor());
		sorter = new TableRowSorter<>((AbstractTableModelProfesor) getModel());
		this.setRowSorter(sorter);
	}
	
	public void search(String query) {
		String[] parts = query.split(";");
		Map<String,String> map = new HashMap<>();
		
		map.put("br.lične", "");
		map.put("ime", "");
		map.put("prezime", "");
		map.put("datum rođenja", "");
		map.put("adresa stanovanja", "");
		map.put("telefon", "");
		map.put("email", "");
		map.put("adresa kancelarije", "");
		map.put("titula", "");
		map.put("zvanje", "");
		
		for(int i = 0; i < parts.length; i++) {
			String[] splited = parts[i].split(":");
			if(splited.length > 1) {
			map.put(splited[0].toLowerCase(), splited[1]);
			System.out.println("Kljuc: " + splited[0].toLowerCase() + "\nVrednost: " + splited[1]);
			}
		}
		
		List<RowFilter<Object,Object>> rfs = new ArrayList<RowFilter<Object,Object>>();
		rfs.add(RowFilter.regexFilter(".*" + map.get("br.lične") + ".*",  0)); 
		rfs.add(RowFilter.regexFilter(".*" + map.get("ime") + ".*", 1));
		rfs.add(RowFilter.regexFilter(".*" + map.get("prezime") + ".*", 2));
		rfs.add(RowFilter.regexFilter(".*" + map.get("datum rođenja") + ".*", 3));
		rfs.add(RowFilter.regexFilter(".*" + map.get("adresa stanovanja") + ".*", 4));
		rfs.add(RowFilter.regexFilter(".*" + map.get("telefon") + ".*", 5));
		rfs.add(RowFilter.regexFilter(".*" + map.get("email") + ".*", 6));
		rfs.add(RowFilter.regexFilter(".*" + map.get("adresa kancelarije") + ".*", 7));
		rfs.add(RowFilter.regexFilter(".*" + map.get("titula") + ".*", 8));
		rfs.add(RowFilter.regexFilter(".*" + map.get("zvanje") + ".*", 9));
		sorter.setRowFilter(RowFilter.andFilter(rfs));
	}
}
