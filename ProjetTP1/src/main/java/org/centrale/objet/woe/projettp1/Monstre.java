/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;
import java.util.Random;

/**
 * Sous-classe de Créature qui gére les monstres
 * @author Augusto ARROJO et Fernando ROJAS
 */
abstract public class Monstre extends Creature {

    /**
     *Constructeur de monstre
     * @param pV Point de vie du monstre
     * @param dA Dégâts d'attaque du monstre
     * @param pPar Points de parade du monstre
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param p Position du monstre
     */
    
    public Monstre (int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        super(pV,dA, pPar, paAtt, paPar, p);
    }
    
    /**
    * Constructeur de copie de monstre
    * @param m à copier
     */
    public Monstre(Monstre m) {
        super((Creature)m);
    }
    
    /**
     *Constructeur par défaut de Monstre
     */
    public Monstre() {
        super();
    }
}
