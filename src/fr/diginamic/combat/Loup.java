package fr.diginamic.combat;

public class Loup extends Creature {

    public Loup() {
        super(Utils.genererNombreAleatoire(3, 8),
                Utils.genererNombreAleatoire(5, 10),
                "Loup",
                1
        );
    }
}
