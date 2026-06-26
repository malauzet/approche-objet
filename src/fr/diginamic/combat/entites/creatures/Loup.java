package fr.diginamic.combat.entites.creatures;

import fr.diginamic.combat.utils.Utils;
import fr.diginamic.combat.entites.Creature;

public class Loup extends Creature {

    public Loup() {
        super(Utils.genererNombreAleatoire(3, 8),
                Utils.genererNombreAleatoire(5, 10),
                "Loup",
                1
        );
    }
}
