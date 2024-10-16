/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Sous-classe de personnage gérant les guerriers
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Guerrier extends Personnage implements Combattant {

    /**
     * Constructeur de Guerrier
     *
     * @param nom Nom du guerrier
     * @param ptVie Points de vie du guerrier
     * @param degAtt Dégâts infligés par une attaque
     * @param ptPar Dégâts parés par une attaque
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position du guerrier
     * @param effets Liste des effets affectant le guerrier
     */
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos, Map<String, Nourriture> effets) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
    }

    /**
     * Constructeur de recopie
     *
     * @param perso Guerrier à recopier
     */
    public Guerrier(Guerrier perso) {

        super((Personnage) perso);
    }

    /**
     * Constructeur par défaut de guerrier
     */
    public Guerrier() {
        super();
    }

    @Override
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch; // Variable pour stocker les points de dégâts infligés
        System.out.println(this.getNom() + " utilise Coup d'Épée");

        // Calculer la distance entre le joueur et la créature
        double d = this.getPos().distance(c.getPos());

        // Vérifier si la créature est à portée d'attaque
        if (d > 1) {
            System.out.println("La créature est trop loin pour être attaquée");
        } else {
            // Tenter l'attaque
            int patt = alea.nextInt(15); // Tirage aléatoire pour déterminer si l'attaque touche
            if (patt > this.getPageAtt()) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussit");
                int ppar = alea.nextInt(15); // Tirage aléatoire pour déterminer si la créature parera l'attaque
                if (ppar > c.getPagePar()) {
                    System.out.println("La parade échoue");
                    ouch = this.getDegAtt(); // Dégâts directs si la parade échoue
                } else {
                    System.out.println("La parade réussit");
                    // Dégâts après la parade
                    ouch = Math.max(0, this.getDegAtt() - c.getPtPar());
                }

                // Affichage des dégâts infligés
                System.out.println("L'attaque inflige " + ouch + " points de dégâts");
                if (ouch >= 0.5 * c.getPtVie()) {
                    System.out.println("C'est super efficace");
                }
                if (ouch <= 0.1 * c.getPtVie()) {
                    System.out.println("Ce n'est pas très efficace");
                }

                // Mettre à jour les points de vie de la créature
                c.setPtVie(c.getPtVie() - ouch);
                if (c.getPtVie() > 0) {
                    System.out.println("Il reste " + c.getPtVie() + " points de vie");
                } else {
                    System.out.println("La créature est vaincue !");
                }
            }
        }
    }
}
