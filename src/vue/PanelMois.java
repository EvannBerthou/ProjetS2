package vue;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import constantes.ConstantesCalendrier;
import constantes.ConstantesCouleursFontes;
import controleur.Controleur;
import modele.BoutonDate;
import modele.CalendrierDuMois;
import modele.Date;
import modele.Port;

/**
 * Panel qui affiche toutes les dates d'un mois
 * @author Evann Berthou
 */
public class PanelMois extends JPanel implements ActionListener,ConstantesCalendrier, ConstantesCouleursFontes {

	/** 
	 * Le bouton qui est selectionnée
	 */
	BoutonDate boutonSelectionne;
	
	/**
	 * Liste de tous les boutons du mois
	 */
	ArrayList<BoutonDate> boutons = new ArrayList<BoutonDate>();
		
	/** 
	 * Constructeur d'un PanelMois
	 * @param mois Le mois avec lequel il faut créer les dates
	 */
	public PanelMois(int mois) {
		Date today = new Date();
		 
		Collection <Date> datesDuMois = new CalendrierDuMois(mois,today.getAnnee()).getDates();
		//System.out.println(datesDuMois);		
		this.setLayout(new GridLayout (0,7,8,8));
		for (int i= 0; i < 7 ; i++) {
			JLabel labeljour = new  JLabel (JOURS_SEMAINE_ABR[i],JLabel.CENTER);
			this.add(labeljour);			
		}
		
		BoutonDate boutonJour;
		
		Iterator <Date> iterateur = datesDuMois.iterator();
		while (iterateur.hasNext()) {
				Date date = iterateur.next();
				boutonJour = new  BoutonDate (date);
				
				boutonJour.setActionCommand("DATE_MOIS");
				boutonJour.addActionListener(this);  // gestion des couleurs des boutons
				this.add(boutonJour);
				boutons.add(boutonJour);
				 
				boutonJour.setBackground (VANILLE);
				
			
				if (date.isToday()) {
					boutonJour.setBackground(VERT);
				}	
				if (date.getMois()!=mois)
					boutonJour.setForeground(BLEU);
		}		
		
		setBackground (VANILLE);
	}

	/**
	 * Ecoute les actions réalisées par le PanelMois
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (boutonSelectionne != null && !boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(VANILLE);			
		}
		boutonSelectionne = (BoutonDate) evt.getSource();
		if (!boutonSelectionne.getDate().isToday()) {
			boutonSelectionne.setBackground(MASTIC);
		}		
	}
	
	/**
	 * Renvoie le bouton selectionnée
	 * @return Le bouton selectionnée
	 */
	public BoutonDate getBoutonSelectionne () {
		return boutonSelectionne;	
	}

	/**
	 * Permet au PanelMois de communiquer avec le controller
	 * @param controller Le controller avec lequel communiquer
	 */
	public void enregistreEcouter(Controleur controller) {
		for (BoutonDate b : boutons) {
			b.addActionListener(controller);
		}
	}
	
	/**
	 * Désactiver les boutons où aucune donnée est disponible.
	 * @param dates La liste des dates où le bouton est activé
	 */
	public void desactiverDates(HashSet<Date> dates) {
		for (BoutonDate btn : boutons) {
			btn.setEnabled(dates.contains(btn.getDate()));
		}
	}
}
