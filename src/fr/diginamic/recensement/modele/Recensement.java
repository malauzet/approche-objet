package fr.diginamic.recensement.modele;

import java.util.ArrayList;
import java.util.List;

public class Recensement {

    private List<Ville> villes;

    public Recensement() {
        this.villes = new ArrayList<>();
    }

    public Recensement(List<Ville> villes) {
        this.villes = villes;
    }

    public List<Ville> getVilles() {
        return villes;
    }

    public void setVilles(List<Ville> villes) {
        this.villes = villes;
    }

    public void ajouterVille(Ville ville) {
        this.villes.add(ville);
    }
}
