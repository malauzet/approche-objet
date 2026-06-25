package fr.diginamic.combat;

public class Gobelin extends Creature {

    public Gobelin() {
        super(Utils.genererNombreAleatoire(5, 10),
                Utils.genererNombreAleatoire(10, 15),
                "Gobelin",
                2
        );
    }
}
