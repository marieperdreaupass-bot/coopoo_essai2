public class Boss extends Monstre {

    public Boss() {
        super("Hades",3000, 300, 666, 0);
    }

    public void colereOlympienne(Personnage cible) {
        System.out.println(this.name + " déchaîne la colère des enfers !");
        int degatsSpeciaux = this.attaque * 2;
        cible.recevoirDegats(degatsSpeciaux);
        System.out.println("Dégâts dévastateurs : " + degatsSpeciaux);
    }

    @Override
    public void attaquer(Personnage cible) {
        if (Math.random() < 0.2) {
            colereOlympienne(cible);
        } else {
            System.out.println("\n💀 Hades frappe avec son bident !");
            super.attaquer(cible);
        }
    }
}

