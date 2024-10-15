/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;
import java.util.Map;
/**
 * Sous-classe de Créature qui gére les monstres
 * @author Augusto ARROJO et Fernando ROJAS
*/
public abstract class Monstre extends Creature {

    /**
     *Constructeur de monstre
     * @param pV Point de vie du monstre
     * @param dA Dégâts d'attaque du monstre
     * @param pPar Points de parade du monstre
     * @param paAtt Pourcentage de chance de toucher avec une attaque
     * @param paPar Pourcentage de chance de parer une attaque
     * @param p Position du monstre
     * @param effets Liste des effets subis par le monstre
    */
    
    public Monstre (int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, Map<String, Nourriture> effets){
        super(pV,dA, pPar, paAtt, paPar, p, effets);
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
