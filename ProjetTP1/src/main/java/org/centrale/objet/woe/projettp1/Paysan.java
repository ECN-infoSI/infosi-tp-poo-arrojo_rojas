/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

/**
 *
 * @author Augusto Arrojo et Fernando ROJAS
 */
public class Paysan extends Personnage {
    public Paysan (String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }
    
    public Paysan(Paysan p) {
        super(p);  // Appel au constructeur par copie de la classe parent Lapin
    }
    
    public Paysan(){
        super();
    }
}
