public class Ruse {
    protected String nomRuse;
    protected int coutEndurance;
    protected int degatsRuse;
    private boolean utilise = false;
    public boolean isUtilise() { return utilise; }
    public void setUtilise(boolean utilise) { this.utilise = utilise; } // Par défaut utilisable

    public Ruse (String nom, int coutEndurance, int degatsRuse) {
        this.nomRuse = nom;
        this.coutEndurance = coutEndurance;
        this.degatsRuse = degatsRuse;
    }

    public String getNom() {
        return nomRuse;
    }

    public int getCoutEndurance() {
        return coutEndurance;
    }

    public int getDegats() {
        return degatsRuse;
    }
}