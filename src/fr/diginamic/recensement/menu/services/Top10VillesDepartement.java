package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.ComparatorPopulationVille;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Top10VillesDepartement extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("\nEntrez le code du département : ");
        String codeDepartement = scanner.nextLine();

        List<Ville> villesDuDepartement = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {
            if (ville.getCodeDepartement().equalsIgnoreCase(codeDepartement)) {
                villesDuDepartement.add(ville);
            }
        }

        villesDuDepartement.sort(new ComparatorPopulationVille());

        System.out.println("————————————————————————————————————————————————————————————————");
        for (int i = 0; i < 10 && i < villesDuDepartement.size(); i++) {
            System.out.println((i + 1) + ". " + villesDuDepartement.get(i));
        }
        System.out.println("————————————————————————————————————————————————————————————————");
    }
}