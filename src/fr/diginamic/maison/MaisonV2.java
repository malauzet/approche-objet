package fr.diginamic.maison;

import java.util.Arrays;

public class MaisonV2 {

    Piece[] pieces;

    public MaisonV2() {
        this.pieces = new Piece[0];
    }

    // Utilisation du Arrays.copyOf() vu précédemment
    public void ajouterPiece(Piece piece) {
        if (piece == null) {
            return;
        }
        pieces = Arrays.copyOf(pieces, pieces.length + 1);
        pieces[pieces.length - 1] = piece;
    }

    // Convertit le tableau en stream, extrait la superficie de chaque pièce et les additionne
    public double getSuperficieTotale() {
        return Arrays.stream(pieces).mapToDouble(Piece::getSuperficie).sum();
    }

    // Même chose qu'avant mais on filtre par étage
    public double getSuperficieParEtage(int etage) {
        return Arrays.stream(pieces).filter(p -> p.getEtage() == etage).mapToDouble(Piece::getSuperficie).sum();
    }

    // Ici, on filtre par type de pièces
    public double getSuperficieParType(String type) {
        return Arrays.stream(pieces).filter(p -> p.getClass().getSimpleName().equalsIgnoreCase(type))
                .mapToDouble(Piece::getSuperficie)
                .sum();
    }

    // Ici, on fait comme celle d'avant mais on les compte juste puis on convertit en int car count() retourne un long
    public int getNbPiecesParType(String type) {
        return (int) Arrays.stream(pieces).filter(p -> p.getClass().getSimpleName().equalsIgnoreCase(type)).count();
    }
}
