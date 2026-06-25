package fr.diginamic.essais;

import fr.diginamic.salaire.Pigiste;
import fr.diginamic.salaire.Salarie;

public class TestIntervenant {
    static void main() {

        Salarie salarie1 = new Salarie("Jean", "Pont", 2252.17);
        Pigiste pigiste2 = new Pigiste("Isabelle", "Durand",10, 205.25);

        System.out.println("Le salarié gagne " + String.format("%.2f", salarie1.getSalaire()) + " par mois.");
        System.out.println("Le pigiste gagne " + String.format("%.2f", pigiste2.getSalaire()) + " par mois.");

        System.out.println("----------------------------------------------");

        salarie1.afficherDonnees();

        System.out.println("----------------------------------------------");

        pigiste2.afficherDonnees();
    }
}
