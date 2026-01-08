import java.util.Scanner;

public class jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialisation
        String nom = outils.demanderNom();
        Personnage monPersonnage = outils.choisirClasse(nom);
        Quete maQuete = new Quete();
        int nbBossVaincus = 0;

        boolean continuer = true;
        System.out.println("\n--- BIENVENUE DANS L'ODYSSÉE ---");

        while (continuer && !monPersonnage.estMort()) {
            System.out.println("\n------------------------------------");
            System.out.println("Statut : " + monPersonnage.getNom() + " | Niveau : " + monPersonnage.getNiveau());
            System.out.println("Progression Quêtes : " + maQuete.nbQuete + "/5");
            System.out.println("------------------------------------");
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Partir en quête (Quiz)");
            System.out.println("2. Combattre le Mini-Boss");
            System.out.println("3. Afficher mes statistiques");
            System.out.println("4. Afficher mon inventaire");
            System.out.println("5. Quitter le jeu");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    maQuete.partirEnQuete(monPersonnage);
                    break;

                case 2:
                    // 1. Message d'avertissement et rappel de la règle des 5 questions
                    System.out.println("\n⚠️ ATTENTION : Le gardien est très puissant.");
                    System.out.println("Vous avez validé " + maQuete.nbQuete + "/5 quêtes sur ce palier.");

                    if (maQuete.nbQuete < 5) {
                        System.out.println("Il vous reste " + (5 - maQuete.nbQuete) + " questions disponibles pour gagner de l'XP avant le combat.");
                    }

                    System.out.print("Voulez-vous vraiment engager le combat maintenant ? (O/N) : ");
                    String confirmation = scanner.next();

                    if (confirmation.equalsIgnoreCase("O")) {
                        // 2. Génération et combat
                        Monstre bossActuel = Monstre.genererProchainBoss(nbBossVaincus);
                        SystemeCombat.lancerCombat(monPersonnage, bossActuel);

                        // 3. Si victoire
                        if (!monPersonnage.estMort()) {
                            // On reset le compteur de quêtes car on passe au palier suivant
                            maQuete.nbQuete = 0;
                            nbBossVaincus++;
                            System.out.println("\n✨ Victoire éclatante ! Le palier suivant est débloqué.");
                        }
                    } else {
                        System.out.println("Sagesse... Vous retournez vous préparer.");
                    }
                    break;

                case 3:
                    monPersonnage.afficherInfo();
                    break;

                case 4:
                    monPersonnage.afficherInventaire();
                    break;

                case 5:
                    continuer = false;
                    System.out.println("Fin de l'aventure. À bientôt, héros !");
                    break;

                default:
                    System.out.println("Choix invalide.");
                    break;

            }
        }

        if (monPersonnage.estMort()) {
            System.out.println("\n💀 Votre légende s'arrête ici... Les Enfers vous attendent.");
        }

        scanner.close();
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
