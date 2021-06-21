package vue;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableCoef;
import modele.ModeleTableHauteurs;

/**
 * Panel contenannt le tableau
 * @author Evann Berthou
 *
 */
public class TableauMarees extends JPanel {
	/**
	 * Le tableau qui sera affiché
	 */
	private JTable table;
	
	/**
	 * Constructeur 
	 */
	public TableauMarees() {
		table = new JTable();
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.VANILLE);
	}
	
	/**
	 * Change les informations des hauteurs à afficher
	 * @param marees La liste des marees à afficher
	 */
	public void setHauteurs(Maree[] marees) {
		ModeleTableHauteurs model = new ModeleTableHauteurs(marees);
		table.setModel(model);
	}
	
	/**
	 * Change les informations des coefficients à afficher
	 * @param marees La liste des marees à afficher
	 */
	public void setCoefs(Maree[] marees) {
		ModeleTableCoef model = new ModeleTableCoef(marees);
		table.setModel(model);
	}
	
	/**
	 * Vide le tableau
	 */
	public void clear() {
		table.setModel(new DefaultTableModel());
	}
}
