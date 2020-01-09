package view;

	import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controllers.PredmetiController;
import controllers.ProfesoriController;
import controllers.StudentiController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import model.Student;

	public class MainMenu extends JMenuBar {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 5103817458709866267L;
		private int tab;
		public MainMenu(){
			
			setFont(new Font("Arial", Font.PLAIN, 20));
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
			
			miNew.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(tab==0){
						DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(0,null);
						d.setVisible(true);
					}
					else if(tab==1)
					{
						DodavanjeProfesoraDialog d = new DodavanjeProfesoraDialog(0,null);
					    d.setVisible(true);
					}
					else
					{
							DodavanjePredmetaDialog d = new DodavanjePredmetaDialog();
						    d.setVisible(true);
					}
				}});
			
			
			miClose.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.exit(0);
				}});
			
			miEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(tab==0){
						if(!StudentiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int rowIndex = StudentiTable.getInstance().convertRowIndexToModel(StudentiTable.getInstance().getSelectedRow());
							Student student = BazaStudent.getInstance().getRow(rowIndex);
							
							DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(1,student);
							d.setVisible(true);
						}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da izmenite ", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
							}
					}
					else if(tab==1)
						{
						if(!ProfesoriTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int rowIndex = ProfesoriTable.getInstance().convertRowIndexToModel(ProfesoriTable.getInstance().getSelectedRow());
							Profesor profesor = BazaProfesora.getInstance().getRow(rowIndex);
							
							
							DodavanjeProfesoraDialog d=new DodavanjeProfesoraDialog(1,profesor);
							d.setVisible(true);
						}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati profesora kog zelite da izmenite ", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
							}
						}
					else
						{
							if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
									int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
									Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
									
									IzmenaPredmetaDijalog dialog = new IzmenaPredmetaDijalog(predmet);
									dialog.setVisible(true);
							}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji zelite da izmenite ", "Predmet nije izabran!", JOptionPane.ERROR_MESSAGE);
							}
						}
					
				}});
			
			miDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(tab==0){
						if(!StudentiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int rowIndex = StudentiTable.getInstance().convertRowIndexToModel(StudentiTable.getInstance().getSelectedRow());
								Student student = BazaStudent.getInstance().getRow(rowIndex);
						
									String poruka ="Da li ste sigurni da želite da obrišete "+student.getIme()+" "+student.getPrezime()+" ?";
						
										if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
												StudentiController.getInstance().brisanjeStudenta(student);
										else return;
						}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati studenta kog zelite da obrisete ", "Student nije izabran!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(tab==1)
					{
						if(!ProfesoriTable.getInstance().getSelectionModel().isSelectionEmpty()) {
								int rowIndex = ProfesoriTable.getInstance().convertRowIndexToModel(ProfesoriTable.getInstance().getSelectedRow());
								Profesor profesor = BazaProfesora.getInstance().getRow(rowIndex);
								
								String poruka ="Da li ste sigurni da želite da obrišete "+profesor.getIme()+" "+profesor.getPrezime()+" ?";
								
								if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje profesora", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//									ProfesoriController.getInstance().obrisiProfesora(profesor.getBrLicne());
								}else return;
							}
						else
						{
							JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati profesora kog zelite da obrisete ", "Profesor nije izabran!", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					else
					{
						if(!ProfesoriTable.getInstance().getSelectionModel().isSelectionEmpty()) {
							int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
							System.out.println("Selected row: " + rowIndex);
							Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
							
							String poruka ="Da li ste sigurni da želite da obrišete "+predmet.getNaziv()+" ?";
							
							if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								PredmetiController.getInstance().brisanjePredmetaIzTabele(predmet);
							}else return;
						}
					}
				}});
			
		}
		public int getTab() {
			return tab;
		}
		public void setTab(int tab) {
			this.tab = tab;
		}

	}


