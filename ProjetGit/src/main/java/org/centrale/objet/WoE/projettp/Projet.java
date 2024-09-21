/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE.projettp;

/**
 *
 * @author Fernando ROJAS
 */
public class Projet {

    public static void main(String[] args) {
        
        World world = new World();
        world.creerMondeAlea();
        
        //Affichage de deplacement des personnages
        //Robin
        System.out.println("Deplacement Robin");
        world.robin.affiche();
        world.robin.deplace();
        world.robin.affiche();
        
        //Peon
        System.out.println("Deplacement Peon");
        world.peon.affiche();
        world.peon.deplace();
        world.peon.affiche();
        
        //Bugs
        System.out.println("Deplacement Bugs");
        world.bugs.affiche();
        world.bugs.deplace();
        world.bugs.affiche();
        
            
    }
}
