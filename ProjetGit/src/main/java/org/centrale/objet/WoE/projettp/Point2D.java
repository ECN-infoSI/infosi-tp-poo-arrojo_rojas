

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;


/**
 *
 * @author Fernando ROJAS
 */
public class Point2D{
    private int PosX;
    private int PosY;
    
    public Point2D(int x, int y){
        PosX = x;
        PosY = y;          
    }
    
    public Point2D(Point2D pto){
        PosX = pto.getX();
        PosY = pto.getY();
    }
           
    public Point2D(){
        PosX = 0;
        PosY = 0;
    }
    
    public int getX(){
        return this.PosX;
    }
    
    public int getY(){
        return this.PosY;
    }
    
    public void setX(int x){
        this.PosX = x;
    }
    
    public void setY(int y){
        this.PosY = y;
    }
    
    public void setPosition(int x, int y){
        this.setX(x);
        this.setY(y);
    }
    
    public void translate(int dx, int dy){
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);         
    }
    
    public void affiche(){
        System.out.println("X = " + this.getX());
        System.out.println("Y = " + this.getY());
    }
    
    public float distance(Point2D p){
        float distance = (float) Math.sqrt(p.getX() << 2 + p.getY() << 2);
        return distance;
    }
}


