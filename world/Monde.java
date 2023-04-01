package org.example.world;


import org.example.actions.Combat;
import org.example.factory.MonstreFactory;
import org.example.factory.HerosFactory;

import java.util.Random;

public class Monde {

    // Création des équipes
    Equipe heros = new Equipe();
    Equipe monstres = new Equipe();


    /**
     * Methode qui regroupe les différents objets à instancier
     * crée les équipes de héros et monstres
     * crée les armes, les boucliers, les nourritures
     * crée la sacoche pour chaque combattant
     * attribue, les armes, boucliers et nourriture
     */
    public void lancementJeu() {

        // Création des Heros & Monstres et ajout aux équipe spécifique

        heros.addFighter(HerosFactory.build());
        heros.addFighter(HerosFactory.build());
        monstres.addFighter(MonstreFactory.build());
        monstres.addFighter(MonstreFactory.build());

        // Ajout de la sacoche aux Héros et Monstres
        heros.addSacoche();
        monstres.addSacoche();

        // Ajout des armes aux Héros & Monstres -> appelé dans addSacoche()
        heros.equipeArme();
        monstres.equipeArme();

        heros.equipeBouclier();
        monstres.equipeBouclier();

        // System.out.println(heros);
        // System.out.println(monstres);
    }

    /**
     * Methode qui boucle sur l'équipe des héros et des monstres pour executer les combats ou les actions
     * @return un boolean pour savoir si l'équipe est en vie ou non
     */
    public boolean demarrer() {
        boolean etat;
        boolean tourJeux = new Random().nextBoolean();
       try{
           if (tourJeux){
               Combat.combat(heros.chooseFighter(), monstres.chooseFighter());
               etat = heros.isDead();
               return !etat;
           }else {
               Combat.combat(monstres.chooseFighter(), heros.chooseFighter());
               etat = monstres.isDead();
               return !etat;
           }
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * retourne l'équipe gagnante
     * @return
     */
    public void teamWinner(){
       if (heros.size() == 0){
            System.out.println("Les monstres ont gagné !");
       }else if (monstres.size() == 0) {
            System.out.println("Les héros ont gagné !");
        }else{
            System.out.println("Pas de vainqueur !");
        }
    }
}