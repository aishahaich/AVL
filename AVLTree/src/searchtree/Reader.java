package searchtree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe permettant de lire le fichier d'entree.
 * 
 * @author Groupe 10
 * @version octobre 2013
 */
public class Reader {

	private BufferedReader input;

	/**
	 * Constructeur
	 *  
	 * @pre  -
	 * @post Ouvre un fichier d'entree.
	 * 		 En cas d'erreur lors de l'ouverture du fichier, affiche un message d'erreur.
	 */ 
	public Reader(String inputFile) {
		try {
			input = new BufferedReader(new FileReader(inputFile));
		} catch (IOException e) {
			System.out.print("Error opening the input file\n");
		}
	}

	/**
	 * Methode permettant de lire la premiere ligne du fichier d'entree deja ouvert
	 *  
	 * @pre -
	 * @post Retourne la ligne du fichier qui n'a pas encore ete lue.
	 * 		 Retourne null si la fin du fichier est atteinte.
	 * 		 Retourne null en cas d'erreur.
	 */ 
	public String readNextLine(){
		try {
			return this.input.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Methode permettant de fermer le fichier d'entree.
	 *  
	 * @pre -
	 * @post Le fichier est correctement ferme.
	 * 		 Si une erreur survient, affiche un message d'erreur.
	 */ 
	public void close() {		
		try {
			this.input.close();
		} catch (IOException e) {
			System.out.print("Error closing the input file.\n");
		}	
	}
}