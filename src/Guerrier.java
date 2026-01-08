import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personnage {

    //Attribut spécifique au guerrier :
    protected int rage = 500;
    private final List<CompRage> esprit;


    public Guerrier(String Nom) {
        super(Nom, 400, 75, 3);

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
            System.out.println("--- Esprit de " + nom + " ---");
            if (esprit.isEmpty()) {
                System.out.println("Le grimoire est vide.");
                return;
        }
            for (int i = 0; i < esprit.size(); i++) {
                CompRage CompActuel = esprit.get(i);
                System.out.println("[" + (i + 1) + "]" + CompActuel.getNom() + "|Rage : " + CompActuel.getCoutRage() + "| Dégâts : " + CompActuel.getDegats());
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
        if(index < 0 || index >= this.esprit.size()){
            return null;
        }

    //Récupération de la compétence sélectionnée
        else {
            return esprit.get(index);
        }
        }
    //Monter de niveau spécifique
    @Override
    public void monterDeNiveau(){
        super.monterDeNiveau();
        this.rage += 100;
    }
}
