package modele;
import java.util.TreeSet;
import java.util.Collection;

/**
 * Abstraction de toutes les dates d'un mois
 * @author eberthou
 *
 */
public class CalendrierDuMois {	
	/**
	 * Liste des dates d'un mois
	 */
	private Collection <Date> treeSetDate;	  

	/**
	 * Constructeur qui génère toutes les dates d'une date mois d'une année donnée
	 * @param mois Le mois
	 * @param annee L'année
	 */
	public CalendrierDuMois (int mois, int annee) {			   
		treeSetDate = new TreeSet <Date> ();
		Date date = new Date (1,mois,annee);
		int indiceJour = date.getJourSemaine() ;
		for (int x = indiceJour ; x!=0 ; x--) {	    	 
			treeSetDate.add(date);	    	
			date = date.dateDeLaVeille();
		}	    
		date = new Date (2,mois,annee);
		indiceJour = indiceJour % 7 ;
		while (date.getMois () == mois) {
			while(indiceJour<7) {
				treeSetDate.add(date);
				date = date.dateDuLendemain();
				indiceJour++ ;
			} 
			indiceJour=0;
		}    
	}

	/**
	 * Renvoie la liste de toutes les dates du mois
	 * @return La liste des dates
	 */
	public Collection <Date> getDates() {	
		return treeSetDate;	
	}	

	/**
	 * Renvoie la liste des dates du mois sous forme de String
	 */
	public String toString () {
		return treeSetDate.toString();
	}

}