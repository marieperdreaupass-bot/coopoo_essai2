import java.util.ArrayList;
import java.util.Scanner;

public class Quete {

    private static Scanner scanner = new Scanner(System.in);
    private ArrayList<String> description;
    private ArrayList<String> bonneReponse;
    public int nbQuete = 0;// Initialisé à 0 par défaut
    public int nbQueteTotal = 0;

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


    public void partirEnQuete(Personnage personnage) {
        boolean veutContinuer = true;

        // On vérifie si le palier est déjà fini avant de commencer
        if (nbQuete >= 5) {
            System.out.println("(!) Vous avez déjà fait vos 5 quêtes. Battez le boss !");
            return;
        }

        while (veutContinuer && nbQuete < 5) {
            if (description.isEmpty()) {
                System.out.println("Plus de questions disponibles !");
                return;
            }

            int gainExp = gererQuete();

            // On augmente le compteur de quêtes posées QUOI QU'IL ARRIVE
            nbQuete++;
            nbQueteTotal++;

            if (gainExp > 0) {
                personnage.gagnerExperience(gainExp);
            }

            // On vérifie s'il reste des chances dans le palier
            if (nbQuete < 5) {
                String choix = "";
                // BOUCLE DE VÉRIFICATION O/N
                while (!choix.equalsIgnoreCase("O") && !choix.equalsIgnoreCase("N")) {
                    System.out.print("\nVoulez-vous répondre à une autre question ? (O/N) : ");
                    choix = scanner.next();

                    if (!choix.equalsIgnoreCase("O") && !choix.equalsIgnoreCase("N")) {
                        System.out.println("⚠️ Réponse invalide. Veuillez taper 'O' pour Oui ou 'N' pour Non.");
                    }
                }

                if (choix.equalsIgnoreCase("N")) {
                    veutContinuer = false;
                    System.out.println("Retour au menu principal...");
                } else if (choix.equalsIgnoreCase("O")) {
                    // On ne fait rien, la boucle de vérification s'arrête et le 'while' principal continue
                } else {
                    System.out.println("⚠️ Choix invalide. Merci de taper 'O' pour Oui ou 'N' pour Non.");
                }
            } else {
                System.out.println("\n✅ 5 questions posées ! Palier terminé. Allez affronter le boss.");
            }
        }
    }

    public int gererQuete() {
        System.out.println("\n--- QUÊTE ---");

        // On prend toujours le premier élément (0)
        String questionActuelle = description.get(0);
        String laBonneReponse = bonneReponse.get(0);

        System.out.println(questionActuelle);
        System.out.print("Votre réponse : ");
        String reponseJoueur = scanner.next();

        // Normalisation
        String repJ = outils.normaliserReponse(reponseJoueur);
        String repC = outils.normaliserReponse(laBonneReponse);

        // SUPPRESSION : On retire la question et sa réponse pour ne plus tomber dessus
        description.remove(0);
        bonneReponse.remove(0);

        if (repJ.equals(repC)) {
            System.out.println("✨ Bonne réponse ! +30 EXP");
            return 30;
        } else {
            System.out.println("❌ Mauvaise réponse... La réponse était : " + laBonneReponse);
            return 0;
        }
    }

}
