package modele;

public class MareeHauteur {
	private String date; //TODO Classe date
	private Maree[] marees;
	
	public MareeHauteur(String _date, Maree[] _marees) {
		this.date = _date;
		this.marees = _marees;
	}
	
	public String toString() {
		String res = date + " : ";
		for (Maree m : marees) {
			if (m == null) continue;
			res += m.toString() + " | ";
		}
		
		return res;
	}
	
	public Maree[] getMarees() {
		return marees;
	}
}
