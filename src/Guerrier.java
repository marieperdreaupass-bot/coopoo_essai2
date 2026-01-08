import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personnage {

    //Attribut spécifique au guerrier :
    protected int rage = 500;
    private final List<CompRage> esprit;


    public Guerrier(String Nom) {
        super(Nom, 400, 60, 3);

        //Remplissage de l'esprit
        this.esprit = new ArrayList<>();
        this.esprit.add(new CompRage("Coup double", 20, 45));
        //Remplissage de l'inventaire
        this.ajouterObjet(new Objet("Hache d'Artélis", degatsDeBase));
        this.ajouterObjet(new Objet("Potion de soulagement : Calme l'esprit pour le préparer à s'enrager.", 250));
        this.ajouterObjet(new Objet("Potion de vie", 200));
    }

    //Afficher les scompétences de l'esprit
    public void afficherEsprit() {
        System.out.println("\n--- Esprit de " + nom + " ---");
        for (int i = 0; i < esprit.size(); i++) {
            CompRage c = esprit.get(i);
            String statut = c.isUtilise() ? "[ÉPUISÉ]" : "(Rage: " + c.getCoutRage() + ")";
            System.out.println("[" + (i + 1) + "] " + c.getNom() + " " + statut + " | Dégâts: " + c.getDegats());
        }
    }

    //Polymorphisme de la méthode attaquer()
    @Override
    public int attaquer() {
        System.out.println(nom + "   met un coup de lance.");
        return this.degatsDeBase;
    }

    //Sélectionner une compétence
    public CompRage UtiliserCompetence(int index) {
        if (index < 0 || index >= this.esprit.size()) return null;

        CompRage comp = esprit.get(index);

        if (comp.isUtilise()) {
            System.out.println("⚠️ Cette technique a déjà été utilisée dans ce combat !");
            return null;
        }

        if (this.rage >= comp.getCoutRage()) {
            this.rage -= comp.getCoutRage();
            comp.setUtilise(true); // Verrouille cette compétence précise
            return comp;
        } else {
            System.out.println("❌ Pas assez de rage !");
            return null;
        }
    }

    public void resetToutesCompetences() {
        for (CompRage c : esprit) c.setUtilise(false);}

        //Monter de niveau spécifique
        @Override
        public void monterDeNiveau () {
            super.monterDeNiveau();
            this.rage += 100;
        }
}
