package vue;

import java.awt.BorderLayout;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controleur.Controleur;

/**
 * Panel de la liste des ports chargés
 * @author Evann Berthou
 *
 */
public class PanelListePorts extends JPanel {

	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 5194024789421207945L;

	/**
	 * Le nom des ports
	 */
	private String[] ports;
	
	/**
	 * La JList des portsd
	 */
	private JList<String> listePorts;
	
	/**
	 * Le champ de recherche d'un port par nom
	 */
	JTextField recherchePort = new JTextField(10);
	
	/**
	 * Constructeur du panel
	 * @param nomPorts La liste des noms des ports
	 */
	public PanelListePorts(Set<String> nomPorts) {
		setLayout(new BorderLayout());
		ports = nomPorts.toArray(new String[0]);
		
		listePorts = new JList<String>(ports);
		listePorts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(listePorts);
		
		add(new JLabel("Liste des ports"), BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(recherchePort, BorderLayout.SOUTH);
		
		recherchePort.getDocument().addDocumentListener(new DocumentListener() {
			@Override public void insertUpdate(DocumentEvent e) {filtrer();}
			@Override public void removeUpdate(DocumentEvent e) {filtrer();}
			@Override public void changedUpdate(DocumentEvent e) {filtrer();}
		});
	}
	
	/**
	 *  Permet de n'afficher que les ports contenant la recherche (insensible à la casse).
	 */
	private void filtrer() {
		String filtre = recherchePort.getText();
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String s : ports) {
			if (s.toLowerCase().contains(filtre.toLowerCase())) {
				model.addElement(s);
			}
		}
		listePorts.setModel(model);
	}

	/**
	 * Enrengistrer le Panel à l'écouter du contrôleur
	 * @param controleur Le contrôleur
	 */
	public void enrengistrerEcoute(Controleur controleur) {
		listePorts.addListSelectionListener(controleur);
	}

	public void setPorts(Set<String> nomPorts) {
		this.ports = nomPorts.toArray(new String[0]);
		DefaultListModel model = new DefaultListModel();
		for (String s : nomPorts) 
			model.addElement(s);
		listePorts.setModel(model);
	}
}
