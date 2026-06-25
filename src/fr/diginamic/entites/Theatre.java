package fr.diginamic.entites;

public class Theatre {

    private String nom;
    private int capaciteMax;
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

    // Méthodes ----------------------------------------------------------------------------------
    public void inscrire(int nbClients, double prixPlace) {

        if (clientsInscrits + nbClients <= capaciteMax) {
            clientsInscrits += nbClients;
            recette += nbClients * prixPlace;

            System.out.println(nbClients + " client(s) inscrit(s).");
            System.out.println("Total clients : " + clientsInscrits);
            System.out.println("Recette totale : " + recette + " €");
            System.out.println();
        } else {
            System.out.println("Erreur : capacité maximale du théâtre atteinte ou dépassée.");
            System.out.println();
        }
    }
}
