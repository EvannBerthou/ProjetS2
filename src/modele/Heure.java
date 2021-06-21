package modele;

import java.io.Serializable;

/**
 * Abstraction d'une heure
 * @author Evann Berthou
 *
 */
public class Heure implements Serializable {
	/**
	 * L'heure
	 */
	private int heure;
	/**
	 * La minute
	 */
	private int minute;
	
	/**
	 * Constructeur à partir d'un String
	 * @param str Le String
	 */
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
	
	/**
	 * Constructeur à partir d'une heure et d'une minute
	 * @param _heure L'heure
	 * @param _minute La minute
	 */
	public Heure(int _heure, int _minute) {
		this.heure = _heure;
		this.minute = _minute;
	}

	/**
	 * Renvoie l'heure
	 * @return L'heure
	 */
	public int getHeure() {
		return heure;
	}

	/**
	 * Renvoie la minute
	 * @return La minute
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * Représentation de l'heure sous la forme hh:mm
	 */
	public String toString() {
		// Si l'heure n'est pas valide
		if (heure == -1) {
			return "--:--";
		}
		//Le format permet de convertir l'int vers un string tout en ajouant des 0
		// afin d'obtenir une heure sous la forme 00:00 au lieu de 0:0
		return String.format("%02d", heure) + ":" + String.format("%02d", minute);
	}
	
	/**
	 * Compare deux dates
	 * @param cmp La date à comparer avec this
	 * @return true si les dates sont égales
	 */
	public boolean equals(Heure cmp) {
		return cmp.getHeure() == getHeure() && cmp.getMinute() == getMinute();
	}
}
