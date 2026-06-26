package fr.diginamic.essais;

import fr.diginamic.maison.*;

public class TestMaison {
    static void main() {

        System.out.println("—————————————————————————————————————————— Test Maison ——————————————————————————————————————————");

        Maison maison = new Maison();

        maison.ajouterPiece(new Salon(30, 0));
        maison.ajouterPiece(new Cuisine(12, 0));
        maison.ajouterPiece(new WC(3, 0));
        maison.ajouterPiece(new Chambre(15, 1));
        maison.ajouterPiece(new SalleDeBain(9, 1));
        maison.ajouterPiece(new WC(3, 1));

        // Que se passe-t-il si vous passez null en paramètre de la méthode ajouterPiece(Piece piece) ? Faites un test.
        maison.ajouterPiece(null);
        // Exception in thread "main" java.lang.NullPointerException:
        // Cannot invoke "fr.diginamic.maison.Piece.getSuperficie()" because "piece" is null

        // Que se passe-t-il si la pièce à une superficie ou un étage négatif ?
        //maison.ajouterPiece(new WC(-3, -1));
        // l'étage -1 à une superficie de -3m², pas d'erreur dans l'IDE


        System.out.println("Superficie totale de la maison : " + maison.getSuperficieTotale());
        System.out.println("Superficie du rez-de-chaussé : " + maison.getSuperficieParEtage(0));
        System.out.println("Superficie du premier étage : " + maison.getSuperficieParEtage(1));

        // Test valeurs négatives
        System.out.println("Superficie de l'étage -1 : " + maison.getSuperficieParEtage(-1));

        System.out.println("Superficie totale des WCs de la maison : " + maison.getSuperficieParType("wc"));
        System.out.println("Nombre de chambre dans la maison : " + maison.getNbPiecesParType("chambre"));

        System.out.println("————————————————————————————————————————— Test MaisonV2 —————————————————————————————————————————");

        MaisonV2 maisonV2 = new MaisonV2();

        maisonV2.ajouterPiece(new Salon(30, 0));
        maisonV2.ajouterPiece(new Cuisine(12, 0));
        maisonV2.ajouterPiece(new WC(3, 0));
        maisonV2.ajouterPiece(new Chambre(15, 1));
        maisonV2.ajouterPiece(new SalleDeBain(9, 1));
        maisonV2.ajouterPiece(new WC(3, 1));
        maisonV2.ajouterPiece(null);

        System.out.println("Superficie totale de la maisonV2 : " + maisonV2.getSuperficieTotale());
        System.out.println("Superficie du rez-de-chaussé : " + maisonV2.getSuperficieParEtage(0));
        System.out.println("Superficie du premier étage : " + maisonV2.getSuperficieParEtage(1));
        System.out.println("Superficie de l'étage -1 : " + maisonV2.getSuperficieParEtage(-1));

        System.out.println("Superficie totale des WCs de la maisonV2 : " + maisonV2.getSuperficieParType("wc"));
        System.out.println("Nombre de chambre dans la maisonV2 : " + maisonV2.getNbPiecesParType("chambre"));

    }
}
