package controllers;

import model.BazaProfesora;
import view.AbstractTableModelProfesor;
import view.ProfesoriTable;

public class ProfesoriController {
	
	private static ProfesoriController instance = null;
	
	public static ProfesoriController getInstance() {
		if(instance == null) {
			instance = new ProfesoriController();
		}
		return instance;
	}
	
	public void obrisiProfesora(int brLicneKarte) {
		BazaProfesora.getInstance().izbrisiProfesora(brLicneKarte);
		
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) ProfesoriTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) ProfesoriTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
}
