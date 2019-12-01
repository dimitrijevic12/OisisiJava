package view;

	import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

	public class MainMenu extends JMenuBar {
		
		public MainMenu(){
			
			
			JMenu file= new JMenu("File");
			JMenuItem miNew = new JMenuItem("New",new ImageIcon("images/New16.png"));
			miNew.setMnemonic(KeyEvent.VK_N);
			miNew.setAccelerator(KeyStroke.getKeyStroke("control N"));
			JMenuItem miClose = new JMenuItem("Close",new ImageIcon("images/Close16.png"));
			miClose.setMnemonic(KeyEvent.VK_W);
			miClose.setAccelerator(KeyStroke.getKeyStroke("control W"));
			
			file.add(miNew);
			file.add(miClose);
			
			JMenu edit= new JMenu("Edit");
			JMenuItem miEdit = new JMenuItem("Edit",new ImageIcon("images/Edit16.png"));
			miEdit.setMnemonic(KeyEvent.VK_E);
			miEdit.setAccelerator(KeyStroke.getKeyStroke("control E"));
			JMenuItem miDelete = new JMenuItem("Delete",new ImageIcon("images/Delete16.png"));
			miDelete.setMnemonic(KeyEvent.VK_D);
			miDelete.setAccelerator(KeyStroke.getKeyStroke("control D"));
			
			edit.add(miEdit);
			edit.add(miDelete);
			
			JMenu help= new JMenu("Help");
			JMenuItem miHelp=new JMenuItem("Help",new ImageIcon("images/Help16.png"));
			miHelp.setMnemonic(KeyEvent.VK_H);
			miHelp.setAccelerator(KeyStroke.getKeyStroke("control H"));
			JMenuItem miAbout=new JMenuItem("Abput",new ImageIcon("images/About16.png"));
			miAbout.setMnemonic(KeyEvent.VK_A);
			miAbout.setAccelerator(KeyStroke.getKeyStroke("control A"));
			
			help.add(miHelp);
			help.add(miAbout);
			
			add(file);
			add(edit);
			add(help);
			
		}

	}


