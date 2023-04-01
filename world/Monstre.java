package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;

/**
 * Permet de creer une instance de Monstre
 * nécessisant Des pdv, nom, force, endurance , coordonnées
 */
public class Monstre extends Combattant {

    public Monstre(String nom, Integer pointDeVie, Integer endurance) {
        super(nom, pointDeVie, endurance);
    }



}
