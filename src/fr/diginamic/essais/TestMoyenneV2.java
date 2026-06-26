package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenneV2;
import java.util.Random;
import java.util.Arrays;

public class TestMoyenneV2 {

    private static final Random RANDOM = new Random();

    static void main() {

        // === Test n°1 : tableau vide ===
        System.out.println("===== Test n°1 : tableau vide =====");
        CalculMoyenneV2 test1 = new CalculMoyenneV2();
        System.out.println("Tableau : []");
        System.out.println("Résultat attendu : 0.0");
        System.out.println("Résultat obtenu  : " + test1.calcul());

        System.out.println();

        // === Test n°2 : nombres positifs ===
        System.out.println("===== Test n°2 : nombres positifs =====");
        CalculMoyenneV2 test2 = new CalculMoyenneV2();
        int taille2 = random(1, 10);
        double[] valeurs2 = new double[taille2];
        double somme2 = 0;
        for (int i = 0; i < taille2; i++) {
            valeurs2[i] = random(0, 100);
            somme2 += valeurs2[i];
            test2.ajout(valeurs2[i]);
        }
        System.out.println("Tableau : " + Arrays.toString(valeurs2));
        System.out.println("Résultat attendu : " + String.format("%.2f", somme2 / taille2));
        System.out.println("Résultat obtenu  : " + String.format("%.2f", test2.calcul()));

        System.out.println();

        // === Test n°3 : nombres positifs et négatifs ===
        System.out.println("===== Test n°3 : nombres positifs et négatifs =====");
        CalculMoyenneV2 test3 = new CalculMoyenneV2();
        int taille3 = random(1, 10);
        double[] valeurs3 = new double[taille3];
        double somme3 = 0;
        for (int i = 0; i < taille3; i++) {
            valeurs3[i] = random(-100, 100);
            somme3 += valeurs3[i];
            test3.ajout(valeurs3[i]);
        }
        System.out.println("Tableau : " + Arrays.toString(valeurs3));
        System.out.println("Résultat attendu : " + String.format("%.2f", somme3 / taille3));
        System.out.println("Résultat obtenu  : " + String.format("%.2f", test3.calcul()));
    }

    public static int random(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}