package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vue.PanelListePorts;
import vue.PanelTableaux;

public class Controleur implements ActionListener, ListSelectionListener {

	private PanelTableaux tableaux;
	private PanelListePorts listePorts;
	
	public Controleur(PanelTableaux _tableaux, PanelListePorts _listePorts) {
		this.tableaux = _tableaux;
		this.listePorts = _listePorts;

		this.listePorts.enrengistrerEcoute(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			JList<String> list = (JList<String>)e.getSource();
			String s = (String) list.getSelectedValue();
			tableaux.setTableauHauteurs(s, null);
			tableaux.setTableauCoefs(s, null);
		}
	}
}
