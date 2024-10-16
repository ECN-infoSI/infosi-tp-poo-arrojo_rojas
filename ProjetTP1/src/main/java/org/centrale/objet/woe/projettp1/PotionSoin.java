/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

import java.util.Arrays;

/**
 * Sous-classe d'objet qui gére les potions de soins
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class PotionSoin extends Objet{
    private int valeur_soin;

    /**
     * Constructeur de PotionSoin
     * @param valeur_soin Points de vie regagné après l'utilisation d'une potion de soin
     * @param nom Nom de l'objet
     * @param description Description de l'objet
     * @param pos Position
    */
    public PotionSoin(int valeur_soin, String nom, String description, Point2D pos) {
        super(nom, description, pos);
        this.valeur_soin = valeur_soin;
    }

    /**
     * Constructeur par défaut
    */
    public PotionSoin() {
        super();
        this.valeur_soin = 5;
    }

    /**
     * Constructeur de recopie
     * @param o Potion à recopier
    */
    public PotionSoin(PotionSoin o) {
        super((Objet)o);
        this.valeur_soin = o.valeur_soin;
    }
    
    /**
     * Méthode pour obtenir la valeur du soin
     * @return la valeur du soin
    */
    public int getValeur_soin() {
        return valeur_soin;
    }

    /**
     * Méthode pour définir la valeur du soin
     * @param valeur_soin valeur du soin
    */
    public void setValeur_soin(int valeur_soin) {
        this.valeur_soin = valeur_soin;
    }
    
    /**
     * Méthode d'affichage pour PotionSoin
    */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("La potion rend " + valeur_soin + " points de vie");
    }
}