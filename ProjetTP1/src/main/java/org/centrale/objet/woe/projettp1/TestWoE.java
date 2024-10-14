/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/
package org.centrale.objet.woe.projettp1;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


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
        //ArrayList<Creature> crea = new ArrayList<>();
        //ArrayList<Objet> obj = new ArrayList<>();
        
        World monde = new World ();
        monde.creerMondeAlea();
        monde.quantite_elements();
        
        //Joueur player = new Joueur();
        //player.choisir();
    }
}
