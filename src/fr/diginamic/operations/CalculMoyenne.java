package fr.diginamic.operations;

public class CalculMoyenne {

    private double[] tableauDoubles;
    private int taille;

    public CalculMoyenne() {
        tableauDoubles = new double[2];
        taille = 0;
    }

    public void ajout(double valeur) {

        if (taille == tableauDoubles.length) {

            double[] nouveauTableauDoubles = new double[tableauDoubles.length * 2];

            for (int i = 0; i < tableauDoubles.length; i++) {
                nouveauTableauDoubles[i] = tableauDoubles[i];
            }

            tableauDoubles = nouveauTableauDoubles;
        }

        tableauDoubles[taille] = valeur;
        taille++;
    }

    public double calcul() {

        if (taille == 0) {
            return 0.0;
        }

        double somme = 0;

        for (int i = 0; i < taille; i++) {
            somme += tableauDoubles[i];
        }

        return somme / taille;
    }
}
