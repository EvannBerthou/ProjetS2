package modele;

import javax.swing.JButton;

/**
 * Permet de stocker la date d'un bouton dans le @see PanelCalendrier
 * @author eberthou
 *
 */
public class BoutonDate extends JButton {

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
		this.date= date;
	}

	/**
	 * Renvoie la date du bouton
	 * @return La date du bouton
	 */
	public Date getDate() {		 
		return date;
	}

}
