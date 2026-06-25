package fr.diginamic.essais;

import fr.diginamic.entites.Theatre;

public class TestTheatre {
    static void main() {

        Theatre theatre = new Theatre("Le Petit Théâtre", 100);

        theatre.inscrire(30, 15.0);
        theatre.inscrire(25, 15.0);
        theatre.inscrire(20, 15.0);
        theatre.inscrire(15, 15.0);
        theatre.inscrire(20, 15.0);

        System.out.println("Total de clients inscrits : " + theatre.getClientsInscrits());
        System.out.println("Recette totale de l'établissement : " + theatre.getRecette() + " €");
    }
}
