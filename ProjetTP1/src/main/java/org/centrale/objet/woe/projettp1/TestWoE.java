/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.woe.projettp1;

/**
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class TestWoE {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
       World wlrd = new World();
       wlrd.creerMondeAlea();
       System.out.println("Position initiale du Robin:");
       wlrd.robin.affiche();
       wlrd.robin.deplace();
       System.out.println("Nouveau position du Robin:");
       wlrd.robin.affiche();
       
       System.out.println("Position initiale du Bug:");
       wlrd.bugs.affiche();
       wlrd.bugs.deplace();
       System.out.println("Nouveau position du Bug:");
       wlrd.bugs.affiche();
       
       System.out.println("Position initiale du Peon:");
       wlrd.peon.affiche();
       wlrd.peon.deplace();
       System.out.println("Nouveau position du Peon:");
       wlrd.peon.affiche();
    }
}
