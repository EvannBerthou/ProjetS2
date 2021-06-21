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
 * Contr�leur qui g�re les int�ractions entre @see PanelTableaux, @see PanelListePorts et @see PanelCalendrier
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
	 * Constructeur du Contr�leur
	 * @param _tableaux Le PanelTableaux � �couter
	 * @param _listePorts Le PanelListePorts � �couter
	 * @param _calendrier Le PanelCalendrier � �couter
	 */
	public Controleur(PanelTableaux _tableaux, PanelListePorts _listePorts, PanelCalendrier _calendrier) {
		this.tableaux = _tableaux;
		this.listePorts = _listePorts;
		this.calendrier = _calendrier;

		this.listePorts.enrengistrerEcoute(this);
		this.calendrier.enregistreEcouter(this);
	}

	/**
	 * D�tecte lorsqu'un bouton du calendrier est s�lectionn� puis donne la date selectionn� au PanelTableaux
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		BoutonDate bouton = (BoutonDate) e.getSource();
		tableaux.setDate(bouton.getDate());
	}

	/**
	 * D�tecte lorsqu'un �lement de la liste des ports est s�lectionn�.
	 * Donne le port s�lectionn� aux PanelTableaux et d�sactive toutes les dates
	 * o� aucune donn�e est disponible pour ce port.
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
