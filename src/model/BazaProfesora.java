package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import controllers.ProfesoriController;

public class BazaProfesora implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7997406027033649884L;
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
		this.kolone.add("Datum rođenja");
		this.kolone.add("Adresa stanovanja");
		this.kolone.add("Telefon");
		this.kolone.add("E-mail");
		this.kolone.add("Adresa kancelarije");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	private void initProfesore() {
		this.profesori = new ArrayList<Profesor>();
		Date datum = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			profesori.add(new Profesor("Aleksa", "Petković", datum = sdf.parse("15.01.1965"), "Temerinska 15, Novi Sad", "021/334-990", "aleksa.petkovic@mailinator.com", "Dositeja Obradovića 6, Novi Sad, MI 105", "007198721", Titula.ASISTENT, Zvanje.DR, new ArrayList<Predmet>()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		profesori.add(new Profesor("Marko", "Markovic", Calendar.getInstance().getTime(), "Micurinova 137", "3331413-222", "nekiTamo2@gmail.com", "Radnicka 12", "4241421", Titula.DOCENT, Zvanje.DR, new ArrayList<Predmet>()));
		profesori.add(new Profesor("Petar", "Petrovic", Calendar.getInstance().getTime(), "Micurinova 2314237", "33344-22222", "nekiTamo3@gmail.com", "Radnicka 18", "1234321456", Titula.ASISTENT, Zvanje.MR, new ArrayList<Predmet>()));
	}

	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 10;
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
		case 0: return profesor.getBrLicne();
		case 1: return profesor.getIme();
		case 2: return profesor.getPrezime();
		case 3: {
			Date datum = profesor.getDatumRodjenja();
		    SimpleDateFormat formatDatum = new SimpleDateFormat("dd/MM/yyyy");
		    String formattedDate = formatDatum.format(datum);
			return formattedDate;
		}
		case 4: return profesor.getAdresaStanovanja();
		case 5: return profesor.getTelefon();
		case 6: return profesor.getEmail();
		case 7: return profesor.getAdresaKancelarije();
		case 8: return profesor.getTitula().toString();
		case 9: return profesor.getZvanje().toString();
		default: return null;
		}
	}
	
	public void dodajProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		this.profesori.add(new Profesor(ime, prezime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije, brLicne, titula, zvanje, predmeti));
	}
	
	
	
	public void izbrisiProfesora(String brLicneKarte) {
		for (Profesor p : profesori) {
			if (p.getBrLicne().equals(brLicneKarte)) {
				int i = -1;
				for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti()) {
					i++;
					for(Predmet pr : p.getPredmeti()) {
						if(pr.getSifra().equals(predmet.getSifra())) {
							BazaPredmeta.getInstance().getPredmeti().get(i).setProfesor(null);
						}
					}
				}
				profesori.remove(p);
				break;
			}
		}
	}
	
	public void izmeniProfesora(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		for (Profesor p : profesori) {
			if (p.getBrLicne().equals(brLicne)) {
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

	@Override
	public String toString() {
		return "BazaProfesora [kolone=" + kolone + ", profesori=" + profesori + "]";
	}
	
	public void serijalizacijaProfesora() {
		try {
			FileOutputStream fProf = new FileOutputStream("profesori.ser");
			ObjectOutputStream profOut = new ObjectOutputStream(fProf);
			profOut.writeObject(BazaProfesora.getInstance().getProfesori());
			
			profOut.close();
			fProf.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	public void deserijalizacijaProfesora() {
		try {
			System.out.println("\n\n");
			FileInputStream fProf = new FileInputStream("profesori.ser");
			ObjectInputStream profIn= new ObjectInputStream(fProf);
			ArrayList<Profesor> profesori = (ArrayList<Profesor>) profIn.readObject();
			BazaProfesora.getInstance().setProfesori(profesori);
			ProfesoriController.getInstance().promenaPosleDeserijalizacije();
			
			fProf.close();
			profIn.close();
		}catch (IOException ie) {
			ie.printStackTrace();
		}catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
	}
	
	public int nadjiPoId(String brLicne) {
		int i = -1;
		for(Profesor p : profesori) {
			i++;
			if(p.getBrLicne().equals(brLicne)) {
				return i;
			}
		}
		return 0;
	}
	
	
}
