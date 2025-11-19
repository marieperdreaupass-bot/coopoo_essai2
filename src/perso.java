public class perso {

    protected  static String name;
    protected static String nom;
    protected static int PV;
    protected static int niveau;
    protected static int degats;

    public perso(String Nom, int pv,int Degats) {
        nom = Nom;
        PV = pv;
        niveau = 1;
        Degats = degats;
    }

    public static void afficherInfo() {
        System.out.println("Nom : " + nom);
        System.out.println("PointsDeVie : " + PV);
        System.out.println("niveau : " + niveau);
        System.out.println("degats : " + degats);
    }

    public void attaquer(){
        System.out.println(nom  + "attaque " );

    }
}

