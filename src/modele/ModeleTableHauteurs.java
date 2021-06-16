package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleTableHauteurs extends DefaultTableModel {

	public ModeleTableHauteurs(Maree[] marees) {
		super();
		setColumnCount(6);
		setRowCount(8);

		int row = 0;
		int column = 0;
		for (Maree m : marees) {
			setValueAt(m.getHeure(), row, column);
			setValueAt(m.getHauteur() + "m", row + 1, column);
			// On avance la colonne après chaque ajout
			column++;
			// Et on ajoute 2 ligne afin de sauter l'heure et la date
			if (column % 6 == 0) {
				row += 2;
				column = 0;
			}
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
