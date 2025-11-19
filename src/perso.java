public class perso {

    protected  static String name;
    protected static String nom;
    protected static int PV;
    protected static int niveau;
    protected static int degats;
    protected static int vitesse;

    public perso(String Nom, int pv,int Degats, int vitesse) {
        nom = Nom;
        PV = pv;
        niveau = 1;
        Degats = degats;
    }
    public perso(String name, int pv, int niveau, int degats, int vitesse) {}


    public static void afficherInfo() {
        System.out.println("Nom : " + nom);
        System.out.println("PointsDeVie : " + PV);
        System.out.println("niveau : " + niveau);
        System.out.println("degats : " + degats);
        System.out.println("vitesse : " + vitesse);
    }

    public void attaquer(){
        System.out.println(nom  + "attaque " );

    }
}

