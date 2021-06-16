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
		PanelApplication panel = new PanelApplication();
		setContentPane(panel);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setSize(1000,600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Client();
	}
}
