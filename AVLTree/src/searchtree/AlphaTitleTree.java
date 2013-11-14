package searchtree;

import dsaj.AVLTreeMap;
import dsaj.InvalidKeyException;

/**
 * Classe permettant de stocker des magazines par ordre alphabetique des titres.
 * 
 * @author Lena Peschke
 * @author Guillaume Moyson
 * @version novembre 2013
 */
public class AlphaTitleTree {
	
	AVLTreeMap<String,Magazine> tree; // l'arbre binaire de recherche AVL
	
	/**
	 * Constructeur
	 * @pre -
	 * @post retourne un arbre AVL<String,Magazine> vide, construit avec le comparateur
	 * 		de la classe String
	 */
	public AlphaTitleTree() {
		tree = new AVLTreeMap<String,Magazine>(String.CASE_INSENSITIVE_ORDER);
	}
	
	/**** METHODES DE MANIPULATION *****/
	/**
	 * @pre - 
	 * @post retourne le nombre de noeuds de l'arbre
	 */
	public int size() {
		return this.tree.size();
	}
	
	/**
	 * @pre - 
	 * @post retourne true si l'arbre est vide, false sinon
	 */
	public boolean isEmpty() {
		return this.tree.isEmpty();
	}
	
	/**
	 * @pre key est une cle valide (un String qui represente un titre de Magazine)
	 * @post retourne le Magazine associe a la cle, si la cle ne se trouve pas dans
	 * 		 l'arbre, retourne null
	 * @throws InvalidKeyException si la cle key est non valide
	 */
	public Magazine get(String key) throws InvalidKeyException {
		return this.tree.get(key);
	}
	
	/**
	 * @pre l'attribut titre de m est non null
	 * @post ajoute m dans l'arbre et renvoie ce qui se trouvait precedemment a
	 * 		 la cle qui vaut le titre de m. S'il n'y avait pas de noeud avec
	 * 		 cette cle, renvoie null.
	 * @throws InvalidKeyException si la cle (titre de m) est non valide
	 */
	public Magazine put(Magazine m) throws InvalidKeyException {
		String key = m.getTitle();
		return this.tree.put(key, m);
	}
	
	/**
	 * @pre key est une cle valide (un String qui represente un titre de Magazine)
	 * @post retire le Magazine dont le titre est key de l'arbre et renvoie le
	 * 		 Magazine en question. S'il n'y en avait pas, retourne null.
	 * @throws InvalidKeyException si la cle key est non valide
	 */
	public Magazine remove(String key) throws InvalidKeyException {
		return this.tree.remove(key);
	}
	
	/**
	 * @pre - 
	 * @post retourne un iterateur sur les cles (String) de l'arbre
	 */
	public Iterable<String> keySet() {
		return this.tree.keySet();
	}
	
	/**
	 * @pre - 
	 * @post retourne un iterateur sur les valeurs (Magazines) de l'arbre
	 */
	public Iterable<Magazine> values() {
		return this.tree.values();
	}
	
	/**** METHODES DE RECHERCHE *****/
}
