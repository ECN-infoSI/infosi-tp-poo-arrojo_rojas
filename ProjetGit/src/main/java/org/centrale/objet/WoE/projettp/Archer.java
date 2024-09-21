/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;

/**
 *
 * @author Augusto Arrojo et Fernando ROJAS
 */
public class Archer extends Personnage {
    private int nbFleches;
    
    public Archer (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFleches) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        this.nbFleches = nbFleches;
    }
    
    public Archer(Archer a) {
        super(a);  // Appel au constructeur par copie de la classe parent Lapin
        this.nbFleches = a.nbFleches;
    }
    
    public Archer(){
        super();
        this.nbFleches = 5;
    }
}
