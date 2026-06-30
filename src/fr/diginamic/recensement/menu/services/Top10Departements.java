package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Departement;
import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.ComparatorPopulationDepartement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Top10Departements extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        List<Departement> departements = new ArrayList<>();

        for (Ville ville : recensement.getVilles()) {

            Departement departement = trouverDepartement(departements, ville.getCodeDepartement());

            if (departement == null) {
                departement = new Departement(ville.getCodeDepartement(), 0);
                departements.add(departement);
            }

            departement.setPopulationTotale(departement.getPopulationTotale() + ville.getPopulationTotale());
        }

        departements.sort(new ComparatorPopulationDepartement());

        System.out.println("————————————————————————————————————————————————————————————————");
        for (int i = 0; i < 10 && i < departements.size(); i++) {
            System.out.println((i + 1) + ". " + departements.get(i));
        }
        System.out.println("————————————————————————————————————————————————————————————————");
    }

    private Departement trouverDepartement(List<Departement> departements, String codeDepartement) {
        for (Departement departement : departements) {
            if (departement.getCodeDepartement().equalsIgnoreCase(codeDepartement)) {
                return departement;
            }
        }
        return null;
    }
}