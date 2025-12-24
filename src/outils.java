import java.util.Scanner;
import java.util.Random;
import java.util.Objects;

public class outils {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    // Affiche l'intro et récupère le nom
    public static String demanderNom() {
        System.out.println("=== BIENVENUE DANS LE JEU ===");
        System.out.println("Pour jouer, il faut choisir un héros parmi Sorcier, Assassin et Guerrier.");
        System.out.println("Chacun possède ses propres capacités.");
        System.out.print("Choisissez votre nom : ");
        return scanner.nextLine();
    }

    // Gère le choix de la classe et RENVOIE le personnage créé
    public static perso choisirClasse(String nomJoueur) {
        System.out.println("\n--- Choix de la classe ---");
        System.out.println("1. Guerrier (Robuste)");
        System.out.println("2. Sorcier (Puissant mais fragile)");
        System.out.println("3. Assassin (Rapide et précis)");

        int choix = 0;
        while (choix < 1 || choix > 3) {
            System.out.print("Entrez 1, 2 ou 3 : ");
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
            } else {
                scanner.next(); // Vide la mauvaise saisie
            }
        }

        switch (choix) {
            case 1:
                System.out.println("Guerrier " + nomJoueur + " créé !");
                return new guerrier(nomJoueur);
            case 2:
                System.out.println("Sorcier " + nomJoueur + " créé !");
                return new sorcier(nomJoueur);
            case 3:
                System.out.println("Assassin " + nomJoueur + " créé !");
                return new assassin(nomJoueur);
            default:
                return new guerrier(nomJoueur);
        }
    }

    // Allège le compilateur "jeu" en gérant la quête ici
    public static int gererQuete(quete q, int expActuelle) {
        System.out.println("\n--- QUÊTE ---");
        System.out.println("Question : " + q.getDescription());
        System.out.print("Votre réponse : ");
        String reponse = scanner.next();

        if (reponse.equalsIgnoreCase(q.getBonnneReponse())) {
            System.out.println("Bonne réponse ! +50 EXP");
            return 50;
        } else {
            System.out.println("Mauvaise réponse... La réponse était : " + q.getBonnneReponse());
            return 0;
        }
    }

    // Allège le compilateur "jeu" en gérant le combat ici
    public static void gererCombat(perso p, miniboss b) {
        System.out.println("\n=== COMBAT CONTRE " + b.name.toUpperCase() + " ===");

        while (p.PV > 0 && b.pv > 0) {
            System.out.println("\n[ " + p.getNom() + " : " + p.PV + " PV ] vs [ " + b.name + " : " + b.pv + " PV ]");
            System.out.println("1. Attaquer | 2. Abandonner");
            int action = scanner.nextInt();

            if (action != 1) {
                System.out.println("Vous fuyez le combat...");
                break;
            }

            // Détermination de l'ordre d'attaque par la vitesse
            if (p.vitesse >= b.vitesse) {
                joueurAttaque(p, b);
                if (b.pv > 0) bossAttaque(b, p);
            } else {
                bossAttaque(b, p);
                if (p.PV > 0) joueurAttaque(p, b);
            }
        }

        if (p.PV > 0 && b.pv <= 0) {
            System.out.println("Félicitations ! Le boss est vaincu !");
            p.gagnerExperience(150);
        } else if (p.PV <= 0) {
            System.out.println("Vous avez été terrassé...");
        }
    }

    private static void joueurAttaque(perso p, miniboss b) {
        int degats = p.attaquer();
        b.pv -= degats;
        System.out.println("Vous infligez " + degats + " dégâts.");
    }

    private static void bossAttaque(miniboss b, perso p) {
        System.out.println(b.name + " réplique !");
        p.PV -= b.attaque;
        System.out.println("Il vous inflige " + b.attaque + " dégâts.");
    }
}