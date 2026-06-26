package fr.diginamic.combat;

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

    public String getDescription() {
        return description;
    }

    public abstract String appliquer(Personnage personnage);

    @Override
    public String toString() {
        return nom + " : " + description;
    }
}