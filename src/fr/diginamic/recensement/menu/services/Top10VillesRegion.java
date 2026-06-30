package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.ComparatorPopulationVille;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Top10VillesRegion extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        System.out.print("\nEntrez le nom de la région : ");
        String nomRegion = scanner.nextLine();

        List<Ville> villesDeLaRegion = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {
            if (ville.getNomRegion().equalsIgnoreCase(nomRegion)) {
                villesDeLaRegion.add(ville);
            }
        }

        villesDeLaRegion.sort(new ComparatorPopulationVille());

        System.out.println("————————————————————————————————————————————————————————————————");
        for (int i = 0; i < 10 && i < villesDeLaRegion.size(); i++) {
            System.out.println((i + 1) + ". " + villesDeLaRegion.get(i));
        }
        System.out.println("————————————————————————————————————————————————————————————————");
    }
}
