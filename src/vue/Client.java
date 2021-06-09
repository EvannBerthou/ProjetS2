package vue;

import java.io.File;
import java.util.ArrayList;

import modele.MareeDate;
import modele.MareeHauteur;
import utils.LectureFichierTxt;

public class Client {

	public static void main(String[] args) {
		File file = new File("data/paimpol.txt");
		/*ArrayList<MareeDate> marees = LectureFichierTxt.lectureMareeDate(file);
		for (MareeDate m : marees) {
			System.out.println(m.toString());
		}*/
		
		file = new File("data/st-nazaire.txt");
		ArrayList<MareeHauteur> marees = LectureFichierTxt.lectureMareeHauteur(file);
		for (MareeHauteur m : marees) {
			System.out.println(m.toString());
		}
	}
}
