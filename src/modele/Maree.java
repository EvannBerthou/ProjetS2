package modele;

public class Maree {
	private Heure heure;
	private float hauteur;
	
	// Si aucun coef est disponible, coef = -1 
	private int coef; 
	
	
	public Maree(Heure _heure, String _hauteur, String _coef) {
		this.heure = _heure;
		this.hauteur = Float.parseFloat(_hauteur);
		this.coef = Integer.parseInt(_coef);
	}
	
	public Maree(Heure _heure, String _hauteur) {
		this.heure = _heure;
		this.hauteur = Float.parseFloat(_hauteur);
		this.coef = -1;
	}
	
	public Maree(int _heure, String _hauteur) {
		this.heure = new Heure(_heure, 0);
		this.hauteur = Float.parseFloat(_hauteur);
		this.coef = -1;
	}
	
	public String toString() {
		if (coef == -1) return heure + " " + hauteur + "m";
		return heure + " " + hauteur + "m " + coef;
	}
	
	public Heure getHeure() {
		return heure;
	}
	
	public float getHauteur() {
		return hauteur;
	}
}
