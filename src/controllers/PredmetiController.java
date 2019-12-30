package controllers;

import java.util.ArrayList;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.GodinaStudija;
import model.Predmet;
import model.Profesor;
import model.Semestar;
import model.Student;
import view.AbstractTableModelPredmeti;
import view.PredmetiTable;

public class PredmetiController {
	

	private static PredmetiController instance = null;
	
	public static PredmetiController getInstance() {
		if (instance == null) {
			instance = new PredmetiController();
		}
		return instance;
	}
	
	private PredmetiController() {
		
	}
	
	public void dodavanjePredmetaUTabelu(String sifra, String naziv, Semestar semestar1, GodinaStudija godina1) {
		
		BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar1, godina1, new Profesor(), new ArrayList<Student>());
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void brisanjePredmetaIzTabele(Predmet p) {
		BazaPredmeta.getInstance().izbrisiPredmet(p);
		
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void dodavanjeProfesoraNaPredmet(Predmet predmet, String brLicneKarte) {
		BazaPredmeta.getInstance().dodajProfesoraNaPredmet(predmet, brLicneKarte);
		System.out.println(BazaProfesora.getInstance());
		
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void izmenaPredmetaIzTabele(Predmet predmet, String sifra, String naziv, Semestar semestar1, GodinaStudija godina1) {
		BazaPredmeta.getInstance().izmeniPredmet(predmet, sifra, naziv, semestar1, godina1);
		
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void brisanjeProfesoraSaPredmeta(Predmet predmet) {
		BazaPredmeta.getInstance().brisanjeProfesoraSaPredmeta(predmet);
		
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
	
	public void promenaPosleDeserijalizacije() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) PredmetiTable.getInstance().getModel();
		
		model.fireTableDataChanged();
	}
}
