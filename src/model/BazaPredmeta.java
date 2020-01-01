package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

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

		predmeti.add(new Predmet("E123", "Analiza", Semestar.PRVI, GodinaStudija.PRVA, new Profesor("Pera", "Peric", new Date(), "Micurinova 37", "333-222", "nekiTamo@gmail.com", "Radnicka", 123456, Titula.ASISTENT, Zvanje.DR, new ArrayList<Predmet>()), new ArrayList<Student>()));
		predmeti.add(new Predmet("E222", "Verovatnoca", Semestar.ČETVRTI, GodinaStudija.DRUGA, new Profesor(), new ArrayList<Student>()));
		predmeti.add(new Predmet("R4345", "SIMS", Semestar.ŠESTI, GodinaStudija.TRECA, new Profesor(), new ArrayList<Student>()));
		
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
			prof = predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime();
			return prof;
		case 3:
			return predmet.getSemestar().toString();
		case 4:
			return predmet.getGodina().name();
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
		for (Predmet i : predmeti) {
			if (i.getSifra() == p.getSifra()) {
				predmeti.remove(i);
				break;
			}
		}
	}

	public void izmeniPredmet(Predmet predmet, String sifra, String naziv, Semestar semestar, GodinaStudija godina) {
		predmet.setSifra(sifra);
		predmet.setNaziv(naziv);
		predmet.setSemestar(semestar);
		predmet.setGodina(godina);
	}
	
	public void dodajProfesoraNaPredmet(Predmet predmet, String brLicneKarte) {
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			if(p.getBrLicne() == Integer.parseInt(brLicneKarte)) {
				predmet.setProfesor(p);
				p.getPredmeti().add(predmet);
			}
		}
	}
	
	public void brisanjeProfesoraSaPredmeta(Predmet predmet) {
		predmet.getProfesor().getPredmeti().remove(predmet);
		predmet.setProfesor(new Profesor());
	}

	@Override
	public String toString() {
		return "BazaPredmeta [kolone=" + kolone + ", predmeti=" + predmeti + "]";
	}
	
	private Object readResolve() {
		System.out.println("READ RESOLVE");
		return getInstance();
	}
	
	private Object writeReplace() {
		System.out.println("WRITE REPLACE");
		return this;
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
