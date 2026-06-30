package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Scanner;

public class RecherchePopulationDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("\nEntrez le code du département : ");
        String codeDepartement = scanner.nextLine();

        int populationTotale = 0;
        boolean trouve = false;

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equalsIgnoreCase(codeDepartement)) {
                populationTotale += ville.getPopulationTotale();
                trouve = true;
            }
        }

        if (trouve) {
            System.out.println("\nPopulation du département " + codeDepartement + " : " + populationTotale + " habitants");
        } else {
            System.out.println("\nDépartement introuvable : " + codeDepartement);
        }
    }
}
