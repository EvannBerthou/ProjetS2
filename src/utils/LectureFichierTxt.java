package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import modele.Maree;
import modele.MareeDate;
 

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
				marees[0] = new Maree(donnees[1], donnees[2], donnees[3]); //Première PM
				marees[1] =  new Maree(donnees[4], donnees[5], donnees[6]);  //Deuxième PM
				marees[2] =  new Maree(donnees[7], donnees[8]);  //Première BM
				marees[3] =  new Maree(donnees[9], donnees[10]);  //Deuxième BM
				mareeDates.add(new MareeDate(donnees[0], marees));
			}	
			buffer.close();
		}
		catch (IOException parException) { 
			// Traitement de l�erreur 
		}
		return mareeDates;
	}
}