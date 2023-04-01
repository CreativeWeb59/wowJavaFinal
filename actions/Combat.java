package org.example.actions;



import org.example.world.Combattant;
import org.example.world.ICombattants;

import java.text.DecimalFormat;
import java.util.Random;

public class Combat {

    /**
     * Methode pour executer un combat
     * Prend 2 combattant en parametre
     * Tire au sort qui joue en 1er
     * Tire au sort entre une attaque ou ce nourrir
     */
    public static void combat(ICombattants hero, ICombattants monster) {
        while(hero.getPointDeVie() > 0 && monster.getPointDeVie() > 0) {
            int rand = new Random().nextInt(2);
            boolean turn = new Random().nextBoolean();
            // Si tour Héros
            if (turn) {
                attaque(hero,monster);
                gagnant(hero, monster);
                // Si tour Monstre
            } else {
                attaque(monster,hero);
                gagnant(hero, monster);
            }
        }
    }

    /**
     * Retourne un message pour savoir qui a gagner le combat
     * @param hero
     * @param monster
     */
    private static void gagnant(ICombattants hero, ICombattants monster) {
        if (hero.getPointDeVie() > 0 && monster.getPointDeVie() <= 0) {
            System.out.println("Le vainqueur est " + hero.getNom());
        }
        else if (hero.getPointDeVie() <= 0 && monster.getPointDeVie() > 0){
            System.out.println("Le vainqueur est " + monster.getNom());
        }
        else {
            System.out.println("Le combat continue");
        }
    }

    /**
     * Methode qui permet au heros d'attaquer 
     * Mets a jour l'endurance perdue chez les 2 équipe
     *
     */
    private static void attaque(ICombattants combattants1, ICombattants combattants2){

        // choix entre attaquer ou manger

        // creation d'un rand true = attaquer, false = manqger
        int action;
        int nbRandAction = new Random().nextInt(1, 6);

        // endurance > 30 => 1 chance sur 5 de manger
        // endurance < 30 => 1 chance sur 3 de manger

        // uniquement si endurance < 30

        if((combattants1.getEndurance() > 30) && (nbRandAction == 1)){
                System.out.println("manger");
        } else if((combattants1.getEndurance() > 30) && (nbRandAction > 1)){
                System.out.println("attaquer");
        } else if((combattants1.getEndurance() <= 30) && (new Random().nextInt(1, 4)==1)){
            System.out.println("manger");
        } else {
            System.out.println("attaquer");
        }


        combattants1.attaquer(combattants2);

        // deplacement des messages dans le combat en lui meme
        // pour mieux les detailler


        // affichage resultat du combat

        System.out.println("Il reste " + combattants1.getPointDeVie() + " points de vie a "+ combattants1.getNom() + " et " + combattants1.getEndurance() + " d'endurance");
        System.out.println("Il reste " + combattants2.getPointDeVie() + " points de vie a "+ combattants2.getNom() + " et " + combattants2.getEndurance() + " d'endurance");
    }

}
