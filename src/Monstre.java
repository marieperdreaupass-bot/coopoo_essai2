import java.util.ArrayList;

public class Monstre {
    // Attributs protégés pour que boss et miniboss y aient accès
    protected int nbBoss;
    protected String name;
    protected int pv;
    protected int pvMax;
    protected int attaque;
    protected int vitesse;
    protected int expDonnee;
    protected ArrayList<Objet> objets;

    // Constructeur pour initialiser un monstre
    public Monstre(int nbBoss, String name, int pv, int attaque, int vitesse, int expDonnee) {
        this.nbBoss = nbBoss;
        this.name = name;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.expDonnee = expDonnee;
        this.objets = new ArrayList<>();
    }

    public void attaquer(Personnage cible) {
        System.out.println(this.name + " attaque " + cible.getNom() + " !");
        // Les dégâts pourraient être réduits par une future stat de défense du perso
        cible.PV -= this.attaque;
        System.out.println("Dégâts infligés : " + this.attaque);
    }

    public void seSoigner(int montant) {
        this.pv += montant;
        if (this.pv > this.pvMax) this.pv = this.pvMax; // Ne dépasse pas le max
        System.out.println(this.name + " se soigne de " + montant + " PV.");
    }

    public void utiliserObjet(int index) {
        if (index >= 0 && index < objets.size()) {
            Objet obj = objets.get(index);
            System.out.println(this.name + " utilise " + obj.getNom() + " !");
            this.pv += obj.getEffet();
            System.out.println("PV actuels : " + this.pv);
            objets.remove(index); // L'objet est consommé
        }
    }

    public void afficherStats() {
        System.out.println("===== STATISTIQUES DE " + this.name.toUpperCase() + " =====");
        System.out.println("PV : " + this.pv + "/" + this.pvMax);
        System.out.println("Attaque : " + this.attaque);
        System.out.println("Vitesse : " + this.vitesse);
        System.out.println("=====================================");
    }

    // Getters utiles pour la classe outils/jeu
    public String getName() { return name; }
    public int getPv() { return pv; }
    public int getVitesse() { return vitesse; }
    public int getAttaque() { return attaque; }
    public int getExpDonnee() { return expDonnee; }

    public static class B1 extends Monstre {

        public B1() {
            // On envoie les infos à la classe Monstre (nom, pv, attaque, vitesse, exp donnee)
            super(1, "Squelette", 500, 500, 500, 500);
        }

    }

    public static class B2 extends Monstre{

        public B2() {
            // On envoie les infos à la classe Monstre (nom, pv, attaque, vitesse, exp donnee)
            super(2, "chevalier corrompu", 800, 800, 800, 800);
        }
    }

    public static class B3 extends Monstre{
            public B3() {
                // On envoie les infos à la classe Monstre (nom, pv, attaque, vitesse, exp donnee)
                super(3, "Geant cyclope", 1000, 1000, 1000, 1000);
            }
        }
}

//import java.util.ArrayList;
//
// Ajoute une liste d'objet avec la fonciton add, le if inde..,
//public class Monstre {
//
//    protected String name;
//    protected int pv;
//    protected int attaque;
//    protected int vitesse;
//    protected int niveau;
//    protected int resistance;
//
//    protected ArrayList<Objet> salle;
//
//    public Monstre() {
//        salle = new ArrayList<>();
//        ////salle.add(new Objet(xxxxxxxxxxxx)) ;
//    }
//
//    public void attaquer() {
//        System.out.println(name + " attaque et inflige " + attaque + " dégâts !");
//    }
//
//    public void attaqueSpeciale() {
//        System.out.println(name + " lance une attaque spéciale !");
//        System.out.println("Dégâts infligés : " + (attaque * 1.5));
//    }
//
//    public void rugir() {
//        System.out.println(name + " rugit et intimide l’ennemi !");
//    }
//
//    public void seSoigner(int soin) {
//        pv += soin;
//        System.out.println(name + " récupère " + soin + " PV !");
//    }
//
//    public void utiliserObjet(int index) {
//        if (index >= 0 && index < salle.size()) {
//            Objet obj = salle.get(index);
//            System.out.println(name + " utilise " + obj.getNom() + " !");
//            pv += obj.getEffet();
//            System.out.println("PV actuels : " + pv);
//        } else {
//            System.out.println(name + " n'a pas cet objet !");
//        }
//    }
//
//    public void afficherStats() {
//        System.out.println("===== STATISTIQUES =====");
//        System.out.println("Nom : " + name);
//        System.out.println("PV : " + pv);
//        System.out.println("Attaque : " + attaque);
//        System.out.println("Vitesse : " + vitesse);
//        System.out.println("Niveau : " + niveau);
//        System.out.println("Résistance : " + resistance);
//        System.out.println("========================");
//    }
//}
