package vue;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableCoef;
import modele.ModeleTableHauteurs;

public class TableauMarees extends JPanel {
	JTable table;
	
	public TableauMarees() {
		table = new JTable();
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.MASTIC);
	}
	
	public void setHauteurs(Maree[] marees) {
		ModeleTableHauteurs model = new ModeleTableHauteurs(marees);
		table.setModel(model);
	}
	
	public void setCoefs(Maree[] marees) {
		ModeleTableCoef model = new ModeleTableCoef(marees);
		table.setModel(model);
	}
	
	public void clear() {
		table.setModel(new DefaultTableModel());
	}
}
