package fr.diginamic.combat;

public abstract class Entites {

    private final int force;
    private int pointsDeVie;

    public Entites(int force, int pointsDeVie) {
        this.force = force;
        this.pointsDeVie = pointsDeVie;
    }

    public int getForce() {
        return force;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    protected void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int calculerAttaque() {
        return force + Utils.genererNombreAleatoire(1, 10);
    }

    public void subitDegats(int degats) {
        pointsDeVie -= degats;
    }

    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
