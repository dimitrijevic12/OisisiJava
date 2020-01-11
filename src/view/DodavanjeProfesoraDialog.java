package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.ProfesoriController;
import model.BazaProfesora;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import model.Student;
import model.Titula;
import model.Zvanje;

public class DodavanjeProfesoraDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4181791070180981454L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JPanel panel_11;
	private SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
	
	public DodavanjeProfesoraDialog(int i,Profesor profesor) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/3, d.height/1.5);
		setSize(d);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(30, 40, 10, 40);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{10, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Ime");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		if(i==0)
			textField = new JTextField();
		else 
			textField = new JTextField(profesor.getIme());
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(10, 40, 10, 40);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{10, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Prezime");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		if(i==0)
			textField_1 = new JTextField();
		else 
			textField_1 = new JTextField(profesor.getPrezime());
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(10, 40, 10, 40);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{10, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Datum rodjenja (dd/mm/yyy)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		if(i==0)
			textField_2 = new JTextField();
		else 
			textField_2 = new JTextField(sdf.format(profesor.getDatumRodjenja()));
		
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 0;
		panel_3.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(10, 40, 10, 40);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		getContentPane().add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{10, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Adresa stanovanja");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		if(i==0)
			textField_3 = new JTextField();
		else 
			textField_3 = new JTextField(profesor.getAdresaStanovanja());
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 0;
		panel_4.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(10, 40, 10, 40);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		getContentPane().add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{10, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Telefon");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_5.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		if(i==0)
			textField_4 = new JTextField();
		else 
			textField_4 = new JTextField(profesor.getTelefon());
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 0;
		panel_5.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(10, 40, 10, 40);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 5;
		getContentPane().add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{10, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_5 = new JLabel("E-mail");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_6.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		if(i==0)
			textField_5 = new JTextField();
		else 
			textField_5 = new JTextField(profesor.getTelefon());
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 0;
		panel_6.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(10, 40, 10, 40);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 6;
		getContentPane().add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{10, 0, 0};
		gbl_panel_7.rowHeights = new int[]{0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Adresa kancelarije");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel_7.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		if(i==0)
			textField_6 = new JTextField();
		else 
			textField_6 = new JTextField(profesor.getAdresaStanovanja());
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 1;
		gbc_textField_6.gridy = 0;
		panel_7.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(10, 40, 10, 40);
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 7;
		getContentPane().add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{10, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Broj licne karte");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_8.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		
		if(i==0)
			textField_7 = new JTextField();
		else 
			{
			textField_7 = new JTextField(profesor.getBrLicne());
			textField_7.setEditable(false);
			}
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 1;
		gbc_textField_7.gridy = 0;
		panel_8.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(10, 40, 10, 40);
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 8;
		getContentPane().add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{10, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Titula");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_9.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		comboBox = new JComboBox<Titula>(Titula.values());
		if(i==1)
			comboBox.setSelectedItem(profesor.getTitula());
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel_9.add(comboBox, gbc_comboBox);
		
		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(10, 40, 10, 40);
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 9;
		getContentPane().add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{10, 0, 0};
		gbl_panel_10.rowHeights = new int[]{0, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel lblNewLabel_9 = new JLabel("Zvanje");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 15);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		panel_10.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		comboBox_1 = new JComboBox<Zvanje>(Zvanje.values());
		if(i==1)
			comboBox.setSelectedItem(profesor.getZvanje());
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 0;
		panel_10.add(comboBox_1, gbc_comboBox_1);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 30, 30);
		gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 10;
		getContentPane().add(panel, gbc_panel);
		
		JButton btnOdustanak = new JButton("Odustanak");
		btnOdustanak.setForeground(Color.BLACK);
		btnOdustanak.setBackground(Color.WHITE);
		panel.add(btnOdustanak);
		
		panel_11 = new JPanel();
		panel_11.setBorder(null);
		panel_11.setBackground(Color.WHITE);
		panel.add(panel_11);
		
		JButton btnPotvrda = new JButton("Potvrda");
		btnPotvrda.setBackground(Color.WHITE);
		panel.add(btnPotvrda);
		
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
				btnPotvrda.setBackground(Color.LIGHT_GRAY);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().trim().isEmpty()||textField_1.getText().trim().isEmpty()||textField_2.getText().trim().isEmpty()||textField_3.getText().trim().isEmpty()||textField_4.getText().trim().isEmpty()||textField_5.getText().trim().isEmpty()||textField_6.getText().trim().isEmpty()||textField_7.getText().trim().isEmpty()) {
						if(i==0)
							for(Profesor p: BazaProfesora.getInstance().getProfesori()) {
								if(textField_7.getText().trim().equals(p.getBrLicne() )) {
									JOptionPane.showMessageDialog(null,"Već postoji profesor sa tim brojem licne karte", "Greška",JOptionPane.ERROR_MESSAGE);
									return;
								}
							}
						Date datumRodjenja = new Date();
						try {
							datumRodjenja = sdf.parse(textField_2.getText());
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(new JFrame(), "Unesite u obliku (dd/mm/yyyy)", "Pogresno unet datum!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
							return;
						} 
						String titula = comboBox.getSelectedItem().toString();
						Titula titula1 = Titula.valueOf(titula);
						String zvanje = comboBox_1.getSelectedItem().toString();
						Zvanje zvanje1 = Zvanje.valueOf(zvanje);
						if(i==0)
							ProfesoriController.getInstance().dodajProfesora(textField.getText(), textField_1.getText(), datumRodjenja, textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText(), titula1, zvanje1, new ArrayList<Predmet>());
						else
							ProfesoriController.getInstance().izmeniProfesora(textField.getText(), textField_1.getText(), datumRodjenja, textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(), textField_7.getText(), titula1, zvanje1, profesor.getPredmeti());
						
						for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
							System.out.println(p.toString());
						}
						
				}
				dispose();
				
			}
		});
		if(i==0)
		{	
			this.setName("Dodavanje profesora");
			this.setTitle("Dodavanje profesora");
		}
		else
		{
				this.setName("Izmena profesora");
				this.setTitle("Izmena profesora");
		}
		this.setModal(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
//		this.setUndecorated(true);
	}

}
