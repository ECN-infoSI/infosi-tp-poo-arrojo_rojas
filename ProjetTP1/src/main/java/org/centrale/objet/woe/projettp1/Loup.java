/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

import java.util.Map;
import java.util.Random;

/**
 * Sous-classe de Monstre qui gére les loups
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class Loup extends Monstre implements Combattant {

    /**
     *Constructeur de Loup
     * @param ptVie Point de vie du loup
     * @param degAtt Dégâts d'attaque du loup
     * @param ptPar Points de parade du loup
     * @param pageAtt Pourcentage de chance de toucher avec une attaque
     * @param pagePar Pourcentage de chance de parer une attaque
     * @param pos Position du loup
    */
    public Loup(int ptVie, int degAtt, int ptPar, int pageAtt, int pagePar, Point2D pos, Map<String, Nourriture> effets) {
        super(ptVie, degAtt, ptPar, pageAtt, pagePar, pos,effets);
    }

    /**
     * Constructeur par défaut de Loup
    */
    public Loup() {
        super();
    }

    /**
     * Constructeur de recopie de Loup
     * @param m Loup à recopier
    */
    public Loup(Loup m) {
        super((Monstre)m);
    }
    
    /**
     * Méthode de combat de loup
     * @param c Créature à combattre
    */
    @Override
    public void combattre(Creature c) {
        Random alea = new Random();
        int ouch;
        System.out.println("Le loup utilise Coup de Croc");
        double d = this.getPos().distance(c.getPos());
        if (d != 1) {
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

