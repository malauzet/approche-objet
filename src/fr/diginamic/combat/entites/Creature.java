package fr.diginamic.combat.entites;

public abstract class Creature extends Entites {

    private final String nom;
    private final int points;

    public Creature(int force, int pointsDeVie, String nom, int points) {
        super(force, pointsDeVie);
        this.nom = nom;
        this.points = points;
    }

    public String getNom() {
        return nom;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return nom + " [Force = " + getForce() + ", PV = " + getPointsDeVie() + "]";
    }
}
