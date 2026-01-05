import java.util.Scanner;
import java.util.Random;
import java.text.Normalizer;

public class outils {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

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
        System.out.println("--- Choix de la classe ---");
        System.out.println("1. Guerrier (Robuste)");
        System.out.println("2. Sorcier (Puissant)");
        System.out.println("3. Assassin (Rapide)");

        int choix = 0;
        while (choix < 1 || choix > 3) {
            System.out.print("Entrez 1, 2 ou 3 : ");
            choix = scanner.nextInt();
        }

        if (choix == 1){
                System.out.println("Guerrier " + nomJoueur + " créé !");
                return new Guerrier(nomJoueur);}
        if (choix == 2){
                System.out.println("Sorcier " + nomJoueur + " créé !");
                return new Sorcier(nomJoueur);}
        if (choix == 1){
                System.out.println("Assassin " + nomJoueur + " créé !");
                return new Assassin(nomJoueur);}
        return null;
    }

    // Méthode pour normaliser une chaîne (enlever accents, mettre en minuscule)
    private static String normaliserReponse(String reponse) {
        // 1. Enlever les accents
        String sansAccent = Normalizer.normalize(reponse, Normalizer.Form.NFD);
        sansAccent = sansAccent.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        // 2. Mettre en minuscule
        return sansAccent.toLowerCase().trim();
    }

    public static int gererQuete(Quete q, int expActuelle) {
        System.out.println("\n--- QUÊTE ---");
        System.out.println("Question : " + q.getDescription());
        System.out.print("Votre réponse : ");
        String reponse = scanner.next();

        // Normaliser la réponse du joueur
        String reponseNormalisee = normaliserReponse(reponse);

        // Normaliser la bonne réponse aussi
        String bonneReponseNormalisee = normaliserReponse(q.getBonneReponse());

        // Comparer les réponses normalisées
        if (reponseNormalisee.equals(bonneReponseNormalisee)) {
            System.out.println("Bonne réponse ! +50 EXP");
            return 50;
        } else {
            System.out.println("Mauvaise réponse... La réponse était : " + q.getBonneReponse());
            return 0;
        }}

        public static void gererCombat(Personnage p, Monstre m) {
            System.out.println("⚔️ LE COMBAT COMMENCE CONTRE : " + m.getName().toUpperCase());

            Scanner sc = new Scanner(System.in);

            while (p.PV > 0 && m.getPv() > 0) {
                System.out.println( p.getNom() + " (" + p.PV + " PV) | " + m.getName() + " (" + m.getPv() + " PV)");
                System.out.println("Appuyez sur Entrée pour attaquer !");
                sc.nextLine();

                // 1. Le joueur attaque
                int degatsJoueur = p.attaquer();
                m.pv -= degatsJoueur;
                System.out.println("Vous infligez " + degatsJoueur + " dégâts.");

                if (m.getPv() <= 0) break; // Si le monstre meurt, on s'arrête

                // 2. Le monstre attaque
                m.attaquer(p);
            }

            if (p.PV > 0) {
                System.out.println("\n✨ VICTOIRE !");
                // C'est ici qu'on utilise l'expDonnee enregistrée dans le monstre !
                int xpGagnee = m.getExpDonnee();
                System.out.println("Vous gagnez " + xpGagnee + " EXP.");
                p.gagnerExperience(xpGagnee);
            } else {
                System.out.println("\n💀 Vous avez été vaincu...");
            }}}



    private static void joueurAttaque(Personnage p, Monstre b) {
        int degats = p.attaquer();
        b.pv -= degats;
        System.out.println("Vous infligez " + degats + " dégâts.");
    }

    private static void bossAttaque(Monstre b, Personnage p) {
        System.out.println(b.name + " réplique !");
        p.PV -= b.attaque;
        System.out.println("Il vous inflige " + b.attaque + " dégâts.");
    }
