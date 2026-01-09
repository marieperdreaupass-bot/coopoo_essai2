import java.util.Scanner;
import java.text.Normalizer;

public class outils {
    private static Scanner scanner = new Scanner(System.in);

    public static String demanderNom() {
        System.out.println("Le jeu va commencer");
        System.out.println("Pour jouer, il faut choisir un héros parmi Sorcier, Assassin et Guerrier");
        System.out.println("Chacun possède des spécificités");
        System.out.print("Choisissez votre nom : ");
        return scanner.nextLine();
    }

    public static Personnage choisirClasse(String nomJoueur) {
        System.out.println("\n--- Choix de la classe ---");
        System.out.println("1. Guerrier (Robuste)");
        System.out.println("2. Sorcier (Puissant)");
        System.out.println("3. Assassin (Rapide)");

        int choix = 0;
        boolean saisieValide = false;

        while (!saisieValide) {
            System.out.print("Entrez 1, 2 ou 3 : ");

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                if (choix >= 1 && choix <= 3) {
                    saisieValide = true; // On sort de la boucle
                } else {
                    System.out.println("⚠️ Choix invalide ! Veuillez saisir 1, 2 ou 3. ⚠️");
                }
            } else {
                System.out.println("⚠️ Erreur : Vous devez entrer un chiffre. ⚠️");
                scanner.next();
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

    public static String normaliserReponse(String reponse) {
        String sansAccent = Normalizer.normalize(reponse, Normalizer.Form.NFD);
        sansAccent = sansAccent.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return sansAccent.toLowerCase().trim();
    }
}

