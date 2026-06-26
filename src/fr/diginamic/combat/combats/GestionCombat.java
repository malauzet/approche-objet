package fr.diginamic.combat.combats;

import fr.diginamic.combat.entites.Creature;
import fr.diginamic.combat.entites.Personnage;
import fr.diginamic.combat.entites.creatures.Gobelin;
import fr.diginamic.combat.entites.creatures.Loup;
import fr.diginamic.combat.entites.creatures.Troll;
import fr.diginamic.combat.utils.Console;
import fr.diginamic.combat.utils.Utils;

public class GestionCombat {

    private static boolean potionUtiliseeCeTour = false;

    public static void combattre(Personnage personnage) {
        if (personnage == null) {
            System.out.println("Veuillez d'abord créer un personnage (option 1).");
            return;
        }
        if (!personnage.estVivant()) {
            System.out.println("Votre personnage est mort. Score final : "
                    + personnage.getScore() + " points.");
            return;
        }

        potionUtiliseeCeTour = false;
        Creature creature = genererCreatureAleatoire();
        Combat combat = new Combat(personnage, creature);
        combat.lancerCombat();
    }

    public static void prendrePotion(Personnage personnage) {
        if (personnage == null) {
            System.out.println("Veuillez d'abord créer un personnage (option 1).");
            return;
        }
        if (!personnage.estVivant()) {
            System.out.println("Votre personnage est mort.");
            return;
        }
        if (!personnage.aDesPotion()) {
            System.out.println("Vous n'avez aucune potion dans votre inventaire.");
            return;
        }
        if (potionUtiliseeCeTour) {
            System.out.println("Vous avez déjà utilisé une potion avant ce combat.");
            return;
        }

        personnage.afficherInventaire();
        System.out.print("Choisissez une potion (numéro) : ");

        int choix = Console.lireChoix();
        boolean succes = personnage.utiliserPotion(choix - 1);

        if (!succes) {
            System.out.println("Numéro invalide.");
        } else {
            potionUtiliseeCeTour = true;
        }
    }

    private static Creature genererCreatureAleatoire() {
        int choix = Utils.genererNombreAleatoire(1, 3);
        return switch (choix) {
            case 1 -> new Loup();
            case 2 -> new Gobelin();
            default -> new Troll();
        };
    }
}
