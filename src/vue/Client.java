package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import constantes.ConstantesPort;

public class Client extends JFrame implements ActionListener {
	
	/**
	 * Constructeur du Client
	 */
	public Client() {
		super("Gestion de ports");
		PanelApplication panel = new PanelApplication();
		setContentPane(panel);
		
		setJMenu();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(1000,600);
		setVisible(true);
	}

	/**
	 * Ajoute les élements au JMenu
	 */
	private void setJMenu() {
		JMenuBar bar = new JMenuBar();
		
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem item2 = new JMenuItem("Vider cache");
		JMenuItem item3 = new JMenuItem("Fermer");

		item2.addActionListener(this);
		item3.addActionListener(this);
		
		item2.setActionCommand("cache");
		item3.setActionCommand("fermer");

		menuFichier.add(item2);
		menuFichier.add(item3);
		
		JMenu menuAide = new JMenu("Aide");
		JMenuItem item4 = new JMenuItem("Aide d'utilisation");
		JMenuItem item5 = new JMenuItem("A propos");

		item4.addActionListener(this);
		item5.addActionListener(this);
		
		item4.setActionCommand("aide");
		item5.setActionCommand("propos");

		menuAide.add(item4);
		menuAide.add(item5);
		
		bar.add(menuFichier);
		bar.add(menuAide);
		
		setJMenuBar(bar);
	}
	
	/**
	 * Main de l'application
	 * @param args Les arguments
	 */
	public static void main(String[] args) {
		new Client();
	}

	/**
	 * Eest appelé lorsqu'un élement du JMenu est cliqué
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "cache": viderCache(); break;
		case "fermer": dispose(); break;
		case "aide": afficherAide(); break;
		case "propos": afficherPropos(); break;
		default:
			System.err.println("Commande inconnue");
		}
	}

	/**
	 * Supprimer les données des ports sauvergardés
	 */
	private void viderCache() {
		File file = new File(ConstantesPort.CHEMIN_FICHIER);
		if (file.length() != 0) {
			if (file.delete()) {
		        JOptionPane.showMessageDialog(null, "Cache vidé", "Succès", JOptionPane.INFORMATION_MESSAGE);
			} else {
		        JOptionPane.showMessageDialog(null, "Impossible de vider le cache", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	/**
	 * Affiche un menu d'aide d'utilisation de l'application
	 */
	private void afficherAide() {
		// TODO Auto-generated method stub
	}	
	
	/**
	 * Affiche le A Propos de l'application
	 */
	private void afficherPropos() {
        JOptionPane.showMessageDialog(null, 
        		"Projet réalisé par : \n"
        		+ "  Evann BERTHOU\n"
        		+ "  Benjamin PELLIEUX",
        		"Gestion de ports", JOptionPane.INFORMATION_MESSAGE);
	}
}
