package fr.diginamic.combat.entites;

import fr.diginamic.combat.utils.Utils;

/**
 * Classe abstraite représentant toute entité pouvant participer à un combat.
 * <p>
 * Une entité possède une force fixée à la création et des points de vie
 * qui évoluent au fil des combats et des soins.
 * </p>
 */
public abstract class Entites {

    /**
     * Force de l'entité, définie à la création et immuable.
     * Elle sert de base au calcul des dégâts infligés lors d'une attaque.
     */
    private final int force;

    /**
     * Points de vie courants de l'entité.
     * Diminuent lors des combats et peuvent augmenter via des soins ou des potions.
     */
    private int pointsDeVie;

    // Constructeur ---------------------------------------------------------------------------------
    /**
     * Construit une entité avec une force et des points de vie initiaux.
     *
     * @param force       valeur de la force de l'entité (immuable)
     * @param pointsDeVie points de vie de départ
     */
    public Entites(int force, int pointsDeVie) {
        this.force = force;
        this.pointsDeVie = pointsDeVie;
    }

    // Getters --------------------------------------------------------------------------------------
    /**
     * Retourne la force de l'entité.
     *
     * @return la force (valeur immuable)
     */
    public int getForce() {
        return force;
    }

    /**
     * Retourne les points de vie courants de l'entité.
     *
     * @return les points de vie actuels
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    // Setters --------------------------------------------------------------------------------------
    /**
     * Modifie les points de vie de l'entité.
     * <p>
     * Accès restreint aux sous-classes afin de contrôler les modifications
     * (soins, dégâts) via les méthodes dédiées.
     * </p>
     *
     * @param pointsDeVie nouvelle valeur des points de vie
     */
    protected void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    // Méthodes -------------------------------------------------------------------------------------

    /**
     * Calcule la valeur d'attaque de l'entité pour un round de combat.
     * <p>
     * L'attaque est égale à la force de l'entité augmentée d'un nombre
     * aléatoire compris entre 1 et 10 inclus.
     * </p>
     *
     * @return la valeur d'attaque calculée
     */
    public int calculerAttaque() {
        return force + Utils.genererNombreAleatoire(1, 10);
    }

    /**
     * Applique des dégâts à l'entité en soustrayant la valeur donnée
     * à ses points de vie courants.
     * <p>
     * Les dégâts correspondent à la différence entre l'attaque du vainqueur
     * du round et celle du perdant.
     * </p>
     *
     * @param degats montant des dégâts à infliger (valeur positive)
     */
    public void subitDegats(int degats) {
        pointsDeVie -= degats;
    }

    /**
     * Indique si l'entité est encore en vie.
     *
     * @return {@code true} si les points de vie sont strictement supérieurs à 0,
     *         {@code false} sinon
     */
    public boolean estVivant() {
        return pointsDeVie > 0;
    }
}
