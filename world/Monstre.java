package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;

/**
 * Permet de creer une instance de Monstre
 * nécessisant Des pdv, nom, force, endurance , coordonnées
 */
public class Monstre extends Combattant {
    private Sacoche sacoche;
    private int armeEquipee;
    private int bouclierEquipe;

    public Monstre(String nom, Integer pointDeVie, double endurance) {
        super(nom, pointDeVie, endurance);
    }

    public Sacoche getSacoche() {
        return sacoche;
    }

    public void setSacoche(Sacoche sacoche) {
        this.sacoche = sacoche;
    }
    // equipe une arme choisi dans la sacoche
    public void equipeArme(int armeEquipee){
        this.armeEquipee = armeEquipee;
    }
    // equipe un bouclier choisi dans la sacoche
    public void equipeBouclier(int bouclierEquipe){
        this.bouclierEquipe = bouclierEquipe;
    }


    public Armes getArmeEquipee() {
        return sacoche.armeEquipee(armeEquipee);
    }

    public void setArmeEquipee(int armeEquipee) {
        this.armeEquipee = armeEquipee;
    }


    @Override
    public String toString() {
        return "Monstre{" +
                "Arme équipée =" + getArmeEquipee() +
                ", armeEquipee=" + armeEquipee +
                ", bouclierEquipe=" + bouclierEquipe +
                ", Contenu " + sacoche +
                '}';
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
