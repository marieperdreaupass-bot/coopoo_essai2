import java.util.Scanner;

public class jeu {
    public void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

/// Démarrage du jeu
        System.out.println("Le jeu commence");
        System.out.print("Choisissez votre nom ");
        String Nom = scanner.next();

        System.out.println(" Choix du perso ");
        System.out.println("1. guerrier ");
        System.out.println("2. sorcier ");
        System.out.print("Choisissez 1 ou 2 : ");
        int choix1 = scanner.nextInt();

        perso monPerso;
        if (choix1 == 1) {
            monPerso = new guerrier(Nom);
            System.out.println("guerrier " + Nom + " crée");
        } else if (choix1 == 2) {
            monPerso = new sorcier(Nom);
            System.out.println("sorcier " + Nom + " crée");
        }
        perso.afficherInfo();

/// Combat 1


/// Quete 1 - augmenter degats vitesse et pv



/// choix quete ou combat

        int manche = 1;
        boolean continuer = true;
        while (continuer) {
            System.out.println("Manche " + manche +" " );
            System.out.println("choix 1: faire une quete ");
            System.out.println("choix 2: combattre le boss ");
            System.out.println("Choisissez 1 ou 2 : ");
            int choix2= scanner.nextInt();
            if (choix2 == 1) {
                new quete();
            }
            else if (choix2 == 2) {
                new boss();
            }

        }



    }}
