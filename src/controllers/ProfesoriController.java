package controllers;

import java.util.ArrayList;
import java.util.Date;

import model.BazaProfesora;
import model.Predmet;
import model.Titula;
import model.Zvanje;
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
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, int brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti){
		BazaProfesora.getInstance().dodajProfesora(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti);
		
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) ProfesoriTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelProfesor model = (AbstractTableModelProfesor) ProfesoriTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
}
