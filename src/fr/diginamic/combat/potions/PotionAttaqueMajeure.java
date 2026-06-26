package fr.diginamic.combat.potions;

import fr.diginamic.combat.entites.Personnage;

public class PotionAttaqueMajeure extends Potion {

    public PotionAttaqueMajeure() {
        super("Potion d'attaque majeure", "+5 en force pour 2 combats");
    }

    @Override
    public String appliquer(Personnage personnage) {
        personnage.ajouterBonusAttaque(5, 2);
        return "Votre force augmente de 5 pour les 2 prochains combats !";
    }
}