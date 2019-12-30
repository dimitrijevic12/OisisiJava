package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controllers.PredmetiController;
import model.GodinaStudija;
import model.Semestar;

public class DodavanjePredmetaDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6059562830346244789L;

	public DodavanjePredmetaDialog() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/3);
		setSize(d);
		
		GridBagLayout gbLayout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(gbLayout);
		
		JLabel sifraLabel = new JLabel("Sifra");
		sifraLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField sifraTextField = new JTextField();
		sifraTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sifraTextField.setColumns(15);
		
		JPanel unosSifre = new JPanel();
		unosSifre.add(sifraLabel);
		unosSifre.add(sifraTextField);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		this.add(unosSifre, c);
		
		JLabel nazivLabel = new JLabel("Naziv");
		nazivLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextField nazivTextField = new JTextField();
		nazivTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nazivTextField.setColumns(15);
		
		JPanel unosNaziva = new JPanel();
		unosNaziva.add(nazivLabel);
		unosNaziva.add(nazivTextField);
		c.gridx = 0;
		c.gridy = 1;
		this.add(unosNaziva, c);
		
		JLabel semestarLabel = new JLabel("Semestar");
		semestarLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox<Semestar> semestarComboBox = new JComboBox<Semestar>(Semestar.values());
		
		JPanel unosSemestra = new JPanel();
		unosSemestra.add(semestarLabel);
		unosSemestra.add(semestarComboBox);
		c.gridx = 0;
		c.gridy = 2;
		this.add(unosSemestra, c);
		
		JLabel godinaLabel = new JLabel("Godina Studija");
		godinaLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox<GodinaStudija> godinaComboBox = new JComboBox<GodinaStudija>(GodinaStudija.values());
		
		JPanel unosGodine = new JPanel();
		unosGodine.add(godinaLabel);
		unosGodine.add(godinaComboBox);
		c.gridx = 0;
		c.gridy = 3;
		this.add(unosGodine, c);
		
		JButton btnOdustanak = new JButton("Odustanak");
		btnOdustanak.setForeground(Color.BLACK);
		btnOdustanak.setBackground(Color.WHITE);
		
		JButton btnPotvrda = new JButton("Potvrda");
		btnPotvrda.setForeground(Color.BLACK);
		btnPotvrda.setBackground(Color.WHITE);
		btnPotvrda.setEnabled(false);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(btnOdustanak);
		buttonPanel.add(btnPotvrda);
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.SOUTHEAST;
		c.fill = GridBagConstraints.NONE;
		this.add(buttonPanel, c);
		
btnOdustanak.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnOdustanak.setBackground(Color.WHITE);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOdustanak.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
			}
		});

btnPotvrda.addMouseListener(new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		btnPotvrda.setBackground(Color.WHITE);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		if((!sifraTextField.getText().equals("")) && !nazivTextField.getText().equals("")) {
			btnPotvrda.setEnabled(true);
		}
		btnPotvrda.setBackground(Color.LIGHT_GRAY);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String semestar = semestarComboBox.getSelectedItem().toString();
		Semestar semestar1 = Semestar.valueOf(semestar);
		
		String godina = godinaComboBox.getSelectedItem().toString();
		GodinaStudija godina1 = GodinaStudija.valueOf(godina);
		
/*		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			System.out.println(p.toString());
		}
*/		
		PredmetiController.getInstance().dodavanjePredmetaUTabelu(sifraTextField.getText(), nazivTextField.getText(), semestar1, godina1);
		
		dispose();
	}
	});
		
		this.setTitle("Dodavanje predmeta");
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
	}

}
