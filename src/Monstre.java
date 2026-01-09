import java.util.ArrayList;

public class Monstre {
    protected String name;
    protected int pv;
    protected int pvMax;
    protected int attaque;
    protected int vitesse;
    protected int expDonnee;
    protected ArrayList<Objet> objets;

    public Monstre(String name, int pv, int attaque, int vitesse, int expDonnee) {
        this.name = name;
        this.pv = pv;
        this.pvMax = pv;
        this.attaque = attaque;
        this.vitesse = vitesse;
        this.expDonnee = expDonnee;
        this.objets = new ArrayList<>();
    }

    public static Monstre genererProchainBoss(int nbBossVaincus) {
        switch (nbBossVaincus) {
            case 0:
                return new Miniboss("Le Minotaure", 550, 100, 2, 150, "Labyrinthe");
            case 1:
                return new Miniboss("L'Hydre de Lerne", 1200, 250, 4, 300, "Marais");
            case 2:
                return new Miniboss("Le Cerbère", 1500, 400, 6, 600, "Portes des Enfers");
            default:
                return new Boss();
        }
    }

    public void attaquer(Personnage cible) {
        System.out.println(this.name + " attaque " + cible.getNom() + " !");
        cible.recevoirDegats(this.attaque);
        System.out.println("Dégâts infligés : " + this.attaque);
    }

    public void recevoirDegats(int montant) {
        this.pv -= montant;
        if (this.pv < 0) this.pv = 0;
        System.out.println("👾 " + this.name + " subit " + montant + " dégâts. (PV : " + this.pv + ")");
    }

    public void afficherStats() {
        System.out.println("===== STATISTIQUES DE " + this.name.toUpperCase() + " =====");
        System.out.println("PV : " + this.pv + "/" + this.pvMax);
        System.out.println("Attaque : " + this.attaque);
        System.out.println("Vitesse : " + this.vitesse);
        System.out.println("=====================================");
    }

    public String getName() {
        return name;
    }

    public int getPv() {
        return pv;
    }

    public int getVitesse() {
        return vitesse;
    }

    public int getExpDonnee() {
        return expDonnee;
    }
}
