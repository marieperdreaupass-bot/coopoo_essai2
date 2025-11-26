import java.util.ArrayList;
import java.util.List;


public class guerrier extends perso {

    //Attributs spécifiques au guerrier
    private int rage;
    private final List<compétenceDeRage> corps;
    private static final int RAGE_DEFAUT = 300
    public guerrier(String nom) {
        super(nom, 700, 300, 2);
        this.rage = RAGE_DEFAUT;

        //Remplissage du corps
        this.corps = new ArrayList<>();
        this.corps.add(new compétenceDeRage("Coup double", 40, 100));

        //Remplissage de l'inventaire
        this.ajouterObjet("Coup double");
    }

        //Afficher les rages sans le corps
        public void afficherCorps() {
            System.out.println("--- Corps de" + this.jeuNom + "---")
            if (corps.isEmpty()) {
                System.out.println("Le corps est épuisé.")

            }
            for (int i = 0; i < corps.size(); i++) {
                compétenceDeRage compétenceDeRageActuel = corps.get(i);
                System.out.println("[" + i + 1 + "]" + compétenceDeRageActuel.getNom() + "|Rage : " + compétenceDeRageActuel.getCoutRage() + "|Dégats: " + compétenceDeRageActuel.getDegatsCompétenceDeRage());
            }

        }

    //Polymorphisme de la méthode attaquer()
    @Override
    public void attaquer() {
        System.out.println(this.jeuNom + "donne un coup.");
        System.out.println("Dégats infligés :  " + this.degatsDeBase);
    }

    public void seDefendre() {
        System.out.println(this.nom + " lève son bouclier et réduit les dégâts reçus !");
    }

    public void coupPuissant() {
        int degatsBoost = this.degats + (int)(this.force * 0.5);
        System.out.println(this.nom + " utilise Coup Puissant ! Il inflige " + degatsBoost + " dégâts !");
    }

    public void crierDeGuerre() {
        this.degats += 20;
        this.force += 5;
        System.out.println(this.nom + " pousse un cri de guerre ! Attaque +20 et Force +5 !");
    }

    public void charge() {
        this.vitesse += 1;
        System.out.println(this.nom + " charge l'ennemi à grande vitesse !");
    }
}

