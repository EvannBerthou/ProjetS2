package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Maree;
import modele.MareeHauteur;

public class PanelHauteurs extends JPanel {

	ArrayList<MareeHauteur> marees;
	JTable table;
	public PanelHauteurs(ArrayList<MareeHauteur> _marees) {
		this.marees = _marees;
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(6);
		model.setRowCount(8);

		int row = 0;
		int column = 0;
		Maree[] ms = marees.get(0).getMarees();
		for (int i = 0; i < ms.length; i++) {
			Maree m = ms[i];
			model.setValueAt(m.getHeure(), row, column);
			model.setValueAt(m.getHauteur() + "m", row + 1, column);
			column++;
			if (column % 6 == 0) {
				row += 2;
				column = 0;
			}
		}
		
		JTable table = new JTable(model);
		add(table);
	}
}
