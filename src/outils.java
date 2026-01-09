import java.util.Scanner;
import java.text.Normalizer;

public class outils {
    private static Scanner scanner = new Scanner(System.in);

    public static String demanderNom() {
        System.out.println("Le jeu va commencer");
        System.out.println("\n--- BIENVENUE DANS L'ODYSSÉE ---");
        System.out.println("“ Dans ce jeu vous êtes un personnage que vous choisissez parmi Guerrier, Sorcier et Assassin.\n" +
                " Ils ont chacun des compétences et des objets différents, utilisables 1 seule fois.\n" +
                " Les compétences sont de différents niveaux, ainsi on vous conseille de garder et utiliser les plus fortes pour la fin.\n" +
                " Ces compétences vous coûtent des ressources (rage, mana ou endurance en fonction du personnage choisi) , qu'il faut dépenser prudemment. \n" +
                "Les objets quant à eux peuvent vous apporter des ressources. Cependant, lorsque vous les utilisez, vous passez votre tour et n’attaquez pas alors veillez à les utiliser au bon moment. \n" +
                "Attention: parfois, vous mettez des dégâts critiques de manière aléatoire, cependant il se peut que le boss final aussi en mette auquel cas vos chances sont minces… ");

        System.out.print("pour commencer, choisissez le nom de votre personnage : ");
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

