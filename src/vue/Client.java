package vue;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;

import constantes.ConstantesCouleurs;
import modele.MareeDate;
import modele.MareeHauteur;
import utils.LectureFichierTxt;

public class Client extends JFrame {

	@SuppressWarnings("unused")
	public Client() {
		super("Titre");
		File file;
		
		if (1 == 0) {
			file = new File("data/paimpol.txt");
			ArrayList<MareeDate> marees = LectureFichierTxt.lectureMareeDate(file);
			PanelCoefs panel = new PanelCoefs(marees);
			setContentPane(panel);
		} else {
			file = new File("data/st-nazaire.txt");
			ArrayList<MareeHauteur> marees = LectureFichierTxt.lectureMareeHauteur(file);
			PanelHauteurs panel = new PanelHauteurs(marees);
			setContentPane(panel);
		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(800,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
