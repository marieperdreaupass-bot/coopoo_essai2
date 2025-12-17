import java.util.Scanner;

public class outils  {
    static String nom;


    public static void afficherDebut(){
        String[] intro = {
            "Pour jouer, il faut choisir 1 perso parmis sorcier assassin et guerrier. ",
            "Ils ont tous des caracteristiques différentes (a completer)",
            "Le jeu commence",
            "Choisissez votre nom ",

        };
        Scanner scanner = new Scanner(System.in);
        nom = scanner.next();
        for (String ligne : intro) {
        System.out.println(ligne);}
    }

    public static void choixPerso(){
        String[] demarrage = {
                " Choix du perso ",
                "1. guerrier ",
                "2. sorcier ",
                "3. assassin ",
                "Choisissez 1 2 ou 3 : "};
        for (String ligne : demarrage) {
            System.out.println(ligne);}
        Scanner scanner = new Scanner(System.in);
        int choix1 = scanner.nextInt();
        perso monPerso = null;
        while(choix1 < 1 || choix1 >3) { ///  methode pr le choix
            if (choix1 == 1) {
                System.out.println("guerrier " + nom + " crée");
                monPerso = new guerrier(nom);
            } else if (choix1 == 2) {
                System.out.println("sorcier " + nom + " crée");
                monPerso = new sorcier(nom);
            } else if (choix1 == 3) {
                System.out.println("assassin  " + nom + " crée");
                monPerso = new assassin(nom);
            } else {System.out.println("choix invalide");}

        }
    }







}
