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
import controllers.StudentiController;
import model.BazaPredmeta;
import model.BazaStudent;
import model.Predmet;
import model.Student;

public class StudentToolbar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6187000729445067253L;
	private JTextField textField;
	public StudentToolbar() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addStudent = new JButton("");
		addStudent.setIcon(new ImageIcon("images/Add_user32.png"));
		addStudent.setToolTipText("Dodavanje studenta");
		panel.add(addStudent);
		
		JButton editStudent = new JButton("");
		editStudent.setIcon(new ImageIcon("images/Edit32.png"));
		editStudent.setToolTipText("Izmena studenta");
		panel.add(editStudent);
		
		JButton deleteStudent = new JButton("");
		deleteStudent.setIcon(new ImageIcon("images/Delete32.png"));
		deleteStudent.setToolTipText("Brisanje studenta");
		panel.add(deleteStudent);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		add(panel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(textField);
		textField.setColumns(15);
		
		JButton searchStudent = new JButton("");
		searchStudent.setIcon(new ImageIcon("images/Search32.png"));
		searchStudent.setToolTipText("Pretraga studenata");
		panel_1.add(searchStudent);
		
		
		addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(0,null);
				d.setVisible(true);
			}
			
		});
		
		editStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowIndex = StudentiTable.getInstance().convertRowIndexToModel(StudentiTable.getInstance().getSelectedRow());
				Student student = BazaStudent.getInstance().getRow(rowIndex);
				
				DodavanjeStudentaDijalog d=new DodavanjeStudentaDijalog(1,student);
				d.setVisible(true);
			}
			});
		
		deleteStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int rowIndex = StudentiTable.getInstance().convertRowIndexToModel(StudentiTable.getInstance().getSelectedRow());
				Student student = BazaStudent.getInstance().getRow(rowIndex);
				
				String poruka =("Da li ste sigurni da želite da obrišete "+student.getIme()+" "+student.getPrezime())+" ?";
				
				if(JOptionPane.showConfirmDialog(null, poruka, "Brisanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					StudentiController.getInstance().brisanjeStudenta(student);
				}else return;
				
			}});
		
		}
	

}
