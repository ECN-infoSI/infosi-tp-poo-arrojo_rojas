/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;
/**
* Sous-classe d'objet gérant les épées
* @author Augusto ARROJO et Fernando ROJAS
*/
public class Epee extends Objet {
    private int bonus_att;

    /**
     * Constructeur de la classe Epee
     * @param bonus_att Points d'attaque bonus apporté par l'objet
     * @param nom Nom de l'objet
     * @param prix_achat Prix d'achat de l'objet
     * @param prix_vente Prix de vente de l'objet
     * @param description Description de l'objet
     * @param pos
     */
    public Epee(int bonus_att, String nom, int prix_achat, int prix_vente, String description, Point2D pos) {
        super(nom, prix_achat, prix_vente, description, pos);
        this.bonus_att = bonus_att;
    }

    /**
     * Constructeur par défaut de Epee
     */
    public Epee() {
        super();
        this.bonus_att = 10;
    }

    /**
     * Constructeur de recopie
     * @param e Epee à recopier
     */
    public Epee(Epee e) {
        super((Objet)e);
        this.bonus_att = e.bonus_att;
    }

    /**
     * 
     * @return Bonus d'attaque de l'objet
     */
    public int getBonus_att() {
        return bonus_att;
    }

    /**
     *
     * @param bonus_att Bonus d'attaque de l'objet
     */
    public void setBonus_att(int bonus_att) {
        this.bonus_att = bonus_att;
    }




}
