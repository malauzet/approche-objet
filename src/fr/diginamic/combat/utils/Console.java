package fr.diginamic.combat.utils;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    public static int lireChoix() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void fermer() {
        scanner.close();
    }
}
