public class CompRage {

    protected String nomComp;
    protected int coutRage;
    protected int degatsComp;

    //Constructeur pour initialiser un sort
    public CompRage(String nomComp, int coutRage, int degats) {
        this.nomComp = nomComp;
        this.coutRage = coutRage;
        this.degatsComp = degats;
    }

    //Getters pour que guerrier puisse accéder aux valeurs
    public String getNom() {
        return nomComp;
    }

    public int getCoutRage() {
        return coutRage;
    }

    public int getDegats() {
        return degatsComp;
    }

    public void utiliser(String jeuNom) {
        System.out.println(jeuNom + "utilise" + this.nomComp + "!");
    }

}
