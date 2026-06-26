package fr.diginamic.combat.combats;

import fr.diginamic.combat.entites.Creature;
import fr.diginamic.combat.entites.Personnage;
import fr.diginamic.combat.potions.PotionAttaqueMajeure;
import fr.diginamic.combat.potions.PotionAttaqueMineure;
import fr.diginamic.combat.potions.PotionSoin;
import fr.diginamic.combat.utils.Utils;

public class Combat {

    private static final double CHANCE_RECOMPENSE = 0.5; // 50% de drop actuellement

    private final Personnage personnage;
    private final Creature creature;

    public Combat(Personnage personnage, Creature creature) {
        this.personnage = personnage;
        this.creature = creature;
    }

    public void lancerCombat() {

        personnage.decrementerBonusAttaque();

        int compteur = 1;

        afficherDebutCombat();

        while(personnage.estVivant() && creature.estVivant()) {
            System.out.println("===== Tour n°" + compteur + " =====");
            jouerTour();
            compteur++;
        }

        if (!personnage.estVivant()) {
            gererDefaitePersonnage();
        }
    }

    private void afficherDebutCombat() {
        System.out.println("\n⚔️  Début du combat contre : " + creature);
        if (personnage.getBonusAttaque() > 0) {
            System.out.println("(Bonus d'attaque actif : +" + personnage.getBonusAttaque() + ")");
        }
    }

    private void jouerTour() {
        int attaquePersonnage = personnage.calculerAttaque();
        int attaqueCreature = creature.calculerAttaque();
        int degats = calculerDegats(attaquePersonnage, attaqueCreature);

        System.out.println("Attaque Personnage : " + attaquePersonnage);
        System.out.println("Attaque Creature : " + attaqueCreature);

        if (degats > 0) {
            creature.subitDegats(degats);
            System.out.println(creature.getNom() + " subit " + degats + " dégâts."
                    + " (PV restants : " + creature.getPointsDeVie() + ")");
            if(!creature.estVivant()) gererVictoirePersonnage();
        }
        else if (degats < 0) {
            int degatsSubis = -degats;
            personnage.subitDegats(degatsSubis);
            System.out.println("Personnage subit " + degatsSubis + " dégâts."
                    + " (PV restants : " + personnage.getPointsDeVie() + ")");
        }
        else System.out.println("Égalité ! Aucun dégât ce tour.");

        System.out.println("====================");
    }

    private int calculerDegats(int attaquePersonnage, int attaqueCreature) {
        return attaquePersonnage - attaqueCreature;
    }

    private void gererVictoirePersonnage() {
        personnage.ajouterScore(creature.getPoints());
        System.out.println("🏆 Victoire !! Vous battez le " + creature.getNom()
                + " et gagnez " + creature.getPoints() + " points.");
        System.out.println("Score total : " + personnage.getScore() + " points.");
        tenterRecompense();
    }

    private void gererDefaitePersonnage() {
        System.out.println("💀 Défaite... Vous finissez la partie avec " + personnage.getScore() + " points.");
    }

    private void tenterRecompense() {

        double tirage = Math.random();

        if (tirage > CHANCE_RECOMPENSE) {
            System.out.println("Pas de récompense cette fois...");
            return;
        }

        System.out.println("\n🎁 Vous avez obtenu une récompense !");

        int choix = Utils.genererNombreAleatoire(1, 4);

        switch (choix) {
            case 1 -> personnage.ajouterPotion(new PotionSoin());
            case 2 -> personnage.ajouterPotion(new PotionAttaqueMineure());
            case 3 -> personnage.ajouterPotion(new PotionAttaqueMajeure());
            case 4 -> {
                personnage.ajouterScore(5);
                System.out.println("Vous gagnez 5 points bonus ! Score : " + personnage.getScore());
            }
        }
    }
}