package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import modele.Heure;
import modele.Maree;
import modele.MareeDate;
import modele.MareeHauteur;
 

public class LectureFichierTxt {
	/**
	 * Est utilisé afin de parser les données payantes.
	 * @param fichier
	 * @return
	 */
	public static ArrayList<MareeDate> lectureMareeDate(File fichier) {
		ArrayList<MareeDate> mareeDates = new ArrayList<MareeDate>();
		try {
			
			BufferedReader buffer = new BufferedReader (
					new InputStreamReader (new FileInputStream (fichier)));
			String ligneLue;
			int ligneIndex = 0;
			while ((ligneLue = buffer.readLine()) != null) {
				ligneIndex++;
				// Les 4 premières lignes correspondent à l'en-tête du fichier
				if (ligneIndex < 5) continue;
				
				String[] donnees = new String[11];
				StringTokenizer decoup = new StringTokenizer(ligneLue,"\t");
				for(int i = 0; decoup.hasMoreTokens(); i++) {
					String token = decoup.nextToken();
					donnees[i] = token;
				}


				Maree[] marees = new Maree[4];
				marees[0] = new Maree(new Heure(donnees[1]), donnees[2], donnees[3]);  //Première PM
				marees[1] = new Maree(new Heure(donnees[4]), donnees[5], donnees[6]);  //Deuxième PM
				marees[2] = new Maree(new Heure(donnees[4]), donnees[8]); 			   //Première BM
				marees[3] = new Maree(new Heure(donnees[9]), donnees[10]);  		   //Deuxième BM
				mareeDates.add(new MareeDate(donnees[0], marees));
			}	
			buffer.close();
		}
		catch (IOException parException) { 
			// Traitement de l�erreur 
		}
		return mareeDates;
	}
	
	/**
	 * Est utilisé afin de parser les données gratuites.
	 * @param fichier
	 * @return
	 */
	public static ArrayList<MareeHauteur> lectureMareeHauteur(File fichier) {
		ArrayList<MareeHauteur> mareeHauteur = new ArrayList<MareeHauteur>();
		try {
			
			BufferedReader buffer = new BufferedReader (
					new InputStreamReader (new FileInputStream (fichier)));
			String ligneLue;

			Maree[] marees = new Maree[24];
			Heure heure = null;
			String date = null;
			String hauteur = null;
			
			while ((ligneLue = buffer.readLine()) != null) {
				// On ignore les # qui sont en en-tête
				if (ligneLue.startsWith("#")) continue;
			
				StringTokenizer decoup = new StringTokenizer(ligneLue,";");
				
				String nouvelleDate = null;
				Heure nouvelleHeure = null;
				
				if (decoup.hasMoreTokens()) {
					String dateEtHeure = decoup.nextToken();
					//On sépare la date et l'heure
					String[] tempsDecoup = dateEtHeure.split(" ");
					nouvelleDate = tempsDecoup[0];
					//Le nouveau temps sous forme de hh:mm:ss
					String nouveauTemps = tempsDecoup[1];
					//On récupère uniquement l'heure
					nouvelleHeure = new Heure(nouveauTemps);

					//Lors de la première lecture, les dates et les heures sont nulles
					if (date == null) date = nouvelleDate;
					if (heure == null) heure = nouvelleHeure;
				}
				
				//On récupère la valeur, qui correspond à la hauteur
				if (decoup.hasMoreTokens()) {
					hauteur = decoup.nextToken();
				}
				
				if (nouvelleHeure.getHeure() != heure.getHeure()) {
					heure = nouvelleHeure;
					marees[heure.getHeure()] = new Maree(heure, hauteur);
				}	
				
				if (!nouvelleDate.equals(date)) {
					date = nouvelleDate;
					mareeHauteur.add(new MareeHauteur(date, marees));
					marees = new Maree[24];
				}
			}	
			buffer.close();
			
			// On ajoute la dernière date qui était en cours de traitement lorsque le fichier a été lu en entier
			marees[heure.getHeure()] = new Maree(heure, hauteur);
			mareeHauteur.add(new MareeHauteur(date, marees));
		}
		catch (IOException parException) { 
			// Traitement de l'érreur 
		}
		return mareeHauteur;
	}
}