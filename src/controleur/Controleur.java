package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.BoutonDate;
import modele.Port;
import vue.PanelCalendrier;
import vue.PanelListePorts;
import vue.PanelTableaux;

/**
 * Contrôleur qui gère les intéractions entre @see PanelTableaux, @see PanelListePorts et @see PanelCalendrier
 * @author Evann Berthou
 *
 */
public class Controleur implements ActionListener, ListSelectionListener {

	/**
	 * Le PanelTableaux
	 */
	private PanelTableaux tableaux;
	
	/**
	 * Le PanelListePorts
	 */
	private PanelListePorts listePorts;
	
	/**
	 * Le PanelCalendrier
	 */
	private PanelCalendrier calendrier;
	
	/**
	 * Constructeur du Contrôleur
	 * @param _tableaux Le PanelTableaux à écouter
	 * @param _listePorts Le PanelListePorts à écouter
	 * @param _calendrier Le PanelCalendrier à écouter
	 */
	public Controleur(PanelTableaux _tableaux, PanelListePorts _listePorts, PanelCalendrier _calendrier) {
		this.tableaux = _tableaux;
		this.listePorts = _listePorts;
		this.calendrier = _calendrier;

		this.listePorts.enrengistrerEcoute(this);
		this.calendrier.enregistreEcouter(this);
	}

	/**
	 * Détecte lorsqu'un bouton du calendrier est sélectionné puis donne la date selectionné au PanelTableaux
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoutonDate bouton = (BoutonDate) e.getSource();
		tableaux.setDate(bouton.getDate());
	}

	/**
	 * Détecte lorsqu'un élement de la liste des ports est sélectionné.
	 * Donne le port sélectionné aux PanelTableaux et désactive toutes les dates
	 * où aucune donnée est disponible pour ce port.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			JList<String> list = (JList<String>)e.getSource();
			String s = (String) list.getSelectedValue();
			tableaux.setPort(s);
			
			Port port = tableaux.getPort(s);
			calendrier.desactiverDates(port.getDates());
		}
	}
}
