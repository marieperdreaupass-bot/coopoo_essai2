public class compétenceDeRage {
    protected String nomcompétenceDeRage;
    protected int coutRage;
    protected int degatsCompétenceDeRage;

    //Constructeur pour initialiser une compétnce
    public compétenceDeRage(String nom, int coutRage, int degats) {
        this.nomcompétenceDeRage = nom;
        this.coutRage = coutRage;
        this.degatsCompétenceDeRage = degats;
    }

    //Getters pour que Guerrier puisse accéder aux valeurs
    public String getNom() {
        return nomcompétenceDeRage;
    }
    public int getCoutRage() {
        return coutRage;
    }
    public int getDegatsCompétenceDeRage(){
        return degatsCompétenceDeRage;
    }

    public void utiliser (String jeuNom){
        System.out.println(jeuNom + "utilise" + this.nomcompétenceDeRage + "!");
    }
}
