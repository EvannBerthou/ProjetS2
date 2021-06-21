package modele;

import java.io.Serializable;

/**
 * Abstraction d'une marée
 * @author Evann Berthou
 *
 */
public class Maree implements Serializable {
	/**
	 * L'heure de la marée
	 */
	private Heure heure;
	/**
	 * La hauteur de la marée
	 */
	private float hauteur;
	
	/**
	 * Le coefficient de la marée
	 * Si aucun coefficient est disponible alors coef = -1 
	 */
	private int coef; 

	/**
	 * Constructeur à partir des informations
	 * @param _heure L'heure de la marée
	 * @param _hauteur La hauteur de la marée
	 * @param _coef Le coefficient de la marée
	 */
	public Maree(Heure _heure, String _hauteur, String _coef) {
		this.heure = _heure;
		setHauteur(_hauteur);
		setCoef(_coef);
	}
	
	/**
	 * Constructeur sans coeficient (est mis à -1)
	 * @param _heure L'heure de la marée
	 * @param _hauteur La hauteur de la marée
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
	 * Représentation de la marée sous la forme 'hh:mm hauteur coefficient'
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
	 * Récupère l'heure de la marée
	 * @return L'heure de la marée
	 */
	public Heure getHeure() {
		return heure;
	}
	
	/**
	 * Renvoie la hauteur de la marée
	 * @return La hauteur de la marée
	 */
	public float getHauteur() {
		return hauteur;
	}
	
	/**
	 * Renvoie les 3 informations de la marée dans des strings distints (heure, hauteur, coefficient)
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
	 * Change la hauteur de la marée, si la hauteur est "--.--" (inconnue), alors elle vaudra -1
	 * @param str La hauteur à parser
	 */
	private void setHauteur(String str) {
		if (str.equals("--.--")) {
			this.hauteur = -1;
		} else {
			this.hauteur = Float.parseFloat(str);
		}
	}
	
	/**
	 * Change le coefficient de la marée, si le coefficient est "---" (inconnue), alors il vaudra -1
	 * @param str Le coefficient à parser
	 */
	private void setCoef(String str) {
		if (str.equals("---")) {
			this.coef = -1;
		} else {
			this.coef = Integer.parseInt(str);
		}
	}
}
