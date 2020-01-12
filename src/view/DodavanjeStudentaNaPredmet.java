package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.PredmetiController;

public class DodavanjeStudentaNaPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6032232686414917989L;
	private JLabel lIndeks;
	private JTextField tIndex;
	private JPanel panel,pDugme;
	private  JButton btnPotvrda,btnOdustanak;
	
	public DodavanjeStudentaNaPredmet() {

		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		GridBagLayout gbl = new GridBagLayout();
		
		BorderLayout bL = new BorderLayout();
		this.setLayout(bL);
		

		panel = new JPanel();
		panel.setLayout(gbl);
		panel.setBackground(Color.WHITE);
		
		lIndeks = new JLabel("Indeks studenta *");
		lIndeks.setHorizontalAlignment(SwingConstants.CENTER);
		lIndeks.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 0, 0, 0);
		panel.add(lIndeks);
		
		tIndex = new JTextField();
		tIndex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tIndex.setColumns(17);
		c.gridx = 0;
		c.gridy = 1;
		panel.add(tIndex, c);
		
		add(panel);
		
		
		 pDugme = new JPanel();
		  
		 btnPotvrda = new JButton("Potvrda"); 
		 btnOdustanak = new JButton("Odustanak");
		 pDugme.add(btnOdustanak);
		 pDugme.add(btnPotvrda);
		 pDugme.setBackground(Color.WHITE);
		 add(pDugme, BorderLayout.SOUTH);
		
		 btnOdustanak.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnOdustanak.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnOdustanak.setBackground(Color.WHITE);
				
			}});
		 
		 btnPotvrda.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
					if(!tIndex.getText().trim().isEmpty())
						PredmetiController.getInstance().dodavanjeStudentaNaPredmet(tIndex.getText());
					else 
						JOptionPane.showMessageDialog(new JFrame(), "Unesite broj indeksa", "Obavezna polja nisu popunjena!", JOptionPane.ERROR_MESSAGE);
					
					dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				btnPotvrda.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				btnPotvrda.setBackground(Color.WHITE);
			}});
		 
		this.setBackground(Color.WHITE);
		this.setSize(d.width/5, d.height/5);
		this.setTitle("Predmet- dodavanje studenta");
		this.setLocationRelativeTo(null);
		this.setModal(true);
	}
}
