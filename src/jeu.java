import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;

public class jeu {


    public static String nom;

    public void main (String[] args) {

        Scanner scanner = new Scanner(System.in);

// Démarrage du jeu
        System.out.println("Le jeu commence");
        System.out.print("Choisissez votre nom ");
        
        String nom = scanner.next();;


/// choix quete ou combat
        quete quete = new quete();

        quete.nbQuete =  0;
        boolean continuer = true;
        while (continuer) {
            System.out.println("Manche " + quete.nbQuete +" " );
            System.out.println("choix 1: faire une quete ");
            System.out.println("choix 2: combattre le boss ");
            System.out.println("Choisissez 1 ou 2 : ");



            System.out.println(" Choix du perso ");
            System.out.println("1. guerrier ");
            System.out.println("2. sorcier ");
            System.out.println("3. assassin ");
            System.out.print("Choisissez 1 2 ou 3 : ");
            int choix1 = scanner.nextInt();

            perso  monPerso = null;
            if (choix1 == 1) {
                System.out.println("guerrier " + nom + " crée");
                monPerso = new guerrier(nom);
            } else if (choix1 == 2) {
                System.out.println("sorcier " + nom + " crée");
                monPerso= new sorcier(nom);
            }else if (choix1 == 3) {
                System.out.println("assassin  "+ nom + " crée");
                monPerso = new assassin(nom);
            }
            ///perso.afficherInfo();


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
            System.out.println("Le combat commence");

            int PVboss =  boss.pv;
            int PVPerso = monPerso.PV;
            System.out.println("PVperso = "  +  monPerso.PV);

//            ///
//
//                while(boss.pv>=0  || perso.PV > 0);
//            if (boss.vitesse < perso.vitesse) {
//                boss.pv = boss.pv -  perso.degatsDeBase;
//                perso.PV = perso.PV    -  boss.attaque;
//            }
//            else if  (boss.vitesse > perso.vitesse) {
//
//                perso.PV = perso.PV    -  boss.attaque;
//                boss.pv = boss.pv -  perso.degatsDeBase;
//
//            }
//            else if (boss.vitesse == perso.vitesse) {
//
//                Random random = new Random();
//                int nbrandom = random.nextInt(2) ;
//
//                if(nbrandom == 0){
//                    System.out.println("Pasde chance, le boss attaque en 1er");
//                    boss.pv = boss.pv -  perso.degatsDeBase;
//                    perso.PV = perso.PV    -  boss.attaque;
//                } else {
//                    System.out.println("Vousavez de la chance, vous attaquez en 1er");
//                    perso.PV = perso.PV    -  boss.attaque;
//                    boss.pv = boss.pv -  perso.degatsDeBase;
//                }
//            }
//            }
//
//            System.out.println("voulez vous continuer? reponse true / false");
//            boolean choix3 = scanner.nextBoolean();
//            if (choix3) {
//                continuer = true;
//                quete.nbQuete ++;
//            } else if (!choix3) {
//                continuer = false;
//            }
//
}}}}
