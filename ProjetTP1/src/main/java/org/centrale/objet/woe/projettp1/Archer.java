/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Random;

/**
 * Sous-classe de personnage qui gére les archers
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Archer extends Personnage {
    private int nbFleches;
    
    /**
     * Constructeur d'Archer
     * @param n Nom de l'archer
     * @param pV Points de vie de l'archer
     * @param dA Dégâts infligés par une attaque
     * @param pPar Dégâts parés par une attaque
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param dMax Distance d'attaque maximale
     * @param p Position de l'archer
     * @param nbFleches Nombre de flèche possédées par l'archer
    */
    public Archer (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }
    
    
    /**
    * Constructeur de copie d'Archer
    * @param a à copier
    */
    public Archer(Archer a) {
        super(a);  // Appel au constructeur par copie de la classe parent Lapin
        this.nbFleches = a.nbFleches;
    }
    
    /**
    * Constructeur par défaut de l'archer
    */
    public Archer(){
        super();
        this.nbFleches = 5;
    }
    
    /**
    * Fonction pour obtenir le nombre de flèches de l'archer 
    * @return Le nombre de flèches de l'archer
    */
    public int getNbFleches() {
        return nbFleches;
    }
    
    /**
    * Fonction pour définir le nombre de flèches de l'archer 
    * @param nbFleches Nombre de flèches de l'archer
    */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    /**
    * Fonction d'affichage de nombre de flèches de l'archer
    */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("L'archer possédé " + nbFleches + "  flèches");
    }
    
    /**
     * Fonction pour gérer le combat
     * @param c Créature à combattre
    */
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch = 0;
        float d = this.getPos().distance(c.getPos());
        if (d > this.getDistAttMax()) {
            System.out.println("La créature est trop loin pour être attaquée"); 
        } else {
            if (d == 1) {
            int patt = alea.nextInt(101);
            System.out.println(this.getNom() + " utilise Coup de dague");
            if (patt > this.getPageAtt()) {
                System.out.println("L'attaque échoue");
            } else {
                System.out.println("L'attaque réussi");
                int ppar = alea.nextInt(101);
                if (ppar > c.getPagePar()) {
                    System.out.println("La parade échoue");
                    ouch = this.getDegAtt();
                    
                } else {
                    System.out.println("La parade réussi");
                    ouch =  Math.max(0,this.getDegAtt()-c.getPtPar());
                }
            }
            } else {
               int patt = alea.nextInt(101);
               System.out.println(this.getNom() + " utilise Tir à l'arc");
               this.setNbFleches(this.getNbFleches()-1);  
                if (patt > this.getPageAtt()) {
                    System.out.println("L'attaque échoue");
                } else {
                    System.out.println("L'attaque réussi");
                    ouch = this.getDegAtt();
                }
            }
        }
        System.out.println("L'attaque inflige " + ouch + " points de dégâts");
        if (ouch >= 0.5*c.getPtVie()) {
            System.out.println("C'est super efficace");
        }
        if (ouch <= 0.1*c.getPtVie()) {
            System.out.println("Ce n'est pas très efficace");
        }
        c.setPtVie(c.getPtVie()-ouch);
        System.out.println("Il reste " + c.getPtVie() + " points de vie");     
    }  
}
