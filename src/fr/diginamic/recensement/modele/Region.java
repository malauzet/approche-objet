package fr.diginamic.recensement.modele;

public class Region {

    private int codeRegion;
    private String nomRegion;
    private long populationTotale;

    public Region(int codeRegion, String nomRegion, long populationTotale) {
        this.codeRegion = codeRegion;
        this.nomRegion = nomRegion;
        this.populationTotale = populationTotale;
    }

    public int getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(int codeRegion) {
        this.codeRegion = codeRegion;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public long getPopulationTotale() {
        return populationTotale;
    }

    public void setPopulationTotale(long populationTotale) {
        this.populationTotale = populationTotale;
    }

    @Override
    public String toString() {
        return nomRegion + " - " + populationTotale + " habitants";
    }
}
