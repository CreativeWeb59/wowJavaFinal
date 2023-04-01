package org.example;

import org.example.world.Monde;

/**
 * Lancement du jeu
 * type tour par tour
 * avec equipe de héros et équipe de monstres
 */
public class Main {
    public static void main(String[] args) {

        Monde m = new Monde();
        System.out.println("Création du monde");
        m.lancementJeu();
        System.out.println("Le monde est créée");
        System.out.println("Lancement des combats");

        boolean condition = true;
        while(condition){
            condition = m.demarrer();
        }
        m.teamWinner();

    }
}