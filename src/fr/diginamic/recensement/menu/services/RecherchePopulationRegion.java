package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Scanner;

public class RecherchePopulationRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("\nEntrez le nom de la région : ");
        String nomRegion = scanner.nextLine();

        int populationTotale = 0;
        boolean trouve = false;

        for (Ville ville : recensement.getVilles()) {
            if (ville.getNomRegion().equalsIgnoreCase(nomRegion)) {
                populationTotale += ville.getPopulationTotale();
                trouve = true;
            }
        }

        if (trouve) {
            System.out.println("\nPopulation de la région " + nomRegion + " : " + populationTotale + " habitants");
        } else {
            System.out.println("\nRégion introuvable : " + nomRegion);
        }
    }
}
