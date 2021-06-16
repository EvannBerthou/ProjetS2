package vue;


import javax.swing.JPanel;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableCoef;

public class PanelCoefs extends JPanel {
	JTable table;
	public PanelCoefs(Maree[] marees) {
		ModeleTableCoef model = new ModeleTableCoef(marees);
		JTable table = new JTable(model);
		table.setShowVerticalLines(false);
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.MASTIC);
	}
}
