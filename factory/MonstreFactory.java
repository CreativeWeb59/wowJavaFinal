package org.example.factory;


import org.example.world.Monstre;

import java.util.Random;

public class MonstreFactory {

    /**
     * Créer un Monstre avec tous ses attributs.
     * Demande a l'utilisateur d'entrer le nom du personnage.
     * retour: une instance de la classe Monstre correctement instancié.
     **/
    public static Monstre build(){
        String nom = monstrePrenom[new Random().nextInt(monstrePrenom.length)]
                +monstreNom[new Random().nextInt(monstreNom.length)];
        Integer pdv = new Random().nextInt(40,101);
        Integer endurance = new Random().nextInt(50,101);

        return new Monstre(nom,pdv, endurance);

    }

    /**
     * Méthode qui contient une liste de prenom possibble pour le monstre
     * **/
    public static String[] monstrePrenom = new String[] {
            "Gobelin ","Orc ","Troll ","Elfe ","Dragon ","Licorne ","Gorgone ","Minotaure ",
            "Harpie ","Kraken ","Méduse ","Chimère ","Centaure ","Vampires ","Loup-garou ",
            "Golem ","Banshee ","Naga ","Ange déchu ","Cyclope ","Sphinx ", "Wyvern ",
            "Nécromancien ","Elfe noir ","Succube ","Démon ","Serpent de mer ", "Yéti ","Ondin "
    };

    /**
     * Méthode qui contient une liste de nom possibble pour le monstre
     * **/
    public static String[] monstreNom = new String[] {
            "Effrayant","Menaçant","Sinistre","Terrifiant","Mortel","Féroce","Implacable",
            "Meurtrier","Sanguinaire","Hurlant","Géant","Hideux","Repoussant","Monstrueux",
            "Nauséabond","Maléfique","Démoniaque","Surnaturel","Surnaturel","Énorme",
            "Invulnérable","Épouvantable","Mystérieux","Immortel","Invincible","Ancien",
            "Primitif","Surnaturel","Magique","Surnaturel","Puissant"
    };
}
