import java.util.ArrayList;
import java.util.List;

public class perso  {

    protected String nom;
    protected int PV;
    protected int pvMax;
    protected int niveau;
    protected int degatsDeBase;
    protected int vitesse;
    protected double chanceCritique; //double nous permet de gerer les pourcentages


    protected List<String> inventaire;

    protected int experience;
    protected int experienceRequise;

    // CONSTRUCTEUR
    public perso(String nom, int pv, int degatsDeBase, int vitesse) {
        this.nom = nom;
        PV = pv;
        pvMax = pv; // Au début, PV max = PV actuels
        degatsDeBase = degatsDeBase;
        vitesse = vitesse;
        chanceCritique = 0.2;
        niveau = 1;
        experience = 0;
        experienceRequise = 100;

        inventaire = new ArrayList<>();
    }

    public void afficherInfo() {
        System.out.println("--- Info de " + nom + " ---");
        System.out.println("Niveau : " + niveau);
        System.out.println("Points de Vie : " + PV + "/" + pvMax);
        System.out.println("Dégâts de Base : " + degatsDeBase);
        System.out.println("Vitesse : " + vitesse);
    }

    public int attaquer() {
        boolean estCritique = Math.random() < chanceCritique; // Math.random() génère entre 0.0 et 1.0. Si < 0.2, c'est critique
        int degatsFinaux = degatsDeBase;
        if (estCritique) {
            degatsFinaux = degatsDeBase * 2;
            System.out.println("⚡️ Dégats CRITIQUE ⚡️" + degatsFinaux);
        }
        System.out.println(nom + " attaque ! (Puissance : " + degatsDeBase + ")");
        return degatsFinaux;
    }

    // Gestion de l'inventaire
    public void afficherInventaire() {
        System.out.println("--- Inventaire de " + nom + " ---");
        if (inventaire.isEmpty()) {
            System.out.println("(Vide)");
        } else {
                for (String item : inventaire) {
                System.out.println("- " + item);
            }
        }
    }

    public void ajouterObjet(String nouvelObjet) {
        inventaire.add(nouvelObjet);
        System.out.println(nom + " a obtenu : " + nouvelObjet + ".");
    }


    // GESTION NIVEAU
    public void gagnerExperience(int montant) {
        experience += montant;
        System.out.println(nom + " a gagné " + montant + " XP.");

        // Boucle while pour passer plusieurs niveaux d'un coup si besoin
        while (experience >= experienceRequise && experienceRequise > 0) {
            monterDeNiveau();


        }
    }

    public void monterDeNiveau() {
        if (experience >= experienceRequise) {
            niveau++;
            experience -= experienceRequise;
            experienceRequise = (int) (experienceRequise * 1.5);
            pvMax += 200;
            PV = pvMax;
            degatsDeBase += 75;
            vitesse += 1;
            System.out.println("✨ LEVEL UP ! " + nom + " est niveau " + niveau);
        }
    }
//    public void monterDeNiveau() {
//        if (experience >= experienceRequise) {
//            niveau++;
//            experience -= experienceRequise;
//
//
//            experienceRequise = (int) (experienceRequise * 1.5);
//
//            // Augmentation des stats
//            pvMax += 200;
//            PV = pvMax; // Soin complet au level up !
//            degatsDeBase += 75;
//            vitesse += 1;
//
//            System.out.println("✨ LEVEL UP ! " + nom + " passe au niveau " + niveau + " ! ✨");
//            System.out.println("Stats -> PV: " + PV + " | Dégâts: " + degatsDeBase);
//        }
//    }

    public boolean estMort() {
        return PV <= 0;
    }

    public String getNom() {
        return nom;
    }

    public int getPV() {
        return PV;
    }
    public void setPV(int pv) {
        this.PV = pv;
    }
    public int getNiveau() {
        return niveau;
    }
    public int getDegatsDeBase() {
        return degatsDeBase;
    }
    public int getVitesse() {
        return vitesse;
    }
}



