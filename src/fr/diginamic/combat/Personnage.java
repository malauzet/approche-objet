package fr.diginamic.combat;

public class Personnage extends Entites {

    private int score;

    public Personnage() {
        super(Utils.genererNombreAleatoire(12, 18), Utils.genererNombreAleatoire(20, 50));
        this.score = 0;
    }

    public void ajouterScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }
}
