package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ProfesorToolbar extends JToolBar {
	
	private JTextField textField;
	public ProfesorToolbar(JFrame frame) {
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel);
		
		JButton addProfesorBtn = new JButton("");
		addProfesorBtn.setIcon(new ImageIcon("images/Add_user32.png"));
		panel.add(addProfesorBtn);
		
		JButton editProfesorBtn = new JButton("");
		editProfesorBtn.setIcon(new ImageIcon("images/Edit32.png"));
		panel.add(editProfesorBtn);
		
		JButton deleteProfesorBtn = new JButton("");
		deleteProfesorBtn.setIcon(new ImageIcon("images/Delete32.png"));
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
				DodavanjeProfesoraDialog d = new DodavanjeProfesoraDialog(frame);
			    d.setVisible(true);
			}
		});
	}
}
