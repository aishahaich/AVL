package searchtree;

import java.util.ArrayList;

import dsaj.AVLTreeMap;
import dsaj.Entry;
import dsaj.InvalidKeyException;
import dsaj.Position;

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
	
	/**** METHODES DE RECHERCHE ****/
	
	/**
	 * @pre -
	 * @post retourne la liste des magazines dans l'ordre alphabetique
	 * @return un iterateur contenant les magazines de l'arbre dans l'ordre alphabetique
	 */
	public Iterable<Magazine> alphabetOrder() {
		ArrayList<Magazine> mag = new ArrayList<Magazine>();
		alphaOrder(this.tree.root(), mag);
		return mag;
	}
	private void alphaOrder(Position<Entry<String, Magazine>> position, ArrayList<Magazine> mag) {
		// Parcours en ordre infix car la plus petite valeur (premier mot dans l'ordre alphabetique) se trouve tout a gauche
		// dans l'arbre et la valeur plus grande se trouve a droite. 
		if(tree.hasLeft(position)) 
			alphaOrder(tree.left(position), mag);
		mag.add(position.element().getValue());
		if(tree.hasRight(position))
			alphaOrder(tree.right(position), mag);
	}
	
	/**
	 * Renvoie une liste des magazines, par ordre alphabetique, dont le domaine (specifie par domainName) 
	 * est a la valeur domainValue. 
	 * Par exemple, effectuer refineByDomain("rank", "A") renverra la liste des magazines contenu dans tree
	 * dont le rang (rank) est egal a "A", la liste etant dans l'ordre alphabetique.
	 * @pre domainName vaut "rank", "title", "for1", "for1name", "for2", "for2name", "for3" ou "for3name"
	 * @post renvoie la liste dans l'ordre alphabetique des magazine de tree dont le champ (domainName) vaut domainValue
	 */
	public Iterable<Magazine> refineByDomain(String domainName, String domainValue) {
		ArrayList<Magazine> mag = new ArrayList<Magazine>();
		refineByDomain(domainName, domainValue, this.tree.root(), mag);
		return mag;
	}
	// COMPLEXITE :
	// La complexite temporelle est en O(n), n etant le nombre de noeuds dans tree., car doit parcourir un seule fois tous 
	// les noeuds de l'arbre pour comparer leur champ avec une valuer.
	private void refineByDomain(String domainName, String domainValue, Position<Entry<String, Magazine>> position, ArrayList<Magazine> mag) {
		if(tree.hasLeft(position)) // appel recursif gauche en premier pour ordre infix (= alphabetique)
			refineByDomain(domainName, domainValue, tree.left(position), mag); 
		
		Magazine m = position.element().getValue();
		switch(domainName.toLowerCase()) { // Compare le domaine a la valeur; si correspond, on l'ajoute a la liste
		case "rank" : 		if(m.getRank().equals(domainValue)) 	mag.add(m); 	break;
		case "title" : 		if(m.getTitle().equals(domainValue))	mag.add(m);		break;
		case "for1" : 		if(m.getFoR1().equals(domainValue)) 	mag.add(m); 	break;
		case "for1name" : 	if(m.getFoR1Name().equals(domainValue)) mag.add(m); 	break;
		case "for2" : 		if(m.getFoR2().equals(domainValue)) 	mag.add(m); 	break;
		case "for2name" : 	if(m.getFoR2Name().equals(domainValue)) mag.add(m); 	break;
		case "for3" : 		if(m.getFoR3().equals(domainValue)) 	mag.add(m); 	break;
		case "for3name" : 	if(m.getFoR3Name().equals(domainValue)) mag.add(m); 	break;
		}
		
		if(tree.hasRight(position)) // appel recursif droit en dernier pour ordre infix (= alphabetique)
			refineByDomain(domainName, domainValue, tree.right(position), mag);
	}
}
