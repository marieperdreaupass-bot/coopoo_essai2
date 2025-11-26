public class assassin extends perso{


    public assassin (){
        super(jeu.nom, 500, 500, 2);

    }
    @Override
    public void attaquer() {
        System.out.println(jeu.nom + "plante sa lame secrete dans l'adversaire");
    }


    public Runnable ojet2() {
        return null;
    }

    @Override
    public void objet(){
        super.objet();
        objets.add(ojet2());
    }
}
