package fr.diginamic.entites;

public class Theatre {

    private final String nom;
    private final int capaciteMax;
    private int clientsInscrits;
    private double recette;

    // Constructeur ------------------------------------------------------------------------------
    public Theatre(String nom, int capaciteMax) {
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.clientsInscrits = 0;
        this.recette = 0;
    }

    // Getters -----------------------------------------------------------------------------------
    public int getClientsInscrits() {
        return clientsInscrits;
    }

    public double getRecette() {
        return recette;
    }

    public String getNom() {return nom;}

    // Méthodes ----------------------------------------------------------------------------------
    public void inscrire(int nbClients, double prixPlace) {

        if (clientsInscrits == capaciteMax) {
            System.out.println("Erreur : La capacité maximale du théâtre (" + capaciteMax + " personnes) est atteinte.");
            System.out.println();
        }
        else if (clientsInscrits + nbClients <= capaciteMax) {
            clientsInscrits += nbClients;
            recette += nbClients * prixPlace;

            System.out.println(nbClients + " client(s) inscrit(s).");
            System.out.println("Total clients : " + clientsInscrits);
            System.out.println("Recette totale : " + recette + " €");
            System.out.println();
        }
        else {
            System.out.println("Erreur : Impossible d'ajouter " + nbClients + " personne(s), seulement " + (capaciteMax - clientsInscrits) + " place(s) restante(s).");
            System.out.println();
        }
    }
}
