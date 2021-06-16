package vue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import constantes.ConstantesCouleurs;
import modele.Maree;
import utils.LectureFichierTxt;

public class Client extends JFrame {

	@SuppressWarnings("unused")
	public Client() {
		super("Titre");
		File file;
		
		if (1 == 0) {
			file = new File("data/paimpol.txt");
			HashMap<String, Maree[]> marees = LectureFichierTxt.lectureMareeDate(file);
			PanelCoefs panel = new PanelCoefs(marees.get("2021-06-02"));
			setContentPane(panel);
		} else {
			file = new File("data/st-nazaire.txt");
			HashMap<String, Maree[]> marees = LectureFichierTxt.lectureMareeHauteur(file);
			PanelHauteurs panel = new PanelHauteurs(marees.get("05/01/2021"));
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
