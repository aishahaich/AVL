package searchtree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe permettant d'ecrire dans un fichier de sortie
 * 
 * @author Group 10 : Goeric Huybrechts
 * @version October 2013
 */
public class Writer {
	
	private BufferedWriter output;
	
	/**
	   * Constructeur
	   *  
	   * @pre  -
	   * @post Ouvre un fichier de sortie ou le cree s'il n'existe pas encore
	   * @exception IOException si erreur lors de l'ouverture du fichier
	   * 
	   */ 
	public Writer(String outputFile) {
		try {
			output = new BufferedWriter(new FileWriter (new File(outputFile)));
		} catch (IOException e) {
			System.out.print("Error opening outputfile\n");
		}
	}
	
	/**
	   * Methode permettant d'ecrire dans le fichier de sortie deja ouvert
	   *  
	   * @pre  Le fichier de sortie "output" doit deja avoir ete ouvert prealablement
	   * @post Ecrit dans un fichier de sortie
	   * @exception IOException si erreur lors de l'ecriture dans le fichier
	   * 
	   */ 
	public void write(String message) {		
		try {
			output.write(message);
		} catch (IOException e) {
			System.out.print("Error writing in outputfile\n");
		}	
	}
	
	/**
	   * Methode permettant de fermer le fichier de sortie
	   *  
	   * @pre  Le fichier de sortie "output" doit deja avoir ete ouvert prealablement
	   * @post Ferme le fichier de sortie
	   * @exception IOException si erreur lors de la fermeture du fichier
	   * 
	   */ 
	public void close() {		
		try {
			output.close();
		} catch (IOException e) {
			System.out.print("Error closing outputfile\n");
		}	
	}
}