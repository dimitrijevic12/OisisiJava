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
		statBar.setSize(getSize());
		getContentPane().add(statBar, BorderLayout.SOUTH);
		
		TabbedPane tabbedPane = new TabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		ProfesorToolbar profesorToolbar = new ProfesorToolbar(this);
		add(profesorToolbar, BorderLayout.NORTH);
		this.setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		
	}
}
