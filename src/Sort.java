public class Sort {
    protected String nomSort;
    protected int coutMana;
    protected int degatsSort;
    private boolean utilise = false;

    public boolean isUtilise() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

    public Sort(String nom, int coutMana, int degats) {
        this.nomSort = nom;
        this.coutMana = coutMana;
        this.degatsSort = degats;
    }

    public String getNom() {
        return nomSort;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public int getDegats() {
        return degatsSort;
    }

}