package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import modele.Maree;
import modele.MareeCellRenderer;
import modele.MareeHauteur;
import modele.ModeleTableHauteurs;

public class PanelHauteurs extends JPanel {
	public PanelHauteurs(ArrayList<MareeHauteur> marees) {
		Maree[] mareesHauteurs = marees.get(0).getMarees();
		ModeleTableHauteurs model = new ModeleTableHauteurs(mareesHauteurs);
		JTable table = new JTable(model);
		table.setShowVerticalLines(false);
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
	}
}
