package org.example.factory;


import org.example.world.Hero;

import java.util.Random;

public class HerosFactory {

    /**
     * Créer un personnage avec tous ses attributs.
     * Demande a l'utilisateur d'entrer le nom du personnage.
     * retour: une instance de la classe Personnage correctement instancié.
     **/
    public static Hero build(){
        String nom = heroNom[new Random().nextInt(heroNom.length)];
        Integer pdv = new Random().nextInt(50,101);
        Integer endurance = new Random().nextInt(50,101);

        return new Hero(nom,pdv, endurance);

    }

    public static String[] heroNom = new String[] {
            "Aiden","Aurora","Blade","Cassius","Diana","Dante","Ember","Shaolan",
            "Gwyneth","Haruki","Isadora","Jaxon","Kaida","Lysandra","Maximus","Nadia",
            "Orion","Phoenix","Raine","Thorin"
    };
}
