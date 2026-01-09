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
        this.technique.add(new Ruse("Coup sournois : vous vous glissez derrière votre ennemi", 30, 175));
        this.technique.add(new Ruse("Lancer de shuriken : saississez vos armes à la vitesse du vent pour les lancer sur les points faibles de votre ennemi", 60, 300));
        this.technique.add(new Ruse("Lame empoisonné : enduisez votre arme d'un puissant poison et attaquez", 100, 500));
        this.technique.add(new Ruse("Ombre mouvante : invoquez des clones et attaquez votre ennemi simultanément", 200, 950));
        this.technique.add(new Ruse("Execution de l'ombre : à la vitesse de la lumière, donner des centaines de coup à votre ennemi", 350, 2400));
        //Remplissage de l'inventaire
        this.ajouterObjet(new Objet("dagues lacerantes : armes transmise de votre maître quand vous étiez enfant. Effet : ", degatsDeBase));
        this.ajouterObjet(new Objet("Potion d'endurance : vous permet de retrouver 200 points d'endurance. ", 200));
        this.ajouterObjet(new Objet("Potion de vie : vous permet de retrouver 250 PV", 250));
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
    public int attaquer()  {
        // 1. On génère un nombre entre 0.0 et 1.0
        // 2. Si ce nombre est inférieur à chanceCritique (ex: 0.2), c'est un coup critique
        boolean estCritique = Math.random() < this.chanceCritique;

        int degatsFinaux = this.degatsDeBase;

        if (estCritique) {
            degatsFinaux = this.degatsDeBase * 2; // Les dégâts sont doublés
            System.out.println("⚡️ COUP CRITIQUE ! ⚡️");
            System.out.println(nom + " plante ses dagues dans l'ennemi pour lui infliger " + degatsFinaux + " dégâts !");
        } else {
            System.out.println(nom + " utilise ses dagues. (Puissance : " + degatsFinaux + ")");
        }

        return degatsFinaux;
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

    @Override
    public void restaurerRessourceSpecifique(int montant) {
        this.endurance = Math.min(500, this.endurance + montant);
        System.out.println("⚡ Endurance restaurée ! (Total : " + this.endurance + ")");
    }

    //Monter de niveau spécifique
    @Override
    public void monterDeNiveau(){
        super.monterDeNiveau();
        this.endurance += 100;
    }
}
