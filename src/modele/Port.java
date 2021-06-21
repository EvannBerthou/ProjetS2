package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Abstraction des informatiosn d'un port
 * @author Evann Berthou
 *
 */
public class Port implements Serializable {
	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = -780175007004083615L;

	/**
	 * La liste des coefficients des mar�es par date
	 */
	private HashMap<Date, Maree[]> mareesCoefs = new HashMap<Date, Maree[]>();
	
	/**
	 * La liste des hauteurs des mar�es par date
	 */
	private HashMap<Date, Maree[]> mareesHauteurs = new HashMap<Date, Maree[]>();
	
	/**
	 * Ajoute des mar�es � la Map des coefficient des mar�es
	 * @param marees La Map � ajouter
	 */
	public void addCoefs(HashMap<Date, Maree[]> marees) {
		mareesCoefs.putAll(marees);
	}
	
	/**
	 * Ajoute des mar�es � la Map des hauteurs des mar�es
	 * @param marees La Map � ajouter
	 */
	public void addHauteurs(HashMap<Date, Maree[]> marees) {
		mareesHauteurs.putAll(marees);
	}
	
	/**
	 * Renvoie la liste de toutes les mar�es coefficient d'une date donn�e
	 * @param date La date � chercher
	 * @return La liste des mar�es
	 */
	public Maree[] getCoefsDate(Date date) {
		for (Date d : mareesCoefs.keySet()) {
			if (d.equals(date)) return mareesCoefs.get(d);
		}
		return null;
	}

	/**
	 * Renvoie la liste de toutes les mar�es hauteurs d'une date donn�e
	 * @param date La date � chercher
	 * @return La liste des mar�es
	 */
	public Maree[] getHauteursDate(Date date) {
		for (Date d : mareesHauteurs.keySet()) {
			if (d.equals(date)) return mareesHauteurs.get(d);
		}
		return null;
	}

	/**
	 * Renvoie la liste de toutes les dates ayant des donn�es disponibles
	 * @return La liste des dates ayant des donn�es
	 */
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