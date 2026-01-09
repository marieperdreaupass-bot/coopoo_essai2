import java.util.Scanner;

public class SystemeCombat {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean competenceUtilisee = false;

    public static void lancerCombat(Personnage personnage, Monstre monstre) {
        competenceUtilisee = false;
        System.out.println(personnage.getNom() + " entre en combat contre " + monstre.getName() + " !");
        monstre.afficherStats();

        boolean tourDuJoueur = personnage.getVitesse() >= monstre.getVitesse();

        while (personnage.getPV() > 0 && monstre.getPv() > 0) {
            System.out.println("--- [" + personnage.getNom() + ": " + personnage.getPV() + " PV] VS [" + monstre.getName() + ": " + monstre.getPv() + " PV] ---");
            if (tourDuJoueur) {
                tourJoueur(personnage, monstre);
            } else {
                tourMonstre(monstre, personnage);
            }
            tourDuJoueur = !tourDuJoueur;
        }
        finaliserCombat(personnage, monstre);
    }

    private static void tourJoueur(Personnage personnage, Monstre monstre) {
        boolean tourFini = false;
        while (!tourFini) {
            System.out.println("C'est votre tour :");
            System.out.println("1. Afficher vos statistiques");
            System.out.println("2. Attaquer (Attaque de base)");
            System.out.println("3. Afficher vos compétences");
            System.out.println("4. Utiliser une compétence");
            System.out.println("5. Afficher votre inventaire");
            System.out.println("6. Utiliser un objet de l'inventaire");
            System.out.print("Action : ");

            int choix = 0;
            if (scanner.hasNextInt()) {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consomme le retour à la ligne
            } else {
                System.out.println("⚠️ Erreur : Veuillez entrer un chiffre (1, 2 ou 3) ! ⚠️");
                scanner.nextLine(); // Vide la mauvaise saisie du tampon
                tourJoueur(personnage, monstre); // Relance le menu
                return;
            }

            switch (choix) {
                case 1:
                    personnage.afficherInfo();
                    break;
                case 2:
                    monstre.recevoirDegats(personnage.attaquer());
                    tourFini = true;
                    break;
                case 3:
                    afficherUniquement(personnage);
                    break;
                case 4:
                    gererCompetence(personnage, monstre);
                    tourFini = true;
                    break;
                case 5:
                    personnage.afficherInventaire();
                    break;
                case 6:
                    if (personnage.getInventaire().isEmpty()) {
                        System.out.println("Votre inventaire est vide !");
                    } else {
                        personnage.afficherInventaire();
                        System.out.print("Numéro de l'objet à utiliser : ");
                        int index = -1;

                        if (scanner.hasNextInt()) {
                            index = scanner.nextInt() - 1;
                            scanner.nextLine(); // Consomme le retour à la ligne
                        } else {
                            System.out.println("⚠️ Erreur : Vous devez entrer un nombre ! ⚠️");
                            scanner.nextLine();
                            tourJoueur(personnage, monstre);
                            return;
                        }
                        if (index >= 0 && index < personnage.getInventaire().size()) {
                            Objet objChoisi = personnage.getInventaire().get(index);
                            String nom = objChoisi.getNom().toLowerCase();

                            // --- VÉRIFICATION POUR L'ARME ---
                            if (nom.contains("hache") || nom.contains("dague") || nom.contains("grimoire")) {
                                System.out.println("ATTENTION : Utiliser l'arme via l'inventaire revient à lancer une attaque de base.");
                                System.out.print("Êtes-vous sûr ? (O/N) : ");
                                String confirmation = scanner.next();
                                if (confirmation.equalsIgnoreCase("O")) {
                                    int degats = personnage.utiliserObjet(index);
                                    monstre.recevoirDegats(degats);
                                    tourFini = true;
                                } else {
                                    System.out.println("Action annulée.");
                                    return;
                                }
                            } else {
                                personnage.utiliserObjet(index);
                                tourFini = true;
                            }
                        } else {
                            System.out.println("Choix invalide.");
                        }
                    }
                    break;
            }
        }
    }

    private static void tourMonstre(Monstre monstre, Personnage personnage) {
        System.out.println("Tour de " + monstre.getName() + " :");
        monstre.attaquer(personnage);
    }

    private static void afficherUniquement(Personnage personnage) {
        if (personnage instanceof Sorcier) {
            ((Sorcier) personnage).afficherGrimoire();
        } else if (personnage instanceof Guerrier) {
            ((Guerrier) personnage).afficherEsprit();
        } else if (personnage instanceof Assassin) {
            ((Assassin) personnage).afficherTechniques();
        }
    }

    private static void gererCompetence(Personnage personnage, Monstre monstre) {
        if (personnage instanceof Sorcier) {
            Sorcier s = (Sorcier) personnage;
            s.afficherGrimoire();
            System.out.print("Choisissez un sort : ");
            int index = scanner.nextInt() - 1;
            Sort sort = s.lancerSort(index);
            if (sort != null)
                if (sort.getDegats() < 0) {
                    int montantSoin = Math.abs(sort.getDegats());
                    personnage.recevoirSoin(montantSoin);
                } else {
                    monstre.recevoirDegats(sort.getDegats());
                }
        } else if (personnage instanceof Guerrier) {
            Guerrier g = (Guerrier) personnage;
            g.afficherEsprit();
            System.out.print("Choisissez une technique : ");
            int index = scanner.nextInt() - 1;
            CompRage comp = g.UtiliserCompetence(index);
            if (comp != null) monstre.recevoirDegats(comp.getDegats());
        } else if (personnage instanceof Assassin) {
            Assassin a = (Assassin) personnage;
            a.afficherTechniques();
            System.out.print("Choisissez une ruse : ");
            int index = scanner.nextInt() - 1;
            Ruse ruse = a.utiliserRuse(index);
            if (ruse != null) monstre.recevoirDegats(ruse.getDegats());
        }
    }

    private static void finaliserCombat(Personnage personnage, Monstre monstre) {
        if (personnage.getPV() > 0) {
            System.out.println("VICTOIRE ! " + monstre.getName() + " a mordu la poussière.");
            personnage.gagnerExperience(monstre.getExpDonnee());
        } else {
            System.out.println("💀 Vous avez succombé face à " + monstre.getName() + "... 💀");
        }
        if (personnage instanceof Sorcier) ((Sorcier) personnage).resetToutesCompetences();
        else if (personnage instanceof Guerrier) ((Guerrier) personnage).resetToutesCompetences();
        else if (personnage instanceof Assassin) ((Assassin) personnage).resetToutesCompetences();
    }
}
