public class Sort {
    protected String nomSort;
    protected int coutMana;
    protected int degatsSort;

    //Constructeur pour initialiser un sort
    public Sort(String nom, int coutMana, int degats) {
        this.nomSort = nom;
        this.coutMana = coutMana;
        this.degatsSort = degats;
    }

    //Getters pour que Sorcier puisse accéder aux valeurs
    public String getNom() {
        return nomSort;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public int getDegats() {
        return degatsSort;
    }

    public void lancer(String jeuNom) {
        System.out.println(jeuNom + "lance" + this.nomSort + "!");
    }
}