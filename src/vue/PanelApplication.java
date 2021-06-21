package vue;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import constantes.ConstantesCouleurs;
import constantes.ConstantesPort;
import controleur.Controleur;
import modele.Date;
import modele.ListePort;
import modele.Maree;
import modele.Port;
import utils.LectureFichier;

public class PanelApplication extends JPanel {

	private ListePort ports = new ListePort();
	
	public PanelApplication() {				
		setLayout(new BorderLayout());
		chargerPorts();	
		
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
		File sauvegarde = new File(ConstantesPort.CHEMIN_FICHIER);
		if (sauvegarde.length() != 0) {
			ports = (ListePort) LectureFichier.charger(sauvegarde);
			System.out.println("Succès de la lecture du fichier sauvegardé");
			return;
		}
		
		File dossier;
		dossier = new File("data/payant");
		for (File fichier : dossier.listFiles()) {
			String nomPort = LectureFichier.getNomPort(fichier);
			
			HashMap<Date, Maree[]> marees = LectureFichier.lectureMareeDate(fichier);
			
			Port port;
			if (ports.containsKey(nomPort)) {
				port = ports.get(nomPort);
			} else {
				port = new Port();
			}
			port.addCoefs(marees);
			ports.put(nomPort, port);
		}
		
		dossier = new File("data/gratuit");
		for (File fichier : dossier.listFiles()) {
			String nomPort = LectureFichier.getNomPort(fichier);
			
			HashMap<Date, Maree[]> marees = LectureFichier.lectureMareeHauteur(fichier);
			
			// Si un port avec le même nom existe déjà, alors on ajoute les données au lieu
			// de créer un nouveau port (ce qui effacerais l'ancien).
			Port port;
			if (ports.containsKey(nomPort)) {
				port = ports.get(nomPort);
			} else {
				port = new Port();
			}
			port.addHauteurs(marees);
			ports.put(nomPort, port);
		}
		LectureFichier.ecriture(new File(ConstantesPort.CHEMIN_FICHIER), ports);
		System.out.println("Nouveau fichier écrit");
	}
}
