public class perso {

    protected static String nom;
    protected static int PV;
    protected static int niveau;
    protected static int degats;

    public perso(String Nom, int pv,int Degats, int Vitesse) {
        nom = Nom;
        PV = pv;
        niveau = 1;
        degats = Degats;
    }

    public perso() {
        nom = nom;
        PV = PV;
        niveau = niveau;
        degats  =  degats;
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

