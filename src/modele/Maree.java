package modele;

public class Maree {
	private String heure; //TODO Classe heure
	private float hauteur;
	
	// Si aucun coef est disponible, coef = -1 
	private int coef; 
	
	private boolean existe;
	
	public Maree(String _heure, String _hauteur, String _coef) {
		if (_heure.equals("--:--")) {
			existe = false;
		} else {
			this.heure = _heure;
			this.hauteur = Float.parseFloat(_hauteur);
			this.coef = Integer.parseInt(_coef);
			existe = true;
		}
	}
	
	public Maree(String _heure, String _hauteur) {
		if (_heure.equals("--:--")) {
			existe = false;
		} else {
			this.heure = _heure;
			this.hauteur = Float.parseFloat(_hauteur);
			this.coef = -1;
			existe = true;
		}
	}
	
	public String toString() {
		if (!existe) return "--";
		return heure + " " + hauteur + "m " + coef;
	}
}
