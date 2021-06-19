package vue;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCouleurs;
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
		panelCentre.add(new JLabel("Calendrier"), BorderLayout.CENTER);
		
		JPanel panelSud = new JPanel(new BorderLayout());
		panelSud.add(new PanelHauteurs(ports.get("st-nazaire").getHauteursDate(new Date(1, 1, 2021))), BorderLayout.CENTER);
		panelSud.add(new PanelCoefs(ports.get("st-nazaire").getCoefsDate(new Date(1, 6, 2021))), BorderLayout.EAST);
		panelCentre.add(panelSud, BorderLayout.SOUTH);
		
		PanelListePorts panelListePorts = new PanelListePorts(ports.keySet());

		add(panelCentre, BorderLayout.CENTER);
		add(panelListePorts, BorderLayout.WEST);
	}
	
	/**
	 * Charge tous les ports qui sont dans les dossiers correspondant
	 * data/gratuit ou data/payant
	 */
	private void chargerPorts() {		
		File dossier;
		dossier = new File("data/payant");
		for (File cheminFichier : dossier.listFiles()) {
			String nomPort = cheminFichier.getName();
			// On retire le .txt à la fin
			nomPort = nomPort.substring(0, nomPort.lastIndexOf('.'));
			
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeDate(cheminFichier);
			
			Port port = new Port();
			port.setCoefs(marees);
			ports.put(nomPort, port);
		}
		
		dossier = new File("data/gratuit");
		for (File cheminFichier : dossier.listFiles()) {
			String nomPort = cheminFichier.getName();
			// On retire le .txt à la fin
			nomPort = nomPort.substring(0, nomPort.lastIndexOf('.'));
			
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeHauteur(cheminFichier);
			
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
