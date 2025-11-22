import java.util.ArrayList;
import java.util.*;

public class quete extends perso { /// extend perso  pour avoir la variable  niveau  ici
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

    public quete(){

        ArrayList<String> description = new ArrayList<>();
    description.add("quete 1");
    description.add("quete2");

ArrayList<String> names = new ArrayList<>();
    names.add("boss1");
    names.add("boss2");

///ArrayList<int> expGagnee = new ArrayList<>();


ArrayList<String> objetRecompennse = new ArrayList<>();
    objetRecompennse.add("objet1");
    objetRecompennse.add("objet2");

ArrayList<String> bonnneReponse = new ArrayList<>();
    bonnneReponse.add("rep1");
    bonnneReponse.add("rep2");
}
}



