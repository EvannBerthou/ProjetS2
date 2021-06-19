package vue;

import javax.swing.JFrame;

public class Client extends JFrame {

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
