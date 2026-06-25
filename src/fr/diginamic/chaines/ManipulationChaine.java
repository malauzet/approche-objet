package fr.diginamic.chaines;

import fr.diginamic.entites.Salarie;

import java.util.Arrays;

public class ManipulationChaine {
    static void main() {

        String chaine = "Durand;Marcel;2 523.5";

        // 1)
        char premierCaractere = chaine.charAt(0);
        System.out.println("Premier caractère: " + premierCaractere);

        // 2)
        int chaineLongueur = chaine.length();
        System.out.println("Longueur de la chaine : " + chaineLongueur);

        // 3)
        int premierPointVirgule = chaine.indexOf(';');
        System.out.println("Première apparition de ';' : " + premierPointVirgule);

        // 4)
        String nom = chaine.substring(0, chaine.indexOf(';'));
        System.out.println("Nom de famille : " + nom);

        // 5)
        System.out.println("Nom de famille en majuscule : " + nom.toUpperCase());

        // 6)
        System.out.println("Nom de famille en miniscule : " + nom.toLowerCase());

        // 7)
        String[] chaineTableau = chaine.split(";");
        System.out.println("Chaine sous forme de tableau : " + Arrays.toString(chaineTableau));

        // 9)
        String nomSalarie = chaineTableau[0];
        String prenomSalarie = chaineTableau[1];
        String salaireStr = chaineTableau[2].replace(" ", "");
        double salaire = Double.parseDouble(salaireStr);

        Salarie salarie = new Salarie(nomSalarie, prenomSalarie, salaire);

        System.out.println("Nom : " + salarie.getNom());
        System.out.println("Prénom : " + salarie.getPrenom());
        System.out.println("Salaire : " + salarie.getSalaire());
    }
}
