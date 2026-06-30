package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.modele.Region;

import java.util.Comparator;

public class ComparatorPopulationRegion implements Comparator<Region> {

    @Override
    public int compare(Region r1, Region r2) {
        return Long.compare(r2.getPopulationTotale(), r1.getPopulationTotale());
    }
}
