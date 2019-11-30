package view;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

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
		panel.add(addPredmetBtn);
		
		JButton editPredmetBtn = new JButton("");
		editPredmetBtn.setIcon(new ImageIcon("images/Edit32.png"));
		panel.add(editPredmetBtn);
		
		JButton deletePredmetBtn = new JButton("");
		deletePredmetBtn.setIcon(new ImageIcon("images/Delete32.png"));
		panel.add(deletePredmetBtn);
		
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
		panel_1.add(searchPredmetBtn);
		
		addPredmetBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaDialog d = new DodavanjePredmetaDialog();
			    d.setVisible(true);
			}
		});
	}
}
