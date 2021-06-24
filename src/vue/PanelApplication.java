package vue;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashMap;
import javax.swing.JPanel;

import constantes.ConstantesCouleursFontes;
import constantes.ConstantesPort;
import controleur.Controleur;
import modele.Date;
import modele.ListePort;
import modele.Maree;
import modele.Port;
import utils.LectureFichier;

/**
 * Panel principal de l'application
 * @author Evann Berthou
 *
 */
public class PanelApplication extends JPanel {

	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 8344764089919552609L;
	/**
	 * Liste des ports
	 */
	private ListePort ports = new ListePort();
	
	/**
	 * Le PanelTableaux
	 */
	private PanelTableaux panelTableaux;
	
	/**
	 * Le PanelListePorts
	 */
	private PanelListePorts panelListePorts;
	
	/**
	 * Constructeur du panel
	 */
	public PanelApplication() {				
		setLayout(new BorderLayout());
		chargerPorts();	
		
		JPanel panelCentre = new JPanel(new BorderLayout());
		panelCentre.setBackground(ConstantesCouleursFontes.BLEU);
		
		PanelCalendrier panelCalendrier = new PanelCalendrier();
		panelCentre.add(panelCalendrier, BorderLayout.CENTER);
		
		panelTableaux = new PanelTableaux(ports);
		panelCentre.add(panelTableaux, BorderLayout.SOUTH);
		
		panelListePorts = new PanelListePorts(ports.keySet());

		add(panelCentre, BorderLayout.CENTER);
		add(panelListePorts, BorderLayout.WEST);
		
		new Controleur(panelTableaux, panelListePorts, panelCalendrier);
	}
	
	/**
	 * Recharge les données après que l'application soit lancé pour la première fois
	 */
	public void actualiserDonnes() {
		ports = new ListePort();
		chargerPorts();
		panelTableaux.setPorts(ports);
		panelListePorts.setPorts(ports.keySet());
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
