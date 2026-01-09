public class Miniboss extends Monstre {
    private String zone;

    public Miniboss(String name, int pv, int attaque, int vitesse, int exp, String zone) {
        super(name, pv, attaque, vitesse, exp);
        this.zone = zone;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println("\n🔱 Le gardien du " + zone + " se déchaîne !");
        super.attaquer(cible);
    }
}