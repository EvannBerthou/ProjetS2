package modele;

import javax.swing.table.DefaultTableModel;

/**
 * Mod�le pour le tableaux des coefficients 
 * @author Evann Berthou
 *
 */
public class ModeleTableHauteurs extends DefaultTableModel {
	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 1546744016690668136L;

	/**
	 * Constructeur du mod�le
	 * @param marees Les mar�es � afficher
	 */
	public ModeleTableHauteurs(Maree[] marees) {
		super();
		setColumnCount(6);
		setRowCount(8);
		int row = 0;
		int column = 0;
		for (Maree m : marees) {
			if (m != null) {
				setValueAt(m.getHeure(), row, column);
				setValueAt(m.getHauteur() + "m", row + 1, column);
			}
			// On avance la colonne apr�s chaque ajout
			column++;
			// Et on ajoute 2 ligne afin de sauter l'heure et la date
			if (column % 6 == 0) {
				row += 2;
				column = 0;
			}
		}
	}
	
	/**
	 * D�sactive l'�dition des cellules.
	 */
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
