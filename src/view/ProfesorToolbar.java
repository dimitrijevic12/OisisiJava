package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controllers.PredmetiController;
import controllers.ProfesoriController;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class ProfesorToolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5037256631147985137L;
	private JTextField textField;
	public ProfesorToolbar() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addProfesorBtn = new JButton("");
		addProfesorBtn.setIcon(new ImageIcon("images/Add_user32.png"));
		addProfesorBtn.setToolTipText("Dodavanje profesora");
		panel.add(addProfesorBtn);
		
		JButton editProfesorBtn = new JButton("");
		editProfesorBtn.setIcon(new ImageIcon("images/Edit32.png"));
		editProfesorBtn.setToolTipText("Izmena profesora");
		panel.add(editProfesorBtn);
		
		JButton deleteProfesorBtn = new JButton("");
		deleteProfesorBtn.setIcon(new ImageIcon("images/Delete32.png"));
		deleteProfesorBtn.setToolTipText("Brisanje profesora");
		panel.add(deleteProfesorBtn);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(textField);
		textField.setColumns(15);
		
		JButton searchProfesorBtn = new JButton("");
		searchProfesorBtn.setIcon(new ImageIcon("images/Search32.png"));
		panel_1.add(searchProfesorBtn);
		
		addProfesorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeProfesoraDialog d = new DodavanjeProfesoraDialog();
			    d.setVisible(true);
			}
		});
		
		deleteProfesorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = ProfesoriTable.getInstance().convertRowIndexToModel(ProfesoriTable.getInstance().getSelectedRow());
				Profesor profesor = BazaProfesora.getInstance().getRow(rowIndex);
				if(JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete profesora", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					ProfesoriController.getInstance().obrisiProfesora(profesor.getBrLicne());
				}else return;
			}
		});
	
	}
}
