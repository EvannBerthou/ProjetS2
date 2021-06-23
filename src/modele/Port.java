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
	 * La liste des coefficients des marées par date
	 */
	private HashMap<Date, Maree[]> mareesCoefs = new HashMap<Date, Maree[]>();
	
	/**
	 * La liste des hauteurs des marées par date
	 */
	private HashMap<Date, Maree[]> mareesHauteurs = new HashMap<Date, Maree[]>();
	
	/**
	 * Ajoute des marées à la Map des coefficient des marées
	 * @param marees La Map à ajouter
	 */
	public void addCoefs(HashMap<Date, Maree[]> marees) {
		mareesCoefs.putAll(marees);
	}
	
	/**
	 * Ajoute des marées à la Map des hauteurs des marées
	 * @param marees La Map à ajouter
	 */
	public void addHauteurs(HashMap<Date, Maree[]> marees) {
		mareesHauteurs.putAll(marees);
	}
	
	/**
	 * Renvoie la liste de toutes les marées coefficient d'une date donnée
	 * @param date La date à chercher
	 * @return La liste des marées
	 */
	public Maree[] getCoefsDate(Date date) {
		return mareesCoefs.get(date);
	}

	/**
	 * Renvoie la liste de toutes les marées hauteurs d'une date donnée
	 * @param date La date à chercher
	 * @return La liste des marées
	 */
	public Maree[] getHauteursDate(Date date) {
		return mareesHauteurs.get(date);
	}

	/**
	 * Renvoie la liste de toutes les dates ayant des données disponibles
	 * @return La liste des dates ayant des données
	 */
	public HashSet<Date> getDates() {
		HashSet<Date> dates = new HashSet<Date>();
		dates.addAll(mareesCoefs.keySet());
		dates.addAll(mareesHauteurs.keySet());
		return dates;
	}
}