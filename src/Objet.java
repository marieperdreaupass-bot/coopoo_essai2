public class Objet {
    private final String nom;
    private final int effet;

    public Objet(String nom, int effet) {
        this.nom = nom;
        this.effet = effet;
    }

    public String getNom() {
        return nom;
    }

    public int getEffet() {
        return effet;
    }
}
