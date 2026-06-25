package fr.diginamic.maison;

public class Maison {

    Piece[] pieces;

    public Maison() {
        this.pieces = new Piece[0];
    }

    public void ajouterPiece(Piece piece) {

        // Ajout du contrôle pour piece == null
        if (piece == null) {
            return;
        }

        Piece[] nouveauTableau = new Piece[pieces.length + 1];

        for (int i = 0; i < pieces.length; i++) {
            nouveauTableau[i] = pieces[i];
        }

        nouveauTableau[pieces.length] = piece;

        pieces = nouveauTableau;
    }

    public double getSuperficieTotale() {

        double superficieTotal = 0;

        for (Piece piece : pieces) {
            superficieTotal += piece.getSuperficie();
        }

        return superficieTotal;
    }

    public double getSuperficieParEtage(int etage) {

        double superficieEtage = 0;

        for (Piece piece : pieces) {
            if (piece.getEtage() == etage) {
                superficieEtage += piece.getSuperficie();
            }
        }

        return superficieEtage;
    }

    public double getSuperficieParType(String type) {

        double total = 0;

        for (Piece piece : pieces) {
            if (piece.getClass().getSimpleName().equalsIgnoreCase(type)) {
                total += piece.getSuperficie();
            }
        }

        return total;
    }

    public int getNbPiecesParType(String type) {

        int nbPieces = 0;

        for (Piece piece : pieces) {
            if (piece.getClass().getSimpleName().equalsIgnoreCase(type)) {
                nbPieces++;
            }
        }

        return nbPieces;
    }
}
