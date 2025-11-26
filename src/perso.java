import java.util.ArrayList;
import java.util.List;

public class perso {

    protected String jeuNom;
    protected int PV;
    protected int pvMax;
    protected int niveau;
    protected int degatsDeBase;
    protected int vitesse;
    protected int chanceCritique;


    protected List<String> inventaire;

    protected int experience;
    protected int experienceRequise;

    // CONSTRUCTEUR
    public perso(String nom, int pv, int degatsDeBase, int vitesse) {
        this.jeuNom = nom;
        this.PV = pv;
        this.pvMax = pv; // Au début, PV max = PV actuels
        this.degatsDeBase = degatsDeBase;
        this.vitesse = vitesse;

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
        boolean estCritique = Math.random() < this.chanceCritique;
        int degatsFinaux = this.degatsDeBase;
        if (estCritique) {
            degatsFinaux = this.degatsDeBase * 2;
            System.out.println("⚡️ Degats CRITIQUE ⚡️" + degatsFinaux);
        }
        System.out.println(this.jeuNom + " attaque ! (Puissance : " + this.degatsDeBase + ")");
        return this.degatsDeBase;
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
        this.inventaire.add(nomObjet);
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
        return this.PV < 0;
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

//    public void levelUP(int niveau) {
//        this.niveau = niveau + 1;
//        System.out.println(this.jeuNom + " a ajouter level " + niveau + ".");
//    }  --> PAS SUR











        //marie core
 //   public Runnable objet1() {
   //     return null;
    //}


    //ArrayList<Runnable> objets;
   // public void objet(){
     //   objets=new ArrayList<>();
       // objets.add(objet1());

//    protected void gagnerObjet(String nomObjet) {
//        this.inventaire.add(nomObjet);
//        System.out.println(this.nom + " a reçu : " + nomObjet);
//    }
//
//
//
//
//        // Afficher ce qu'il y a dans le sac
//        public void afficherInventaire() {
//            System.out.println("Inventaire de " + this.nom + " :");
//            if (inventaire.isEmpty()) {
//                System.out.println(" - (Vide)");
//            } else {
//                for (String objet : inventaire) {
//                    System.out.println(" - " + objet);
//                }
//            }
//        }
//
//        // --- AUTRES METHODES ---
//
//        public void afficherInfo() {
//            System.out.println("--- Infos Perso ---");
//            System.out.println("Nom : " + this.nom);
//            System.out.println("PV : " + this.pv);
//            // On affiche aussi l'inventaire
//            afficherInventaire();
//        }
//
//        public void attaquer() {
//            System.out.println(this.nom + " attaque !");
//        }
//    }// Utiliser/Perdre un objet (optionnel)
//    public void perdreObjet(String nomObjet) {
//        if (this.inventaire.contains(nomObjet)) {
//            this.inventaire.remove(nomObjet);
//            System.out.println(this.nom + " a utilisé/perdu : " + nomObjet);
//        } else {
//            System.out.println("Objet introuvable !");
//        }
//    }
//
//    // Afficher ce qu'il y a dans le sac
//    public void afficherInventaire() {
//        System.out.println("Inventaire de " + this.nom + " :");
//        if (inventaire.isEmpty()) {
//            System.out.println(" - (Vide)");
//        } else {
//            for (String objet : inventaire) {
//                System.out.println(" - " + objet);
//            }
//        }
//    }
//
//    // --- AUTRES METHODES ---
//
//    public void afficherInfo() {
//        System.out.println("--- Infos Perso ---");
//        System.out.println("Nom : " + this.nom);
//        System.out.println("PV : " + this.pv);
//        // On affiche aussi l'inventaire
//        afficherInventaire();
//    }
//
//    public void attaquer() {
//        System.out.println(this.nom + " attaque !");
//    }
//}
//
//
//public void afficherInfo() {
//            System.out.println("Nom : " + jeu.nom);
//            System.out.println("PointsDeVie : " + perso.PV);
//            System.out.println("niveau : " + perso.niveau);
//            System.out.println("degats : " + perso.degatsDeBase);
//            System.out.println("vitesse : " + perso.vitesse);
//    }
//
//
//    public void attaquer(){
//        System.out.println(jeu.nom  + "attaque " );
//
//    }

