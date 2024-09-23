/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Sous-classe de personnage gérant les guerriers
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class Guerrier extends Personnage {

    /**
     * Constructeur de Guerrier
     * @param nom Nom du guerrier
     * @param ptVie Points de vie du guerrier
     * @param degAtt Dégâts infligés par une attaque
     * @param ptPar Dégâts parés par une attaque
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param distAttMax Distance d'attaque maximale
     * @param pos Position du guerrier
     */
    public Guerrier(String nom, int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, int distAttMax, Point2D pos) {
        super(nom, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
    }

    /**
     * Constructeur de recopie 
     * @param perso Guerrier à recopier
     */
    public Guerrier(Guerrier perso) {
        
        super((Personnage)perso);
    }

    /**
     * Constructeur par défaut de guerrier
     */
    public Guerrier() {
        super();
    }
    
    /**
     * Méthode de combat
     * @param c Créature à combattre
     */
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch;
        System.out.println(this.getNom() + " utilise Coup d'Épée");
        double d = this.getPos().distance(c.getPos());
        if (d !=1) {
            System.out.println("La créature est trop loin pour être attaquée"); 
        } else {
            int patt = alea.nextInt(101);
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
                System.out.println("L'attaque inflige " + ouch + "points de dégâts");
            if (ouch >= 0.5*c.getPtVie()) {
                System.out.println("C'est super efficace");
            }
            if (ouch <= 0.1*c.getPtVie()) {
                System.out.println("Ce n'est pas très efficace");
            }
            c.setPtVie(c.getPtVie()-ouch);
            System.out.println("Il reste " + c.getPtVie() + "points de vie");
            }
            
            
            }   
}
}
