package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;


/**
 * Permet de créer une instance de Personnage
 * nécessitant Des pdv, nom, force, endurance , coordonnées
 */
public class Hero extends Combattant {

    private Sacoche sacoche;
    // private Armes armes;
    private int armeEquipee;
    private int bouclierEquipe;
    private int endurance;

    public Hero(String nom, Integer pointDeVie){
        super(nom, pointDeVie);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "Arme équipée =" + getArmeEquipee() +
                ", armeEquipee=" + armeEquipee +
                "Bouclier équipé =" + getBouclierEquipe() +
                ", bouclierEquipe=" + bouclierEquipe +
                ", Contenu " + sacoche +
                '}';
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
}
