import java.util.Scanner;
import java.util.Random;
import java.text.Normalizer;

public class outils {
    private static Scanner scanner = new Scanner(System.in);

    // Affiche l'intro et récupère le nom
    public static String demanderNom() {
        System.out.println("Le jeu va commencer");
        System.out.println("Pour jouer, il faut choisir un héros parmi Sorcier, Assassin et Guerrier");
        System.out.println("Chacun possède des spécificités");
        System.out.print("Choisissez votre nom : ");
        return scanner.nextLine();
    }

    // Gère le choix de la classe et RENVOIE le personnage créé
    public static Personnage choisirClasse(String nomJoueur) {
        System.out.println("\n--- Choix de la classe ---");
        System.out.println("1. Guerrier (Robuste)");
        System.out.println("2. Sorcier (Puissant)");
        System.out.println("3. Assassin (Rapide)");

        int choix = 0;
        boolean saisieValide = false;

        // Boucle tant que le choix n'est pas 1, 2 ou 3
        while (!saisieValide) {
            System.out.print("Entrez 1, 2 ou 3 : ");

            // Vérification si l'entrée est bien un nombre
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();

                if (choix >= 1 && choix <= 3) {
                    saisieValide = true; // On sort de la boucle
                } else {
                    System.out.println("⚠️ Choix invalide ! Veuillez saisir 1, 2 ou 3.");
                }
            } else {
                // Si l'utilisateur a tapé une lettre ou un symbole
                System.out.println("⚠️ Erreur : Vous devez entrer un chiffre.");
                scanner.next(); // "Consomme" la mauvaise saisie pour éviter une boucle infinie
            }
        }

        if (choix == 1) {
            System.out.println("Guerrier " + nomJoueur + " créé !");
            return new Guerrier(nomJoueur);
        } else if (choix == 2) {
            System.out.println("Sorcier " + nomJoueur + " créé !");
            return new Sorcier(nomJoueur);
        } else if (choix == 3) {
            System.out.println("Assassin " + nomJoueur + " créé !");
            return new Assassin(nomJoueur);
        }
        return null;
    }

    // Méthode pour normaliser une chaîne (enlever accents, mettre en minuscule)
    public static String normaliserReponse(String reponse) {
        // 1. Enlever les accents
        String sansAccent = Normalizer.normalize(reponse, Normalizer.Form.NFD);
        sansAccent = sansAccent.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        // 2. Mettre en minuscule
        return sansAccent.toLowerCase().trim();
    }
}

