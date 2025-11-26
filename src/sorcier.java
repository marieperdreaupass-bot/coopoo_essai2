import java.util.ArrayList;
import java.util.List;

public class sorcier extends perso {

    //Attribut spécifique au Sorcier :
    protected int mana;
    private List<Sort> grimoire;

    //Définition des constantes de classe
    private static final int PV_DEFAUT = 300;
    private static final int DEGATS_DEFAUT = 150;
    private static final int VITESSE_DEFAUT = 5;
    private static final int MANA_DEFAUT = 500;

        public sorcier(String Nom) {
            super(jeu.nom, PV_DEFAUT, DEGATS_DEFAUT, VITESSE_DEFAUT);
            this.mana = MANA_DEFAUT;
            this.grimoire = new ArrayList<>();
            this.grimoire.add(new Sort("Boule de feu", 20, 45));
        }






        @Override
        public void attaquer() {
            System.out.println(jeu.nom + "lance un sort");
        }
    }

