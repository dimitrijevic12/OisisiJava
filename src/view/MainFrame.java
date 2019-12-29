package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		
		TabbedPane tabbedPane = new TabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		StudentToolbar studentToolbar = new StudentToolbar();
		add(studentToolbar, BorderLayout.NORTH);
		
		ProfesorToolbar profesorToolbar = new ProfesorToolbar();
		PredmetToolbar predmetToolbar = new PredmetToolbar();
		
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int tab = tabbedPane.getSelectedIndex();
				
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
	
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		
	}
}
