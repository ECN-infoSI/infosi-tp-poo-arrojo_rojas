/*
 * Click nbfs:nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.centrale.objet.woe.projettp1;

import java.util.LinkedList;
import java.util.Scanner;

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

        World monde = new World();
        monde.creerMondeAlea();
        monde.createJoueur();
        monde.tour_de_jeu(0);
    }
}
