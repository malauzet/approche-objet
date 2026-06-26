package fr.diginamic.combat;

import java.util.Scanner;

public class Jeu {

    private static Personnage personnage = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean potionUtiliseeCeTour = false;

    static void main() {

        int choix = -1;

        while (choix != 5) {
            afficherMenu();
            choix = lireChoix();

            switch (choix) {
                case 1 -> creerPersonnage();
                case 2 -> combattre();
                case 3 -> afficherScore();
                case 4 -> prendrePotion();
                case 5 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide, veuillez réessayer.");
            }
        }

        scanner.close();
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

    private static int lireChoix() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void creerPersonnage() {

        personnage = new Personnage();

        System.out.println("Personnage créé avec succès !");
        System.out.println("Force           : " + personnage.getForce());
        System.out.println("Points de vie   : " + personnage.getPointsDeVie());
        System.out.println("Score           : " + personnage.getScore());

        personnage.afficherInventaire();
    }

    private static void combattre() {

        if (personnage == null) {
            System.out.println("Veuillez d'abord créer un personnage (option 1).");
            return;
        }

        if (!personnage.estVivant()) {
            System.out.println("Votre personnage est mort. Il a obtenu le score de "
                    + personnage.getScore() + " points. Veuillez créer un nouveau personnage.");
            return;
        }

        potionUtiliseeCeTour = false;
        Creature creature = genererCreatureAleatoire();
        Combat combat = new Combat(personnage, creature);
        combat.lancerCombat();
    }

    private static Creature genererCreatureAleatoire() {
        int choix = Utils.genererNombreAleatoire(1, 3);
        return switch (choix) {
            case 1 -> new Loup();
            case 2 -> new Gobelin();
            default -> new Troll();
        };
    }

    private static void afficherScore() {
        if (personnage == null) {
            System.out.println("Aucun personnage n'existe encore.");
            return;
        }
        System.out.println("Score actuel : " + personnage.getScore() + " points.");
        System.out.println("PV restants  : " + personnage.getPointsDeVie());
    }

    private static void prendrePotion() {

        if (personnage == null) {
            System.out.println("Veuillez d'abord créer un personnage (option 1).");
            return;
        }
        if (!personnage.aDesPotion()) {
            System.out.println("Vous n'avez aucune potion dans votre inventaire.");
            return;
        }
        if (potionUtiliseeCeTour) {
            System.out.println("Vous avez déjà utilisé une potion ce tour.");
            return;
        }

        personnage.afficherInventaire();
        System.out.print("Choisissez une potion (numéro) : ");

        int choix = lireChoix();
        boolean succes = personnage.utiliserPotion(choix - 1);

        if (!succes) {
            System.out.println("Numéro invalide.");
        }
        else {
            potionUtiliseeCeTour = true;
        }
    }
}
