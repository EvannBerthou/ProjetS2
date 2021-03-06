package modele;

import javax.swing.JButton;

/**
 * Permet de stocker la date d'un bouton dans le @see PanelCalendrier
 * @author Evann Berthou
 *
 */
public class BoutonDate extends JButton {
	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = -4741746749878237055L;
	/**
	 * La date du bouton
	 */
	private Date date;
	
	/** 
	 * Constructeur d'un bouton et de sa date
	 * @param date La date du bouton
	 */
	public BoutonDate(Date date) {
		super (Integer.toString(date.getJour()));
		this.date = date;
	}

	/**
	 * Renvoie la date du bouton
	 * @return La date du bouton
	 */
	public Date getDate() {		 
		return date;
	}

}
