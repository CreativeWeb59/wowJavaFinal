package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;

import java.text.DecimalFormat;

public abstract class Combattant implements ICombattants {

    private String nom;
    private Integer pointDeVie;
    private Integer endurance;
    private Sacoche sacoche;
    private int armeEquipee;
    private int bouclierEquipe;

    public Combattant(String nom, Integer pointDeVie, Integer endurance){
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

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
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
     * utilisation du bouclier => moins de degats + perte endurance
     * points d'attaque subis
     * setEndurance passe à zéro si négative
     */
    @Override
    public void attaquer(ICombattants adversaire) {

        /*
        Par exemple, si un héros attaque un monstre et lui inflige 10pts de dégât, en se défendant avec un
        bouclier qui encaisse 5, il ne perdra que 5 points de vie. Il ne pourra se défendre que si il a
        l'endurance nécessaire. Chaque action de défense lui fera perdre des points d'endurances (même
        principe qu'avec l'arme PE = (poidsGr/1000)
         */

        // calcul de l'endurance necessaire pour que l'adversaire puisse utiliser son bouclier
        Integer enduNecessaire = Math.toIntExact(Math.round(adversaire.getBouclierEquipe().getPoids() / 1000));

        Integer degatSubis = 0;
        if ((!adversaire.getBouclierEquipe().getNom().equals("aucun")) && (adversaire.getEndurance() >= enduNecessaire)){

            // ajout du nombre de points d'encaissement sur l'adversaire
            // baisse de l'endurance de l'adversaire
            degatSubis = this.getArmeEquipee().getDegat() - adversaire.getBouclierEquipe().getEncaissement();
            if (degatSubis<0){
                degatSubis =0;
            }
            degatSubis = adversaire.getPointDeVie() - degatSubis;

            if((adversaire.getEndurance() - enduNecessaire) <0){
                adversaire.setEndurance(0);
            } else {
                adversaire.setEndurance(adversaire.getEndurance() - enduNecessaire);
            }

            System.out.println(this.nom + " (" + this.getPointDeVie() + " pv) frappe " + this.getArmeEquipee().getDegat() + " points à " + adversaire.getNom() + " avec " + this.getArmeEquipee().getNom());
            System.out.println(adversaire.getNom() + "(" + adversaire.getPointDeVie() + " pv) bloque " + adversaire.getBouclierEquipe().getEncaissement() + " points de dégat " +
                    "et perds " + enduNecessaire + " d'endurance");
            System.out.println(this.nom + " inflige au total " +
                    degatSubis
                    + " points à " + adversaire.getNom());
            adversaire.setPointDeVie(degatSubis);
        } else {
            if (adversaire.getBouclierEquipe().getNom().equals("aucun")) {
                System.out.println("Le défenseur n'a pas de bouclier");
            } else {
                System.out.println("Le defenseur n'a pas assez d'endurance pour utiliser son bouclier");
            }

            System.out.println(this.nom + " (" + this.getPointDeVie() + ") inflige " + this.getArmeEquipee().getDegat() + " points à " + adversaire.getNom() + " avec " + this.getArmeEquipee().getNom());
            System.out.println(adversaire.getNom() + "(" + adversaire.getPointDeVie() + ") reçoit " + this.getArmeEquipee().getDegat() + " dégats");
            adversaire.setPointDeVie(adversaire.getPointDeVie() - (this.getArmeEquipee().getDegat()));
        }

    }

    /**
     * perte endurance due à l'attaque
     * Quand une arme (épée ou gourdin) est utilisée, elle réduira les points d’endurances du personnage
     *         en suivant le calcul suivant : (longueurCm*poidsGr)/10000
     *         Par exemple, un héros qui a 70pt d’endurance et qui est équipé d’une épée de 50cm pesant 900gr,
     *         quand il attaque perdra (50*900)/10000 = 4.5pt d’endurance.
     * multi : permet d'ajuste les points d'endurance
     * setEndurance passe à zéro si négative
     * @return
     */
    public void perteEndurance(){
        Integer multi = 1500;
        Integer calculPerte = Math.toIntExact(this.getArmeEquipee().getLongueur() * this.getArmeEquipee().getPoids() / multi);
        System.out.println(this.getNom() + " perd " + calculPerte + " points d'endurance");
        if((this.getEndurance() - calculPerte) < 0){
            this.setEndurance(0);
        } else {
            this.setEndurance(this.getEndurance() - calculPerte);
        }

    }

}
