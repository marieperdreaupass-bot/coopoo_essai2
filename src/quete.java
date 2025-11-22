import java.util.ArrayList;
import java.util.*;

public class quete<manche> extends perso { /// extend perso  pour avoir la variable  niveau  ici
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
private ArrayList<String> names;
private ArrayList<String> objetRecompennse;
private ArrayList<String> bonnneReponse;



public quete(){

    description = new ArrayList<>();
        description.add("donjon numero 1 : combien font 2+2?");
        description.add("quete2");

    names = new ArrayList<>();
        names.add("boss1");
        names.add("boss2");

///ArrayList<int> expGagnee = new ArrayList<>();

    objetRecompennse = new ArrayList<>();
        objetRecompennse.add("objet1");
        objetRecompennse.add("objet2");

    bonnneReponse = new ArrayList<>();
        bonnneReponse.add("4");
        bonnneReponse.add("rep2");
}

    public static int manche ;
    public String getDescription() {
        return description.get( manche);}
    public String getName() {
        return names.get( manche);}
    public String getObjetRecompense() {
        return objetRecompennse.get(manche);}
    public String getBonnneReponse() {
        return bonnneReponse.get(manche);
    }


}



