public class sorcier extends perso {

        private int magie;

        public sorcier(String Nom) {
            super(jeu.nom, 300, 500);
        }

        @Override
        public void attaquer() {
            System.out.println(jeu.nom + "lance un sort");
        }
    }

