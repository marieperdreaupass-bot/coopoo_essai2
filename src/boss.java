import java.util.ArrayList;

public class boss extends perso {

    private final ArrayList<Objet> objets;
    private int resistance;

    public boss(String name) {
        super(name, 7000, 300, 2);
        this.resistance = 150;
        this.niveau = 1;
        objets = new ArrayList<>();
        objets.add(new Objet("Potion de soin", 5000));
        objets.add(new Objet("Épée magique", 200));
        objets.add(new Objet("Bouclier", 1000));
    }

    @Override
    public void attaquer() {
        System.out.println(name + " attaque avec puissance !");
        System.out.println("Dégâts infligés : " + degatsDeBase);
    }

    public void attaqueSpeciale() {
        System.out.println(name + " lance une attaque spéciale dévastatrice !");
        System.out.println("Dégâts infligés : " + (degatsDeBase * 2));
    }

    public void rugir() {
        System.out.println(name + " pousse un rugissement terrifiant !");
    }

    public void seSoigner() {
        PV += 2000;
        System.out.println(name + " se soigne et récupère 2000 PV !");
        System.out.println("PV actuels : " + PV);
    }

    public void utiliserObjet(int index) {
        if (index >= 0 && index < objets.size()) {
            Objet obj = objets.get(index);
            System.out.println(name + " utilise " + obj.getNom() + " !");
            PV += obj.getEffet();
            System.out.println("PV actuels : " + PV);
        } else {
            System.out.println(name + " n'a pas cet objet !");
        }
    }

    public void afficherStats() {
        System.out.println("===== STATISTIQUES DU BOSS =====");
        System.out.println("Nom : " + name);
        System.out.println("PV : " + PV);
        System.out.println("Dégâts : " + degatsDeBase);
        System.out.println("Vitesse : " + vitesse);
        System.out.println("Résistance : " + resistance);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        boss monBoss = new boss("Dragon Noir");

        monBoss.afficherStats();
        monBoss.rugir();
        monBoss.attaquer();
        monBoss.attaqueSpeciale();
        monBoss.seSoigner();
        monBoss.utiliserObjet(0);
        monBoss.utiliserObjet(1);

        System.out.println("Test terminé !");
    }
}

/// /ATTENTION BOSS NE DOIT PAAAASSS EXTENDS PERSO

