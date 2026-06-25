package fr.diginamic.combat;

public class Troll extends Creature {

    public Troll() {
        super(Utils.genererNombreAleatoire(10, 15),
                Utils.genererNombreAleatoire(20, 30),
                "Troll",
                5
        );
    }
}
