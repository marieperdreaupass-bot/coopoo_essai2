public class assassin extends perso{


    public assassin (String nom){
        super(jeu.nom, 500, 500, 2);

    }
    @Override
    public int attaquer() {
        System.out.println(jeu.nom + "plante sa lame secrete dans l'adversaire");
    }


    public Runnable objet2() {
        return null;
    }

    @Override
    public void objet(){
        super.objet();
        objets.add(objet2());
    }
}
