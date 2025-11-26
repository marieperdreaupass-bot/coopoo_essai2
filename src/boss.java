import java.util.ArrayList;

public class boss {

    protected static String name;
    protected static int pv;
    protected static int attaque;
    protected static int vitesse;
    protected static int niveau;

    private final ArrayList<Objet> objets;
    private int resistance;

    public boss()
    {name = "Hades";
        pv= 7000;
        attaque=300;
        vitesse = 666;
        niveau = 666;

        this.resistance = 150;
        objets = new ArrayList<>();
        objets.add(new Objet("Potion de soin", 5000));
        objets.add(new Objet("Épée magique", 200));
        objets.add(new Objet("Bouclier", 1000));
    }

    public void attaquer() {
        System.out.println(name + " attaque avec puissance !");
        System.out.println("Dégâts infligés : " + attaque);
    }

    public void attaqueSpeciale() {
        System.out.println(name + " lance une attaque spéciale dévastatrice !");
        System.out.println("Dégâts infligés : " + (attaque * 2));
    }

    public void rugir() {
        System.out.println(name + " pousse un rugissement terrifiant !");
    }

    public void seSoigner() {
        pv += 2000;
        System.out.println(name + " se soigne et récupère 2000 PV !");
        System.out.println("PV actuels : " + pv);
    }

    public void utiliserObjet(int index) {
        if (index >= 0 && index < objets.size()) {
            Objet obj = objets.get(index);
            System.out.println(name + " utilise " + obj.getNom() + " !");
            pv += obj.getEffet();
            System.out.println("PV actuels : " + pv);
        } else {
            System.out.println(name + " n'a pas cet objet !");
        }
    }

    public void afficherStats() {
        System.out.println("===== STATISTIQUES DU BOSS =====");
        System.out.println("Nom : " + name);
        System.out.println("PV : " + pv);
        System.out.println("Dégâts : " + attaque);
        System.out.println("Vitesse : " + vitesse);
        System.out.println("Résistance : " + resistance);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        boss monBoss = new boss();

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

