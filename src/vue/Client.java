package vue;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import modele.MareeDate;
import modele.MareeHauteur;
import utils.LectureFichierTxt;

public class Client extends JFrame {

	public Client() {
		super("Titre");
		
		File file = new File("data/paimpol.txt");
		ArrayList<MareeDate> marees = LectureFichierTxt.lectureMareeDate(file);
		for (MareeDate m : marees) {
			System.out.println(m.toString());
		}
		
		/*file = new File("data/st-nazaire.txt");
		ArrayList<MareeHauteur> marees = LectureFichierTxt.lectureMareeHauteur(file);
		for (MareeHauteur m : marees) {
			System.out.println(m.toString());
		}*/
		
		PanelCoefs panel = new PanelCoefs(marees);
		setContentPane(panel);
	    setSize(800,600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Client();

	}
}
