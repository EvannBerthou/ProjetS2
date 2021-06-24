package modele;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

/**
 * Encapsulation d'une Liste des ports
 * La classe n'a pas d'implémentation car on se sert juste de l'extends afin de
 * pouvoir utilser le type ListePort au lieu du long nom HashMap
 * @author Evann Berthou
 *
 */
public class ListePort extends HashMap<String, Port> implements Serializable { }