package vue;

import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.JPanel;

import modele.Date;
import modele.Maree;
import modele.Port;

public class PanelTableaux extends JPanel {

	private TableauMarees table = new TableauMarees();
	private HashMap<String, Port> ports;
	
	private String port;
	private Date date;
	
	public PanelTableaux(HashMap<String, Port> _ports) {
		this.ports = _ports;
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}	

	public void setPort(String _port) {
		this.port = _port;
		changerTableaux();
	}
	
	public void setDate(Date _date) {
		this.date = _date;
		changerTableaux();
	}
	
	//TODO: Afficher un tableau vide si aucune info est disponible
	private void changerTableaux() {
		if (this.port == null || this.date == null) return;
		if (!ports.containsKey(port)) return;
		
		Maree[] hauteurs = ports.get(port).getHauteursDate(this.date);
		if (hauteurs != null) {
			table.setHauteurs(hauteurs);
			return;
		}

		Maree[] coefs = ports.get(port).getCoefsDate(this.date);
		if (coefs != null) {
			table.setCoefs(coefs);
			return;
		}
		
		// Si aucune donnée n'est disponible
		table.clear();
	}
}
