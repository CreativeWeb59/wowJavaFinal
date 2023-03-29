package org.example.world;


import org.example.objets.Armes;
import org.example.objets.Boucliers;
import org.example.objets.Sacoche;

/**
 * Interface qui contient tous les getter et setter que les 
 * combattant vont avoir besoin pour exister
 */
public interface ICombattants {

    public String getNom();
    public void setNom(String nom);
    public Integer getPointDeVie();
    public void setPointDeVie(Integer pointDeVie);
    public double getEndurance();
    public void setEndurance(double endurance);
    public Sacoche getSacoche();
    public void setSacoche(Sacoche sacoche);
    public void attaquer(ICombattants adversaire);
    public Armes getArmeEquipee();
    public void setArmeEquipee(int armeEquipee);
    public Boucliers getBouclierEquipe();
    public void setBouclierEquipe(int bouclierEquipe);
    public double perteEndurance();
    public String toString();

    // n'est plus utilise
    // choix de l'arme int alea de l'arme dans la sacoche
    // public Armes getArmes();
    // public void setArmes(Armes armes);
}
