package fr.diginamic.combat;

public class PotionAttaqueMineure extends Potion {

    public PotionAttaqueMineure() {
        super("Potion d'attaque mineure", "+3 en force pour 1 combat");
    }

    @Override
    public String appliquer(Personnage personnage) {
        personnage.ajouterBonusAttaque(3, 1);
        return "Votre force augmente de 3 pour le prochain combat !";
    }
}
