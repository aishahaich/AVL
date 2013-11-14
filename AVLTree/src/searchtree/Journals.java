package searchtree;
/**
 * Classe contenant un Reader qui permet de lire une entree du fichier correctement,
 * en le decoupant selon les virgules et en tenant compte des guillemets.
 * 
 * @author Groupe 10
 * @version octobre 2013
 */
public class Journals {

	private Reader input; 

	/**
	 * Constructeur
	 * @pre inputFile est un fichier existant qui respecte le format lisible
	 * @post cree un Journal avec inputFile
	 */
	public Journals (String inputFile) {
		input = new Reader(inputFile);
	}

	/**
	 * @pre -
	 * @post retourne le Reader du Journal
	 */
	public Reader getInput() {
		return this.input;
	}

	/**
	 * @pre line est une ligne sous le format text,text,text,text,text,text,text,text
	 * 		ou text,"abc,def,..",text,text,text,text,text,text qui contient 8 entrees
	 * 		separees par des virgules (sauf s'il y a des guillemets)
	 * @post retourne un tableau de Strings a 8 entrees dont chaque case contient un morceau
	 * 		 de la ligne lue delimite par des virgules
	 */
	public String[] parseLine(String line) {

		String[] parseLine = new String[8];
		String value;

		for (int i=0, index=0; i<7; i++) {
			
			// index de la prochaine virgule ou il faut separer
			index = this.getNextComma(line);
			if (index > -1) {
				value  = line.substring(0, index);
				parseLine[i] = (!value.isEmpty()) ? value : null;
				line = line.substring(index+1);
			} else {
				parseLine[i] = null;
			}
		}
		parseLine[7] = (!line.isEmpty()) ? line : null;

		return parseLine;
	}

	/**
	 * @pre - 
	 * @return l'index de la prochaine virgule dans line se trouvant en dehors de guillemets
	 * 		   -1 s'il n'y a plus de virgule ou si les guillemets ne sont pas fermes
	 */
	int getNextComma(String line) {
		
		if (line == null || line.isEmpty())
			return -1;

		int indexQuote = line.indexOf('"', 0);
		int indexComma = line.indexOf(',', 0);

		if (indexComma <= indexQuote)
			return indexComma;
		else {
			// s'il n'y a pas de guillemets, on considere qu'ils sont fermes
			boolean closed = (indexQuote >= 0) ? false : true;

			// il y a un delimiteur " avant la prochaine virgule
			while (indexQuote >= 0 && indexQuote < indexComma) {
				indexQuote = line.indexOf('"', indexQuote+1);
				if (indexQuote >= 0) {
					closed = !closed;
					indexComma = line.indexOf(',', indexQuote);
				}	
			}

			return (closed) ? indexComma : -1;
		}
	}
}
