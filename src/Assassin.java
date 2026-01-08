import java.util.ArrayList;
import java.util.List;

public class Assassin extends Personnage {

    //Attribut spécifique a l'assassin
    protected int endurance = 500;
    private final List<Ruse> technique;


    public Assassin(String Nom) {
        super(Nom, 300, 50, 8);

        //Remplissage du grimoire
        this.technique = new ArrayList<>();
        this.technique.add(new Ruse("Coup sournois : vous vous glissez derrière votre ennemi", 20, 45));
        //Remplissage de l'inventaire
        this.ajouterObjet(new Objet("Dague lacérantes", degatsDeBase));
        this.ajouterObjet(new Objet("Potion d'endurance", 200));
        this.ajouterObjet(new Objet("Potion de vie", 150));
    }

    public void afficherTechniques() {
        System.out.println("\n--- Techniques de " + nom + " ---");
        for (int i = 0; i < technique.size(); i++) {
            Ruse r = technique.get(i);
            String statut = r.isUtilise() ? "[ÉPUISÉ]" : "(Endurance: " + r.getCoutEndurance() + ")";
            System.out.println("[" + (i + 1) + "] " + r.getNom() + " " + statut + " | Dégâts: " + r.getDegats());
        }
    }

    //Polymorphisme de la méthode attaquer()
    @Override
    public int attaquer() {
        System.out.println(nom + " plante ses dagues dans l'ennemi.");
        return this.degatsDeBase;
    }

    //Utiliser une ruse
    public Ruse utiliserRuse(int index) {
        if (index < 0 || index >= this.technique.size()) return null;

        Ruse ruse = technique.get(index);

        if (ruse.isUtilise()) {
            System.out.println("⚠️ Vous avez déjà utilisé cette ruse ! L'ennemi s'y attend.");
            return null;
        }

        if (this.endurance >= ruse.getCoutEndurance()) {
            this.endurance -= ruse.getCoutEndurance();
            ruse.setUtilise(true); // Verrouille cette ruse
            return ruse;
        } else {
            System.out.println("❌ Pas assez d'endurance !");
            return null;
        }
    }

    public void resetToutesCompetences() {
        for (Ruse r : technique) r.setUtilise(false);
    }

    //Monter de niveau spécifique
    @Override
    public void monterDeNiveau(){
        super.monterDeNiveau();
        this.endurance += 100;
    }
}
