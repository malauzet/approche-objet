package fr.diginamic.recensement.modele;

public class Departement {

    private String codeDepartement;
    private long populationTotale;

    public Departement(String codeDepartement, long populationTotale) {
        this.codeDepartement = codeDepartement;
        this.populationTotale = populationTotale;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public long getPopulationTotale() {
        return populationTotale;
    }

    public void setPopulationTotale(long populationTotale) {
        this.populationTotale = populationTotale;
    }

    @Override
    public String toString() {
        return "Département " + codeDepartement + " - " + populationTotale + " habitants";
    }
}
