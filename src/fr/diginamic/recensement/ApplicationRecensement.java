package fr.diginamic.recensement;

import fr.diginamic.recensement.menu.MenuPrincipal;
import fr.diginamic.recensement.menu.services.*;
import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.chargement.RecensementLoader;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationRecensement {

    static void main() throws IOException {

        RecensementLoader loader = new RecensementLoader();
        Recensement recensement = loader.charger("resources/recensement.csv");

        System.out.println(recensement.getVilles().size() + " villes chargées.");

        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal();
        boolean continuer = true;

        while (continuer) {

            menu.afficher();
            int choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    MenuService recherchePopulationVille = new RecherchePopulationVille();
                    recherchePopulationVille.traiter(recensement, scanner);
                    break;

                case 2:
                    MenuService recherchePopulationDepartement = new RecherchePopulationDepartement();
                    recherchePopulationDepartement.traiter(recensement, scanner);
                    break;

                case 3:
                    MenuService recherchePopulationRegion = new RecherchePopulationRegion();
                    recherchePopulationRegion.traiter(recensement, scanner);
                    break;

                case 4:
                    MenuService top10Regions = new Top10Regions();
                    top10Regions.traiter(recensement, scanner);
                    break;

                case 5:
                    MenuService top10Departements = new Top10Departements();
                    top10Departements.traiter(recensement, scanner);
                    break;

                case 6:
                    MenuService top10VillesDepartement = new Top10VillesDepartement();
                    top10VillesDepartement.traiter(recensement, scanner);
                    break;

                case 7:
                    MenuService top10VillesRegion = new Top10VillesRegion();
                    top10VillesRegion.traiter(recensement, scanner);
                    break;

                case 8:
                    MenuService top10VillesFrance = new Top10VillesFrance();
                    top10VillesFrance.traiter(recensement, scanner);
                    break;

                case 9:
                    continuer = false;
                    System.out.println("\nAu revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }

            System.out.println();
        }

        scanner.close();
    }
}