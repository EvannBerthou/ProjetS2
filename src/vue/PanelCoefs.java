package vue;

import modele.Maree;
import modele.ModeleTableCoef;

public class PanelCoefs extends PanelMaree {
	public void setValeurs(Maree[] marees) {
		ModeleTableCoef model = new ModeleTableCoef(marees);
		table.setModel(model);
	}
}
