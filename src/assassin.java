public class assassin extends perso{


    public assassin (){
        super(jeu.nom, 500, 500, 2);

    }
    @Override
    public int attaquer() {
        System.out.println(jeu.nom + "plante sa lame secrete dans l'adversaire");
    }
}
