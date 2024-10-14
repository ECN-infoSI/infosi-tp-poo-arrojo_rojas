/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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

        Joueur player = new Joueur();
        player.choisir();
        int action = 1; // Inicialize com um valor fora do intervalo desejado
        while (player.getPtVie() > 0) {
            do {
                if (action < 1 || action > 3) { // Verifica se o valor está fora do intervalo
                    System.out.println("Commande invalide. Il faut essayer à nouveau !");
                } else {
                    System.out.println("Quelle option vous voulez choisir ? ");
                    System.out.println("De se déplacer (1) \t Combattre (2) \t Inventaire (3)");
                }

                Scanner scanner = new Scanner(System.in);
                action = scanner.nextInt();

            } while (action < 1 || action > 3); // Repete enquanto o valor estiver fora do intervalo
        }
        System.out.println("Le jeu a fini parce que vous êtes mort");
    }
}
