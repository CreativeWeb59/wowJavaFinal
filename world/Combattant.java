package org.example.world;

import java.text.DecimalFormat;

public abstract class Combattant implements ICombattants {

    private String nom;
    private Integer pointDeVie;
    private double endurance;

    public Combattant(String nom, Integer pointDeVie, double endurance){
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.endurance = endurance;
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

    public double getEndurance() {
        return endurance;
    }

    public void setEndurance(double endurance) {
        this.endurance = endurance;
    }

    /**
     * Permet de recuperer les degats de l'attaque de l'arme
     * et d'infliger une perte de point de vie a l'adversaire
     */
    @Override
    public void attaquer(ICombattants adversaire) {
        adversaire.setPointDeVie(this.getPointDeVie() - (this.getArmeEquipee().getDegat()));

    }

    public double perteEndurance(){
        // perte endurance due à l'attaque
        /*
        Quand une arme (épée ou gourdin) est utilisée, elle réduira les points d’endurances du personnage
        en suivant le calcul suivant : (longueurCm*poidsGr)/10000
        Par exemple, un héros qui a 70pt d’endurance et qui est équipé d’une épée de 50cm pesant 900gr,
        quand il attaque perdra (50*900)/10000 = 4.5pt d’endurance.
         */
        // utilise pour le formatage de l'endurance
        DecimalFormat df = new DecimalFormat("0.00");
        // permet de forcer le format double
        double multi = 10000;
        double resultat = (Math.round((this.getArmeEquipee().getLongueur() * this.getArmeEquipee().getPoids() / multi)*100.0)/100.0);
        double envoi = this.getEndurance() - resultat;
        this.setEndurance(envoi);
        return resultat;

    }

}
