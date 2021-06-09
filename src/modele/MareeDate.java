package modele;

import java.util.ArrayList;

public class MareeDate {
	private String date; //TODO: Classe date
	private Maree[] marees;
	
	public MareeDate(String _date, Maree[] _marees) {
		this.date = _date;
		this.marees = _marees;
	}
	
	public String toString() {
		String res = date + " | ";
		for (Maree m : marees) {
			res += m.toString() + " | ";
		}
		return res;
	}
}
