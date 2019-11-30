package view;

import javax.swing.JToolBar;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StudentToolbar extends JToolBar {
	private JTextField textField;
	public StudentToolbar() {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addStudent = new JButton("");
		addStudent.setIcon(new ImageIcon("images/Add_user32.png"));
		panel.add(addStudent);
		
		JButton editStudent = new JButton("");
		editStudent.setIcon(new ImageIcon("images/Edit32.png"));
		panel.add(editStudent);
		
		JButton deleteStudent = new JButton("");
		deleteStudent.setIcon(new ImageIcon("images/Delete32.png"));
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
