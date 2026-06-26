package fr.diginamic.combat;

public abstract class Entites {

    /**
     * Force de l'entité, ne change pas une fois généré
     */
    private final int force;

    /**
     * Points de vie de l'entité qui change avec les combats et potions
     */
    private int pointsDeVie;

    // Constructeur ---------------------------------------------------------------------------------
    public Entites(int force, int pointsDeVie) {
        this.force = force;
        this.pointsDeVie = pointsDeVie;
    }

    // Getters --------------------------------------------------------------------------------------
    public int getForce() {
        return force;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    // Setters --------------------------------------------------------------------------------------
    protected void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    // Méthodes -------------------------------------------------------------------------------------

    /**
     * Méthode qui calcul l'attaque d'une entité
     * attaque = force de l'entité + un nombre aléatoire entre 1 et 10 compris
     * @return l'attaque de l'entité
     */
    public int calculerAttaque() {
        return force + Utils.genererNombreAleatoire(1, 10);
    }

    /**
     * Méthode qui soustrait les dégâts subis aux points de vie de l'entité
     * @param degats = attaque entité1 — attaque entité2 (si attaque entité1 > attaque entité2 sinon on inverse)
     */
    public void subitDegats(int degats) {
        pointsDeVie -= degats;
    }

    /**
     * Méthode pour vérifier qu'une entité est vivante
     * On regarde si ses points de vie sont > 0
     * @return true si vivant
     */
    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
