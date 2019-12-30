package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151702376082229142L;
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String indeks;
	private Date datumUpisa;
	private Integer godinaStudija;
	private Status status;
	private Float prosek;
	private ArrayList<Predmet> predmeti;
	
	public Student(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String indeks, Date datumUpisa, Integer godinaStudija, Status status, Float prosek) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.indeks = indeks;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.status = status;
		this.prosek = prosek;
		predmeti= new ArrayList<Predmet>();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Float getProsek() {
		return prosek;
	}

	public void setProsek(Float prosek) {
		this.prosek = prosek;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	public Boolean dodajPredmet(Predmet predmet) 
	{
		return predmeti.add(predmet);
		
	}
	
	public Boolean ukloniPredmet(Predmet predmet) 
	{
		return predmeti.remove(predmet);
		
	}
	
}
