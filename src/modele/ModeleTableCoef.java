package modele;

import javax.swing.table.DefaultTableModel;

public class ModeleTableCoef extends DefaultTableModel {
	public ModeleTableCoef(Maree[] marees) {
		super();
		setColumnCount(4);
		setRowCount(5);

		setValueAt("Heure", 	  0, 1);
		setValueAt("Hauteur(m)",  0, 2);
		setValueAt("Coefficient", 0, 3);
		
		setValueAt("PM", 1, 0);
		setValueAt("PM", 2, 0);
		setValueAt("BM", 3, 0);
		setValueAt("BM", 4, 0);
		
		// On sait qu'il y a toujours 4 marées au maximum
		for (int i = 0; i < 4; i++) {
			setCoefHeure(marees[i], i + 1);
		}
	}
	
	private void setCoefHeure(Maree m, int row) {
		String[] parts = m.getParts();			
		for (int j = 0; j < 3; j++) {
			// On ajoute 1 afin de sauter les entêtes
			setValueAt(parts[j].toString(), row, j + 1);
		}
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
