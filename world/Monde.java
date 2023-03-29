package org.example.world;


import org.example.actions.Combat;
import org.example.factory.MonstreFactory;
import org.example.factory.HerosFactory;
import org.example.factory.SacocheFactory;

import java.util.Random;

public class Monde {

    //Création des équipes
    Equipe heros = new Equipe();
    Equipe monstres = new Equipe();


    /**
     * Methode qui regroupe les différent objet
     * a instancier et a regroupe dans les
     * sac et & equipe respective
     */
    public void lancementJeu() {

        // Création des Heros & Monstres et ajout aux équipe spécifique

        heros.addFighter(HerosFactory.build());
        heros.addFighter(HerosFactory.build());
        monstres.addFighter(MonstreFactory.build());
        monstres.addFighter(MonstreFactory.build());

        // Ajout de la sacoche aux Héros et Monstres
        // attribue la meilleure arme
        heros.addSacoche();
        monstres.addSacoche();

        // Ajout des armes aux Héros & Monstres -> appelé dans addSacoche()
        // heros.addArmes();
        // monstres.addArmes();
        heros.equipeArme();
        monstres.equipeArme();

        System.out.println(heros);
    }

    /**
     * Methode qui boucle sur l'équipe des héros et des monstres pour execute les combat ou les action
     * @return un boolean pour savoir si l'équipe est en vie ou non
     */
    public boolean demarrer() {
        boolean etat;
        boolean tourJeux = new Random().nextBoolean();
        //System.out.println(heros.size()+" "+monstres.size());
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
     * Essayer pour retourner la team qui gagne
     * @return
     */
    public void teamWinner(){
       if (heros.size() == 0){
            System.out.println("Les monstres ont gagné !");
       }else if (monstres.size() == 0) {
            System.out.println("Les héros ont gagné !");
        }else{
            System.out.println("No one win.");
        }
    }
}