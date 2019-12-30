package view;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

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
		panel_1.add(searchStudent);
	}

}
