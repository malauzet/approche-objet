package fr.diginamic.recensement.chargement;

import fr.diginamic.recensement.modele.Recensement;
import fr.diginamic.recensement.modele.Ville;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecensementLoader {

    public Recensement charger(String nomFichier) throws IOException {

        Recensement recensement = new Recensement();

        Path chemin = Paths.get(nomFichier);
        List<String> lignes = Files.readAllLines(chemin);

        for (int i = 1; i < lignes.size(); i++) {

            String[] tokens = lignes.get(i).split(";");

            int codeRegion = Integer.parseInt(tokens[0].trim());
            String nomRegion = tokens[1];
            String codeDepartement = tokens[2];
            String codeCommune = tokens[5];
            String nomCommune = tokens[6];
            int populationTotale = Integer.parseInt(tokens[9].trim().replace(" ", ""));

            Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);

            recensement.ajouterVille(ville);
        }

        return recensement;
    }
}
