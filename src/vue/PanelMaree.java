package vue;

import javax.swing.JPanel;
import javax.swing.JTable;

import constantes.ConstantesCouleurs;
import modele.MareeCellRenderer;

public class PanelMaree extends JPanel {
	JTable table;
	
	public PanelMaree() {
		table = new JTable();
		table.setDefaultRenderer(Object.class, new MareeCellRenderer());
		add(table);
		setBackground(ConstantesCouleurs.MASTIC);
	}
}
