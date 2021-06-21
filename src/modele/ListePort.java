package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class ListePort implements Serializable{
	
	private HashMap<String, Port> ports = new HashMap<String, Port>();
	
	public Port put(String key, Port value) {
		return ports.put(key, value);
	}

	public boolean containsKey(String nomPort) {
		return ports.containsKey(nomPort);
	}

	public Port get(String nomPort) {
		return ports.get(nomPort);
	}

	public Set<String> keySet() {
		return ports.keySet();
	}
}