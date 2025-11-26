import java.util.ArrayList;

public class perso {

    protected String name;
    protected String nomPerso = jeu.nom;
    protected int PV;
    protected int niveau;
    protected int degats;
    protected int vitesse;
    protected ArrayList<String> inventaire;

}

public Perso(String nom, int pv, int degats, int vitesse) {
    this.nom = nom;       // On utilise 'this' pour dire "l'attribut de cet objet"
    this.pv = pv;
    this.degats = degats;
    this.vitesse = vitesse;
    this.niveau = 1;      // Niveau 1 par défaut
    this.inventaire = new ArrayList<String>();
}
public void gagnerObjet(String nomObjet) {
    this.inventaire.add(nomObjet);
    System.out.println(this.nom + " a reçu : " + nomObjet);
}

// Utiliser/Perdre un objet (optionnel)
public void perdreObjet(String nomObjet) {
    if (this.inventaire.contains(nomObjet)) {
        this.inventaire.remove(nomObjet);
        System.out.println(this.nom + " a utilisé/perdu : " + nomObjet);
    } else {
        System.out.println("Objet introuvable !");
    }
}

// Afficher ce qu'il y a dans le sac
public void afficherInventaire() {
    System.out.println("Inventaire de " + this.nom + " :");
    if (inventaire.isEmpty()) {
        System.out.println(" - (Vide)");
    } else {
        for (String objet : inventaire) {
            System.out.println(" - " + objet);
        }
    }
}

// --- AUTRES METHODES ---

public void afficherInfo() {
    System.out.println("--- Infos Perso ---");
    System.out.println("Nom : " + this.nom);
    System.out.println("PV : " + this.pv);
    // On affiche aussi l'inventaire
    afficherInventaire();
}

public void attaquer() {
    System.out.println(this.nom + " attaque !");
}
}
    public perso(String Nom, int pv,int Degats, int vitesse) {
        Nom = jeu.nom;
        PV = pv;
        niveau = 1;
        Degats = degats;
    }
    public perso(String name, int pv, int niveau, int degats, int vitesse) {}

    public perso() {
    }

public static void afficherInfo() {
            System.out.println("Nom : " + jeu.nom);
            System.out.println("PointsDeVie : " + perso.PV);
            System.out.println("niveau : " + perso.niveau);
            System.out.println("degats : " + perso.degats);
            System.out.println("vitesse : " + perso.vitesse);
    }


    public void attaquer(){
        System.out.println(jeu.nom  + "attaque " );

    }

}

