package org.example.world;



import org.example.factory.ArmeFactory;
import org.example.factory.SacocheFactory;
import org.example.objets.Sacoche;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Equipe implements Iterable<ICombattants> {
    private final List<ICombattants> tab;
    public Equipe(){
        this.tab = new ArrayList<>();
    }

    // Permet d’ajouter un combattant à une équipe
    public void addFighter(ICombattants pCombattants ){
        tab.add(pCombattants);
    }

    // Permet d’ajouter une sacoche à un combattant en parcourant l’équipe
    // elle est rempli d'armes, boucliers et nourriture par la SacocheFactory
    public void addSacoche(){
        for (ICombattants e: tab) {
            e.setSacoche(SacocheFactory.build(e));
        }
    }
    public void afficheCombattant(){

        for (ICombattants e: tab) {
            System.out.println(e.getSacoche());
        }
    }
    // Permet d’ajouter une arme à un combattant en parcourant l’équipe
    /*
    public void addArmes(){
        for (ICombattants e: tab) {
            e.setArmes(ArmeFactory.build());
        }
    }
    */


    // Permet de recuperate le 1er combatant de l'équipe , celui a l'index 0
    public ICombattants chooseFighter(){
        if (tab.size() == 0){
            throw new RuntimeException("L'équipe est vide !");
        }else{
            int rand = new Random().nextInt(tab.size());
            return tab.get(rand); 
        }
    }

    public ICombattants get(int index){
        return tab.get(index);
    }
    public int size(){
        return tab.size();
    }

    @Override
    public Iterator<ICombattants> iterator() {
        return tab.iterator();
    }

    /**
     * Utilise un iterateur pour parcourir la liste de personnages/monstres et savoir s’ils sont morts
     * @return renvoie true si le combattant est en vie, false si mort
     */
    public boolean isDead(){
        boolean resultat = true;
        Iterator<ICombattants> iter = iterator();
        while(iter.hasNext()){
            ICombattants e = iter.next();
            if(e.getPointDeVie() > 0) {
                resultat = false ;
            } else {
                iter.remove();
                System.out.println(e.getNom()+" est mort !");
            }
        }
        return resultat;
    }

    @Override
    public String toString() {
        return "Equipe{" + "tab=" + tab +'}';
    }
}
