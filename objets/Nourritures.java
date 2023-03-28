package org.example.objets;

public class Nourritures implements Items{
    private String nom;
    private Integer valeur;
    private Integer poids;

    public Nourritures(String nom, Integer valeur, Integer poids) {
        this.nom = nom;
        this.valeur = valeur;
        this.poids = poids;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    @Override
    public Integer getPoids() {
        return poids;
    }

    @Override
    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public String toString() {
        return "Nourritures{" +
                "nom='" + nom + '\'' +
                ", valeur=" + valeur +
                ", poids=" + poids +
                '}';
    }
}
