/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

/**
 * Sous-classe de Personnage qui gére les paysans
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Paysan extends Personnage {

    /**
     * Constructeur de Paysan
     * @param n Nom du paysan
     * @param pV Points de vie du paysan
     * @param dA Dégâts infligés par une attaque
     * @param pPar Dégâts parés par une attaque
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param dMax Distance d'attaque maximale
     * @param p Position du paysan
     */
    public Paysan (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }
    
    /**
    * Constructeur de copie de paysan
    * @param p à copier
    */
    public Paysan(Paysan p) {
        super(p);  // Appel au constructeur par copie de la classe parent Lapin
    }
    
    /**
    * Constructeur par défaut de paysan
    */
    public Paysan(){
        super();
    }
}
