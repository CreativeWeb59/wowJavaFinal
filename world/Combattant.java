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

        Integer degatSubis = 0;
        if ((!adversaire.getBouclierEquipe().getNom().equals("aucun")) && (adversaire.getEndurance() >= perteEnduranceDefenseur(adversaire))){
            // ajout du nombre de points d'encaissement sur l'adversaire
            // ne peut pas être supérieur aux dégats subis
            degatSubis = this.getArmeEquipee().getDegat() - adversaire.getBouclierEquipe().getEncaissement();
            if (degatSubis<0){
                degatSubis =0;
            }

            System.out.println(this.nom + " (" + this.getPointDeVie() + "pv et " + this.getEndurance() + " endu) frappe " + this.getArmeEquipee().getDegat() + " points à " + adversaire.getNom() + " avec " + this.getArmeEquipee().getNom());
            System.out.println(adversaire.getNom() + "(" + adversaire.getPointDeVie() + "pv et "+ adversaire.getEndurance() + " endu) bloque " + adversaire.getBouclierEquipe().getEncaissement() + " points de dégat " +
                    "et perds " + perteEnduranceDefenseur(adversaire) + " d'endurance");
            System.out.println(this.nom + " inflige au total " +
                    degatSubis
                    + " points à " + adversaire.getNom());

            // Adversaire : maj endu et degats subis
            degatSubis = adversaire.getPointDeVie() - degatSubis;
            adversaire.setPointDeVie(degatSubis);
            adversaire.setEndurance(adversaire.getEndurance() - perteEnduranceDefenseur(adversaire));
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
        // Perte d'endurance de l'attaquant
        this.setEndurance(this.getEndurance() - perteEnduranceAttaquant());
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

    /**
     * Teste deux valeurs : renvoie la premiere valeur ou la soustraction des deux<br/>
     * la première est une valeur de base qu'on ne veut pas passer en dessous de 0<br/>
     * la deuxième est la valeur qui se soustrait à la première<br/>
     * utile pour le calcul de la perte d'endurance afin d'éviter des valeurs négatives<br/>
     * @param valeurBase
     * @param valeurMoins
     * @return
     */
    public Integer valeurPositive(Integer valeurBase, Integer valeurMoins){
        if((valeurBase - valeurMoins) < 0){
            return valeurBase;
        } else {
            return (valeurMoins);
        }
    }

    /**
     * calcule l'endurance à perdre lorsque le combattant attaque<br/>
     * on prends en compte la longueur de son arme et son poids<br/>
     * @return
     */
    public Integer perteEnduranceAttaquant(){
        Integer multi = 1500;
        Integer calculPerte = Math.toIntExact(this.getArmeEquipee().getLongueur() * this.getArmeEquipee().getPoids() / multi);
        return valeurPositive(this.getEndurance(), calculPerte);
    }

    /**
     * calcule l'endurance à perdre par l'adversaire lorsqu'il possede un bouclier (ou peut l'utiliser) et bloque l'attaque<br/>
     * @return
     */
    public Integer perteEnduranceDefenseur(ICombattants adversaire){
        Integer multi = 1000;
        Integer calculPerte = Math.toIntExact(Math.round(adversaire.getBouclierEquipe().getPoids() / multi));
        return valeurPositive(adversaire.getEndurance(), calculPerte);
    }

}
