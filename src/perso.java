import java.util.ArrayList;
import java.util.List;

public class perso {

    protected static String jeuNom ;
    protected static int PV;
    protected static int niveau;
    protected static int degatsDeBase;
    protected static int vitesse;
    protected List<String> inventaire;
    protected int experience;
    protected int experienceRequise;
    protected int pvMax;

    public perso(String nom, int pv,int degatsDeBase, int vitesse) {
        this.jeuNom = nom;
        this.PV = pv;
        this.pvMax = PV;
        this.niveau = 1;
        this.degatsDeBase = degatsDeBase;
        this.vitesse = vitesse;
        this.inventaire = new ArrayList<>();

        this.experience = 0;
        this.experienceRequise = 100;
    }

    public void afficherInfo(){
        System.out.println("Info de " + this.jeuNom + " ---");
        System.out.println("Niveau : " + this.niveau);
        System.out.println("Points de Vie :" + this.PV);
        System.out.println("Degats de Base :" + this.degatsDeBase);
        System.out.println("Vitesse :" + this.vitesse);
    }

    public void attaquer() {
        System.out.println(this.jeuNom + "attaque (Dégats : " + this.degatsDeBase);
    }

    //Afficher le contenu de l'inventaire
    public void afficherInventaire() {
        System.out.println("--- Inventaire de " + this.jeuNom + " ---");
        if (inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide.");
        } else {
            for (String item : inventaire) {
                System.out.println("- " + item);
            }
        }
    }

    //Ajout d'un objet à l'inventaire
    public void ajouterObjet(String nomObjet) {
        this.inventaire.add(nomObjet);
        System.out.println(this.jeuNom + " a ajouté objet : " + nomObjet + "à son inventaire.");
    }

    public void gagnerExperience(int montant) {
        this.experience += montant;
        System.out.println(this.jeuNom + " a gagner experience : " + montant + "XP");
        while (this.experience >= this.experienceRequise) {
            monterdeNiveau();
        }
    }

        public void monterDeNiveau() {
            this.niveau++;
            this.experience -= this.experienceRequise; // On soustrait l'XP utilisée (on garde le surplus)
            this.experienceRequise = (int) (this.experience * 1.5); // on augmente de 50 %
            this.PV += 200;
            this.degatsDeBase += 75;
            this.vitesse += 1;
            this.pv = this.pvMax; // a definir
        System.out.println("✨ LEVEL UP ! " + this.jeuNom + " passe au niveau " + this.niveau + " ! ");
        System.out.println("Vitesse : " + this.vitesse);
        System.out.println("PV : " + this.PV);
        System.out.println("Degats de Base : " + this.degatsDeBase);
        System.out.println("Experience : " + this.experience);


        }
    }

//    public void levelUP(int niveau) {
//        this.niveau = niveau + 1;
//        System.out.println(this.jeuNom + " a ajouter level " + niveau + ".");
//    }  --> PAS SUR
}










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
public void afficherInfo() {
            System.out.println("Nom : " + jeu.nom);
            System.out.println("PointsDeVie : " + perso.PV);
            System.out.println("niveau : " + perso.niveau);
            System.out.println("degats : " + perso.degatsDeBase);
            System.out.println("vitesse : " + perso.vitesse);
    }


    public void attaquer(){
        System.out.println(jeu.nom  + "attaque " );

    }

