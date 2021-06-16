package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;

import modele.Maree;
import modele.MareeHauteur;
import modele.ModeleTableHauteurs;

public class PanelHauteurs extends JPanel {

	ArrayList<MareeHauteur> marees;
	JTable table;
	public PanelHauteurs(ArrayList<MareeHauteur> _marees) {
		this.marees = _marees;
		Maree[] mareesHauteurs = marees.get(0).getMarees();
		ModeleTableHauteurs model = new ModeleTableHauteurs(mareesHauteurs);
		JTable table = new JTable(model);
		add(table);
	}
}
