package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5093064061027429275L;


	public MainFrame()
	{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		setSize(d.width/4*3, d.height/4*3);
		setLocationRelativeTo(null);
		setName("Studentska sluzba");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		MainMenu menu = new MainMenu();
		setJMenuBar(menu);
		StatusBar statBar = new StatusBar();
		getContentPane().add(statBar, BorderLayout.SOUTH);
		
		TabbedPane tabbedPane = new TabbedPane();
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		StudentToolbar studentToolbar = new StudentToolbar();
		add(studentToolbar, BorderLayout.NORTH);
		
		ProfesorToolbar profesorToolbar = new ProfesorToolbar();
		PredmetToolbar predmetToolbar = new PredmetToolbar();
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void stateChanged(ChangeEvent e) {		
				int tab = tabbedPane.getSelectedIndex();
				menu.setTab(tab);
				if(tab == 0) {
					getContentPane().add(studentToolbar,  BorderLayout.NORTH);
					studentToolbar.show();
					profesorToolbar.hide();
					predmetToolbar.hide();
				}
				else if(tab == 1) {
					add(profesorToolbar, BorderLayout.NORTH);
					studentToolbar.hide();
					profesorToolbar.show();
					predmetToolbar.hide();
				}
				else {
					add(predmetToolbar, BorderLayout.NORTH);
					studentToolbar.hide();
					profesorToolbar.hide();
					predmetToolbar.show();
				}
				
			}
		});
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				BazaPredmeta.getInstance().deserijalizacijaPredmeta();
				BazaProfesora.getInstance().deserijalizacijaProfesora();
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				BazaPredmeta.getInstance().serijalizacijaPredmeta();
				BazaProfesora.getInstance().serijalizacijaProfesora();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainFrame mf = new MainFrame();
		
		
	}
}
