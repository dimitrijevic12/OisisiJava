package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controllers.PredmetiController;
import model.BazaPredmeta;
import model.Predmet;

public class DodavanjeProfesoraNaPredmet extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 729002353215829058L;
	
	public String brLicne;

	public DodavanjeProfesoraNaPredmet() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		GridBagLayout gL = new GridBagLayout();
		
		BorderLayout bL = new BorderLayout();
		this.setLayout(bL);
		
//		BorderLayout bL1 = new BorderLayout();
		JPanel panel = new JPanel();
		panel.setLayout(gL);
		
		JLabel label = new JLabel("Unesite broj licne karte profesora");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 0, 0, 0);
		panel.add(label);
		
		JTextField brLicneTextField = new JTextField();
		brLicneTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		brLicneTextField.setColumns(17);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(brLicneTextField, c);
		
		add(panel);
		
		
		 JPanel panel2 = new JPanel();
		  
		 JButton btnPotvrda = new JButton("Potvrda"); 
		 btnPotvrda.setEnabled(false);
		 JButton btnOdustanak = new JButton("Odustanak");
		 panel2.add(btnOdustanak);
		 panel2.add(btnPotvrda);
		 add(panel2, BorderLayout.SOUTH);
		 
		 KeyListener myKeyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(brLicneTextField.getText().trim().length() > 0) {
					btnPotvrda.setEnabled(true);
				}else {
					btnPotvrda.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		brLicneTextField.addKeyListener(myKeyListener);
		 
		btnPotvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = PredmetiTable.getInstance().convertRowIndexToModel(PredmetiTable.getInstance().getSelectedRow());
				Predmet predmet = BazaPredmeta.getInstance().getRow(rowIndex);
				
				PredmetiController.getInstance().dodavanjeProfesoraNaPredmet(predmet, brLicneTextField.getText());
				dispose();
			}
		});
		
		btnOdustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		this.setSize(d.width/5, d.height/5);
		this.setTitle("Dodavanje profesora na predmet");
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}
}
