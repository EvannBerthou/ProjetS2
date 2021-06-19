package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.io.File;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import constantes.ConstantesCouleurs;
import modele.Date;
import modele.Maree;
import utils.LectureFichierTxt;

public class PanelApplication extends JPanel {
	public PanelApplication() {
		setLayout(new BorderLayout());

		File file;
		file = new File("data/paimpol.txt");
		HashMap<Date, Maree[]> mareesCoefs = LectureFichierTxt.lectureMareeDate(file);
		PanelCoefs panelCoefs = new PanelCoefs(mareesCoefs.get(mareesCoefs.keySet().iterator().next()));

		file = new File("data/st-nazaire.txt");
		HashMap<Date, Maree[]> mareesHauteurs = LectureFichierTxt.lectureMareeHauteur(file);
		PanelHauteurs panelHauteurs = new PanelHauteurs(mareesHauteurs.get(mareesHauteurs.keySet().iterator().next()));

		
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
}
