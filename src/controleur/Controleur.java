package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modele.BoutonDate;
import vue.PanelCalendrier;
import vue.PanelListePorts;
import vue.PanelTableaux;

public class Controleur implements ActionListener, ListSelectionListener {

	private PanelTableaux tableaux;
	private PanelListePorts listePorts;
	private PanelCalendrier calendrier;
	
	public Controleur(PanelTableaux _tableaux, PanelListePorts _listePorts, PanelCalendrier _calendrier) {
		this.tableaux = _tableaux;
		this.listePorts = _listePorts;
		this.calendrier = _calendrier;

		this.listePorts.enrengistrerEcoute(this);
		this.calendrier.enregistreEcouter(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BoutonDate bouton = (BoutonDate) e.getSource();
		tableaux.setDate(bouton.getDate());
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			JList<String> list = (JList<String>)e.getSource();
			String s = (String) list.getSelectedValue();
			tableaux.setPort(s);
		}
	}
}
