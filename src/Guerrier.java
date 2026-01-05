import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personnage {

    //Attribut spécifique au guerrier :
    protected int rage;
    private final List<CompRage> esprit;

    //Définition des constantes de classe
    private static final int PV_DEFAUT = 300;
    private static final int DEGATS_DEFAUT = 150;
    private static final int VITESSE_DEFAUT = 5;
    private static final int RAGE_DEFAUT = 500;

    public Guerrier(String Nom) {
        super(Nom, PV_DEFAUT, DEGATS_DEFAUT, VITESSE_DEFAUT);
        this.rage = RAGE_DEFAUT;
        //Remplissage de l'esprit
        this.esprit = new ArrayList<>();
        this.esprit.add(new CompRage("Coup double", 20, 45));
        //Remplissage de l'inventaire
        this.ajouterObjet("Hache d'Artélis");
        this.ajouterObjet("Potion de soulagement : Calme l'esprit pour le préparer à s'enrager.");
        this.ajouterObjet("Potion de vie");
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
                System.out.println("[" + i + 1 + "]" + CompActuel.getNom() + "|Rage : " + CompActuel.getCoutRage() + "| Dégâts : " + CompActuel.getDegats());
            }
        }

    //Polymorphisme de la méthode attaquer()
    @Override
        public int attaquer() {
            System.out.println(nom + "met un coup de lance.");
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
