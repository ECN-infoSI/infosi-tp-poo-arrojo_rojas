/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

import java.util.Map;

/**
 * Sous-classe de monstre qui gére les Lapins
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class Lapin extends Monstre {    

    /**
     * Constructeur de Lapin
     * @param pV Point de vie du lapin
     * @param dA Dégâts d'attaque du lapin
     * @param pPar Points de parade du lapin
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param p Position du lapin
     * @param effets Liste des effets subis par le lapin
    */
    public Lapin (int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, Map<String, Nourriture> effets) {
        super (pV, dA, pPar, paAtt, paPar, p, effets);
    }
    
    /**
     * Constructeur de copie de Lapin
     * @param l à copier
    */
    public Lapin(Lapin l) {
        super(l);  // Appel au constructeur par copie de la classe parent Lapin
    }
    
    /**
     * Constructeur par défaut de Lapin
    */
    public Lapin(){
        super();
    }
}
