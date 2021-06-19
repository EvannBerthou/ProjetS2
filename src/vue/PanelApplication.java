package vue;

import java.awt.BorderLayout;
import java.io.File;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCouleurs;
import modele.Date;
import modele.Maree;
import utils.LectureFichierTxt;

public class PanelApplication extends JPanel {
	
	private HashMap<Date, Maree[]> mareesCoefs;
	private PanelCoefs panelCoefs;
	
	private HashMap<Date, Maree[]> mareesHauteurs;
	private PanelHauteurs panelHauteurs;
	
	public PanelApplication() {
		setLayout(new BorderLayout());
		chargerPorts();

		JPanel panelCentre = new JPanel(new BorderLayout());
		panelCentre.setBackground(ConstantesCouleurs.BLEU);
		panelCentre.add(new JLabel("Calendrier"), BorderLayout.CENTER);
		
		JPanel panelSud = new JPanel(new BorderLayout());
		panelSud.add(panelHauteurs, BorderLayout.CENTER);
		panelSud.add(panelCoefs, BorderLayout.EAST);
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
		
		file = new File("data/payant/paimpol.txt");
		mareesCoefs = LectureFichierTxt.lectureMareeDate(file);
		panelCoefs = new PanelCoefs(mareesCoefs.get(mareesCoefs.keySet().iterator().next()));

		file = new File("data/gratuit/st-nazaire.txt");
		mareesHauteurs = LectureFichierTxt.lectureMareeHauteur(file);
		panelHauteurs = new PanelHauteurs(mareesHauteurs.get(mareesHauteurs.keySet().iterator().next()));

	}
}
