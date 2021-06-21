package constantes;

import java.awt.Color;
import java.awt.Font;

/**
 * Interface qui stocke des couleurs et les polices d'écriture
 * @author eberthou
 *
 */
public interface ConstantesCouleursFontes {
	/**
	 * Couleur MASTIC
	 */
	final Color MASTIC = new Color (179, 177, 145);
	/**
	 * Couleur VANILLE
	 */
	final Color VANILLE = new Color (225, 206, 154);
	/**
	 * Couleur ROUGE
	 */
	final Color ROUGE = new Color (150,15,15);
	/**
	 * Couleur VERT
	 */
	final Color VERT = new Color (150,150,15);
	/**
	 * Couleur BLEU
	 */
	final Color BLEU = new Color (22,159,182); 
	/**
	 * Couleur CREAM
	 */
	public final static Color CREAM = new Color (253,241,184);
	
	/**
	 * Police Verdana, en gras, taille 14
	 */
	public final static Font FONT_14 = new Font ("Verdana", Font.BOLD,14);


	/**
	 * Police Verdana, en gras, taille 12
	 */
	public final static Font FONT_12 = new Font ("Verdana", Font.BOLD,12);

	/**
	 * Police Verdana, en gras, taille 11
	 */
	public final static Font FONT_11 = new Font ("Verdana", Font.BOLD,11);
}
