package view;

import javax.swing.JTable;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;

public class PredmetiTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3478162967519031093L;

	private static PredmetiTable instance = null;
	
	public static PredmetiTable getInstance() {
		if(instance == null) {
			instance = new PredmetiTable();
		}
		return instance;
	}
	
	private PredmetiTable() {
		this.setModel(new AbstractTableModelPredmeti());
		new ButtonColumnPredmeti(this, 5);
		this.setAutoCreateRowSorter(true);
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) this.getModel();
		
		this.getRowSorter().addRowSorterListener(new RowSorterListener() {
			
			@Override
			public void sorterChanged(RowSorterEvent e) {
		        for (int i = 0; i < model.getRowCount(); i++) {
		        	for (int j = 0; j < model.getColumnCount(); j++) {
			        	model.setValueAt(model.getValueAt(i, j), i, j);
			        }
		        }
				
			}
		});
	}
}
