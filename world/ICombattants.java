package org.example.world;


import org.example.objets.Armes;
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
    public Sacoche getSacoche();
    public void setSacoche(Sacoche sacoche);
    public void attaquer(ICombattants adversaire);
    public Armes getArmeEquipee();
    public void setArmeEquipee(int armeEquipee);
    public void equipeBouclier(int bouclierEquipe);

    // n'est plus utilise
    // choix de l'arme int alea de l'arme dans la sacoche
    // public Armes getArmes();
    // public void setArmes(Armes armes);
}
