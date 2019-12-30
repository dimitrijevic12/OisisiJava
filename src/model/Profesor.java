package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Profesor {
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String email;
	private String adresaKancelarije;
	private int brLicne;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> predmeti;
	
	public Profesor() {
		this.ime = "";
		this.prezime = "";
		this.datumRodjenja = new Date();
		this.adresaStanovanja = "";
		this.telefon = "";
		this.email = "";
		this.adresaKancelarije = "";
		this.brLicne = 0;
		this.titula = Titula.ASISTENT;
		this.zvanje = Zvanje.DR;
		this.predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, int brLicne, Titula titula, Zvanje zvanje,
			ArrayList<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicne = brLicne;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti = predmeti;
	}
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public String getTelefon() {
		return telefon;
	}
	public String getEmail() {
		return email;
	}
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public int getBrLicne() {
		return brLicne;
	}
	public Titula getTitula() {
		return titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public void setBrLicne(int brLicne) {
		this.brLicne = brLicne;
	}
	public void setTitula(Titula titula) {
		this.titula = titula;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	@Override
	public String toString() {
		return "Profesor [ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", telefon=" + telefon + ", email=" + email
				+ ", adresaKancelarije=" + adresaKancelarije + ", brLicne=" + brLicne + ", titula=" + titula
				+ ", zvanje=" + zvanje + ", predmeti=" + predmeti + "]";
	}
	
	
/*	public Object toCell(int col) {
		switch(col) {
		case 0: return ime;
		case 1: return prezime;
		case 2: return datumRodjenja;
		case 3: return adresaStanovanja;
		case 4: return telefon;
		case 5: return email;
		case 6: return adresaKancelarije;
		case 7: return brLicne;
		case 8: return titula;
		case 9: return zvanje;
		default: return null;
		}
	}

	public void set(int col, Object value) {
		switch(col) {
		case 0: ime = (String)value;
		break;
		case 1: prezime = (String)value;
		break;
		case 2: datumRodjenja = (Calendar)value;
		break;
		case 3: adresaStanovanja = (String)value;
		break;
		case 4: telefon = (String)value;
		break;
		case 5: email = (String)value;
		break;
		case 6: adresaKancelarije = (String)value;
		break;
		case 7: brLicne = (int)value;
		break;
		case 8: titula = (Titula)value;
		break;
		case 9: zvanje = (Zvanje)value;
		}
	}
*/	
}
