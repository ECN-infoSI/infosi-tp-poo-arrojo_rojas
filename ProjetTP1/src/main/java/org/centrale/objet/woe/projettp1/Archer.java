/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

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
        System.out.println("L'archer possédé " + nbFleches + "flèches");
    }
}
