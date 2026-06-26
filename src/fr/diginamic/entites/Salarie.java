package fr.diginamic.entites;

public record Salarie(String nom, String prenom, double salaire) {}

// OU alors :
/*
public class Salarie {

    private final String nom;
    private final String prenom;
    private final double salaire;

    public Salarie(String nom, String prenom, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public double getSalaire() {
        return salaire;
    }

}
*/
