package modele;

import java.io.Serializable;

public class Heure implements Serializable {
	private int heure;
	private int minute;
	
	public Heure(String str) {
		if (str.equals("--:--")) {
			heure = -1;
		} else {
			String[] parts  = str.split(":");
			assert(parts.length == 2);
			heure = Integer.parseInt(parts[0]);
			minute = Integer.parseInt(parts[1]);
		}
	}
	
	public Heure(int _heure, int _minute) {
		this.heure = _heure;
		this.minute = _minute;
	}

	public int getHeure() {
		return heure;
	}

	public int getMinute() {
		return minute;
	}
	
	public String toString() {
		// Si l'heure n'est pas valide
		if (heure == -1) {
			return "--:--";
		}
		//Le format permet de convertir l'int vers un string tout en ajouant des 0
		// afin d'obtenir une heure sous la forme 00:00 au lieu de 0:0
		return String.format("%02d", heure) + ":" + String.format("%02d", minute);
	}
	
	public boolean equals(Heure cmp) {
		return cmp.getHeure() == getHeure() && cmp.getMinute() == getMinute();
	}
}
