package org.example.objets;

import org.example.world.ICombattants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sacoche implements Iterable<Armes> {
    private List<Armes> tabArmes;
    private List<Boucliers> tabBoucliers;
    private List<Nourritures> tabNourritures;

    public Sacoche(List<Armes> tabArmes, List<Boucliers> tabBoucliers, List<Nourritures> tabNourriture) {
        this.tabArmes = tabArmes;
        this.tabBoucliers = tabBoucliers;
        this.tabNourritures = tabNourriture;
    }

    public List<Armes> getTabArmes() {
        return tabArmes;
    }

    public void addArme(List<Armes> tabArmes) {
        this.tabArmes = tabArmes;
    }

    public List<Boucliers> getTabBoucliers() {
        return tabBoucliers;
    }

    public void addBouclier(List<Boucliers> tabBoucliers) {
        this.tabBoucliers = tabBoucliers;
    }

    public List<Nourritures> getTabNourriture() {
        return tabNourritures;
    }

    public void addNourriture(List<Nourritures> tabNourriture) {
        this.tabNourritures = tabNourriture;
    }

    @Override
    public String toString() {
        return "Sacoche{" +
                "tabArmes=" + tabArmes +
                ", tabBoucliers=" + tabBoucliers +
                ", tabNourritures=" + tabNourritures +
                '}';
    }

    @Override
    public Iterator<Armes> iterator() {
        return tabArmes.iterator();
    }

    // recherche la meilleure arme dans la sacoche
    public Armes bestArmes(List armes){
        Iterator<Armes> iter = iterator();
        // arme par defaut
        // modifie les valeurs si on trouve mieux niveau degats
        Armes bestArme = new Armes("Gourdin", 10, 30, 200);

        int max = 0;
        int index = 0;
        // 1re etape je recupere la valeur la + elevee
        while(iter.hasNext()){
            Armes e = iter.next();
            if (e.getDegat()>max){
                max = e.getDegat();
                bestArme.setNom(e.getNom());
                bestArme.setDegat(e.getDegat());
                bestArme.setLongueur(e.getLongueur());
                bestArme.setPoids(e.getPoids());
            }
        }
        return bestArme;
    }
}
