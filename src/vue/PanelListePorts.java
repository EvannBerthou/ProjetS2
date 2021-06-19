package vue;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PanelListePorts extends JPanel {

	private final String[] ports = new String[] { "Saint-Nazaire", "Port 2", "Port 3","Port 1", "Port 2", "Port 3","Port 1", "Port 2", "Port 3","Port 1", "Port 2", "Port 3"};
	private JList<String> listePorts = new JList<String>(ports);
	JTextField recherchePort = new JTextField(10);
	
	public PanelListePorts() {
		setLayout(new BorderLayout());
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
}
