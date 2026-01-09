public class TestUnitaire {

    public static void main(String[] args) {
        System.out.println("--- DÉBUT DES TESTS UNITAIRES ---\n");

        testSoinCapPlafond();
        testMortPersonnage();
        testUtilisationObjet();

        System.out.println("\n--- FIN DES TESTS ---");
    }

    // Test 1 : Vérifier que le soin ne dépasse pas le max
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

    // Test 2 : Vérifier la mort
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

    // Test 3 : Vérifier l'inventaire
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
