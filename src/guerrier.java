public class guerrier extends perso{
    private int force;

    public guerrier(String Nom) {
        super(jeu.nom, 700,300, 2 );
    }

    @Override
    public void attaquer() {
        System.out.println(jeu.nom + "frappe à l'épée");
    }
}
