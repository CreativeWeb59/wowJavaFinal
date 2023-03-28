package org.example.world;

public abstract class Combattant implements ICombattants {

    private String nom;
    private Integer pointDeVie;

    public Combattant(String nom, Integer pointDeVie){
        this.nom = nom;
        this.pointDeVie = pointDeVie;
    }
    public String toString(){
        return "nom: "+this.nom+", point de vie: "+this.pointDeVie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(Integer pointDeVie) {
        this.pointDeVie = pointDeVie;
    }


    /**
     * Permet de recupere les degat de l'attaque de l'arme
     * et d'infliger une perte de point de vie a l'adversaire
     */
    @Override
    public void attaquer(ICombattants adversaire) {
        adversaire.setPointDeVie(this.getPointDeVie() - (this.getArmes().getDegat()));
    }

}
