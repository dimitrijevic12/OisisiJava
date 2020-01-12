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
import java.util.ListIterator;

import controllers.StudentiController;

public class BazaStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7997406027033649884L;
	private static BazaStudent instance = null;
	
	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}

	private ArrayList<String> kolone;
	private ArrayList<Student> studenti;
	private SimpleDateFormat sdf;
	
	private BazaStudent() {
		
		sdf=new SimpleDateFormat("dd/MM/yyyy");
		
		initStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");

	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	
	public int getColumnCount() {
		return kolone.size();
	}
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch(column) {
		case 0: return student.getIndeks();
		case 1: return student.getIme();
		case 2: return student.getPrezime();
		case 3: return sdf.format(student.getDatumRodjenja());
		case 4: return student.getGodinaStudija().toString();
		case 5: return student.getStatus().toString();
		case 6: return student.getProsek().toString();
		default: return null;
		}
	}
	
	public void dodajStudenta(Student s) {
		this.studenti.add(s);
		
	}
	
	public void izmeniStudenta(Student s) {
		ListIterator<Student> iterator = studenti.listIterator();
		while (iterator.hasNext()) {
			Student student=iterator.next();
				if(student.getIndeks().equals(s.getIndeks())) {
					student.setIme(s.getIme());
					student.setPrezime(s.getPrezime());
					student.setAdresaStanovanja(s.getAdresaStanovanja());
					student.setEmail(s.getEmail());
					student.setTelefon(s.getTelefon());
					student.setDatumRodjenja(s.getDatumRodjenja());
					student.setGodinaStudija(s.getGodinaStudija());
					student.setStatus(s.getStatus());
					iterator.set(student);
					System.out.println(iterator.toString());
				}
			
			}
	}
	
	public void brisanjeStudenta(Student s) {
		ListIterator<Student> iterator = studenti.listIterator();
		while (iterator.hasNext()) {
			Student student=iterator.next();
				if(student.getIndeks().equals(s.getIndeks())) {
					iterator.remove();
					}
				}
	}
	
	public void serijalizacijaStudenata() {
		try {
			FileOutputStream fStudenata = new FileOutputStream("studenti.ser");
			ObjectOutputStream studentOut = new ObjectOutputStream(fStudenata);
			studentOut.writeObject(BazaStudent.getInstance().getStudenti());
			
			studentOut.close();
			fStudenata.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserijalizacijaStudenata() {
		try {
			System.out.println("\n\n");
			FileInputStream fStudenata = new FileInputStream("studenti.ser");
			ObjectInputStream studentIn = new ObjectInputStream(fStudenata);
			@SuppressWarnings("unchecked")
			ArrayList<Student> studenti = (ArrayList<Student>) studentIn.readObject();
			BazaStudent.getInstance().setStudenti(studenti);
		    StudentiController.getInstance().promenaPosleDeserijalizacije();
			
			studentIn.close();
			fStudenata.close();
		}catch (IOException e) {
			
			 e.printStackTrace();
		}catch (ClassNotFoundException cnf) {
		  	 
			cnf.printStackTrace();
		}
	}
	
	
}