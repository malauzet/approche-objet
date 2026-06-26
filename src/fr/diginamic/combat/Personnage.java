package fr.diginamic.combat;

import java.util.ArrayList;
import java.util.List;

public class Personnage extends Entites {

    private int score;
    private final int pointsDeVieMax;
    private final List<Potion> inventaire;

    private int bonusAttaque = 0;
    private int combatsAvecBonus = 0;

    // Constructeur ---------------------------------------------------------------------------------
    public Personnage() {
        super(Utils.genererNombreAleatoire(12, 18), Utils.genererNombreAleatoire(20, 50));
        this.score = 0;
        this.pointsDeVieMax = getPointsDeVie();
        this.inventaire = new ArrayList<>();

        inventaire.add(new PotionSoin());
        inventaire.add(new PotionAttaqueMineure());
        inventaire.add(new PotionAttaqueMajeure());
    }

    // Score ----------------------------------------------------------------------------------------
    public void ajouterScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }

    // Soin -----------------------------------------------------------------------------------------
    public void soigner(int quantite) {
        int nouveauxPV = Math.min(getPointsDeVie() + quantite, pointsDeVieMax);
        setPointsDeVie(nouveauxPV);
    }

    // Attaque --------------------------------------------------------------------------------------
    public void ajouterBonusAttaque(int bonus, int nbCombats) {
        this.bonusAttaque += bonus;
        this.combatsAvecBonus = Math.max(this.combatsAvecBonus, nbCombats);
    }

    public void decrementerBonusAttaque() {
        if (combatsAvecBonus > 0) {
            combatsAvecBonus--;
            if (combatsAvecBonus == 0) {
                System.out.println("(Le bonus d'attaque de " + bonusAttaque + " a expiré.)");
                bonusAttaque = 0;
            }
        }
    }

    public int getBonusAttaque() {
        return (combatsAvecBonus > 0) ? bonusAttaque : 0;
    }

    @Override
    public int calculerAttaque() {
        return super.calculerAttaque() + getBonusAttaque();
    }

    // Inventaire -----------------------------------------------------------------------------------
    public void ajouterPotion(Potion potion) {

        boolean dejaPresente = inventaire.stream()
                .anyMatch(p -> p.getClass().equals(potion.getClass()));

        if (dejaPresente) {
            System.out.println("Vous possédez déjà une " + potion.getNom() + ", elle est perdue.");
        } else {
            inventaire.add(potion);
            System.out.println("Nouvelle potion ajoutée à l'inventaire : " + potion.getNom());
        }
    }

    public boolean utiliserPotion(int index) {

        if (index < 0 || index >= inventaire.size()) {
            return false;
        }

        Potion potion = inventaire.remove(index);
        String resultat = potion.appliquer(this);
        System.out.println(resultat);

        return true;
    }

    public boolean aDesPotion() {
        return !inventaire.isEmpty();
    }

    public void afficherInventaire() {

        if (inventaire.isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        }
        else {
            System.out.println("=== Inventaire ===");

            for (int i = 0; i < inventaire.size(); i++) {
                System.out.println((i + 1) + ". " + inventaire.get(i));
            }
        }
    }
}
