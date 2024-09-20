/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.centrale.objet.woe.projettp1;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fe_a8
 */
public class World {
    Archer robin;
    Paysan peon;
    Lapin bugs;
    int[][] matrix;
    int a;
    int b;
           
    
    public World(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Indiquer la taille du monde");
        System.out.printf("Taille horizontal : ");
        a = scanner.nextInt();
        System.out.printf("Taille vertical : ");
        b = scanner.nextInt();
        matrix = new int[a][b];    
    }
    
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        
        //Object[] personnages = new Object[3];
        Object[] personnages = {robin, peon, bugs};
        //personnages[0] = robin;
        //personnages[1] = peon;
        //personnages[2] = bugs;
        System.out.println(personnages[1] == peon);
        
        int i = 0;
        
        while(i < personnages.length){
            int nbAleaX = generateurAleatoire.nextInt(a);
            int nbAleaY = generateurAleatoire.nextInt(b);
            
            if (matrix[nbAleaX][nbAleaY] == 0){
            } else {
                Point2D point = new Point2D(nbAleaX, nbAleaY);
                if(personnages[i].getClass() == Archer.class){
                    Archer archer = (Archer) personnages[i];
                    archer.setPos(point);
                    matrix[nbAleaX][nbAleaY] = i;
                    i++;
                } else if(personnages[i].getClass() == Paysan.class){
                    Paysan paysan = (Paysan) personnages[i];
                    paysan.setPos(point);
                    matrix[nbAleaX][nbAleaY] = i;
                    i++;
                } else if(personnages[i].getClass() == Lapin.class){
                    Lapin lapin = (Lapin) personnages[i];
                    lapin.setPos(point);
                    matrix[nbAleaX][nbAleaY] = i;
                    i++;
                } else if(personnages[i].getClass() == Monstre.class){
                    Monstre monstre = (Monstre) personnages[i];
                    monstre.setPos(point);
                    matrix[nbAleaX][nbAleaY] = i;
                    i++;
                } else {
                    System.out.println("Personnage pas identifié");
                }
                
            }
        }
    }
    
}
