import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class jeu {


    public static String nom;

    public void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

// Démarrage du jeu
        System.out.println("Le jeu commence");
        System.out.print("Choisissez votre nom ");
        
        String nom = scanner.next();;

        System.out.println(" Choix du perso ");
        System.out.println("1. guerrier ");
        System.out.println("2. sorcier ");
        System.out.println("3. assassin ");
        System.out.print("Choisissez 1 2 ou 3 : ");
        int choix1 = scanner.nextInt();


        perso monPerso;
        if (choix1 == 1) {
            monPerso = new guerrier(nom);
            System.out.println("guerrier " + nom + " crée");
        } else if (choix1 == 2) {
            monPerso = new sorcier(nom);
            System.out.println("sorcier " + nom + " crée");
        }else if (choix1 == 3) {
            System.out.println("assassin  "+ nom + " crée");
        }
        ///perso.afficherInfo();
        


/// choix quete ou combat
        quete quete = new quete();

        quete.manche =  0;
        boolean continuer = true;
        while (continuer) {
            System.out.println("Manche " + quete.manche +" " );
            System.out.println("choix 1: faire une quete ");
            System.out.println("choix 2: combattre le boss ");
            System.out.println("Choisissez 1 ou 2 : ");

            int choix2= scanner.nextInt();

            if (choix2 == 1) {

                System.out.println("Répondez à la question");
                System.out.println("Description: " + quete.getDescription());
                String reponse = scanner.next();
                if(Objects.equals(reponse, quete.getBonnneReponse())){
                    System.out.println("BonnneReponse ");
                    System.out.println("Vous recevez " + quete.getObjetRecompense());}
                else {
                    System.out.println("MauvaiseReponse ");
                    System.out.println("La bonne rep etait " + quete.getBonnneReponse());
                    System.out.println("Vous ne recevez rien ");
                }


            }
            else if (choix2 == 2) {
                /// a completer
            System.out.println("Le combat commence");
            while(boss.PV>=0  or perso.PV )
            if (boss.vitesse < perso.vitesse) {

            }
            else if  (boss.vitesse > perso.vitesse) {

            }
            else if (boss.vitesse == perso.vitesse) {

            }
            }

            System.out.println("voulez vous continuer? reponse true / false");
            boolean choix3 = scanner.nextBoolean();
            if (choix3) {
                continuer = true;
                quete.manche ++;
            } else if (!choix3) {
                continuer = false;
            }

        }



    }}
