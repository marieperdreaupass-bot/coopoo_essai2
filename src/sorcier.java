public class sorcier extends perso {

        private int magie;

        public sorcier(String Nom) {
            super(nom, 300, 500, 2);
        }

        @Override
        public void attaquer() {
            System.out.println(nom + "lance un sort");
        }
    }

