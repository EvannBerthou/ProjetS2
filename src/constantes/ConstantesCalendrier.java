package constantes;

/**
 * Constantes pour le @see PanelCalendrier
 * @author Evann Berthou
 *
 */
public interface ConstantesCalendrier {
	
	/** 
	 * Le nom des jours de la semaine
	 */
	final String [] JOURS_SEMAINE = {"lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"} ; 
	
	/**
	 * Version courte des jours de la semaine
	 */
	final String [] JOURS_SEMAINE_ABR = {"lu","ma","me","je","ve","sa","di"} ;  
	
	/**
	 * Le nom des mois de l'ann�e
	 */
	final  String [] MOIS = {"janvier", "f�vrier","mars","avril","mai","juin","juillet", "ao�t","septembre","octobre","novembre","d�cembre"};
	
	/**
	 * Texte bouton premier
	 */
	final String INTIT_PREMIER = "<<";
	/**
	 * Texte bouton pr�c�dent
	 */
	final String INTIT_PRECEDENT = "<";
	/**
	 * Texte bouton suivant
	 */
	final String INTIT_SUIVANT = ">";
	/**
	 * Text bouton dernier
	 */
	final String INTIT_DERNIER = ">>";
	/**
	 * Liste des textes des boutons
	 */
	final  String [] INTITULES_BOUTONS = {INTIT_PREMIER,INTIT_PRECEDENT, INTIT_SUIVANT, INTIT_DERNIER};
}
