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

		JPanel panelCentre = new JPanel(new BorderLayout());
		panelCentre.setBackground(ConstantesCouleurs.BLEU);
		panelCentre.add(new JLabel("Calendrier"), BorderLayout.CENTER);
		
		JPanel panelSud = new JPanel(new BorderLayout());
		panelSud.add(new PanelHauteurs(ports.get("st-nazaire").getHauteursDate(new Date(1, 1, 2021))), BorderLayout.CENTER);
		panelSud.add(new PanelCoefs(ports.get("st-nazaire").getCoefsDate(new Date(1, 6, 2021))), BorderLayout.EAST);
		panelCentre.add(panelSud, BorderLayout.SOUTH);
		
		PanelListePorts panelListePorts = new PanelListePorts();

		add(panelCentre, BorderLayout.CENTER);
		add(panelListePorts, BorderLayout.WEST);
	}
	
	/**
	 * Charge tous les ports qui sont dans les dossiers correspondant
	 * data/gratuit ou data/payant
	 */
	private void chargerPorts() {
		File file;
		//TODO: Charger les ports depuis la liste des dossiers
		final String[] portsPayant = new String[] { "paimpol" , "st-nazaire" };
		final String[] portsGratuit = new String[] { "st-nazaire" };
		
		//TODO: Le nom du port devrait être récupérer depuis le fichier
		for (String portName : portsPayant) {
			file = new File("data/payant/" + portName + ".txt");
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeDate(file);

			Port port = new Port();
			port.setCoefs(marees);
			ports.put(portName, port);
		}

		for (String portName : portsGratuit) {
			file = new File("data/gratuit/" + portName + ".txt");
			HashMap<Date, Maree[]> marees = LectureFichierTxt.lectureMareeHauteur(file);
			Port port;
			
			if (ports.containsKey(portName)) {
				port = ports.get(portName);
			} else {
				port = new Port();
			}

			port.setHauteurs(marees);
			ports.put(portName, port);
		}
	}
}
