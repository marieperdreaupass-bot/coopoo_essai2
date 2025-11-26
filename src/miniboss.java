import java.util.ArrayList;

public class miniboss {

    protected String name;
    protected int pv;
    protected int attaque;
    protected int vitesse;
    protected int niveau;

    private final ArrayList<Objet> objets;
    private int resistance;

    public miniboss() {

        name = "Le Chevalier Corrompu";
        pv = 1500;
        attaque = 120;
        vitesse = 70;
        niveau = 1;

        this.resistance = 50;           // Résistance réduite (Boss = 150)
        objets = new ArrayList<>();
        objets.add(new Objet("Petite Potion", 400));
        objets.add(new Objet("Talisman de Force", 30));
        objets.add(new Objet("Cape", 100));
    }

    public void attaquer() {
        System.out.println(name + " attaque avec une faible puissance !");
        System.out.println("Dégâts infligés : " + attaque);
    }

    public void attaqueSpeciale() {
        System.out.println(name + " lance son attaque spéciale !");
        // L'attaque spéciale est moins dévastatrice
        System.out.println("Dégâts infligés : " + (attaque * 1.5)); // Multiplicateur plus petit (Boss = *2)
    }

    public void rugir() {
        System.out.println(name + " pousse un cri d'intimidation !");
    }

    public void seSoigner() {
        //int soinminiboss = 400; // Soin réduit (Boss = 2000)
        pv += 1500;
        System.out.println(name + " se soigne et récupère " + 1500 + " PV !");
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
        System.out.println("===== STATISTIQUES DU MINI-BOSS =====");
        System.out.println("Nom : " + name);
        System.out.println("PV : " + pv);
        System.out.println("Dégâts : " + attaque);
        System.out.println("Vitesse : " + vitesse);
        System.out.println("Résistance : " + resistance);
        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        miniboss monMiniBoss = new miniboss();

        monMiniBoss.afficherStats();
        monMiniBoss.rugir();
        monMiniBoss.attaquer();
        monMiniBoss.attaqueSpeciale();
        monMiniBoss.seSoigner();
        monMiniBoss.utiliserObjet(0);

        System.out.println("Test terminé !");
    }
}