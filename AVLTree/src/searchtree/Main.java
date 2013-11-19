package searchtree;

import java.util.Scanner;

/**
 *
 * Classe permettant de placer toutes les revues (du fichier d'entree) avec ses informations correspondantes dans un arbre AVL.
 * La classe permet a l'utilisateur de retrouver les informations correspondantes au titre de la revue recherchee.
 * La classe permet egalement de lister toutes les revues d'un domaine par ordre alphabetique et
 * de lister toutes les revues par rang du classement par ordre alphabetique. -> Resultats ecrits dans des fichiers de sortie
 * 
 * @author Goeric Huybrechts
 * @version novembre 2013
 */
public class Main {
    
    public static void main(String[] args) {
        
        Journals journals = new Journals(args[0]);
        Reader reader = journals.getInput();
        Writer writerFor2 = new Writer("outputJournalsFoR2");
        Writer writerRank = new Writer("outputJournalsRank");

        // Creation arbre AVL
        AlphaTitleTree tree = new AlphaTitleTree();
        
        String line = reader.readNextLine();
        if (line == null)
            System.out.println("Your file does not contain any useful content");
        line = reader.readNextLine();
        if (line == null)
            System.out.println("Your file does not contain any useful content");
        
        // Lecture fichier d'entree afin de placer les revues dans l'arbre
        while (true) {
            String[] parseLine = journals.parseLine(line);
            
            Magazine magazine = new Magazine(parseLine);
            
            tree.put(magazine);
            
            line = reader.readNextLine();
            
            if (line == null)
                break;
            while (line.equals("")) {
                line = reader.readNextLine();
                if (line == null)
                    break;
            }
        }
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter title magazine you wish to find");
        System.out.println("Enter q to stop");
        
        // Outil permettant a l'utilisateur de retrouver les informations correspondantes au titre recherche
        String title;
        title = in.nextLine();
        while (!title.equals("q")) {
            Magazine magazine = (Magazine) tree.get(((String) title).toLowerCase());
            if (magazine == null) {
                System.out.println("Your magazine hasn't been found");
            } else {
                System.out.println(magazine.toString());
            }
            title = in.nextLine();
        }
        
        /*
        
        Francois, lorsque Guillaume a mis ses fonctions de recherche, tu devras adapter le code-ci dessous par rapport a son code.
        Il ne te reste donc plus grand chose a faire...
        Le reste fonctionne.
        
        */
        
        // Fonction permettant de lister toutes les revues selon le domaine FoR2 Name par ordre alphabetique
        
        /*
        AlphaTitleTree treeFoR2 = tree.orderFoR2();
        String treeFoR2S = treeFor2.getString();
        
        writerFor2.write(treeFoR2S);
        */
        
        
        // Fontion permettant de lister toutes ls revues par rang du classement par ordre alphabetique
        
        /*
        AlphaTitleTree treeRank = tree.orderRank();
        String treeRankS = treeRank.getString();

        writerRank.write(treeFoR2S);
        */
        
           
        in.close();
        writerFor2.close();
        writerRank.close();
        reader.close();
    }
}
