package vue;

import modele.Maree;
import modele.ModeleTableHauteurs;

public class PanelHauteurs extends PanelMaree {
	public void setValeurs(Maree[] marees) {
		ModeleTableHauteurs model = new ModeleTableHauteurs(marees);
		table.setModel(model);
	}
}