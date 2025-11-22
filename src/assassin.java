public class assassin extends perso{


    public assassin (){
        super(nom, 500, 500, 2);

    }
    @Override
    public void attaquer() {
        System.out.println(nom + "plate sa lame secrete dans l'adversaire");
    }
}
