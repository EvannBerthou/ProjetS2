package vue;

import javax.swing.JPanel;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableCoef;

public class PanelCoefs extends JPanel {
	JTable table;
	
	public PanelCoefs() {
		table = new JTable();
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.MASTIC);
	}
	
	public void setValeurs(Maree[] marees) {
		ModeleTableCoef model = new ModeleTableCoef(marees);
		table.setModel(model);
	}
}
