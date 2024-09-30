/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.centrale.objet.woe.projettp1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Methode pour tester le jeu
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class TestWoE {

    /**
     * Methode pour tester le jeu
     *
     * @param args paramètres du main
     */
    public static void main(String[] args) {

        Archer Arch1 = new Archer();
        Guerrier Guer1 = new Guerrier();
        Lapin Lap1 = new Lapin();
        Loup Loup1 = new Loup();
        Paysan Pays1 = new Paysan();
        PotionSoin Ps1 = new PotionSoin();
        Epee Ep1 = new Epee();
            
        ArrayList<Creature> crea = new ArrayList<>();
        ArrayList<Objet> obj = new ArrayList<>();
            
        crea.add(Arch1);
        crea.add(Guer1);
        crea.add(Lap1);
        crea.add(Pays1);
        crea.add(Loup1);
            
        obj.add(Ps1);
        obj.add(Ep1);
                   
            
        World wrld = new World(crea,obj);
        wrld.creerMondeAlea(); 
        
        wrld.affiche();
        System.out.println("------------------------------");              
        System.out.println("Génération du monde: Essai n°2");
        World wrld2 = new World();
        wrld2.creerMondeAlea();
            
        wrld2.affiche();
    }
}
