/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;


/**
 * Classe qui gére les ensembles de deux entiers représentant les corrdonées(x,y) d'entité dans le jeu
 * @author Augusto ARROJO et Fernando ROJAS
*/
class Point2D{
    private int PosX;
    private int PosY;
    /**
     * Constructeur de Point2D
     * @param a Coordonnée selon x
     * @param b Coordonnée selon y
    */
    public Point2D(int x, int y){
        this.PosX = x;
        this.PosY = y;          
    }
    /**
     * Constructeur de copie
     * @param p Point à recopier
    */
    public Point2D(Point2D pto){
        this.PosX = pto.getX();
        this.PosY = pto.getY();
    }
    /**
     * Constructeur par défaut
    */
    public Point2D(){
        this.PosX = 0;
        this.PosY = 0;
    }
    
    /**
     * Méthode pour obtenir la position x
     * @return la position x
    */
    public int getX(){
        return this.PosX;
    }
    /**
     * Méthode pour obtenir la position y
     * @return la position y
    */
    public int getY(){
        return this.PosY;
    }
    
    /**
     * Méthode pour obtenir les coordonnées d'un point
     * @return Les coordonnées x,y
    */
    public int[] GetPosition() {
        int tab[] = new int[2];
        tab[0] = PosX;
        tab[1] = PosY;
        
        return tab;
    }
    /**
     * Méthode pour définir la position x
     * @param x la position x
    */
    public void setX(int x){
        this.PosX = x;
    }
    
    /**
     * Méthode pour définir la position y
     * @param y la position y
    */
    public void setY(int y){
        this.PosY = y;
    }
    
    /**
     * Méthode pour définir la position x et y
     * @param x la position x
     * @param y la position y
    */ 
    public void setPosition(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    /**
     * Méthode pour définir la translate
     * @param dx la variation de la position x
     * @param dy la variation de la position y
    */  
    public void translate(int dx, int dy){
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);         
    }
    
    /**
     * Méthode pour afficher la position
     * @return position 
    */
    public void affiche(){
        System.out.println("Position: [" + this.getX()+ ", " + this.getY() + "]");
    }
    
    /**
     * Méthode de calculer la distance entre deux points
     * @param p Point à avec lequel mesurer la distance
     * @return Distance 
    */
    public float distance(Point2D p){
        float distance = (float) Math.sqrt(p.getX() << 2 + p.getY() << 2);
        return distance;
    }
}


