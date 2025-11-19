import java.util.ArrayList;

public class quete {
    private String name;
    private String[] choix;
    private int bonneReponse;
    private String description;
    private int niveaurequis;
    private Monstre bossDeLaQuete; // assure que chaque quête est liée à un ennemi spécifique
    // que votre méthode de combat devra utiliser.
    private int experienceGagnee; // Pour la progression du personnage.
    private String objetRecompense; // gérez des items
    private boolean estComplete; // Initialisé à false, il devient true après avoir vaincu
    // le boss et donné la récompense.
}


