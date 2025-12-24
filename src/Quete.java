import java.util.ArrayList;

public class Quete {

    private ArrayList<String> description;
    private ArrayList<String> bonneReponse;
    public int nbQuete = 0; // Initialisé à 0 par défaut

    public Quete() {
        description = new ArrayList<>();
        // --- Questions simplifiées ---
        description.add("Question 1 : Qui est le roi des dieux et le dieu de la foudre ?");
        description.add("Question 2 : Qui est le dieu de la mer avec un trident ?");
        description.add("Question 3 : Quelle déesse est la plus belle et représente l'amour ?");
        description.add("Question 4 : Quel monstre a des serpents à la place des cheveux ?");
        description.add("Question 5 : Quel héros est connu pour sa force légendaire ?");

        description.add("Question 6 : Comment s'appelle le cheval ailé qui peut voler ?");
        description.add("Question 7 : Quel dieu voyage très vite grâce à ses sandales ailées ?");
        description.add("Question 8 : Quel monstre est à moitié homme et à moitié taureau ?");
        description.add("Question 9 : Sur quelle montagne vivent les dieux grecs ?");
        description.add("Question 10 : Qui est le dieu des morts et du royaume souterrain ?");

        description.add("Question 11 : Quel monstre est un chien géant à trois têtes ?");
        description.add("Question 12 : Quel géant possède un seul œil au milieu du front ?");
        description.add("Question 13 : Quelle déesse est la protectrice de la sagesse et de la guerre ?");
        description.add("Question 14 : Quel dieu est le maître du soleil et de la musique ?");
        description.add("Question 15 : Quelle créature est à moitié homme et à moitié cheval ?");

        description.add("Question 16 : Qui est la déesse de la chasse, souvent avec un arc ?");
        description.add("Question 17 : Quel roi transformait tout ce qu'il touchait en or ?");
        description.add("Question 18 : Quel dieu est le forgeron des dieux et travaille le feu ?");
        description.add("Question 19 : Quel dieu est le patron de la guerre et des combats ?");
        description.add("Question 20 : Quelle jeune femme a ouvert une boîte contenant tous les malheurs ?");

        description.add("Question 21 : Qui est le dieu du vin et de la fête ?");
        description.add("Question 22 : Quel héros a tué le Minotaure dans le labyrinthe ?");
        description.add("Question 23 : Comment appelle-t-on les créatures qui charment les marins par leur chant ?");
        description.add("Question 24 : Quel petit dieu tire des flèches pour rendre les gens amoureux ?");
        description.add("Question 25 : Qui est la reine des dieux et la femme de Zeus ?");

        bonneReponse = new ArrayList<>();
        // --- Réponses correspondantes ---
        bonneReponse.add("Zeus");
        bonneReponse.add("Poseidon");
        bonneReponse.add("Aphrodite");
        bonneReponse.add("Meduse");
        bonneReponse.add("Hercule");

        bonneReponse.add("Pegase");
        bonneReponse.add("Hermes");
        bonneReponse.add("Minotaure");
        bonneReponse.add("Olympe");
        bonneReponse.add("Hades");

        bonneReponse.add("Cerbere");
        bonneReponse.add("Cyclope");
        bonneReponse.add("Athena");
        bonneReponse.add("Apollon");
        bonneReponse.add("Centaure");

        bonneReponse.add("Artemis");
        bonneReponse.add("Midas");
        bonneReponse.add("Hephaistos");
        bonneReponse.add("Ares");
        bonneReponse.add("Pandore");

        bonneReponse.add("Dionysos");
        bonneReponse.add("Thesee");
        bonneReponse.add("Sirenes");
        bonneReponse.add("Eros");
        bonneReponse.add("Hera");
    }

    public String getDescription() {
        return description.get(nbQuete);
    }

    public String getBonneReponse() {
        return bonneReponse.get(nbQuete);
    }
}
