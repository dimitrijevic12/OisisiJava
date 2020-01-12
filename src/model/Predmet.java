package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6406874098458315733L;
	private String sifra;
	private String naziv;
	private Semestar semestar;
	private GodinaStudija godina;
	private Profesor profesor;
	private ArrayList<Student> studenti;
	
	public Predmet() {
		super();
		this.sifra = "";
		this.naziv = "";
		this.semestar = Semestar.PRVI;
		this.godina = GodinaStudija.PRVA;
		this.profesor = null;
		this.studenti = new ArrayList<Student>();
	}
	
	public Predmet(String sifra, String naziv, Semestar semestar, GodinaStudija godina, Profesor profesor,ArrayList<Student> studenti)
	{
			
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		this.profesor = profesor;
		this.studenti = studenti;
	}

	public String getSifra() {
		return sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public GodinaStudija getGodina() {
		return godina;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public ArrayList<Student> getStudenti() {
	return studenti;
	}
	

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public void setGodina(GodinaStudija godina) {
		this.godina = godina;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
	}
	
	public void ukloniStudenta(Student s) {
		this.studenti.remove(s);
	}

	@Override
	public String toString() {
		return "Predmet [sifra=" + sifra + ", naziv=" + naziv + ", semestar=" + semestar + ", godina=" + godina
				+ ", studenti=" + studenti + "]";
	}
	
}
