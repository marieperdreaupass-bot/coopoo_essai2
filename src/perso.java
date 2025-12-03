import java.util.ArrayList;
import java.util.List;

public class perso {

    protected String jeuNom;
    protected int PV;
    protected int pvMax;
    protected int niveau;
    protected int degatsDeBase;
    protected int vitesse;
    protected double chanceCritique; //double nous permet de gerer les pourcentages


    protected List<Objet> inventaire;

    protected int experience;
    protected int experienceRequise;

    // CONSTRUCTEUR
    public perso(String nom, int pv, int degatsDeBase, int vitesse) {
        this.jeuNom = nom;
        this.PV = pv;
        this.pvMax = pv; // Au début, PV max = PV actuels
        this.degatsDeBase = degatsDeBase;
        this.vitesse = vitesse;
        this.chanceCritique = 0.2;
        this.niveau = 1;
        this.experience = 0;
        this.experienceRequise = 100;

        this.inventaire = new ArrayList<>();
    }

    public void afficherInfo() {
        System.out.println("--- Info de " + this.jeuNom + " ---");
        System.out.println("Niveau : " + this.niveau);
        System.out.println("Points de Vie : " + this.PV + "/" + this.pvMax);
        System.out.println("Dégâts de Base : " + this.degatsDeBase);
        System.out.println("Vitesse : " + this.vitesse);
    }

    public int attaquer() {
        boolean estCritique = Math.random() < this.chanceCritique; // Math.random() génère entre 0.0 et 1.0. Si < 0.2, c'est critique
        int degatsFinaux = this.degatsDeBase;
        if (estCritique) {
            degatsFinaux = this.degatsDeBase * 2;
            System.out.println("⚡️ Dégats CRITIQUE ⚡️" + degatsFinaux);
        }
        System.out.println(this.jeuNom + " attaque ! (Puissance : " + this.degatsDeBase + ")");
        return degatsFinaux;
    }

    // Gestion de l'inventaire
    public void afficherInventaire() {
        System.out.println("--- Inventaire de " + this.jeuNom + " ---");
        if (inventaire.isEmpty()) {
            System.out.println("(Vide)");
        } else {
            for (String item : inventaire) {
                System.out.println("- " + item);
            }
        }
    }

    public void ajouterObjet(String nomObjet) {
        this.inventaire.add(String nomObjet);
        System.out.println(this.jeuNom + " a obtenu : " + nomObjet);
    }

    // GESTION NIVEAU
    public void gagnerExperience(int montant) {
        this.experience += montant;
        System.out.println(this.jeuNom + " a gagné " + montant + " XP.");

        // Boucle while pour passer plusieurs niveaux d'un coup si besoin
        while (this.experience >= this.experienceRequise) {
            monterDeNiveau();
        }
    }

    public void monterDeNiveau() {
        this.niveau++;
        this.experience -= this.experienceRequise;


        this.experienceRequise = (int) (this.experienceRequise * 1.5);

        // Augmentation des stats
        this.pvMax += 200;
        this.PV = this.pvMax; // Soin complet au level up !
        this.degatsDeBase += 75;
        this.vitesse += 1;

        System.out.println("✨ LEVEL UP ! " + this.jeuNom + " passe au niveau " + this.niveau + " ! ✨");
        System.out.println("Stats -> PV: " + this.PV + " | Dégâts: " + this.degatsDeBase);
    }

    public boolean estMort() {
        return this.PV <= 0;
    }

    public String getNom() {
        return this.jeuNom;
    }

    public int getPV() {
        return this.PV;
    }

    public int getNiveau() {
        return this.niveau;
    }
}



