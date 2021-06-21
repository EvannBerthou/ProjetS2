package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class Port implements Serializable {
	private HashMap<Date, Maree[]> mareesCoefs = new HashMap<Date, Maree[]>();
	private HashMap<Date, Maree[]> mareesHauteurs = new HashMap<Date, Maree[]>();
	
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

	public HashSet<Date> getDates() {
		HashSet<Date> dates = new HashSet<Date>();
		for (Date d : mareesCoefs.keySet()) {
			dates.add(d);
		}
		
		for (Date d : mareesHauteurs.keySet()) {
			dates.add(d);
		}
		
		return dates;
	}
}