package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import modele.Date;
import modele.Heure;
import modele.ListePort;
import modele.Maree;
 

public class LectureFichier {
	/**
	 * Est utilisé afin de parser les données payantes.
	 * @param fichier
	 * @return
	 */
	public static HashMap<Date, Maree[]> lectureMareeDate(File fichier) {
		HashMap<Date, Maree[]> res = new HashMap<Date, Maree[]>();
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
				marees[2] = new Maree(new Heure(donnees[7]), donnees[8]); 			   //Première BM
				marees[3] = new Maree(new Heure(donnees[9]), donnees[10]);  		   //Deuxième BM
				res.put(new Date(donnees[0]), marees);
			}	
			buffer.close();
		}
		catch (IOException parException) { 
			// Traitement de l�erreur 
		}
		return res;
	}
	
	/**
	 * Est utilisé afin de parser les données gratuites.
	 * @param fichier
	 * @return
	 */
	public static HashMap<Date, Maree[]> lectureMareeHauteur(File fichier) {
		HashMap<Date, Maree[]> res = new HashMap<Date, Maree[]>();
		try {
			
			BufferedReader buffer = new BufferedReader (
					new InputStreamReader (new FileInputStream (fichier)));
			String ligneLue;

			Maree[] marees = new Maree[24];
			Heure heure = null;
			Date date = null;
			String hauteur = null;
			
			while ((ligneLue = buffer.readLine()) != null) {
				// On ignore les # qui sont en en-tête
				if (ligneLue.startsWith("#")) continue;
			
				StringTokenizer decoup = new StringTokenizer(ligneLue,";");
				
				Date nouvelleDate = null;
				Heure nouvelleHeure = null;
				
				if (decoup.hasMoreTokens()) {
					String dateEtHeure = decoup.nextToken();
					//On sépare la date et l'heure
					String[] tempsDecoup = dateEtHeure.split(" ");
					nouvelleDate = new Date(tempsDecoup[0]);
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
				
				if (nouvelleDate.compareTo(date) != 0) {
					res.put(date, marees);
					marees = new Maree[24];
					date = nouvelleDate;
				}
			}	
			buffer.close();
			
			// On ajoute la dernière date qui était en cours de traitement lorsque le fichier a été lu en entier
			marees[heure.getHeure()] = new Maree(heure, hauteur);
			res.put(date, marees);
		}
		catch (IOException parException) { 
			// Traitement de l'érreur 
		}
		return res;
	}
	
	public static String getNomPort(File fichier) {
		try {
			BufferedReader buffer = new BufferedReader (new InputStreamReader(new FileInputStream(fichier)));
			String ligneLue = buffer.readLine();
			String[] parts = ligneLue.split(":");
			if (ligneLue.startsWith("#")) {
				String nom = parts[1];
				return nom.trim().toLowerCase();
			} 
			
			String[] parts2 = parts[1].split("\\(");
			return parts2[0].trim().toLowerCase();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	/**
	 * 
	* Méthode de lecture d'un fichier
	* @param fichier : le fichier lu
	* @return l'objet lu
	*/
	public static Object charger(File fichier) {
		ObjectInputStream flux;
		Object objetLu = null;
		// Ouverture du fichier en mode lecture
		try {
			flux = new ObjectInputStream(new FileInputStream(fichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		catch (ClassNotFoundException parException) {
			System.err.println(parException.toString());
			System.exit(1);
		}
		catch (IOException parException) {
			System.err.println("Erreur lecture du fichier " + parException.toString());
			System.exit(1);
		}
		return objetLu;
	}
	
	/* Méthode d'écriture dans un fichier
	* @param parFichier : le fichier dans lequel on écrit
	* @param parObjet : l'objet écrit dans le fichier
	*/
	public static void ecriture (File parFichier, Object parObjet) {
		ObjectOutputStream flux = null;
		// Ouverture du fichier en mode �criture
		try {
			flux = new ObjectOutputStream(new FileOutputStream(parFichier));
			flux.writeObject(parObjet);
			flux.flush();
			flux.close();
		}
		catch (IOException parException) {
			System.err.println("Probleme a l�ecriture\n" + parException.toString());
			System.exit(1);
		}
	}
}