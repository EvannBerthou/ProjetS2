package modele;

import java.io.Serializable;

/**
 * Abstraction d'une mar�e
 * @author Evann Berthou
 *
 */
public class Maree implements Serializable {
	/**
	 * L'heure de la mar�e
	 */
	private Heure heure;
	/**
	 * La hauteur de la mar�e
	 */
	private float hauteur;
	
	/**
	 * Le coefficient de la mar�e
	 * Si aucun coefficient est disponible alors coef = -1 
	 */
	private int coef; 

	/**
	 * Constructeur � partir des informations
	 * @param _heure L'heure de la mar�e
	 * @param _hauteur La hauteur de la mar�e
	 * @param _coef Le coefficient de la mar�e
	 */
	public Maree(Heure _heure, String _hauteur, String _coef) {
		this.heure = _heure;
		setHauteur(_hauteur);
		setCoef(_coef);
	}
	
	/**
	 * Constructeur sans coeficient (est mis � -1)
	 * @param _heure L'heure de la mar�e
	 * @param _hauteur La hauteur de la mar�e
	 */
	public Maree(Heure _heure, String _hauteur) {
		this.heure = _heure;
		setHauteur(_hauteur);
		this.coef = -1;
	}
	
	/**
	 * Construcuter avec juste une heure sans minute
	 * @param _heure L'heure en nombre
	 * @param _hauteur La hauteur
	 */
	public Maree(int _heure, String _hauteur) {
		this.heure = new Heure(_heure, 0);
		this.hauteur = Float.parseFloat(_hauteur);
		this.coef = -1;
	}
	
	/**
	 * Repr�sentation de la mar�e sous la forme 'hh:mm hauteur coefficient'
	 */
	public String toString() {
		String res = heure.toString();
		if (hauteur == -1) res += " --.--";
		else res += " " + hauteur + "m";
		
		if (coef == -1) res += " --";
		else res += " " + coef;
		return res;
	}
	
	/**
	 * R�cup�re l'heure de la mar�e
	 * @return L'heure de la mar�e
	 */
	public Heure getHeure() {
		return heure;
	}
	
	/**
	 * Renvoie la hauteur de la mar�e
	 * @return La hauteur de la mar�e
	 */
	public float getHauteur() {
		return hauteur;
	}
	
	/**
	 * Renvoie les 3 informations de la mar�e dans des strings distints (heure, hauteur, coefficient)
	 * @return La liste des informations
	 */
	public String[] getParts() {
		String[] parts = new String[3];
		if (heure.getHeure() == -1) parts[0] = "--.--";
		else parts[0] = heure.toString();
		
		if (getHauteur() == -1) parts[1] = "---";
		else parts[1] = String.valueOf(getHauteur());
		
		if (coef == -1) parts[2] = "--.--";
		else parts[2] = String.valueOf(coef);
		
		return parts;
	}
	
	/**
	 * Change la hauteur de la mar�e, si la hauteur est "--.--" (inconnue), alors elle vaudra -1
	 * @param str La hauteur � parser
	 */
	private void setHauteur(String str) {
		if (str.equals("--.--")) {
			this.hauteur = -1;
		} else {
			this.hauteur = Float.parseFloat(str);
		}
	}
	
	/**
	 * Change le coefficient de la mar�e, si le coefficient est "---" (inconnue), alors il vaudra -1
	 * @param str Le coefficient � parser
	 */
	private void setCoef(String str) {
		if (str.equals("---")) {
			this.coef = -1;
		} else {
			this.coef = Integer.parseInt(str);
		}
	}
}
