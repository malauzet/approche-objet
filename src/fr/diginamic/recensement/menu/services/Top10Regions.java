package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Region;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.ComparatorPopulationRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Top10Regions extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        List<Region> regions = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {

            Region region = trouverRegion(regions, ville.getCodeRegion());

            if (region == null) {
                region = new Region(ville.getCodeRegion(), ville.getNomRegion(), 0);
                regions.add(region);
            }

            region.setPopulationTotale(region.getPopulationTotale() + ville.getPopulationTotale());
        }

        regions.sort(new ComparatorPopulationRegion());

        System.out.println("————————————————————————————————————————————————————————————————");
        for (int i = 0; i < 10 && i < regions.size(); i++) {
            System.out.println((i + 1) + ". " + regions.get(i));
        }
        System.out.println("————————————————————————————————————————————————————————————————");
    }

    private Region trouverRegion(List<Region> regions, int codeRegion) {
        for (Region region : regions) {
            if (region.getCodeRegion() == codeRegion) {
                return region;
            }
        }
        return null;
    }
}
