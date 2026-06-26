package fr.diginamic.combat.entites.creatures;

import fr.diginamic.combat.utils.Utils;
import fr.diginamic.combat.entites.Creature;

public class Troll extends Creature {

    public Troll() {
        super(Utils.genererNombreAleatoire(10, 15),
                Utils.genererNombreAleatoire(20, 30),
                "Troll",
                5
        );
    }
}
