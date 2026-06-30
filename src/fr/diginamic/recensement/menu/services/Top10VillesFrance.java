package fr.diginamic.recensement.menu.services;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;
import fr.diginamic.recensement.utils.ComparatorPopulationVille;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Top10VillesFrance extends MenuService {

    @Override
    public void traiter(Recensement recensement, Scanner scanner) {

        List<Ville> toutesLesVilles = new ArrayList<>(recensement.getVilles());

        toutesLesVilles.sort(new ComparatorPopulationVille());

        System.out.println("————————————————————————————————————————————————————————————————");
        for (int i = 0; i < 10 && i < toutesLesVilles.size(); i++) {
            System.out.println((i + 1) + ". " + toutesLesVilles.get(i));
        }
        System.out.println("————————————————————————————————————————————————————————————————");
    }
}