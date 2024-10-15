/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

/**
 * Classe qui gére les élements du jeu
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class ElementDeJeu {
    private Point2D pos;

    /**
     * Constructeur de la classe ElementDeJeu
     * @param pos Position de l'élément de jeu
    */
    public ElementDeJeu(Point2D pos) {
        this.pos = new Point2D(pos);
    }
    
    /**
     * Constructeur par défaut de la classe ElementDeJeu
     */
    public ElementDeJeu() {
        this.pos = new Point2D(0,0);
    }
    
    /**
     * Constructeur de recopie de la classe ElementDeJeu
     * @param m Élement de jeu à recopier
     */
    public ElementDeJeu(ElementDeJeu m) {
        this.pos = new Point2D(m.pos);
    }

    /**
     * Getter de l'attribut Pos
     * @return La position de l'élément de jeu
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Setter de l'attribut position
     * @param pos La nouvelle position de l'élément de jeu
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }
}
