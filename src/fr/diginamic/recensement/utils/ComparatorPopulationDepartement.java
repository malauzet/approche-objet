package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.modele.Departement;

import java.util.Comparator;

public class ComparatorPopulationDepartement implements Comparator<Departement> {

    @Override
    public int compare(Departement d1, Departement d2) {
        return Long.compare(d2.getPopulationTotale(), d1.getPopulationTotale());
    }
}