package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controllers.PredmetiController;
import model.BazaPredmeta;
import model.BazaStudent;
import model.Predmet;

public class PredmetToolbar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6783852462327144646L;
	private JTextField textField;
	
	public PredmetToolbar() {
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addPredmetBtn = new JButton("");
		addPredmetBtn.setIcon(new ImageIcon("images/File_add32.png"));
		addPredmetBtn.setToolTipText("Dodavanje predmeta");
		panel.add(addPredmetBtn);
		
		JButton editPredmetBtn = new JButton("");
		editPredmetBtn.setIcon(new ImageIcon("images/Edit32.png"));
		editPredmetBtn.setToolTipText("Izmena predmeta");
		panel.add(editPredmetBtn);
		
		JButton deletePredmetBtn = new JButton("");
		deletePredmetBtn.setIcon(new ImageIcon("images/File_delete32.png"));
		deletePredmetBtn.setToolTipText("Brisanje predmeta");
		panel.add(deletePredmetBtn);
		
		JButton addProfesorUPredmetBtn = new JButton("");
		addProfesorUPredmetBtn.setIcon(new ImageIcon("images/Add32.png"));
		addProfesorUPredmetBtn.setToolTipText("Dodavanje profesora na predmet");
		panel.add(addProfesorUPredmetBtn);
		
		JButton deleteProfesoraSaPredmetaBtn = new JButton("");
		deleteProfesoraSaPredmetaBtn.setIcon(new ImageIcon("images/Delete32.png"));
		deleteProfesoraSaPredmetaBtn.setToolTipText("Brisanje profesora sa predmeta");
		panel.add(deleteProfesoraSaPredmetaBtn);
		
		JButton addStudentUPredmetBtn = new JButton("");
		addStudentUPredmetBtn.setIcon(new ImageIcon("images/Add_user32.png"));
		addStudentUPredmetBtn.setToolTipText("Dodavanje studenta na predmet");
		panel.add(addStudentUPredmetBtn);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(textField);
		textField.setColumns(15);
		
		JButton searchPredmetBtn = new JButton("");
		searchPredmetBtn.setIcon(new ImageIcon("images/Search32.png"));
		searchPredmetBtn.setToolTipText("Pretraga predmeta");
		panel_1.add(searchPredmetBtn);
		
		addPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaDialog d = new DodavanjePredmetaDialog();
			    d.setVisible(true);
			}
		});

		
		
		deletePredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
					System.out.println("Selected row: " + rowIndex);
					Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
					
					if(JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete predmet", "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						PredmetiController.getInstance().brisanjePredmetaIzTabele(predmet);
					}else return;
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji želite da obrišete ", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
					
			}
		});
		addProfesorUPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {	
					DodavanjeProfesoraNaPredmet dialog = new DodavanjeProfesoraNaPredmet();
					dialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet u koji želite da upišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		editPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
					Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
					
					IzmenaPredmetaDijalog dialog = new IzmenaPredmetaDijalog(predmet);
					dialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet koji želite da izmenite", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		deleteProfesoraSaPredmetaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {
					int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
					Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
					if(predmet.getProfesor() != null) {
						if(JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete profesora", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)		
							PredmetiController.getInstance().brisanjeProfesoraSaPredmeta(rowIndex);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Predmet nema profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet iz kojeg želite da obrišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		searchPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String query = textField.getText();
				
				PredmetiTable.getInstance().search(query);
			}
		});
		
		addStudentUPredmetBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!PredmetiTable.getInstance().getSelectionModel().isSelectionEmpty()) {	
					int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
					Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
					
					DodavanjeStudentaNaPredmet dialog = new DodavanjeStudentaNaPredmet();
					dialog.setVisible(true);
				}
				else if(ProfesoriTable.getInstance().getRowCount()==0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Tabela profesora je prazna.\n Molim prvo dodajte predmet.", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Potrebno je izabrati predmet u koji želite da upišete profesora", "Greška!", JOptionPane.ERROR_MESSAGE);
				}
			}});
	}
	
}
