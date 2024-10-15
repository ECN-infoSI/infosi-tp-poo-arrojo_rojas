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
        /*int action = 1;
        while (monde.getJoueur().getPtVie() > 0) {
            monde.afficheDisplay();
            do {
                if (action < 1 || action > 3) {  Vérifie si la valeur est hors plage
                    System.out.println("Commande invalide. Il faut essayer à nouveau !");
                } else {
                    System.out.println("Quelle option vous voulez choisir ? \t De se déplacer (1) \t Combattre (2) \t Inventaire (3)");
                }

                Scanner scanner = new Scanner(System.in);
                action = scanner.nextInt();

            } while (action < 1 || action > 3);  Répéter lorsque la valeur est hors plage
        }
        System.out.println("Le jeu a fini parce que vous êtes mort");*/
        monde.tour_de_jeu(10);
    }
}
