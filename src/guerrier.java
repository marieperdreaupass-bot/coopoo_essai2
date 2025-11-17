public class guerrier extends perso{
    private int force;

    public guerrier(String Nom) {
        super(nom, 1500,300, 1);
    }

    @Override
    public void attaquer() {
        System.out.println(nom + "frappe à l'épée");
    }
}
