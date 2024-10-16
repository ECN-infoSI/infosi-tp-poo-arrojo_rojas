/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Map;
import java.util.Random;

/**
 * Sous-classe de personnage qui gère les archers
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Archer extends Personnage implements Combattant {

    private int nbFleches; // Nombre de flèches possédées par l'archer

    /**
     * Constructeur d'Archer
     *
     * @param n Nom de l'archer
     * @param pV Points de vie de l'archer
     * @param dA Dégâts infligés par une attaque
     * @param pPar Dégâts parés par une attaque
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param dMax Distance d'attaque maximale
     * @param p Position de l'archer
     * @param effets Liste des effets affectant l'archer
     * @param nbFleches Nombre de flèches possédées par l'archer
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, Map<String, Nourriture> effets, int nbFleches) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p, effets);
        this.nbFleches = nbFleches;
    }

    /**
     * Constructeur de copie d'Archer
     *
     * @param a Archer à copier
     */
    public Archer(Archer a) {
        super(a);  // Appel au constructeur par copie de la classe parent Personnage
        this.nbFleches = a.nbFleches;
    }

    /**
     * Constructeur par défaut de l'archer
     */
    public Archer() {
        super();
        this.nbFleches = 5; // Initialisation par défaut à 5 flèches
    }

    /**
     * Méthode pour obtenir le nombre de flèches de l'archer
     *
     * @return Le nombre de flèches de l'archer
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Méthode pour définir le nombre de flèches de l'archer
     *
     * @param nbFleches Nombre de flèches de l'archer
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Méthode d'affichage du nombre de flèches de l'archer
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("L'archer possède " + nbFleches + " flèches");
    }

    /**
     * Méthode pour gérer le combat
     *
     * @param c Créature à combattre
     */
    @Override
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch = 0; // Dégâts infligés à la créature
        float d = this.getPos().distance(c.getPos()); // Calcul de la distance à la créature

        // Vérification de la portée d'attaque
        if (d > this.getDistAttMax()) {
            System.out.println("La créature est trop loin pour être attaquée");
        } else {
            // Si la distance est égale à 1, l'archer utilise une attaque au corps à corps
            if (d == 1) {
                int patt = alea.nextInt(30);
                System.out.println(this.getNom() + " utilise Coup de dague");
                if (patt > this.getPageAtt()) {
                    System.out.println("L'attaque échoue");
                } else {
                    System.out.println("L'attaque réussit");
                    int ppar = alea.nextInt(10);
                    if (ppar > c.getPagePar()) {
                        System.out.println("La parade échoue");
                        ouch = this.getDegAtt(); // Dégâts infligés
                    } else {
                        System.out.println("La parade réussit");
                        ouch = Math.max(0, this.getDegAtt() - c.getPtPar()); // Dégâts après la parade
                    }
                }
            } else {
                // Si la distance est supérieure à 1, l'archer tire une flèche
                if (this.nbFleches > 0) { // Vérifier s'il reste des flèches
                    int patt = alea.nextInt(10);
                    System.out.println(this.getNom() + " utilise Tir à l'arc");
                    this.setNbFleches(this.getNbFleches() - 1); // Décrémenter le nombre de flèches
                    if (patt > this.getPageAtt()) {
                        System.out.println("L'attaque échoue");
                    } else {
                        System.out.println("L'attaque réussit");
                        ouch = this.getDegAtt(); // Dégâts infligés
                    }
                } else {
                    System.out.println("Aucune flèche disponible pour tirer.");
                    return; // Sortir de la méthode si aucune flèche
                }
            }
        }

        // Affichage des résultats de l'attaque
        if (ouch > 0) {
            System.out.println("L'attaque inflige " + ouch + " points de dégâts");
            if (ouch >= 0.5 * c.getPtVie()) {
                System.out.println("C'est super efficace");
            }
            if (ouch <= 0.1 * c.getPtVie()) {
                System.out.println("Ce n'est pas très efficace");
            }
            c.setPtVie(c.getPtVie() - ouch); // Mise à jour des points de vie de la créature
            if (c.getPtVie() > 0) {
                System.out.println("Il reste " + c.getPtVie() + " points de vie");
            } else {
                System.out.println("La créature est vaincue !");
            }
        }
    }
}
