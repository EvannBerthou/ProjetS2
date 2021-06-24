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

/**
 * Fenêtre mère de l'application
 * @author Evann Berthou
 *
 */
public class Client extends JFrame implements ActionListener {
	
	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = -7409557890286668784L;

	/**
	 * Le PanelApplication
	 */
	private PanelApplication application;
	
	/**
	 * Constructeur du Client
	 */
	public Client() {
		super("Gestion de ports");
		application = new PanelApplication();
		setContentPane(application);
		
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
		JMenuItem item1 = new JMenuItem("Vider le cache");
		JMenuItem item2 = new JMenuItem("Fermer");

		item1.addActionListener(this);
		item2.addActionListener(this);
		
		item1.setActionCommand("cache");
		item2.setActionCommand("fermer");

		menuFichier.add(item1);
		menuFichier.add(item2);
		
		JMenu menuAide = new JMenu("Aide");
		JMenuItem item3 = new JMenuItem("A propos");

		item3.addActionListener(this);
		
		item3.setActionCommand("propos");

		menuAide.add(item3);
		
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
		        application.actualiserDonnes();
		        JOptionPane.showMessageDialog(null, "Cache vidé", "Succès", JOptionPane.INFORMATION_MESSAGE);
			} else {
		        JOptionPane.showMessageDialog(null, "Impossible de vider le cache", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			}
		}
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
