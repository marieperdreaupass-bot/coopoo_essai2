import java.util.Scanner;

public class jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nom = outils.demanderNom();
        Personnage monPersonnage = outils.choisirClasse(nom);
        Quete maQuete = new Quete();

        int nbQuetesFaites = 0;
        boolean continuer = true;

        while (continuer && !monPersonnage.estMort()) {
            System.out.println("Quêtes de suite : " + nbQuetesFaites + "/5");
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Partir en quête (Quiz)");
            System.out.println("2. Combattre le Mini-Boss");
            System.out.println("3. Afficher mes infos");
            System.out.println("4. Quitter le jeu");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();

            if (choix == 1) {
                // ON VERIFIE LA LIMITE ICI
                if (nbQuetesFaites < 5) {
                    int gainExp = outils.gererQuete(maQuete, monPersonnage.experience);
                    monPersonnage.gagnerExperience(gainExp);
                    maQuete.nbQuete++;
                    nbQuetesFaites++;
                } else {
                    System.out.println("(!) Vous êtes fatigué de répondre à des questions.");
                    System.out.println("(!) Vous devez combattre un boss pour vous vider la tête !");
                }
            }
//            else if (choix == 2) {
//                miniboss B1 = new miniboss();
//                outils.gererCombat(monPerso, B1);
//
//                nbQuetesFaites = 0;
//                System.out.println(" vous pouvez de nouveau faire des quêtes.");
//            }
//            else if (choix == 3) {
//                monPerso.afficherInfo();
//            }
//            else {
//                continuer = false;
//            }
        }
    }
}





//import java.util.ArrayList;
//import java.util.Objects;
//import java.util.Scanner;
//import java.util.Random;
//
//public class jeu {
//    Scanner scanner = new Scanner(System.in);
//    public void main (String[] args) {
//
//// Démarrage du jeu
//outils.afficherDebut();
//outils.choixPerso();
//
//perso monPerso = new perso;
//monPerso.afficherInfo();
//monPerso.afficherInventaire();
//
//        ///  si possible, monter de niveau:
//        int EXP = monPerso.experience;
//        monPerso.monterDeNiveau();
//
///// choix quete ou combat
//        quete quete = new quete();
//        quete.nbQuete =  0;
//        boolean continuer = true;
//        int nbQ = 0;
//        int recExp = 20;
//        while (continuer) {
//            System.out.println("Manche " + quete.nbQuete +" " );
//            System.out.println("choix 1: faire une quete ");
//            System.out.println("choix 2: combattre le boss ");
//            System.out.println("Choisissez 1 ou 2 : ");
//            int choix2= scanner.nextInt();
//            if (choix2 == 1) {
//                if (nbQ < 5) {
//                    System.out.println("Répondez à la question");
//                    System.out.println("Description: " + quete.getDescription());
//                    String reponse = scanner.next();
//                    if (Objects.equals(reponse, quete.getBonnneReponse())) {
//                        System.out.println("BonnneReponse ");
//                        System.out.println("Vous recevez " + recExp + "EXP supplémentaires");
//                        EXP = EXP + recExp;
//                    } else {
//                        System.out.println("MauvaiseReponse ");
//                        System.out.println("La bonne rep etait " + quete.getBonnneReponse());
//                        System.out.println("Vous ne recevez rien ");
//                    }
//                    System.out.println("EXP totale"+ EXP);
//                    recExp = (int) (1.25 * recExp);
//                    nbQ ++;
//                    quete.nbQuete ++;
//                }
//                else {System.out.println("Vous ne pouvez plus faire de question pour l'instant, vous devez faire un combat pour continuer ");}
//            }
//            if (choix2 == 2) {
//            nbQ = 0;
//            System.out.println("Le combat commence");
//            miniboss miniboss = new miniboss();
//            int PVPerso = monPerso.PV;
//            int Vperso= monPerso.vitesse;
//            int DegPerso = monPerso.degatsDeBase;
//            System.out.println("pv bboss  " + miniboss.pv);
//            System.out.println("attaqueboss  " + miniboss.attaque);
//            System.out.println("PVperso = "  +  monPerso.PV);
//            System.out.println("Vperso = "  +  monPerso.vitesse);
//            System.out.println("DegPerso = "+  monPerso.degatsDeBase);
//                if (miniboss.pv>0  && PVPerso > 0){
//                    System.out.println("Pour  attaquer tapez 1");
//                    int choix3 = scanner.nextInt();
//                    if (choix3 == 1) {
//                    } else  {
//                        System.out.println("Vous abandonnnez la manche ");
//                        break;
//                    }
//                    if (miniboss.vitesse > Vperso) {
//                        System.out.println("Le  boss attaque");
//                        System.out.println("puis");
//                        miniboss.pv = miniboss.pv -  DegPerso;
//                        System.out.println("Vous attaquez");
//                        PVPerso = PVPerso    -  miniboss.attaque;
//                        System.out.println("PVperso = "  +  PVPerso);
//                        System.out.println("pv boss = "  +  miniboss.pv);
//                     }
//                    else if  (miniboss.vitesse < Vperso) {
//                       PVPerso = PVPerso    -  miniboss.attaque;
//                       System.out.println("Vous attaquez");
//                       System.out.println("puis");
//                       miniboss.pv = miniboss.pv -  DegPerso;
//                       System.out.println("Le  boss attaque");
//                        System.out.println("PVperso = "  +  PVPerso);
//                        System.out.println("pv boss = "  +  miniboss.pv);
//                    }
//                     else if (miniboss.vitesse == Vperso) {
//                           Random random = new Random();
//                          int nbrandom = random.nextInt(2) ;
//                          if(nbrandom == 0){
//                               System.out.println("Pas  de chance, le boss attaque en 1er");
//                              miniboss.pv = miniboss.pv -  DegPerso;
//                              System.out.println("Le  boss attaque");
//                              System.out.println("puis");
//                             PVPerso = PVPerso    -  miniboss.attaque;
//                              System.out.println("Vous attaquez");
//                              System.out.println("PVperso = "  +  PVPerso);
//                              System.out.println("pv boss = "  +  miniboss.pv);
//                          } else {
//                              System.out.println("Vousavez de la chance, vous attaquez en 1er");
//                              PVPerso = PVPerso    -  miniboss.attaque;
//                              System.out.println("Le  boss attaque");
//                              System.out.println("puis");
//                              miniboss.pv = miniboss.pv -  DegPerso;
//                             System.out.println("Vous attaquez");
//                              System.out.println("PVperso = "  +  PVPerso);
//                              System.out.println("pv boss = "  +  miniboss.pv);
//                                 }
//                     }if (miniboss.pv<= 0 && PVPerso >=0 ){ System.out.println("Vous avez gagne");
//                        break;}
//                    else if (miniboss.pv>=0  && PVPerso <= 0){ System.out.println("le boss a gagne");
//                        break;}
//                }
//            }
//
////            System.out.println("voulez vous continuer? reponse true / false");
////            boolean choix3 = scanner.nextBoolean();
////            if (choix3) {
////                continuer = true;
////                quete.nbQuete ++;
////            } else if (!choix3) {
////                continuer = false;
////                System.out.println("vous avez abandonné la partie");
////            }
//}}}
