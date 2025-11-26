import java.util.ArrayList;
import java.util.*;

public class quete<nbQuete> { /// extend perso  pour avoir la variable  niveau  ici
    ///private String[] names;
    ////private String[] choix;idk si on le garde car complique a coder
    ///private String[] bonneReponse;
   /// private String[] description;
///    private int[] niveaurequis;
///    ///private Monstre bossDeLaQuete; /// assure que chaque quête est liée à un ennemi spécifique
    // que votre méthode de combat devra utiliser.
///    private int[] experienceGagnee; /// Pour la progression du personnage.
    ///private String[] objetRecompense; /// gérez des items
    ///private boolean[] estComplete;
    /// Initialisé à false, il devient true après avoir vaincu
    /// le boss et donné la récompense.
///}
///
private ArrayList<String> description;
private ArrayList<String> bonnneReponse;



public quete(){

    description = new ArrayList<>();
        description.add("question 1 : combien font 2+2?");
        description.add(" question 2 : quelle est la capitale de la france?");
        description.add(" question 3 : tuer c'est mal?");
        description.add(" question 4 : c'est qui le + bô?");




    bonnneReponse = new ArrayList<>();
        bonnneReponse.add("4");
        bonnneReponse.add("Paris");
        bonnneReponse.add("oui");
        bonnneReponse.add("Nayan");

}

    public static int nbQuete ;
    public String getDescription() {
        return description.get( nbQuete);}
    public String getName() {
        return names.get( nbQuete);}
    public String getObjetRecompense() {
        return objetRecompennse.get(nbQuete);}
    public String getBonnneReponse() {
        return bonnneReponse.get(nbQuete);
    }


}



