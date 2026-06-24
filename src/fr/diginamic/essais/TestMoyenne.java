package fr.diginamic.essais;

import fr.diginamic.operations.CalculMoyenne;

public class TestMoyenne {
    static void main() {

        System.out.println("===== Test n°1 =====");

        CalculMoyenne test1 = new CalculMoyenne();

        test1.ajout(10.0);
        test1.ajout(15.0);
        test1.ajout(20.0);
        test1.ajout(25.0);

        // 10 + 15 + 20 + 25 = 70
        // 70 / 4 = 17.5
        // Réponse attendue : "La moyenne est : 17.5"
        System.out.println("La moyenne est : " + test1.calcul());

        System.out.println();

        System.out.println("===== Test n°2 =====");

        CalculMoyenne test2 = new CalculMoyenne();

        test2.ajout(-10.3);
        test2.ajout(15.2);
        test2.ajout(9.8);
        test2.ajout(-5.7);

        // 15.2 + 9.8 - 10.3 - 5.7 = 9
        // 9 / 4 = 2.25
        // Réponse attendue : "La moyenne est : 2.25"
        System.out.println("La moyenne est : " + test2.calcul());
    }
}
