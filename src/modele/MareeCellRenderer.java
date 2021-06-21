package modele;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import constantes.ConstantesCouleurs;

/**
 * Renderer du tableaux des informations des marées.
 * @author Evann Berthou
 *
 */
public class MareeCellRenderer extends JLabel implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		setOpaque(true);
		Object cell = table.getValueAt(row, column);
		if (cell == null) {
			setText("");
		} else {
			setText(cell.toString());
		}
		if (row % 2 == 0) {
			setBackground(ConstantesCouleurs.BLEU);
		} else {
			setBackground(Color.WHITE);
		}
		this.setHorizontalAlignment(CENTER);
		return this;
	}
}
