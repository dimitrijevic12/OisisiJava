package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BazaProfesora {
	private static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	private ArrayList<String> kolone;
	private ArrayList<Profesor> profesori;
	
	private BazaProfesora() {
		initProfesore();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Br. lične karte");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Zvanje");
	}
	
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		Calendar c = Calendar.getInstance();
		c.set(1989, 8, 12);
		profesori.add(new Profesor("Pera", "Peric", new Date(1997, 8, 16), "Micurinova 37", "333-222", "nekiTamo@gmail.com", "Radnicka", 123456, Titula.ASISTENT, Zvanje.DR, new ArrayList<Predmet>()));
		profesori.add(new Profesor("Marko", "Markovic", Calendar.getInstance().getTime(), "Micurinova 137", "3331413-222", "nekiTamo2@gmail.com", "Radnicka 12", 4241421, Titula.DOCENT, Zvanje.DR, new ArrayList<Predmet>()));
		profesori.add(new Profesor("Petar", "Petrovic", Calendar.getInstance().getTime(), "Micurinova 2314237", "33344-22222", "nekiTamo3@gmail.com", "Radnicka 18", 1234321456, Titula.ASISTENT, Zvanje.MR, new ArrayList<Predmet>()));
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Profesor profesor = this.profesori.get(row);
		switch(column) {
		case 0: return Integer.toString(profesor.getBrLicne());
		case 1: return profesor.getIme();
		case 2: return profesor.getPrezime();
		case 3: return profesor.getZvanje().toString();
		default: return null;
		}
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, int brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti));
	}
	
	public void izbrisiProfesora(int brLicneKarte) {
		for (Profesor p : profesori) {
			if (p.getBrLicne() == brLicneKarte) {
				profesori.remove(p);
				break;
			}
		}
	}
	
	public void izmeniProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, int brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		for (Profesor p : profesori) {
			if (p.getBrLicne() == brLicne) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodjenja(datumRodjenja);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setTelefon(telefon);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setBrLicne(brLicne);
				p.setTitula(titula);
				p.setZvanje(zvanje);
			}
		}
	}
	
}
