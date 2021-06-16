package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.MareeDate;
import modele.ModeleTableCoef;

public class PanelCoefs extends JPanel {
	JTable table;
	public PanelCoefs(ArrayList<MareeDate> marees) {
		Maree[] mareesHauteurs = marees.get(0).getMarees();
		ModeleTableCoef model = new ModeleTableCoef(mareesHauteurs);
		JTable table = new JTable(model);
		table.setShowVerticalLines(false);
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.MASTIC);
	}
}
