package fr.diginamic.combat;

public class Menu {

    private Personnage personnage = null;

    public void demarrer() {
        int choix = -1;

        while (choix != 5) {
            afficherMenu();
            choix = Console.lireChoix();

            switch (choix) {
                case 1 -> personnage = creerPersonnage();
                case 2 -> GestionCombat.combattre(personnage);
                case 3 -> afficherScore();
                case 4 -> GestionCombat.prendrePotion(personnage);
                case 5 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide, veuillez réessayer.");
            }
        }

        Console.fermer();
    }

    private Personnage creerPersonnage() {
        Personnage p = new Personnage();
        System.out.println("Personnage créé avec succès !");
        System.out.println("Force         : " + p.getForce());
        System.out.println("Points de vie : " + p.getPointsDeVie());
        System.out.println("Score         : " + p.getScore());
        p.afficherInventaire();
        return p;
    }

    private void afficherScore() {
        if (personnage == null) {
            System.out.println("Aucun personnage n'existe encore.");
            return;
        }
        System.out.println("Score actuel : " + personnage.getScore() + " points.");
        System.out.println("PV restants  : " + personnage.getPointsDeVie());
    }

    private static void afficherMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Créer le personnage");
        System.out.println("2. Combattre une créature");
        System.out.println("3. Afficher le score");
        System.out.println("4. Prendre une potion");
        System.out.println("5. Sortir");
        System.out.println("==========================");
        System.out.print("Votre choix : ");
    }
}
