import java.util.ArrayList;
import java.util.List;

public class Assassin extends Personnage {

    //Attribut spécifique a l'assassin
    protected int endurance;
    private final List<Ruse> technique;

    //Définition des constantes de classe
    private static final int PV_DEFAUT = 300;
    private static final int DEGATS_DEFAUT = 150;
    private static final int VITESSE_DEFAUT = 5;
    private static final int ENDURANCE_DEFAUT = 500;

    public Assassin(String Nom) {
        super(Nom, PV_DEFAUT, DEGATS_DEFAUT, VITESSE_DEFAUT);
        this.endurance = ENDURANCE_DEFAUT;
        //Remplissage du grimoire
        this.technique = new ArrayList<>();
        this.technique.add(new Ruse("Coup sournois : vous vous glissez derrière votre ennemi", 20, 45));
        //Remplissage de l'inventaire
        this.ajouterObjet(new Objet("Dague lacérantes", DEGATS_DEFAUT));
        this.ajouterObjet(new Objet("Potion d'endurance", 200));
        this.ajouterObjet(new Objet("Potion de vie", 150));
    }

    //Afficher les ruses dans les techniques
    public void afficherTechniques(){
        System.out.println("--- Techniques de " + nom + " ---");
        if(technique.isEmpty()){
            System.out.println("Aucune technique n'est connue.");
            return;
        }
        for(int i = 0; i < technique.size(); i++){
            Ruse ruseActuelle = technique.get(i);
            System.out.println("[" + (i+1) + "]" + ruseActuelle.getNom() + "|Endurance : " + ruseActuelle.getCoutEndurance() + "| Dégâts : " + ruseActuelle.getDegats());
        }
    }

    //Polymorphisme de la méthode attaquer()
    @Override
    public int attaquer() {
        System.out.println(nom + "plante ses dagues dans l'ennemi.");
        return this.degatsDeBase;
    }

    //Utiliser une ruse
    public Ruse utiliserRuse(int index) {
        if(index < 0 || index >= this.technique.size()){
            return null;
        }
        //Récupération de la ruse sélectionnée
        else {
            return technique.get(index);
        }
        //Récupération du sort sélectionné
    }
    //Monter de niveau spécifique
    @Override
    public void monterDeNiveau(){
        super.monterDeNiveau();
        this.endurance += 100;
    }
}
