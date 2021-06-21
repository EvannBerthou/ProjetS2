package modele;
import java.io.Serializable;
import java.util.GregorianCalendar;

import constantes.ConstantesCalendrier;

import java.util.Calendar;

/**
 * Abstraction d'une date
 * @author Evann Berthou
 *
 */
public class Date implements Comparable <Date>, ConstantesCalendrier, Serializable {
	/**
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 5157598511773634423L;

	/**
	 * Jour de la date
	 */
	private int jour;
	
	/**
	 * Mois de la date
	 */
	private int mois;
	
	/**
	 * Annee de la date
	 */
	private int annee;
	
	/**
	 * Jour de la semaine de la date (0 = Lundi, 6 = Dimanche)
	 */
	private int jourSemaine ;

	/**
	 * Constructeur par défaut d'une Date. Est la date du jour par défaut
	 */
	public Date () { 
		GregorianCalendar dateAuj = new GregorianCalendar ();
		annee = dateAuj.get (Calendar.YEAR);
		mois = dateAuj.get (Calendar.MONTH) + 1; 
		jour = dateAuj.get (Calendar.DAY_OF_MONTH);
		jourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
		if (jourSemaine == 1)
			jourSemaine = 7;
		else jourSemaine -= 1; 
	}

	/**
	 * Créer une date par des informations données
	 * @param parJour Jour de la date
	 * @param parMois Mois de la date
	 * @param parAnnee Annee de la date
	 */
	public Date (int parJour, int parMois, int parAnnee)   {   
		jour = parJour;
		mois = parMois;
		annee = parAnnee; 
		GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
		if (jourSemaine == 1)
			jourSemaine = 7;
		else jourSemaine -= 1; 
	}

	/** 
	 * Permet de créer une date à partir d'une chaine de caractères.
	 * @param str Le chaine de caractères à parser
	 */
	public Date(String str) {
		//Les données gratuites utilises des '/' pour la séparation, les payantes '-'
		String[] parts = str.split("/|-");
		assert (parts.length == 3);

		// Les dates des données gratuites sont sous la forme jj/mm/aaaa, les payantes aaaa-mm-jj
		if (str.contains("-")) {
			annee = Integer.parseInt(parts[0]);
			mois = Integer.parseInt(parts[1]);
			jour = Integer.parseInt(parts[2]);
		} else {
			jour = Integer.parseInt(parts[0]);
			mois = Integer.parseInt(parts[1]);
			annee = Integer.parseInt(parts[2]);
		}
		GregorianCalendar date = new GregorianCalendar (annee,mois-1,jour);
		jourSemaine = date.get (Calendar.DAY_OF_WEEK);		
		if (jourSemaine == 1)
			jourSemaine = 7;
		else 
			jourSemaine -= 1; 
	}

	/**
	 * Compare this avec une autre date
	 * @param parDate La date avec laquelle comparer
	 * @return 0 si this et parDate sont égales,
	 * 		  -1 si this précéde parDate
	 * 		   1 si parDate précéde this
	 */
	public int compareTo (Date parDate) {
		if (annee < parDate.annee)
			return -1;
		if (annee > parDate.annee)
			return 1;
		// les ann�es sont =
		if (mois < parDate.mois)
			return -1;
		if (mois > parDate.mois)
			return 1;
		// les mois sont =
		if (jour < parDate.jour)
			return -1;
		if (jour > parDate.jour)
			return 1;
		return 0;	
	}

	/**
	 * Renvoie la date du lendemain 
	 * @return La date du lendemain
	 */
	public Date dateDuLendemain ()   {	
		if (jour < dernierJourDuMois(mois,annee))
			return  new Date (jour+1,mois,annee);
		else if (mois < 12)
			return new Date (1,mois+1,annee);
		else return new Date (1,1,annee+1);	
	}  

	/**
	 * Renvoie la date de la veille
	 * @return La date de la veille
	 */
	public Date dateDeLaVeille () {    
		if (jour > 1)
			return  new Date (jour-1,mois,annee);
		else if (mois > 1)
			return new Date (Date.dernierJourDuMois(mois-1, annee),mois-1,annee);
		else return  new Date (31,12,annee-1);
	}	 

	/**
	 * Renvoie le dernier jour d'un mois donn�
	 * @param parMois Le mois
	 * @param parAnnee L'année
	 * @return Le dernier jour du mois parMois/parAnnee
	 */
	public static int dernierJourDuMois (int parMois, int parAnnee) {
		switch (parMois) {
		case 2 : if (estBissextile (parAnnee))  return 29 ; else return 28 ;  
		case 4 : 	 case 6 : 	 case 9 : 	 case 11 : return 30 ;
		default : return 31 ;
		}  // switch
	} 

	/**
	 * Renvoie le premier jour de la semaine de la date de this
	 * @return La date du premier jour de la semaine
	 */
	public Date datePremierJourSemaine() {
		Date date = this;
		while (date.getJourSemaine() != 1) {
			date = date.dateDeLaVeille();
		}
		return date;
	}
	
	/**
	 * Renvoie si une année donnée est bissextile ou non
	 * @param parAnnee L'année à vérifier
	 * @return boolean true si l'ann�e est bissextile sinon false
	 */
	private static boolean estBissextile(int parAnnee) {
		return parAnnee % 4 == 0 && (parAnnee % 100 != 0 || parAnnee % 400 == 0);
	}

	/**
	 * Renvoie un la date sous la forme "JOUR_DE_LA_SEMAINE JOUR MOIS" 
	 */
	public String toString () {
		return  JOURS_SEMAINE [jourSemaine -1] + " " + jour + " " + MOIS [mois-1];	  
	}  
	
	/**
	 * Renvoie la version courte de toString
	 * @return version courte de toString
	 */
	public String toShortString() {
		return JOURS_SEMAINE_ABR[jourSemaine - 1] + " " + jour + " " + MOIS[mois-1];
	}

	/**
	 * Renvoie l'année de this
	 * @return l'année de this
	 */
	public int getAnnee() { 
		return annee;
	}

	/**
	 * Renvoie jour de this
	 * @return jour de this
	 */
	public int getJour() { 
		return jour;
	}

	/**
	 * Renvoie mois de this
	 * @return mois de this
	 */
	public int getMois() { 
		return mois;
	}

	/**
	 * Renvoie jour de la semaine de this
	 * @return jourSemaine de this
	 */
	public int getJourSemaine () {
		return jourSemaine;
	}

	/**
	 * Compare si this est la date du jour
	 * @return true si la date est aujourd'hui sinon false
	 */
	public boolean isToday() {
		return new Date().compareTo(this) == 0;
	}
	
	/**
	 * Compare deux dates
	 * @param parDate La date a comaprer
	 * @return true si les dates sont égales
	 */
	public boolean equals(Object parDate) {
		if (this.getClass() != parDate.getClass()) return false;
		return this.compareTo((Date)parDate) == 0;
	}
	
	/**
	 * Est utilisé par les Map afin de pouvoir comparer des objets différents
	 */
	public int hashCode() {
		return new java.util.Date(jour,mois,annee).hashCode();
	}
}