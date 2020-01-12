package view;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Help  extends JDialog {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help() {
		
		this.setLayout(new BorderLayout());
		setSize(550,600);
		setLocationRelativeTo(null);
		
		String help = "	Dodavanje novog studenta \n" + 
				"  Da bi ste dodali novog studenta potrebno je da kliknete na tab\n" + 
				"  na kojem piše \"Student\" i da zatim kliknete dugme za dodavanje\n" + 
				"  studenta ,odnosno prvo dugme od tri koja se nalaze u ćošku iznad \n" + 
				"  tabela. Klikom na dugme pojavice vam se novi prozor , ovde je potrebon\n" + 
				"  popuniti sva polja i potom kliknuti na dugme potvrdi.\n\n" + 
				"	Dodavanje novog profesora \n" + 
				"  Da bi ste dodali novog profesora potrebno je da kliknete na tab\n" + 
				"  na kojem piše \"Profesor\" i da zatim kliknete dugme za dodavanje\n" + 
				"  profesora ,odnosno prvo dugme od tri koja se nalaze u ćošku iznad \n" + 
				"  tabela. Klikom na dugme pojavice vam se novi prozor , ovde je potrebon\n" + 
				"  popuniti sva polja i potom da kliknete dugme potvrdi.\n\n" + 
				"  	Dodavanje novog predmeta\n" + 
				"  Da bi ste dodali novog predmeta potrebno je da kliknete na tab\n" + 
				"  na kojem piše \"Predmet\" i da zatim kliknete dugme za dodavanje\n" + 
				"  predmeta ,odnosno prvo dugme od šest koja se nalaze u ćošku iznad \n" + 
				"  tabela. Klikom na dugme pojavice vam se novi prozor , ovde je potrebon\n" + 
				"  popuniti sva polja i potom da kliknete dugme potvrdi.\n\n" + 
				"	Da bi ste izvršili izmenu podatka potrebno je da izaberete željeni tab\n" + 
				"  ,a potom i željeni podatak i potom pritisnete dugme za izmenu, odnosno\n" + 
				"  drugo dugme od ponu]enih i zatim u novom prozoru izmenite željeni podatak\n" + 
				"	Da bi ste izvršili brisanje podatka potrebno je da izaberete željeni tab\n" + 
				"  ,a potom i željeni podatak i potom pritisnete dugme za brisanje, odnosno\n" + 
				"  treće dugme od ponuđenih\n\n" + 
				"	Ako izaberete tab \"Predmet\" pojavice vam se tri nova dugmeta \n" + 
				"  Ta dugmad vam redom mogu omogućiti da dodate postojećeg profesora na \n" + 
				"  postojeći predmet,da uklonite profesora sa predmeta i da dodate postojećeg \n \r\n" + 
				"  studenta na postojeći predmet \n\n \r\n" + 
				"	Meni\r\n" + 
				"  Meni se sastoji iza opcija file ,edit i help\n" + 
				"  File se sastoji iz opcija new ,koja ima istu funkciju kao i dugme za dodavanje,\n" + 
				"  i close kojom mozete zatvoriti aplikaciju \n\n" + 
				"  Edit se sastoji iz opcija edit ,koja ima istu funkciju kao i dugme za izmenu,\n" + 
				"  i delete ,koja ima istu funkciju kao i dugme za brisanje\n\n" + 
				"  Help se sastoji iz opcija about i help\n" + 
				"  Klikom na about otvara se about prozor koji prikazuje infoemacije \n \r\n" + 
				"  o autorima i aplikaciji \n" + 
				"  Klikom na dugme help otvara se ovaj prozor sa uputstvom za uoptrebu\n\n" + 
				"   Precice :\n\n" + 
				"	CTRL+N Dugme za dodavanje\n" + 
				"	CTRL+W Zatvara aplikaciju\n" + 
				"	CRTL+E Dugme za izmenu\n" + 
				"	CTRL+D Dugme za brisanje \n" + 
				"	CTRL+A Otvara About\n \r\n" + 
				"	CTRL+H Otvara Help \n\n\n";
		
		JTextArea jHelp = new JTextArea(help);
		
        jHelp.setEditable(false);
        JScrollPane jsp = new JScrollPane(jHelp,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(jsp, BorderLayout.CENTER);
        setTitle("Help");

	}

}


