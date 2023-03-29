package org.example.factory;

import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Nourritures;
import org.example.objets.Sacoche;
import org.example.world.ICombattants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SacocheFactory {
    public static Sacoche build(ICombattants combattantsS){
        Sacoche sacoche;
        List<Armes> listArmes = new ArrayList<>(buildArmes());
        List<Boucliers> listBoucliers = new ArrayList<>(buildBouclier());
        List<Nourritures> listNourritures = new ArrayList<>(buildNourriture());
        sacoche = new Sacoche(listArmes, listBoucliers, listNourritures);
        // System.out.println(sacoche);

        // Ajoute la meilleur arme au combattant
        // n'est plus utilisé
        // Armes armes;
        // combattantsS.setArmes(sacoche.bestArmes(listArmes));
        // attribue une arme aleatoire parmi celles crées
        // combattantsS.setArmes(listArmes.get(new Random().nextInt(0,listArmes.size())));
        return sacoche;
    }

    public static List<Armes> buildArmes(){
        Integer nbArmes = new Random().nextInt(1,5);
        List<Armes> listArmes = new ArrayList<>();
        for (int i = 0; i <= nbArmes ; i++) {
            listArmes.add(ArmeFactory.build());
        }
        return listArmes;
    }

    public static List<Boucliers> buildBouclier(){
        Integer nbBoucliers = new Random().nextInt(1,5);
        List<Boucliers> listBoucliers = new ArrayList<>();
        Boucliers boucliers;
        // creation d'un bouclier à valeur des stats 0
        // pour signifier le pas de bouclier
        boucliers = new Boucliers("aucun", 0, 0);
        listBoucliers.add(boucliers);

        for (int i = 0; i <= nbBoucliers ; i++) {
            String nom = bouclierNom[new Random().nextInt(bouclierNom.length)];
            Integer defense = new Random().nextInt(5,21);
            Integer poids = new Random().nextInt(500,1001);
            boucliers = new Boucliers(nom, defense, poids);
            listBoucliers.add(boucliers);
        }
        return listBoucliers;
    }

    public static List<Nourritures> buildNourriture(){
        Integer nbNourriture = new Random().nextInt(1,11);
        List<Nourritures> listNourritures = new ArrayList<>();
        Nourritures nourritures;
        for (int i = 0; i <= nbNourriture ; i++) {
            String nom = nourritureNom[new Random().nextInt(nourritureNom.length)];
            Integer valeur = new Random().nextInt(10,41);
            Integer poids = new Random().nextInt(50,201);
            nourritures = new Nourritures(nom, valeur, poids);
            listNourritures.add(nourritures);
        }
        return listNourritures;
    }

    public static String[] bouclierNom = new String[] {
            "rundskjold", "Skjaldmo", "Adarga", "Broquel", "Aspis", "Clipeus", "Pavois", "Rondache", "Targe", "Tarja", "ecu"
    };

    public static String[] nourritureNom = new String[] {
            "Gâteau", "Ragoût de lapin", "Champignons", "Saumon Cuit", "Pain", "Pommes", "Pomme de terre au four",
            "Charlotte aux Fraises", "Artichauts", "Banane", "Tomate", "verre de lait", "pâtes au fromage"
    };


}
