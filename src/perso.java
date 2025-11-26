import java.util.ArrayList;
import java.util.List;

public class perso {

    protected String jeuNom ;
    protected  int PV;
    protected  int niveau;
    protected  int degatsDeBase;
    protected  int vitesse;
    protected List<String> inventaire;

    public perso(String nom, int pv,int DegatsDeBase, int Vitesse) {
        this.jeuNom = nom;
        this.PV = pv;
        this.niveau = 1;
        this.degatsDeBase = DegatsDeBase;
        this.vitesse = Vitesse;
        this.inventaire = new ArrayList<>();
    }

    public void afficherInfo(){
        System.out.println("Info de " + this.jeuNom + " ---");
        System.out.println("Niveau : " + this.niveau);
        System.out.println("Points de Vie :" + this.PV);
        System.out.println("Degats de Base :" + this.degatsDeBase);
        System.out.println("Vitesse :" + this.vitesse);
    }
}
    public void attaquer() {
        System.out.println(this.jeuNom + "attaque (Dégats : " + this.degatsDeBase);
    }










        //marie core
    public Runnable objet1() {
        return null;
    }


    ArrayList<Runnable> objets;
    public void objet(){
        objets=new ArrayList<>();
        objets.add(objet1());

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
//            System.out.println("degats : " + perso.degats);
//            System.out.println("vitesse : " + perso.vitesse);
//    }
//
//
//    public void attaquer(){
//        System.out.println(jeu.nom  + "attaque " );
//
//    }

