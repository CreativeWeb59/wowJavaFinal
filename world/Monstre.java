package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Sacoche;

/**
 * Permet de creer une instance de Monstre
 * nécessisant Des pdv, nom, force, endurance , coordonnées
 */
public class Monstre extends Combattant {

    private Armes armes;
    private Sacoche sacoche;
    private int armeEquipee;
    private int bouclierEquipe;

    public Monstre(String nom, Integer pointDeVie) {
        super(nom,pointDeVie);
    }


    public Armes getArmes() {
        return armes;
    }

    public void setArmes(Armes armes) {
        this.armes = armes;
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
                "armes=" + armes +
                ", armeEquipee=" + armeEquipee +
                ", bouclierEquipe=" + bouclierEquipe +
                ", sacoche=" + sacoche +
                '}';
    }
}
