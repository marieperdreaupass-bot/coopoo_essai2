import java.util.ArrayList;
import java.util.List;

public class Guerrier extends Personnage {
    protected int rage = 500;
    private final List<CompRage> esprit;

    public Guerrier(String Nom) {
        super(Nom, 400, 60, 3);
        this.esprit = new ArrayList<>();
        this.esprit.add(new CompRage("Coup de paume : utilise la paume de votre hache pour frapper l'ennemi. ", 20, 120));
        this.esprit.add(new CompRage("Lame acérée : plantez votre lame dans votre enemi et touner la pour causer un maximum de souffrance. ", 250, 1200));
        this.esprit.add(new CompRage("Brise armure : viser les points faibles de votre ennemi pour briser son armure. ", 100, 350));
        this.esprit.add(new CompRage("Fracas sismique : sautez en l'air et frappez le sol de toute votre force. ", 380, 1100));
        this.esprit.add(new CompRage("Exécution d'Ares : renvoyez votre ennemi en enfer", 700, 1800));

        this.ajouterObjet(new Objet("Hache d'Artémis", degatsDeBase));
        this.ajouterObjet(new Objet("Potion de soulagement : calme votre esprit pour en récupérer 250 points de rage.", 250));
        this.ajouterObjet(new Objet("Potion de vie : vous permet de retrouver 500 PV", 500));
    }

    public void afficherEsprit() {
        System.out.println("\n--- Esprit de " + nom + " ---");
        for (int i = 0; i < esprit.size(); i++) {
            CompRage c = esprit.get(i);
            String statut = c.isUtilise() ? "[ÉPUISÉ]" : "(Rage: " + c.getCoutRage() + ")";
            System.out.println("[" + (i + 1) + "] " + c.getNom() + " " + statut + " | Dégâts: " + c.getDegats());
        }
    }

    @Override
    public int attaquer() {
        boolean estCritique = Math.random() < this.chanceCritique;
        int degatsFinaux = this.degatsDeBase;
        if (estCritique) {
            degatsFinaux = this.degatsDeBase * 2;
            System.out.println("⚡️ COUP CRITIQUE ! ⚡️");
            System.out.println(nom + " inflige un coup dévastateur de " + degatsFinaux + " dégâts avec sa hache !");
        } else {
            System.out.println(nom + " donne un coup de hache. (Puissance : " + degatsFinaux + ")");
        }
        return degatsFinaux;
    }

    public CompRage UtiliserCompetence(int index) {
        if (index < 0 || index >= this.esprit.size()) return null;
        CompRage comp = esprit.get(index);
        if (comp.isUtilise()) {
            System.out.println("⚠️ Cette technique a déjà été utilisée dans ce combat ! ⚠️");
            return null;
        }
        if (this.rage >= comp.getCoutRage()) {
            this.rage -= comp.getCoutRage();
            comp.setUtilise(true);
            return comp;
        } else {
            System.out.println("Pas assez de rage !");
            return null;
        }
    }

    public void resetToutesCompetences() {
        for (CompRage c : esprit) c.setUtilise(false);
    }

    @Override
    public void restaurerRessourceSpecifique(int montant) {
        this.rage = Math.min(500, this.rage + montant);
        System.out.println("Votre rage bouillonne à nouveau ! (Total : " + this.rage + ")");
    }

    @Override
    public void monterDeNiveau() {
        super.monterDeNiveau();
        this.rage += 100;
    }
}
