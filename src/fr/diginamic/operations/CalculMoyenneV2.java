package fr.diginamic.operations;

import java.util.Arrays;

public class CalculMoyenneV2 {

    private double[] tableauDoubles = new double[0];

    public void ajout(double valeur) {
        tableauDoubles = Arrays.copyOf(tableauDoubles , tableauDoubles.length + 1);
        tableauDoubles[tableauDoubles.length-1] = valeur ;
    }

    public double calcul() {
        return Arrays.stream(tableauDoubles).average().orElse(0.0);
    }
}
