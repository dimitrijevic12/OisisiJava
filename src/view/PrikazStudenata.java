package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import controllers.PredmetiController;
import model.Predmet;
import model.Student;

public class PrikazStudenata extends JDialog {
	private static final long serialVersionUID = -8426010216433710116L;
	
	  static JList<String> listaStudent;
	  JPanel pLista,pButtons,panel;
	  JButton btnObrisi,btnNazad;
	  String studenti[];
	  int i=0;
	
	public PrikazStudenata(Predmet predmet) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = new Dimension();
		d = kit.getScreenSize();
		d.setSize(d.width/6, d.height/4);
		setSize(d); 
		
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		
		panel=new JPanel(gbl);
		pLista=new JPanel();
		
		studenti=new String[predmet.getStudenti().size()];
		
		for(Student s:predmet.getStudenti()){
			studenti[i++]=s.getIndeks();
		}
		//String studenti[]= {"aaaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa","aaaaaaaa"};
		
		listaStudent=new JList<String>(studenti);
		listaStudent.setVisibleRowCount(4);
		listaStudent.setLayoutOrientation(JList.VERTICAL);
		listaStudent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaStudent.setSelectedIndex(0);
		
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor=GridBagConstraints.NORTH;
		gbc.gridheight=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		JScrollPane jsp=new JScrollPane();
		jsp.setPreferredSize(new Dimension(d.width/2,d.height/3));
		
		pLista.add(jsp);
		panel.add(pLista,gbc);
		
		btnObrisi=new JButton("Obrisi");
		btnNazad= new JButton("Nazad");
		
		pButtons=new JPanel(new FlowLayout());
		
		pButtons.setSize(getSize());
		pButtons.add(btnObrisi);
		pButtons.add(btnNazad);
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.ipadx=20;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridheight=1;
		panel.add(pButtons,gbc);
		
		add(panel);
		jsp.setViewportView(listaStudent);
		jsp.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		btnObrisi.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(!listaStudent.isSelectionEmpty()) {
					PredmetiController.getInstance().brisanjeStudentaSaPredmeta(listaStudent.getSelectedValue(),predmet);
					}
				else
					btnObrisi.setEnabled(false);
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
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				}
			});
				btnObrisi.addMouseListener(new MouseListener() {

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
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}});
	}
}
