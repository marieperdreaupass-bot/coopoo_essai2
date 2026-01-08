import java.util.Scanner;
import java.util.List;

public class SystemeCombat {
    private static Scanner scanner = new Scanner(System.in);

    // 1. La méthode principale
    public static void lancerCombat(Personnage personnage, Monstre monstre) {
        System.out.println("\n⚔️ " + personnage.getNom() + " entre en combat contre " + monstre.getName() + " !");

        // On détermine qui commence selon la vitesse
        boolean tourDuJoueur = personnage.getVitesse() >= monstre.getVitesse();

        while (personnage.getPV() > 0 && monstre.getPv() > 0) {
            System.out.println("\n--- [" + personnage.getNom() + ": " + personnage.getPV() + " PV] VS [" + monstre.getName() + ": " + monstre.getPv() + " PV] ---");

            if (tourDuJoueur) {
                tourJoueur(personnage, monstre);
            } else {
                tourMonstre(monstre, personnage);
            }

            // On alterne le tour
            tourDuJoueur = !tourDuJoueur;
        }

        finaliserCombat(personnage, monstre);
    }

    // 2. Le tour du joueur avec ses 3 choix
    private static void tourJoueur(Personnage personnage, Monstre monstre) {
        System.out.println("\nC'est votre tour :");
        System.out.println("1. Attaquer (Attaque de base)");
        System.out.println("2. Utiliser une compétence");
        System.out.println("3. Utiliser un objet de l'inventaire");
        System.out.print("Action : ");

        int choix = scanner.nextInt();

        switch (choix) {
            case 1:
                int degats = personnage.attaquer();
                monstre.recevoirDegats(degats);
                break;
            case 2:
                gererCompetence(personnage, monstre);
                break;
            case 3:
               //Faire une méthode utiliserObjet(inspi Personnage) et ajouter ce code
                List<Objet> sac = personnage.getInventaire();
                if (sac.isEmpty()) {
                    System.out.println("Votre sac est vide !");
                } else {
                    personnage.afficherInventaire();
                    System.out.print("Quel numéro d'objet utiliser ? ");
                    int index = scanner.nextInt() - 1;

                    if (index >= 0 && index < sac.size()) {
                        Objet obj = sac.get(index);
                        // Appliquer l'effet (soin)
                        // on recoit pas forcément du soin : personnage.recevoirSoin(obj.getEffet());
                        System.out.println("Vous utilisez " + obj.getNom() + " !");
                        // Retirer l'objet après usage
                        sac.remove(index);
                    } else {
                        System.out.println("Numéro invalide.");
                    }
                }
                break;
        }
    }

    // 3. Le tour du monstre
    private static void tourMonstre(Monstre monstre, Personnage personnage) {
        System.out.println("\nTour de " + monstre.getName() + " :");
        monstre.attaquer(personnage);
    }

    // 4. Gestion dynamique des compétences selon la classe
    private static void gererCompetence(Personnage personnage, Monstre monstre) {
        if (personnage instanceof Sorcier) {
            Sorcier s = (Sorcier) personnage;
            s.afficherGrimoire();
            System.out.print("Choisissez un sort : ");
            int index = scanner.nextInt() - 1;
            Sort sort = s.lancerSort(index);
            if (sort != null) monstre.recevoirDegats(sort.getDegats());
        }
        else if (personnage instanceof Guerrier) {
            Guerrier g = (Guerrier) personnage;
            g.afficherEsprit();
            System.out.print("Choisissez une technique : ");
            int index = scanner.nextInt() - 1;
            CompRage comp = g.UtiliserCompetence(index);
            if (comp != null) monstre.recevoirDegats(comp.getDegats());
        }
        else if (personnage instanceof Assassin) {
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
            System.out.println("\n✨ VICTOIRE ! " + monstre.getName() + " a mordu la poussière.");
            personnage.gagnerExperience(monstre.getExpDonnee());
        } else {
            System.out.println("\n💀 Vous avez succombé face à " + monstre.getName() + "...");
        }
    }
}
