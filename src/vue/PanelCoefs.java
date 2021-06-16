package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import modele.Maree;
import modele.MareeDate;
import modele.MareeHauteur;
import modele.ModeleTableCoef;

public class PanelCoefs extends JPanel {
	JTable table;
	public PanelCoefs(ArrayList<MareeDate> marees) {
		Maree[] mareesHauteurs = marees.get(0).getMarees();
		ModeleTableCoef model = new ModeleTableCoef(mareesHauteurs);
		JTable table = new JTable(model);
		add(table);
	}
}
