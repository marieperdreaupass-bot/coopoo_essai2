public class perso {

    protected  static String name;
    protected static String nomPerso = jeu.nom ;
    protected static int PV;
    protected static int niveau;
    protected static int degats;
    protected static int vitesse;

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

