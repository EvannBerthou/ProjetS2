package vue;

import javax.swing.JPanel;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.Maree;
import modele.MareeCellRenderer;
import modele.ModeleTableHauteurs;

public class PanelHauteurs extends JPanel {
	JTable table;
	
	public PanelHauteurs() {
		table = new JTable();
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());  
		add(table);
		setBackground(ConstantesCouleurs.ROUGE);
	}
	
	public void setValeurs(Maree[] marees) {
		ModeleTableHauteurs model = new ModeleTableHauteurs(marees);
		table.setModel(model);
	}
}
