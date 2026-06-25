package fr.diginamic.combat;

public class Combat {

    private final Personnage personnage;
    private final Creature creature;

    public Combat(Personnage personnage, Creature creature) {
        this.personnage = personnage;
        this.creature = creature;
    }

    public void lancerCombat() {

        int compteur = 1;

        afficherDebutCombat();

        while(personnage.estVivant() && creature.estVivant()) {
            System.out.println("===== Tour n°" + compteur + " =====");
            jouerTour();
            compteur++;
        }

        if (!personnage.estVivant()) {
            gererDefaitePersonnage();
        }
    }

    private void afficherDebutCombat() {
        System.out.println("Début du combat contre : " + creature);
    }

    private void jouerTour() {
        int attaquePersonnage = personnage.calculerAttaque();
        int attaqueCreature = creature.calculerAttaque();

        int degats = calculerDegats(attaquePersonnage, attaqueCreature);

        System.out.println("Attaque Personnage : " + attaquePersonnage);
        System.out.println("Attaque Creature : " + attaqueCreature);

        if (degats > 0) {
            creature.subitDegats(degats);
            System.out.println(creature.getNom() + " subit " + degats + " dégâts."
                    + " (PV restants : " + creature.getPointsDeVie() + ")");
            if(!creature.estVivant()) gererVictoirePersonnage();
        }
        else if (degats < 0) {
            int degatsSubis = -degats;
            personnage.subitDegats(degatsSubis);
            System.out.println("Personnage subit " + degatsSubis + " dégâts."
                    + " (PV restants : " + personnage.getPointsDeVie() + ")");
        }
        else System.out.println("Égalité ! Aucun dégât ce tour.");

        System.out.println("====================");
    }

    private int calculerDegats(int attaquePersonnage, int attaqueCreature) {
        return attaquePersonnage - attaqueCreature;
    }

    private void gererVictoirePersonnage() {
        personnage.ajouterScore(creature.getPoints());
        System.out.println("🏆 Victoire !! Vous battez le " + creature.getNom()
                + " et gagnez " + creature.getPoints() + " points.");
        System.out.println("Score total : " + personnage.getScore() + " points.");
    }

    private void gererDefaitePersonnage() {
        System.out.println("💀 Défaite... Vous finissez la partie avec " + personnage.getScore() + " points.");
    }
}