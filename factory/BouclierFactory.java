package org.example.factory;

import org.example.objets.Boucliers;

import java.util.Random;
public class BouclierFactory {
    public static Boucliers build(){
        Integer rand = new Random().nextInt(1,6);
        Boucliers boucliers;
        Integer degat = new Random().nextInt(10,21);
        Integer poids = new Random().nextInt(350,601);

        switch (rand){
            case 1:
                degat = new Random().nextInt(10,21);
                poids = new Random().nextInt(350,601);
                boucliers = new Boucliers("Epée", degat, poids);
                break;
            case 2:
                degat = new Random().nextInt(10,21);
                poids = new Random().nextInt(150,301);
                boucliers = new Boucliers("Gourdin", degat, poids);
                break;
            case 3:
                degat = new Random().nextInt(20,41);
                poids = new Random().nextInt(250,401);
                boucliers = new Boucliers("Masse", degat, poids);
                break;
            case 4:
                degat = new Random().nextInt(20,41);
                poids = new Random().nextInt(25,101);
                boucliers = new Boucliers("Dague", degat, poids);
                break;
            case 5:
                degat = new Random().nextInt(25,51);
                poids = new Random().nextInt(300,501);
                boucliers = new Boucliers("Hache", degat, poids);
                break;
            default:
                degat = new Random().nextInt(10,21);
                poids = new Random().nextInt(150,301);
                boucliers = new Boucliers("Gourdin", degat, poids);
        }
        return boucliers;
    }
}
