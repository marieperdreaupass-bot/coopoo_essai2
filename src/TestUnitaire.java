public class TestUnitaire {

    public static void main(String[] args) {
        System.out.println("--- DÉBUT DES TESTS UNITAIRES ---");

        testSoinCapPlafond();
        testMortPersonnage();
        testUtilisationObjet();

        System.out.println("--- FIN DES TESTS ---");
    }

    public static void testSoinCapPlafond() {
        System.out.print("Test 1 (Soin Max) : ");
        Guerrier g = new Guerrier("TestMan");
        // PV Max du Guerrier = 400
        g.recevoirDegats(50); // 350 PV
        g.recevoirSoin(1000); // Tente de soigner énormément

        if (g.getPV() == 400) {
            System.out.println("✅ SUCCÈS (PV bloqués au max)");
        } else {
            System.err.println("❌ ÉCHEC (PV actuels : " + g.getPV() + ")");
        }
    }

    public static void testMortPersonnage() {
        System.out.print("Test 2 (Mort) : ");
        Sorcier s = new Sorcier("Gandalf");
        s.recevoirDegats(9999); // Dégâts massifs

        if (s.estMort() && s.getPV() == 0) {
            System.out.println("✅ SUCCÈS (Personnage bien mort)");
        } else {
            System.err.println("❌ ÉCHEC (Le personnage est encore vivant ou PV < 0)");
        }
    }

    public static void testUtilisationObjet() {
        System.out.print("Test 3 (Inventaire) : ");
        Assassin a = new Assassin("Altair");
        int tailleInventaireAvant = a.getInventaire().size();

        // On ajoute un objet factice
        a.ajouterObjet(new Objet("TestPotion", 50));

        if (a.getInventaire().size() == tailleInventaireAvant + 1) {
            System.out.println("✅ SUCCÈS (Objet ajouté)");
        } else {
            System.err.println("❌ ÉCHEC (Taille inventaire incorrecte)");
        }
    }
}
