import java.util.ArrayList;
import java.util.List;

public class Sorcier extends Personnage {

    //Attribut spécifique au Sorcier :
    protected int mana = 500;
    private final List<Sort> grimoire;


    public Sorcier(String Nom) {
        super(Nom, 200, 40, 5);
            //Remplissage du grimoire
            this.grimoire = new ArrayList<>();
            this.grimoire.add(new Sort("Boule de feu : concentrez votre pouvoir dans votre main et lancez une boule de feu dévastatrice", 20, 45));
            this.grimoire.add(new Sort("Lumière revigorante: faites appel aux esprits pour soigner vos blessures", 100, -100));
            this.grimoire.add(new Sort("Fouet d'épines : faites apparaître un long fouet d'épines pour battre vos ennemis", 50, 35));
            this.grimoire.add(new Sort("Colère de Bahamut : Lancez un laser puissant pulvérisant vos ennemis", 300, 500));
            //Remplissage de l'inventaire
            this.ajouterObjet(new Objet("Grimoire Radiant : votre fidèle arme vous permettant de lancer des sorts", degatsDeBase));
            this.ajouterObjet(new Objet("Potion de mana : un liquide au goût étrange vous restorant 200 points de mana", 200));
            this.ajouterObjet(new Objet("Larme de Banshee : renferme un pouvoir mystique. L'utiliser infligera des dégats monstrueux (c;) au monstre !", 500));
        }

    public void afficherGrimoire() {
        System.out.println("\n--- Grimoire de " + nom + " ---");
        if (grimoire.isEmpty()) {
            System.out.println("Le grimoire est vide.");
            return;
        }
        for (int i = 0; i < grimoire.size(); i++) {
            Sort s = grimoire.get(i);
            // On affiche [ÉPUISÉ] si le sort a déjà servi dans le combat
            String statut = s.isUtilise() ? "[ÉPUISÉ]" : "(Mana: " + s.getCoutMana() + ")";
            System.out.println("[" + (i + 1) + "] " + s.getNom() + " " + statut + " | Puissance: " + s.getDegats());
        }
    }

        @Override
        public void afficherInfo() {
            super.afficherInfo();
            System.out.println("Mana : " + this.mana);
        }

    // Méthode pour tout débloquer après le combat
    public void resetToutesCompetences() {
        for (Sort s : grimoire) {
            s.setUtilise(false);
        }
        System.out.println("✨ Le mana résiduel restaure votre grimoire.");
    }

        //Polymorphisme de la méthode attaquer()
        @Override
        public int attaquer() {
            System.out.println(nom + " lance un sort simple.");
            return this.degatsDeBase;
        }

        //Lancer un sort
        public Sort lancerSort(int index) {
            if (index < 0 || index >= this.grimoire.size()) {
                return null;
            }

            Sort sortChoisi = grimoire.get(index);

            // 1. Vérifier si le sort a déjà été utilisé
            if (sortChoisi.isUtilise()) {
                System.out.println("⚠️ Ce sort est épuisé pour ce combat ! Choisissez-en un autre.");
                return null;
            }

            // 2. Vérifier le mana
            if (this.mana >= sortChoisi.getCoutMana()) {
                this.mana -= sortChoisi.getCoutMana();
                sortChoisi.setUtilise(true); // Verrouille ce sort précis
                System.out.println(nom + " lance " + sortChoisi.getNom() + " !");
                return sortChoisi;
            } else {
                System.out.println("❌ Pas assez de mana pour lancer ce sort.");
                return null;
            }
        }
        //Monter de niveau spécifique
        @Override
        public void monterDeNiveau(){
            super.monterDeNiveau();
            this.mana += 100;
        }


}

