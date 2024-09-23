/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

/**
 * Fonction pour tester le jeu
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class TestPoint2D {

    /**
     * Fonction pour tester le jeu
     * @param args
     */
    public static void main(String[] args) {
        // Créer un point en utilisant le constructeur avec des coordonnées
        Point2D point1 = new Point2D(3, 4);
        point1.affiche(); // Affiche le point (3, 4)

        // Créer un point par copie d'un autre point
        Point2D point2 = new Point2D(point1);
        point2.affiche(); // Affiche le point (3, 4)

        // Créer un point par défaut (0, 0)
        Point2D point3 = new Point2D();
        point3.affiche(); // Affiche le point (0, 0)

        // Modifier les coordonnées du point 3
        point3.setX(5);
        point3.setY(6);
        point3.affiche(); // Affiche le point (5, 6)

        // Déplacer le point 3 de (2, -1)
        point3.translate(2, -1);
        point3.affiche(); // Affiche le point (7, 5)

        // Calculer la distance entre point1 et point3
        float dist = point1.distance(point3);
        System.out.println("Distance entre point1 et point3: " + dist);

        // Définir de nouvelles coordonnées pour point2
        point2.setPosition(1, 1);
        point2.affiche(); // Affiche le point (1, 1)
    }
}
