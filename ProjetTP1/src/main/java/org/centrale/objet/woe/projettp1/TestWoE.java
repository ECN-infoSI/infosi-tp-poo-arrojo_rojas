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
import java.util.Scanner;
/**
 * Classe pour tester le jeu
 * @author augustoarrojo
 */
public class TestWoE {
    /**
     * Méthode pour tester le jeu
     *
     * @param args paramètres du main
     */
    public static void main(String[] args) {
        World monde = new World();

        Scanner scanner = new Scanner(System.in);
        String choix;

        System.out.println("Bienvenue au jeu WoE !");
        System.out.println("Que voulez-vous faire ?");

        // Loop até a escolha ser válida
        while (true) {
            System.out.println("1 - Commencer une nouvelle partie");
            System.out.println("2 - Charger une partie existante");
            System.out.print("Veuillez entrer votre choix: ");
            
            // Recebe a entrada do jogador
            choix = scanner.nextLine();

            // Verifica se a escolha é válida
            if (choix.equals("1")) {
                System.out.println("Vous avez choisi de commencer une nouvelle partie.");
                // Chama a função para commencer uma nova partida
                monde.creerMondeAlea();
                monde.createJoueur();
                break;
            } else if (choix.equals("2")) {
                System.out.println("Vous avez choisi de charger une partie existante.");
                // Pede o nome do arquivo a ser carregado
                System.out.print("Entrez le nom du fichier de sauvegarde: ");
                String nomFichier = scanner.nextLine();
                monde.chargementPartie(nomFichier + ".txt");
                break;
            } else {
                System.out.println("Choix invalide. Veuillez entrer 1 ou 2.");
            }
        }

        // Depois da escolha, começa o turno de jogo
        monde.tour_de_jeu(0);
    }
}
