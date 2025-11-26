import java.util.ArrayList;
import java.util.List;

public class sorcier extends perso {

    //Attribut spécifique au Sorcier :
    protected int mana;
    private final List<Sort> grimoire;

    //Définition des constantes de classe
    private static final int PV_DEFAUT = 300;
    private static final int DEGATS_DEFAUT = 150;
    private static final int VITESSE_DEFAUT = 5;
    private static final int MANA_DEFAUT = 500;

        public sorcier(String Nom) {
            super(Nom,300, 150, 5);
            this.mana = MANA_DEFAUT;
            //Remplissage du grimoire
            this.grimoire = new ArrayList<>();
            this.grimoire.add(new Sort("Boule de feu", 20, 45));
            //Remplissage de l'inventaire
            this.ajouterObjet("Grimoire Radiant");
            this.ajouterObjet("Potion de mana");
            this.ajouterObjet("Potion de vie");
        }

        //Afficher les sorts dans le grimoire
        public void afficherGrimoire(){
            System.out.println("--- Grimoire de " + this.jeuNom + " ---");
            if(grimoire.isEmpty()){
                System.out.println("Le grimoire est vide.");
                return;
            }
        for(int i = 0; i < grimoire.size(); i++){
            Sort sortActuel = grimoire.get(i);
            System.out.println("[" + i+1 + "]" + sortActuel.getNom() + "|Mana : " + sortActuel.getCoutMana() + "| Dégâts : " + sortActuel.getDegats());
        }
        }

        //Polymorphisme de la méthode attaquer()
        @Override
        public int attaquer() {
            System.out.println(this.jeuNom + "lance un sort simple.");
            return this.degatsDeBase;
        }

        //Lancer un sort
        public Sort lancerSort(int index) {
            if(index < 0 || index >= this.grimoire.size()){
                return null;
            }
            //Récupération du sort sélectionné
            else {
                return grimoire.get(index);
            }
            //Récupération du sort sélectionné


        }
    }

