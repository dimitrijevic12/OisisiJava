package controllers;


import model.BazaStudent;
import model.Student;
import view.AbstractTableModelStudent;
import view.StudentiTable;

public class StudentiController {
	
	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if(instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}

	
	public void dodajStudenta(Student s){
		BazaStudent.getInstance().dodajStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentiTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void izmeniStudenta(Student s) {
		BazaStudent.getInstance().izmeniStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentiTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
	public void brisanjeStudenta(Student s) {
		BazaStudent.getInstance().brisanjeStudenta(s);
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentiTable.getInstance().getModel();
		model.fireTableDataChanged();
	}
	
}
