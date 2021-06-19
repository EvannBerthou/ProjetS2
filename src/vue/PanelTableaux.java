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
	HashMap<String, Port> ports;
	
	public PanelTableaux(HashMap<String, Port> _ports) {
		this.ports = _ports;
		
		setLayout(new BorderLayout());
		panelHauteurs = new PanelHauteurs();
		panelCoefs = new PanelCoefs();

		add(panelHauteurs, BorderLayout.CENTER);
		add(panelCoefs, BorderLayout.EAST);

		//setTableauHauteurs(ports.get("st-nazaire").getHauteursDate(new Date(1, 1, 2021)));
		//setTableauCoefs(ports.get("st-nazaire").getCoefsDate(new Date(1, 6, 2021)));
	}	
	
	public void setTableauHauteurs(String port, String date) {
		if (ports.containsKey(port)) {
			Maree[] m = ports.get(port).getHauteursDate(new Date(1, 1, 2021));
			if (m != null) {
				panelHauteurs.setValeurs(m);
			}
		}
	}
	
	public void setTableauCoefs(String port, String date) {
		if (ports.containsKey(port)) {
			Maree[] m = ports.get(port).getCoefsDate(new Date(1, 6, 2021));
			if (m != null) {
				panelCoefs.setValeurs(m);
			}
		}
	}
}
