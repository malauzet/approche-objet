package fr.diginamic.combat;

public class PotionSoin extends Potion {

    public PotionSoin() {
        super("Potion de soin", "+5 à 10 points de santé");
    }

    @Override
    public String appliquer(Personnage personnage) {
        int soin = Utils.genererNombreAleatoire(5, 10);
        personnage.soigner(soin);
        return "Vous récupérez " + soin + " points de vie. (PV : " + personnage.getPointsDeVie() + ")";
    }
}
