package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import controllers.PredmetiController;
import view.PredmetiTable;


public class BazaPredmeta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3708881607457833073L;
	
	private static BazaPredmeta instance = null;
	
	public static BazaPredmeta getInstance() {
		if(instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private ArrayList<String> kolone;
	private ArrayList<Predmet> predmeti;
	private ArrayList<Student> studenti;
	
	private BazaPredmeta() {
		initPredmete();
		System.out.println("Konstruktor");
		
		this.kolone = new ArrayList<String>();
		kolone.add("Šifra");
		kolone.add("Naziv");
		kolone.add("Profesor");
		kolone.add("Semestar");
		kolone.add("Godina");
	}
	
	public void initPredmete() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("E123", "Analiza", Semestar.PRVI, GodinaStudija.PRVA, new Profesor(BazaProfesora.getInstance().getProfesori().get(0)), new ArrayList<Student>()));
		predmeti.add(new Predmet("E222", "Verovatnoca", Semestar.ČETVRTI, GodinaStudija.DRUGA, new Profesor(), new ArrayList<Student>()));
		predmeti.add(new Predmet("R4345", "SIMS", Semestar.ŠESTI, GodinaStudija.TREĆA, new Profesor(), new ArrayList<Student>()));
		
	}
	
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			String prof;
			if(predmet.getProfesor() == null) {
				prof = "";
			}else prof = predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime();
			return prof;
		case 3:
			return predmet.getSemestar().toString();
		case 4:
			return predmet.getGodina().toString();
		default:
			return null;
		}
	}
	
	public void dodajPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}

	public void dodajPredmet(String sifra, String naziv, Semestar semestar, GodinaStudija godina, Profesor profesor,
			ArrayList<Student> studenti) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar,  godina,  profesor, studenti));
	}

	public void izbrisiPredmet(Predmet p) {
		Profesor prof = p.getProfesor();
		if(prof != null) {
			for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
				if(profesor.getBrLicne().equals(prof.getBrLicne())) {
					profesor.izbrisiPredmet(p.getSifra());
				}
			}
		}
		predmeti.remove(p);
		System.out.println(BazaProfesora.getInstance());
	}

	public void izmeniPredmet(Predmet predmet, String sifra, String naziv, Semestar semestar, GodinaStudija godina) {
		for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			for(Predmet p : profesor.getPredmeti()) {
				if(p.getSifra().equals(predmet.getSifra())) {
					p.setSifra(sifra);
					p.setNaziv(naziv);
					p.setSemestar(semestar);
					p.setGodina(godina);
					break;
				}
			}
		}
		predmet.setSifra(sifra);
		predmet.setNaziv(naziv);
		predmet.setSemestar(semestar);
		predmet.setGodina(godina);
		
	}
	
	public void dodajStudentaNaPredmet(String indeks) {
		int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
		Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(rowIndex);
		
		for(Student s: BazaStudent.getInstance().getStudenti()) {
			if(indeks.toLowerCase().trim().equals(s.getIndeks().trim().toLowerCase() )) {
				if(predmet.getGodina().equals(s.getGodinaStudija()) )
				{
					if(predmet.getStudenti().isEmpty())
					{
						predmet.dodajStudenta(s);
						s.dodajPredmet(predmet);
						return;
					}
					else {
					for(Student student: predmet.getStudenti()) {
						if(!indeks.toLowerCase().equals(student.getIndeks().toLowerCase()))
							{	
	
								predmet.dodajStudenta(student);
								student.dodajPredmet(predmet);
								return;
							}
						else
							{
							JOptionPane.showMessageDialog(null,"Student je vec upisan na ovaj predmet ", "Greška",JOptionPane.ERROR_MESSAGE);
							return;
							}
					}
				}
			}else 
				JOptionPane.showMessageDialog(null,"Student nije odgovarajuca godina za izabrani predmet", "Greška",JOptionPane.ERROR_MESSAGE);
				return;
				
				}
		}
		JOptionPane.showMessageDialog(null,"Ne postoji student sa unetim indeksom ", "Greška",JOptionPane.ERROR_MESSAGE);
	}
	
	public void dodajProfesoraNaPredmet(int indeks, String brLicneKarte) {
		int postoji = 0;
		Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(indeks);
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrLicne().equals(brLicneKarte)) {
				postoji = 1;
				if(predmet.getProfesor() == null) {
					predmet.setProfesor(p);
					p.getPredmeti().add(predmet);
					break;
				}else if(!predmet.getProfesor().getBrLicne().equals(p.getBrLicne())){
					
					brisanjeProfesoraSaPredmeta(indeks);
					predmet.setProfesor(p);
					p.getPredmeti().add(predmet);	
					break;
				}else {
					JOptionPane.showMessageDialog(null, "Već postoji profesor na tom predmetu sa istim brojem lične karte", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(postoji == 0) {
			JOptionPane.showMessageDialog(null, "Ne postoji zadati broj lične karte u bazi profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void obrisiStudentaSaPredmeta(String indeks,Predmet predmet) {
		for(Student student:predmet.getStudenti())
			if(student.getIndeks().toLowerCase().trim().equals(indeks.trim().toLowerCase()))
				{
				predmet.ukloniStudenta(student);
				student.ukloniPredmet(predmet);
				return;
				}
	}
	
	public void brisanjeProfesoraSaPredmeta(int index) {
		Predmet predmet = BazaPredmeta.getInstance().getPredmeti().get(index);
		Profesor prof = BazaPredmeta.getInstance().getPredmeti().get(index).getProfesor();
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrLicne().equals(prof.getBrLicne())) {
				p.izbrisiPredmet(predmet.getSifra());
				break;
			}
		}
		predmet.setProfesor(null);
		System.out.println(BazaProfesora.getInstance());
	}
	
	@Override
	public String toString() {
		return "BazaPredmeta [kolone=" + kolone + ", predmeti=" + predmeti + "]";
	}
	
	public void serijalizacijaPredmeta() {
		try {
			FileOutputStream fPred = new FileOutputStream("predmeti.ser");
			ObjectOutputStream predOut = new ObjectOutputStream(fPred);
			predOut.writeObject(BazaPredmeta.getInstance().getPredmeti());
			
			predOut.close();
			fPred.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void deserijalizacijaPredmeta() {
		try {
			System.out.println("\n\n");
			FileInputStream fPred = new FileInputStream("predmeti.ser");
			ObjectInputStream predIn= new ObjectInputStream(fPred);
			ArrayList<Predmet> predmeti = (ArrayList<Predmet>) predIn.readObject();
			BazaPredmeta.getInstance().setPredmeti(predmeti);
			PredmetiController.getInstance().promenaPosleDeserijalizacije();
			
			fPred.close();
			predIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}

}
