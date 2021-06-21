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
	 * Le serialVersionUID
	 */
	private static final long serialVersionUID = 3399746444268534203L;
	/**
	 * La liste des ports avec en cl� le nom du port et en valeur les informations du port, @see Port
	 */
	private HashMap<String, Port> ports = new HashMap<String, Port>();
	
	/**
	 * Ajouter un port
	 * @param key Le nom du port
	 * @param value Le port
	 * @return Le port ajout�
	 */
	public Port put(String key, Port value) {
		return ports.put(key, value);
	}

	/**
	 * V�rifie si un port avec un nom donn� existe
	 * @param nomPort Le nom � tester
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