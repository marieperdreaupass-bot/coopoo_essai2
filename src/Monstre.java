import java.util.ArrayList;

// Ajoute une liste d'objet avec la fonciton add, le if inde..,
public class Monstre {

    protected String name;
    protected int pv;
    protected int attaque;
    protected int vitesse;
    protected int niveau;
    protected int resistance;

    protected ArrayList<Objet> salle;

    public Monstre() {
        salle = new ArrayList<>();
        ////salle.add(new Objet(xxxxxxxxxxxx)) ;
    }

    public void attaquer() {
        System.out.println(name + " attaque et inflige " + attaque + " dégâts !");
    }

    public void attaqueSpeciale() {
        System.out.println(name + " lance une attaque spéciale !");
        System.out.println("Dégâts infligés : " + (attaque * 1.5));
    }

    public void rugir() {
        System.out.println(name + " rugit et intimide l’ennemi !");
    }

    public void seSoigner(int soin) {
        pv += soin;
        System.out.println(name + " récupère " + soin + " PV !");
    }

    public void utiliserObjet(int index) {
        if (index >= 0 && index < salle.size()) {
            Objet obj = salle.get(index);
            System.out.println(name + " utilise " + obj.getNom() + " !");
            pv += obj.getEffet();
            System.out.println("PV actuels : " + pv);
        } else {
            System.out.println(name + " n'a pas cet objet !");
        }
    }

    public void afficherStats() {
        System.out.println("===== STATISTIQUES =====");
        System.out.println("Nom : " + name);
        System.out.println("PV : " + pv);
        System.out.println("Attaque : " + attaque);
        System.out.println("Vitesse : " + vitesse);
        System.out.println("Niveau : " + niveau);
        System.out.println("Résistance : " + resistance);
        System.out.println("========================");
    }
}
