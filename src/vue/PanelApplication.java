package vue;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JPanel;

import constantes.ConstantesCouleurs;
import controleur.Controleur;
import modele.Date;
import modele.Maree;
import modele.Port;
import utils.LectureFichierTxt;

public class PanelApplication extends JPanel {
	
	private HashMap<String, Port> ports = new HashMap<String, Port>();
	
	public PanelApplication() {
		setLayout(new BorderLayout());
		chargerPorts();	
		sauvegarderPorts();
		
		JPanel panelCentre = new JPanel(new BorderLayout());
		panelCentre.setBackground(ConstantesCouleurs.BLEU);
		
		PanelCalendrier panelCalendrier = new PanelCalendrier();
		panelCentre.add(panelCalendrier, BorderLayout.CENTER);
		
		PanelTableaux panelSud = new PanelTableaux(ports);
		panelCentre.add(panelSud, BorderLayout.SOUTH);
		
		PanelListePorts panelListePorts = new PanelListePorts(ports.keySet());

		add(panelCentre, BorderLayout.CENTER);
		add(panelListePorts, BorderLayout.WEST);
		
		new Controleur(panelSud, panelListePorts, panelCalendrier);
	}

	/**
	 * Charge tous les ports qui sont dans les dossiers correspondant
	 * data/gratuit ou data/payant
	 */
	private void chargerPorts() {		
		File dossier;
		dossier = new File("data/payant");
		for (File fichier : dossier.listFiles()) {
			String nomPort = LectureFichierTxt.getNomPort(fichier);
			
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeDate(fichier);
			
			Port port = new Port();
			port.setCoefs(marees);
			ports.put(nomPort, port);
		}
		
		dossier = new File("data/gratuit");
		for (File fichier : dossier.listFiles()) {
			String nomPort = LectureFichierTxt.getNomPort(fichier);
			
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeHauteur(fichier);
			
			// Si un port avec le même nom existe déjà, alors on ajoute les données au lieu
			// de créer un nouveau port (ce qui effacerais l'ancien).
			Port port;
			if (ports.containsKey(nomPort)) {
				port = ports.get(nomPort);
			} else {
				port = new Port();
			}
			port.setHauteurs(marees);
			ports.put(nomPort, port);
		}
	}
	
	/**
	 * TODO: Serializer les données chargés.
	 */
	private void sauvegarderPorts() {
	}
}
