package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Sacoche;


/**
 * Permet de créer une instance de Personnage
 * nécessitant Des pdv, nom, force, endurance , coordonnées
 */
public class Hero extends Combattant {

    private Sacoche sacoche;
    private Armes armes;
    private int armeEquipee;
    private int bouclierEquipe;

    public Hero(String nom, Integer pointDeVie){
        super(nom, pointDeVie);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "armes=" + armes +
                ", armeEquipee=" + armeEquipee +
                ", bouclierEquipe=" + bouclierEquipe +
                ", sacoche=" + sacoche +
                '}';
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

}
