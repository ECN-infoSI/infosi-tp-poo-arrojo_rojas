/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;
import java.util.Random;

/**
 * Sous-classe de la classe Créature qui gére les personnages
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Personnage extends Creature {
    private String nom;
    private int distAttMax;
    private Point2D pos;
    
    /**
     * Constructeur de Personnage
     * @param N
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Personnage (String N, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        super(pV, dA, pPar, paAtt, paPar, p);
        this.nom = N;
        this.distAttMax = dA;
    }
    
    /**
     * Constructeur de copie de Personnage
     * @param perso
     */
    public Personnage (Personnage perso) {
        super((Creature)perso);
        this.nom = perso.getNom();
        this.distAttMax = perso.getDistAttMax();
    }
    
    /**
     * Constructeur par défaut de personnage
     */
    public Personnage ()
    {
        super();
        this.nom = "Inconnu";
        this.distAttMax = 1;
    }
    
    /**
     * Fonction pour obtenir le nom de personnage
     * @return le nom de personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * Fonction pour définir le nom de personnage
     * @param n le nom de personnage
     */
    public void setNom(String n) {
        this.nom = n;
    }

    /**
     * Fonction pour obtenir la distance d'attaque maximale
     * @return Distance d'attaque maximale
    */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Fonction pour définir la distance d'attaque maximale
     * @param distAttMax Distance d'attaque maximale
    */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
   
}
