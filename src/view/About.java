package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import model.Student;

public class About  extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7754918383926484094L;
	
	JPanel panel,p1,p2,p3;
	JTextArea lAplikacija,lAutor1,lAutor2;
	
	public About() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension d = new Dimension();
	d = kit.getScreenSize();
	d.setSize(d.width/4, d.height/3);
	setSize(d);
	
	GridLayout grid = new GridLayout(3,1);
	String aplikacija=" Naziv:Studentska služba \n Verzija:1.0\n Aplikacija pruza nogucnost lakog upravljanja\n podacima studentskih sluzbi fakulteta ";
	String autor1=" Autor : Nemanja Dimitrijević, rođen u Beogradu 16.08.1997. \n Završio Gimnaziju \"Branko Radičević\" u Staroj Pazovi. \n Student 3. godine Fakulteta Tehničkih Nauka, smer E2\n Radio deo projekta koji treba da radi student 2";
	String autor2=" Autor : Slađana Vojnović \n Student 3. godine Fakulteta Tehničkih Nauka, smer E2\n Radila deo koji treba da radi student 1";
	
	panel=new JPanel(grid);
	
	
	lAplikacija=new JTextArea(aplikacija);
	lAplikacija.setEditable(false);
	lAplikacija.setFont(new Font("Tahoma", Font.PLAIN, 12) );
	lAplikacija.setLineWrap(true);
	lAplikacija.setWrapStyleWord(true); 
	panel.add(lAplikacija);


	lAutor1=new JTextArea(autor1);
	lAutor1.setEditable(false);
	lAutor1.setFont(new Font("Tahoma", Font.PLAIN, 12) );
	lAutor1.setLineWrap(true);
	lAutor1.setWrapStyleWord(true); 
	panel.add(lAutor1);
	
	
	lAutor2=new JTextArea(autor2);
	lAutor2.setEditable(false);
	lAutor2.setFont(new Font("Tahoma", Font.PLAIN, 12) );
	lAutor2.setLineWrap(true);
	lAutor2.setWrapStyleWord(true); 
	panel.add(lAutor2);
	

	add(panel);
	this.setResizable(false);
	this.setTitle("About");
	this.setLocationRelativeTo(null);
	this.setVisible(true);
	
	}
}
