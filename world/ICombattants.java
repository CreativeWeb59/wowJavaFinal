package org.example.world;


import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Nourritures;
import org.example.objets.Sacoche;

import java.util.List;

/**
 * Interface qui contient tous les getter et setter que les 
 * combattant vont avoir besoin pour exister
 */
public interface ICombattants {

    public String getNom();
    public void setNom(String nom);
    public Integer getPointDeVie();
    public void setPointDeVie(Integer pointDeVie);
    public Integer getEndurance();
    public void setEndurance(Integer endurance);
    public Sacoche getSacoche();
    public void setSacoche(Sacoche sacoche);
    public void attaquer(ICombattants adversaire);
    public Armes getArmeEquipee();
    public void setArmeEquipee(int armeEquipee);
    public Boucliers getBouclierEquipe();
    public void setBouclierEquipe(int bouclierEquipe);
    public Integer perteEnduranceAttaquant();
    public Integer perteEnduranceDefenseur(ICombattants adversaire);
    public void utiliserNourriture(List<Nourritures> nourritures, int index);
    public String toString();

}
