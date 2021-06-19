package modele;

import java.util.HashMap;

public class Port {
	private HashMap<Date, Maree[]> mareesCoefs;
	private HashMap<Date, Maree[]> mareesHauteurs;
	
	public void setCoefs(HashMap<Date, Maree[]> marees) {
		this.mareesCoefs = marees;
	}
	
	public void setHauteurs(HashMap<Date, Maree[]> marees) {
		this.mareesHauteurs = marees;
	}
	
	public Maree[] getCoefsDate(Date date) {
		for (Date d : mareesCoefs.keySet()) {
			if (d.equals(date)) return mareesCoefs.get(d);
		}
		return null;
	}

	public Maree[] getHauteursDate(Date date) {
		for (Date d : mareesHauteurs.keySet()) {
			if (d.equals(date)) return mareesHauteurs.get(d);
		}
		return null;
	}

}