package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.util.Scanner;

public class RecherchePopulationVille extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("\nEntrez le nom de la ville : ");
        String nomVille = scanner.nextLine();

        String nomVillePropre = nomVille.replace(" ", "");

        for (Ville ville : recensement.getVilles()) {

            String nomCommunePropre = ville.getNomCommune().replace(" ", "");

            if (nomCommunePropre.equalsIgnoreCase(nomVillePropre)) {
                System.out.println("\n" + ville.getNomCommune() + " : " + ville.getPopulationTotale() + " habitants");
                return;
            }
        }

        System.out.println("\nVille introuvable : " + nomVille);
    }
}
