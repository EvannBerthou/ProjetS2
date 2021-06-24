package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import modele.Date;
import modele.ListePort;
import modele.Maree;
import modele.Port;

/**
 * Panel des tableaux
 * @author Evann Berthou
 *
 */
public class PanelTableaux extends JPanel {

	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 5712087401859656592L;
	/**
	 * La table où seront affichés les données
	 */
	private TableauMarees table = new TableauMarees();
	/**
	 * La liste des ports
	 */
	private ListePort ports;
	
	/**
	 * Le nom du port sélectionné
	 */
	private String port;
	/**
	 * La date du calendrier selectionné
	 */
	private Date date;
	
	/**
	 * Constructeur
	 * @param _ports La liste des ports
	 */
	public PanelTableaux(ListePort _ports) {
		this.ports = _ports;
		setLayout(new BorderLayout());
		add(table, BorderLayout.CENTER);
	}	

	/**
	 * Change le port selectionné
	 * @param _port Le nom du port
	 */
	public void setPort(String _port) {
		this.port = _port;
		changerTableaux();
	}

	/** 
	 * Change la date selectionné
	 * @param _date La date du calendrier
	 */
	public void setDate(Date _date) {
		this.date = _date;
		changerTableaux();
	}

	/**
	 * Change les informations du tableaux en fonction de la date et du nom du port
	 */
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

	/**
	 * Renvoie le @see Port selectionné
	 * @param nom Le nom du port
	 * @return Le port
	 */
	public Port getPort(String nom) {
		return ports.get(nom);
	}
	
	public void setPorts(ListePort _ports) {
		this.ports = _ports;
		
	}
}
