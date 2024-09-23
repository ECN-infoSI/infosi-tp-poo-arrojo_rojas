/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.centrale.objet.woe.projettp1;
import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * CLasse permettant de gérer la création du monde ainsi, que l'emplacement des différentes entités
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class World {
    HashMap<Object,Point2D> world;
    Archer robin;
    Paysan peon;
    Lapin bugs;
    ArrayList<Creature> crea;
    /*ArrayList<PotionSoin> potion;
    ArrayList<Epee> sword;   */
    
    /**
     *Constructeur par défaut de World
    */
    public World(){
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        world = new HashMap();
    }
    
    /**
     * Méthode permettant d'initialiser les positions des objets dans le monde
    */
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        //Object[] personnages = new Object[3];
        Object[] personnages = {robin, peon, bugs};
        //personnages[0] = robin;
        //personnages[1] = peon;
        //personnages[2] = bugs;
        
        int i = 0;
        
        while(i < personnages.length){
            int nbAleaX = generateurAleatoire.nextInt();
            int nbAleaY = generateurAleatoire.nextInt();
            Point2D p = new Point2D(nbAleaX,nbAleaY);
            
            if (world.containsValue(p)){
            } else {
                Point2D point = new Point2D(nbAleaX, nbAleaY);
                if(personnages[i].getClass() == Archer.class){
                    Archer archer = (Archer) personnages[i];
                    archer.setPos(point);
                    world.put(archer, point);
                    i++;
                } else if(personnages[i].getClass() == Paysan.class){
                    Paysan paysan = (Paysan) personnages[i];
                    paysan.setPos(point);
                    world.put(paysan, point);
                    i++;
                } else if(personnages[i].getClass() == Lapin.class){
                    Lapin lapin = (Lapin) personnages[i];
                    lapin.setPos(point);
                    world.put(lapin, point);
                    i++;
                } else if(personnages[i].getClass() == Monstre.class){
                    Monstre monstre = (Monstre) personnages[i];
                    monstre.setPos(point);
                    world.put(monstre, point);
                    i++;
                } else {
                    System.out.println("Personnage pas identifié");
                }
                
            }
        }
    }
    
}
