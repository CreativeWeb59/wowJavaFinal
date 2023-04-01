package org.example.world;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;


/**
 * Permet de créer une instance de Personnage
 * nécessitant Des pdv, nom, force, endurance , coordonnées
 */
public class Hero extends Combattant {
        public Hero(String nom, Integer pointDeVie, Integer endurance) {
        super(nom, pointDeVie, endurance);
    }


}
