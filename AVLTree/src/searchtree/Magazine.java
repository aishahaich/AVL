package searchtree;

/**
 * Classe representant un magazine.
 * 
 * @author Groupe 10
 * @version octobre 2013
 */
public class Magazine {
	
	private String Rank;
	private String title;
	private String FoR1;
	private String FoR1Name;
	private String FoR2;
	private String FoR2Name;
	private String FoR3;
	private String FoR3Name;
	
	/**
	 * Constructeur
	 * @pre -
	 * @post cree un Magazine dont les 7 attributs sont les 7 arguments, dans l'ordre
	 */
	public Magazine(String rank, String title, String foR1, String foR1Name, String foR2,
					String foR2Name, String foR3, String foR3Name) {
		this.Rank = rank;
		this.title = title;
		this.FoR1 = foR1;
		this.FoR1Name = foR1Name;
		this.FoR2 = foR2;
		this.FoR2Name = foR2Name;
		this.FoR3 = foR3;
		this.FoR3Name = foR3Name;
	}
	
	/**
	 * Constructeur
	 * @pre entries est un tableau de String a exactement 8 entrees
	 * @post cree un Magazine dont les 8 attributs sont les 8 entrees du tableau
	 * 		 si entries ne comporte pas 8 arguments, retourne
	 */
	public Magazine(String[] entries) {
		if (entries.length != 8)
			return;
		
		this.Rank = entries[0];
		this.title = entries[1];
		this.FoR1 = entries[2];
		this.FoR1Name = entries[3];
		this.FoR2 = entries[4];
		this.FoR2Name = entries[5];
		this.FoR3 = entries[6];
		this.FoR3Name = entries[7];
	}

	public String getRank() {
		return this.Rank;
	}

	public void setRank(String rank) {
		this.Rank = rank;
	}
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFoR1() {
		return this.FoR1;
	}

	public void setFoR1(String foR1) {
		this.FoR1 = foR1;
	}

	public String getFoR1Name() {
		return this.FoR1Name;
	}

	public void setFoR1Name(String foR1Name) {
		this.FoR1Name = foR1Name;
	}

	public String getFoR2() {
		return this.FoR2;
	}

	public void setFoR2(String foR2) {
		this.FoR2 = foR2;
	}

	public String getFoR2Name() {
		return this.FoR2Name;
	}

	public void setFoR2Name(String foR2Name) {
		this.FoR2Name = foR2Name;
	}

	public String getFoR3() {
		return this.FoR3;
	}

	public void setFoR3(String foR3) {
		this.FoR3 = foR3;
	}

	public String getFoR3Name() {
		return this.FoR3Name;
	}

	public void setFoR3Name(String foR3Name) {
		this.FoR3Name = foR3Name;
	}
	/**
	 * Renvoie une representation sous forme de String d'un magazine.
	 * @pre -
	 * @post retourne le contenu de tous les attributs du magazine
	 */
	public String toString() {
		
		String retour = new String();
		retour = retour.concat("Title: ").concat(this.getTitle()).concat("\n");
		if (Rank != null)
			retour = retour.concat("Rank: ").concat(this.getRank()).concat("\n");
		if (FoR1 != null)
			retour = retour.concat("FoR1: ").concat(this.getFoR1()).concat("\n");
		if (FoR1Name != null)
			retour = retour.concat("FoR1Name: ").concat(this.getFoR1Name()).concat("\n");
		if (FoR2 != null)
			retour = retour.concat("FoR2: ").concat(this.getFoR2()).concat("\n");
		if (FoR2Name != null)
			retour = retour.concat("FoR2Name: ").concat(this.getFoR2Name()).concat("\n");
		if (FoR3 != null)
			retour = retour.concat("FoR3: ").concat(this.getFoR1()).concat("\n");
		if (FoR3Name != null)
			retour = retour.concat("FoR3Name: ").concat(this.getFoR1Name()).concat("\n");
		
		return retour;
	}
}
