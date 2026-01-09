public class CompRage {

    protected String nomComp;
    protected int coutRage;
    protected int degatsComp;
    private boolean utilise = false;
    public boolean isUtilise() { return utilise; }
    public void setUtilise(boolean utilise) { this.utilise = utilise; }

    public CompRage(String nomComp, int coutRage, int degats) {
        this.nomComp = nomComp;
        this.coutRage = coutRage;
        this.degatsComp = degats;
    }

    public String getNom() {
        return nomComp;
    }

    public int getCoutRage() {
        return coutRage;
    }

    public int getDegats() {
        return degatsComp;
    }
}
