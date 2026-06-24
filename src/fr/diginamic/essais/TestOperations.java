package fr.diginamic.essais;

import static fr.diginamic.operations.Operations.calcul;

public class TestOperations {
    static void main(){

        double a = 12.3;
        double b = 2.0;

        char operateurA = '+';
        char operateurS = '-';
        char operateurM = '*';
        char operateurD = '/';
        // Pour tester les opérateurs invalide.
        char operateurInvalide = 'a';

        System.out.println(calcul(a, b, operateurA));
        System.out.println(calcul(a, b, operateurS));
        System.out.println(calcul(a, b, operateurM));
        System.out.println(calcul(a, b, operateurD));
        // 5ème test pour les entrées invalide.
        System.out.println(calcul(a, b, operateurInvalide));
    }
}
