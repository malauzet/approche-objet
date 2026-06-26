package fr.diginamic.combat.potions;

import fr.diginamic.combat.entites.Personnage;

public abstract class Potion {

    private final String nom;
    private final String description;

    public Potion(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public abstract String appliquer(Personnage personnage);

    @Override
    public String toString() {
        return nom + " : " + description;
    }
}