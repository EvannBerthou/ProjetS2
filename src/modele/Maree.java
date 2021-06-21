package modele;

import java.io.Serializable;

public class Maree implements Serializable {
	private Heure heure;
	private float hauteur;
	
	// Si aucun coef est disponible, coef = -1 
	private int coef; 

	public Maree(Heure _heure, String _hauteur, String _coef) {
		this.heure = _heure;
		setHauteur(_hauteur);
		setCoef(_coef);
	}
	
	public Maree(Heure _heure, String _hauteur) {
		this.heure = _heure;
		setHauteur(_hauteur);
		this.coef = -1;
	}
	
	public Maree(int _heure, String _hauteur) {
		this.heure = new Heure(_heure, 0);
		this.hauteur = Float.parseFloat(_hauteur);
		this.coef = -1;
	}
	
	public String toString() {
		String res = heure.toString();
		if (hauteur == -1) res += " --.--";
		else res += " " + hauteur + "m";
		
		if (coef == -1) res += " --";
		else res += " " + coef;
		return res;
	}
	
	public Heure getHeure() {
		return heure;
	}
	
	public float getHauteur() {
		return hauteur;
	}
	
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
	
	private void setHauteur(String str) {
		if (str.equals("--.--")) {
			this.hauteur = -1;
		} else {
			this.hauteur = Float.parseFloat(str);
		}
	}
	
	private void setCoef(String str) {
		if (str.equals("---")) {
			this.coef = -1;
		} else {
			this.coef = Integer.parseInt(str);
		}
	}
}
