import java.util.ArrayList;
import java.util.List;

public abstract class Personnage {

    protected String nom;
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
    public Personnage(String nom, int pv, int degatsDeBase, int vitesse) {
        this.nom = nom;
        PV = pv;
        pvMax = pv; // Au début, PV max = PV actuels
        this.degatsDeBase = degatsDeBase;
        this.vitesse = vitesse;
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

    public abstract int attaquer();

    public void augmenterChanceCritiquePermanente(double montant) {
        this.chanceCritique += montant;
        System.out.println("✨ " + this.nom + " ressent une puissance occulte... Chance critique augmentée de " + (montant * 100) + "% !");
    }

    // Gestion de l'inventaire
    public void afficherInventaire() {
        System.out.println("\n--- 📦 Inventaire de " + nom + " ---");
        if (inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide.");
        } else {
            for (int i = 0; i < inventaire.size(); i++) {
                Objet obj = inventaire.get(i);
                System.out.println("[" + (i + 1) + "] " + obj.getNom() + " (Effet: " + obj.getEffet() + ")");
            }
        }
    }

    public void ajouterObjet(Objet nouvelObjet) {
        inventaire.add(nouvelObjet);
        System.out.println(nom + " a obtenu : " + nouvelObjet.getNom() + ".");
    }

    public List<Objet> getInventaire() {
        return inventaire;
    }
    public int utiliserObjet(int index) {
        if (index >= 0 && index < inventaire.size()) {
            Objet obj = inventaire.get(index);
            String nomObj = obj.getNom().toLowerCase();
            int valeurEffet = obj.getEffet();

            System.out.println("\n--- UTILISATION : " + obj.getNom().toUpperCase() + " ---");


            if (nomObj.contains("larme de banshee")) {
                this.augmenterChanceCritiquePermanente(0.05);
                System.out.println("Vos chances de critique ont sont maintenant de " + chanceCritique*100 + "%");
                inventaire.remove(index);// L'objet est consommé
                return 0;
            }

            // 1. CAS DES ARMES (Hache, Dague, Grimoire)
            if (nomObj.contains("hache") || nomObj.contains("dague") || nomObj.contains("grimoire")) {
                if (nomObj.contains("hache"))
                    System.out.println("Description : Une arme lourde qui décuple la force brute.");
                else if (nomObj.contains("dague"))
                    System.out.println("Description : Des lames rapides pour trancher les points vitaux.");
                else if (nomObj.contains("grimoire"))
                    System.out.println("Description : Un livre ancien canalisant l'énergie magique.");

                // On appelle l'attaque spécifique de la classe (Guerrier, Sorcier ou Assassin)
                // L'arme n'est PAS supprimée de l'inventaire (on ne fait pas remove)
                return this.attaquer();
            }

            // 2. CAS DU SOIN (Potion de vie)
            else if (nomObj.contains("vie")) {
                this.recevoirSoin(obj.getEffet());
                inventaire.remove(index); // On consomme la potion
                return 0;
            }

            // 3. CAS DE L'ÉNERGIE (Mana, Rage, Endurance)
            else if (nomObj.contains("mana") || nomObj.contains("endurance") || nomObj.contains("soulagement")) {
                restaurerRessourceSpecifique(obj.getEffet());
                inventaire.remove(index);
            } else {
                System.out.println("L'objet n'a pas d'effet immédiat.");
            }
        } else {
            System.out.println("⚠️ Index invalide ou objet introuvable.");
        }
        return 0;
    }

    public void recevoirDegats(int montant) {
        this.PV -= montant;
        if (this.PV < 0) {
            this.PV = 0;
        }
        System.out.println(this.nom + " a reçu " + montant + " points de dégâts ! (PV restants : " + this.PV + ")");
    }

    public void recevoirSoin(int montant) {
        this.PV += montant;
        if (this.PV > this.pvMax) {
            this.PV = this.pvMax;
        }
        System.out.println(this.nom + " récupère " + montant + " PV ! (Total : " + this.PV + ")");
    }
    // Dans Personnage.java (méthode vide par défaut)
    public abstract void restaurerRessourceSpecifique(int montant);

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
        niveau++;
        experience -= experienceRequise;
        experienceRequise = (int) (experienceRequise * 1.15);
        pvMax += 200;
        PV = pvMax;
        degatsDeBase += 75;
        this.chanceCritique += 0.02; // +2% de chance critique par niveau
        System.out.println("✨ LEVEL UP ! " + nom + " est niveau " + niveau);
        afficherInfo();
    }

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
    public int getVitesse() {
        return vitesse;
    }
}


