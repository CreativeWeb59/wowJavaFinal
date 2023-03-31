package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;

import java.text.DecimalFormat;

public abstract class Combattant implements ICombattants {

    private String nom;
    private Integer pointDeVie;
    private double endurance;
    private Sacoche sacoche;
    private int armeEquipee;
    private int bouclierEquipe;

    public Combattant(String nom, Integer pointDeVie, double endurance){
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "Combattant{" +
                "nom='" + nom + '\'' +
                ", pointDeVie=" + pointDeVie +
                ", endurance=" + endurance +
                ", sacoche=" + sacoche +
                ", armeEquipee=" + armeEquipee +
                ", bouclierEquipe=" + bouclierEquipe +
                '}';
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
    @Override
    public void setSacoche(Sacoche sacoche) {
        this.sacoche = sacoche;
    }

    @Override
    public Sacoche getSacoche() {
        return sacoche;
    }

    @Override
    public Armes getArmeEquipee() {
        return sacoche.armeEquipee(armeEquipee);
    }
    // equipe une arme choisi dans la sacoche
    @Override
    public void setArmeEquipee(int armeEquipee) {
        this.armeEquipee = armeEquipee;
    }
    public Boucliers getBouclierEquipe() {
        return sacoche.bouclierEquipe((bouclierEquipe));
    }
    // equipe un bouclier choisi dans la sacoche
    // mettre 0 si pas de bouclier => bouclier aux stats 0
    public void setBouclierEquipe(int bouclierEquipe) {
        this.bouclierEquipe = bouclierEquipe;
    }

    /**
     * Permet de recuperer les degats de l'attaque de l'arme
     * et d'infliger une perte de point de vie a l'adversaire
     */
    @Override
    public void attaquer(ICombattants adversaire) {
        // utilisation du bouclier => moins de degats + perte endurance
        // points d'attaque subis

        /*
        Par exemple, si un héros attaque un monstre et lui inflige 10pts de dégât, en se défendant avec un
        bouclier qui encaisse 5, il ne perdra que 5 points de vie. Il ne pourra se défendre que si il a
        l'endurance nécessaire. Chaque action de défense lui fera perdre des points d'endurances (même
        principe qu'avec l'arme PE = (poidsGr/1000)
         */

        // rajouter test get pv jamais superieurs à set pv
        Integer degatSubis = 0;
        if (!adversaire.getBouclierEquipe().getNom().equals("aucun")){
            // ajout du nombre de points d'encaissement sur l'adversaire
            // baisse de l'endurance de l'adversaire
            double multi = 1000;
            degatSubis = this.getArmeEquipee().getDegat() - adversaire.getBouclierEquipe().getEncaissement();
            if (degatSubis<0){
                degatSubis =0;
            }
            degatSubis = adversaire.getPointDeVie() - degatSubis;
            adversaire.setEndurance(adversaire.getBouclierEquipe().getPoids()/multi);

            System.out.println(this.nom + "(" + this.getPointDeVie() + " pv) frappe " + this.getArmeEquipee().getDegat() + " points à " + adversaire.getNom() + " avec " + this.getArmeEquipee().getNom());
            System.out.println(adversaire.getNom() + "(" + adversaire.getPointDeVie() + " pv) bloque " + adversaire.getBouclierEquipe().getEncaissement() + " points de dégat");
            System.out.println(this.nom + " inflige au total " +
                    degatSubis
                    + " points à " + adversaire.getNom());
            adversaire.setPointDeVie(degatSubis);
        } else {
            System.out.println("Le défenseur n'a pas de bouclier");
            System.out.println(this.nom + "(" + this.getPointDeVie() + ") inflige " + this.getArmeEquipee().getDegat() + " points à " + adversaire.getNom() + " avec " + this.getArmeEquipee().getNom());
            System.out.println(adversaire.getNom() + "(" + adversaire.getPointDeVie() + ") reçoit " + this.getArmeEquipee().getDegat() + " dégats");
            adversaire.setPointDeVie(adversaire.getPointDeVie() - (this.getArmeEquipee().getDegat()));
        }




    }

    public double perteEndurance(){
        // perte endurance due à l'attaque
        /*
        Quand une arme (épée ou gourdin) est utilisée, elle réduira les points d’endurances du personnage
        en suivant le calcul suivant : (longueurCm*poidsGr)/10000
        Par exemple, un héros qui a 70pt d’endurance et qui est équipé d’une épée de 50cm pesant 900gr,
        quand il attaque perdra (50*900)/10000 = 4.5pt d’endurance.
         */

        // permet de forcer le format double
        double multi = 10000;
        double calculPerte = (Math.round((this.getArmeEquipee().getLongueur() * this.getArmeEquipee().getPoids() / multi)*100.0)/100.0);
        double envoi = Math.round((this.getEndurance() - calculPerte)*100.0)/100.0;
        this.setEndurance(envoi);
        return calculPerte;

    }

}
