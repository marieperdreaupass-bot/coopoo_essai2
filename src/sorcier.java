import java.util.ArrayList;
import java.util.List;

// Convention : Majuscule au début du nom de la classe
public class Sorcier extends Perso {

    // Attributs spécifiques
    protected int mana;
    private final List<Sort> grimoire;

    // Constantes (Très bonne pratique !)
    private static final int PV_DEFAUT = 300;
    private static final int DEGATS_DEFAUT = 150;
    private static final int VITESSE_DEFAUT = 5;
    private static final int MANA_DEFAUT = 500;

    // CONSTRUCTEUR
    public Sorcier(String nomDonne) {
        // CORRECTION ICI : On passe 'nomDonne' au super, pas 'jeu.nom'
        // On envoie les constantes définies au-dessus
        super(nomDonne, PV_DEFAUT, DEGATS_DEFAUT, VITESSE_DEFAUT);

        this.mana = MANA_DEFAUT;

        // Remplissage du grimoire
        this.grimoire = new ArrayList<>();
        // (Assure-toi d'avoir une classe "Sort" créée ailleurs)
        this.grimoire.add(new Sort("Boule de feu", 20, 45));
        this.grimoire.add(new Sort("Eclair de Givre", 15, 30));

        // Remplissage de l'inventaire (méthodes héritées de Perso)
        this.ajouterObjet("Grimoire Radiant");
        this.ajouterObjet("Potion de mana");
    }

    // Afficher les sorts
    public void afficherGrimoire() {
        System.out.println("--- Grimoire de " + this.jeuNom + " --- (Mana: " + this.mana + ")");
        if (grimoire.isEmpty()) {
            System.out.println("Le grimoire est vide.");
            return;
        }

        for (int i = 0; i < grimoire.size(); i++) {
            Sort sortActuel = grimoire.get(i);
            // J'ai ajouté des parenthèses (i+1) pour que l'affichage soit correct (1, 2, 3...)
            System.out.println("[" + (i + 1) + "] " + sortActuel.getNom()
                    + " | Coût: " + sortActuel.getCoutMana()
                    + " | Dégâts: " + sortActuel.getDegats());
        }
    }

    // On surcharge l'attaque de base (si le sorcier n'a plus de mana, il tape avec son bâton)
    @Override
    public void attaquer() {
        System.out.println(this.jeuNom + " donne un coup de bâton !");
        // return super.attaquer(); // Si tu veux garder la logique de base
    }

    // Méthode spécifique pour lancer un sort
    public Sort choisirSort(int index) {
        // On ajuste l'index car l'utilisateur tape 1, mais la liste commence à 0
        int indexReel = index - 1;

        if (indexReel < 0 || indexReel >= this.grimoire.size()) {
            System.out.println("Ce sort n'existe pas !");
            return null;
        }

        Sort sortChoisi = grimoire.get(indexReel);

        // Vérification du Mana
        if (this.mana >= sortChoisi.getCoutMana()) {
            this.mana -= sortChoisi.getCoutMana();
            System.out.println(this.jeuNom + " lance " + sortChoisi.getNom() + " !");
            return sortChoisi;
        } else {
            System.out.println("Pas assez de mana !");
            return null;
        }
    }
}