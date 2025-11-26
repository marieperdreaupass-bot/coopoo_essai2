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

            int choix2= scanner.nextInt();
            if (choix2 == 1) {
                int recompense =5;
                System.out.println("Répondez à la question");
                System.out.println("Description: " + quete.getDescription());
                String reponse = scanner.next();
                if(Objects.equals(reponse, quete.getBonnneReponse())){
                    System.out.println("BonnneReponse ");
                    System.out.println("Vous recevez " + recompense);}
                else {
                    System.out.println("MauvaiseReponse ");
                    System.out.println("La bonne rep etait " + quete.getBonnneReponse());
                    System.out.println("Vous ne recevez rien ");
                }

            }
            else if (choix2 == 2) {
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

            System.out.println("Le combat commence");
            boss boss = new boss();
            int PVPerso = monPerso.PV;
            int Vperso= monPerso.vitesse;
            int DegPerso = monPerso.degatsDeBase;
            System.out.println("pv bboss  " + boss.pv);
            System.out.println("attaqueboss  " + boss.attaque);
            System.out.println("PVperso = "  +  monPerso.PV);
            System.out.println("Vperso = "  +  monPerso.vitesse);
            System.out.println("DegPerso = "+  monPerso.degatsDeBase);

                if (boss.pv>0  && PVPerso > 0){
                    System.out.println("Pour  attaquer tapez 1");
                    int choix3 = scanner.nextInt();
                    if (choix3 == 1) {
                    } else  {
                        System.out.println("Vous abandonnnez la manche ");
                        break;
                    }

                    if (boss.vitesse > Vperso) {
                        System.out.println("Le  boss attaque");
                        System.out.println("puis");
                      boss.pv = boss.pv -  DegPerso;
                        System.out.println("Vous attaquez");
                        PVPerso = PVPerso    -  boss.attaque;
                        System.out.println("PVperso = "  +  PVPerso);
                        System.out.println("pv boss = "  +  boss.pv);
                     }
                    else if  (boss.vitesse < Vperso) {
                       PVPerso = PVPerso    -  boss.attaque;
                       System.out.println("Vous attaquez");
                        System.out.println("puis");
                       boss.pv = boss.pv -  DegPerso;
                       System.out.println("Le  boss attaque");
                        System.out.println("PVperso = "  +  PVPerso);
                        System.out.println("pv boss = "  +  boss.pv);

                    }
                     else if (boss.vitesse == Vperso) {

                           Random random = new Random();
                          int nbrandom = random.nextInt(2) ;

                          if(nbrandom == 0){
                               System.out.println("Pas  de chance, le boss attaque en 1er");
                             boss.pv = boss.pv -  DegPerso;
                              System.out.println("Le  boss attaque");
                              System.out.println("puis");
                             PVPerso = PVPerso    -  boss.attaque;
                              System.out.println("Vous attaquez");
                              System.out.println("PVperso = "  +  PVPerso);
                              System.out.println("pv boss = "  +  boss.pv);
                          } else {
                              System.out.println("Vousavez de la chance, vous attaquez en 1er");
                              PVPerso = PVPerso    -  boss.attaque;
                              System.out.println("Le  boss attaque");
                              System.out.println("puis");
                              boss.pv = boss.pv -  DegPerso;
                             System.out.println("Vous attaquez");
                              System.out.println("PVperso = "  +  PVPerso);
                              System.out.println("pv boss = "  +  boss.pv);
                                 }
                     }if (boss.pv<= 0 && PVPerso >=0 ){ System.out.println("Vous avez gagne");
                        break;}
                    else if (boss.pv>=0  && PVPerso <= 0){ System.out.println("le boss a gagne");
                        break;}
                }
            }

            System.out.println("voulez vous continuer? reponse true / false");
            boolean choix3 = scanner.nextBoolean();
            if (choix3) {
                continuer = true;
                quete.nbQuete ++;
            } else if (!choix3) {
                continuer = false;
            }

            /// /10  pv pr  la 1e quete / 20 pv pr la 2e quete
        /// 5poit attaque1equete/  10 2eme quete
        ///  nepeut chat : seulement 5questions puius doit faireun miniboss ou unn boss
}}}
