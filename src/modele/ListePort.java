package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * Encapsulation d'une Liste des ports
 * @author Evann Berthou
 *
 */
public class ListePort implements Serializable{
	
	/**
	 * La liste des ports avec en clé le nom du port et en valeur les informations du port, @see Port
	 */
	private HashMap<String, Port> ports = new HashMap<String, Port>();
	
	/**
	 * Ajouter un port
	 * @param key Le nom du port
	 * @param value Le port
	 * @return Le port ajouté
	 */
	public Port put(String key, Port value) {
		return ports.put(key, value);
	}

	/**
	 * Vérifie si un port avec un nom donné existe
	 * @param nomPort Le nom à tester
	 * @return true si le port est dans la liste des ports
	 */
	public boolean containsKey(String nomPort) {
		return ports.containsKey(nomPort);
	}

	/**
	 * Renvoie un @see Port par son nom
	 * @param nomPort Le nom du port
	 * @return Le port
	 */
	public Port get(String nomPort) {
		return ports.get(nomPort);
	}

	/**
	 * Renvoie la liste des noms de port
	 * @return Le liste des noms de port
	 */
	public Set<String> keySet() {
		return ports.keySet();
	}
}