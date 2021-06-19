package vue;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import modele.Date;
import modele.Maree;
import modele.Port;

public class PanelTableaux extends JPanel {

	PanelHauteurs panelHauteurs;
	PanelCoefs panelCoefs;
	
	public PanelTableaux(HashMap<String, Port> ports) {
		setLayout(new BorderLayout());
		panelHauteurs = new PanelHauteurs();
		panelCoefs = new PanelCoefs();

		add(panelHauteurs, BorderLayout.CENTER);
		add(panelCoefs, BorderLayout.EAST);

		setTableauHauteurs(ports.get("st-nazaire").getHauteursDate(new Date(1, 1, 2021)));
		setTableauCoefs(ports.get("st-nazaire").getCoefsDate(new Date(1, 6, 2021)));
	}
	
	public void setTableauCoefs(Maree[] marees) {
		panelCoefs.setValeurs(marees);
	}
	
	public void setTableauHauteurs(Maree[] marees) {
		panelHauteurs.setValeurs(marees);
	}
}
