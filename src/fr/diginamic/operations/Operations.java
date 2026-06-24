package fr.diginamic.operations;

public class Operations {

    public static double calcul(double a, double b, char operateur) {

        return switch (operateur) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new ArithmeticException("Division par zéro impossible.");
                }
                yield a / b;
            }
            // Pas demandé, mais je le mets au cas où.
            default -> throw new IllegalArgumentException("Opérateur invalide : " + operateur);
        };
    }
}
