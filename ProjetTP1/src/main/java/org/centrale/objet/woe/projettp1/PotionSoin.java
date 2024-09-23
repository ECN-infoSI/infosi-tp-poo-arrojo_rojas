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
    
int valeur_soin;

    /**
     *Constructeur de PotionSoin
     * @param valeur_soin Points de vie regagné après l'utilisation d'une potion de soin
     * @param nom Nom de l'objet
     * @param prix_achat Prix à l'achat de l'objet
     * @param prix_vente Prix à la vente de l'objet
     * @param description Description de l'objet
     * @param pos
     */
    public PotionSoin(int valeur_soin, String nom, int prix_achat, int prix_vente, String description, Point2D pos) {
        super(nom, prix_achat, prix_vente, description, pos);
        this.valeur_soin = valeur_soin;
    }

    /**
     *Constructeur par défaut
     */
    public PotionSoin() {
        super();
        this.valeur_soin = 1000000000;
    }

    /**
     *Constructeur de recopie
     * @param o Potion à recopier
     */
    public PotionSoin(PotionSoin o) {
        super((Objet)o);
        this.valeur_soin = o.valeur_soin;
    }
    
    /**
     *
     * @return
     */
    public int getValeur_soin() {
        return valeur_soin;
    }

    /**
     *
     * @param valeur_soin
     */
    public void setValeur_soin(int valeur_soin) {
        this.valeur_soin = valeur_soin;
    }
    
    /**
     *Fonction d'affichage pour PotionSoin
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("La potion rend " + valeur_soin + " points de vie");
    }


}