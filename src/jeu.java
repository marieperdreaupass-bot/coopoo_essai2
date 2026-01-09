import java.util.Scanner;

public class jeu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nom = outils.demanderNom();
        Personnage monPersonnage = outils.choisirClasse(nom);
        Quete maQuete = new Quete();
        int nbBossVaincus = 0;

        boolean continuer = true;

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

            int choix = 0;

            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme le retour à la ligne
            } else {
                System.out.println("⚠️ Erreur : Veuillez entrer un chiffre entre 1 et 5 ! ⚠️");
                scanner.nextLine(); // Vide la saisie incorrecte (la lettre)
                continue; // Relance la boucle du menu
            }

            switch (choix) {
                case 1:
                    maQuete.partirEnQuete(monPersonnage);
                    break;

                case 2:
                    boolean correct = false;
                    while (!correct) {
                        System.out.println("⚠️ ATTENTION : Le gardien est très puissant. ⚠️");
                        System.out.println("Vous avez essayé " + maQuete.nbQuete + "/5 quêtes possibles sur ce palier.");

                        if (maQuete.nbQuete < 5) {
                            System.out.println("Il vous reste " + (5 - maQuete.nbQuete) + " questions disponibles pour gagner de l'XP avant le combat.");
                        }

                        System.out.print("Voulez-vous vraiment engager le combat maintenant ? (O/N) : ");
                        String confirmation = scanner.next();

                        if (confirmation.equalsIgnoreCase("O")) {
                            correct = true;
                            Monstre bossActuel = Monstre.genererProchainBoss(nbBossVaincus);
                            SystemeCombat.lancerCombat(monPersonnage, bossActuel);

                            if (!monPersonnage.estMort()) {
                                maQuete.nbQuete = 0;
                                nbBossVaincus++;
                                System.out.println("Victoire éclatante ! Le palier suivant est débloqué.");
                            }
                        } else if (confirmation.equalsIgnoreCase("N")) {
                            System.out.println("Sagesse... Vous retournez vous préparer.");
                            correct = true;
                        } else {
                            System.out.println("Invalide");
                            continue;
                        }
                        break;
                    }
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
            System.out.println("\n💀 Votre légende s'arrête ici... Les Enfers vous attendent. 💀");
        }
        scanner.close();
    }
}