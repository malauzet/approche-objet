package fr.diginamic.salaire;

public class Pigiste extends Intervenant {

    private int jourTravailMois;
    private double remunerationJournaliere;

    public Pigiste(String nom, String prenom, int jourTravailMois, double remunerationJournaliere) {
        super(nom, prenom);
        this.jourTravailMois = jourTravailMois;
        this.remunerationJournaliere = remunerationJournaliere;
    }

    @Override
    public double getSalaire() {
        return jourTravailMois * remunerationJournaliere;
    }

    @Override
    public String getStatut() {
        return "Pigiste";
    }
}
