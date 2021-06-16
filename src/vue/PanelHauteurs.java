package vue;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableHauteurs;

public class PanelHauteurs extends JPanel {
	public PanelHauteurs(Maree[] marees) {
		ModeleTableHauteurs model = new ModeleTableHauteurs(marees);
		JTable table = new JTable(model);
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());  
		add(table);
		setBackground(ConstantesCouleurs.ROUGE);
	}
}
