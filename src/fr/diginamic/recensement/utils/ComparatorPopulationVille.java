package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.modele.Ville;

import java.util.Comparator;

public class ComparatorPopulationVille implements Comparator<Ville> {

    @Override
    public int compare(Ville v1, Ville v2) {
        return Integer.compare(v2.getPopulationTotale(), v1.getPopulationTotale());
    }
}
