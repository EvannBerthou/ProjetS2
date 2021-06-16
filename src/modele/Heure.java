package modele;

public class Heure {
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
		if (heure == -1) {
			return "--:--";
		} 
		return heure + ":" + minute;
	}
	
	public boolean equals(Heure cmp) {
		return cmp.getHeure() == getHeure() && cmp.getMinute() == getMinute();
	}
}
