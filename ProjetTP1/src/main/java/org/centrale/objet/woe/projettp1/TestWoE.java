/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.centrale.objet.woe.projettp1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Methode pour tester le jeu
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
public class TestWoE {

    /**
     * Methode pour tester le jeu
     *
     * @param args paramètres du main
     */
    public static void main(String[] args) {

        Archer Arch1 = new Archer();
        Guerrier Guer1 = new Guerrier();
        Lapin Lap1 = new Lapin();
        Loup Loup1 = new Loup();
        Paysan Pays1 = new Paysan();
        PotionSoin Ps1 = new PotionSoin();
        Epee Ep1 = new Epee();
            
        ArrayList<Creature> crea = new ArrayList<>();
        ArrayList<Objet> obj = new ArrayList<>();
            
        crea.add(Arch1);
        crea.add(Guer1);
        crea.add(Lap1);
        crea.add(Pays1);
        crea.add(Loup1);
            
        obj.add(Ps1);
        obj.add(Ep1);
                   
            
        World wrld = new World(crea,obj);
        wrld.creerMondeAlea(); 
        
        wrld.affiche();
        System.out.println("------------------------------");              
        System.out.println("Génération du monde: Essai n°2");
        World wrld2 = new World();
        wrld2.creerMondeAlea();
            
        wrld2.affiche();
	
        /*Création et placements des entités pour le test de déplacement*/
 /*System.out.println("Test de déplacement");
        Point2D pa = new Point2D(0,0);
        Point2D pb = new Point2D(10,10);
        Point2D pc = new Point2D(-10,-10);
            
        Lapin bugs = new Lapin(100,40,30,80,60,pa);
        Paysan peons = new Paysan("Roger",100,20,5,60,60,10,pb);
        Archer robin = new Archer("Steve",10,100,30,10,60,30,pc,10);
            
            
        /*Test de déplacement*/
 /*bugs.affiche();
        System.out.println("Déplacement de bugs");
        bugs.deplace();
        bugs.affiche();
        bugs.deplace();
        bugs.affiche();
        bugs.deplace();
        bugs.affiche();
            
        peons.affiche();
        System.out.println("Déplacement de peons");
        peons.deplace();
        peons.affiche();
        peons.deplace();
        peons.affiche();
        peons.deplace();
        peons.affiche();
            
        robin.affiche();
        System.out.println("Déplacement de robin");
        robin.deplace();
        robin.affiche();
        robin.deplace();
        robin.affiche();
        robin.deplace();
        robin.affiche();
            
            
        /*Test de copie*/
        /*
        Point2D r1 = new Point2D(0, 0);
        Archer robin = new Archer("robin", 10, 100, 30, 10, 60, 30, r1, 10);
        Archer GuillaumeT = new Archer(robin);

        System.out.println("La position de robin est " + Arrays.toString(robin.getPos().GetPosition()));
        System.out.println("La position de GuillaumeT est " + Arrays.toString(GuillaumeT.getPos().GetPosition()));
        robin.deplace();
        System.out.println("La position de robin est " + Arrays.toString(robin.getPos().GetPosition()));
        System.out.println("La position de GuillaumeT est " + Arrays.toString(GuillaumeT.getPos().GetPosition()));


        /*Création et placements des entités pour le test de combat*/
        /*System.out.println("Test du combat");
        Point2D p1 = new Point2D(0, 0);
        Point2D p2 = new Point2D(1, 0);
        Point2D p3 = new Point2D(0, 1);
        Guerrier Bob = new Guerrier("Kevin", 40, 40, 30, 45, 90, 5, p1);
        Loup random_mob = new Loup(100, 20, 5, 60, 60, p2);
        Archer Steve = new Archer("Steve", 75, 30, 20, 30, 5, 10, p3, 4);

        
        /*Test de combat */
        /*
        Bob.affiche();
        random_mob.affiche();
        Steve.affiche();
        Bob.combattre(random_mob);
        Bob.combattre(random_mob);
        Bob.combattre(Steve);
        random_mob.combattre(Bob);
        Steve.combattre(Bob);
        Steve.combattre(Bob);
        Bob.affiche();
        random_mob.affiche();
        Steve.affiche();

        /*Test de Soin*/
 /*Point2D pa1 = new Point2D(0,0);
        Point2D pa2 = new Point2D(1,0);
        Point2D pa3 = new Point2D(-1,0);
        Point2D pa4 = new Point2D(0,1);
        Point2D pa5 = new Point2D(0,-1);
            
        Lapin Sujet_de_test = new Lapin(100,40,30,80,60,pa1);
        PotionSoin P1 = new PotionSoin(10,"Potion 1",0,0,"C'est la potion 1",pa2);
        PotionSoin P2 = new PotionSoin(20,"Potion 2",0,0,"C'est la potion 2",pa3);
        PotionSoin P3 = new PotionSoin(30,"Potion 3",0,0,"C'est la potion 3",pa4);
        PotionSoin P4 = new PotionSoin(40,"Potion 4",0,0,"C'est la potion 4",pa5);
            
        ArrayList<Creature> crea = new ArrayList<>();
        ArrayList<PotionSoin> potion = new ArrayList<>();
        ArrayList<Epee> sword = new ArrayList<>();
            
        crea.add(Sujet_de_test);
        potion.add(P1);
        potion.add(P2);
        potion.add(P3);
        potion.add(P4);
            
        World Test_Soin = new World(crea,potion,sword);
        Test_Soin.crea.get(0).affiche();
        Test_Soin.crea.get(0).deplace();
        System.out.println("Avant que le lapin boive la potion il a " + Test_Soin.crea.get(0).getPtVie());
         Test_Soin.soigne();
        System.out.println("Après avoir bu la potion, le lapin a " + Test_Soin.crea.get(0).getPtVie());
        if (Test_Soin.potion.get(0) != null){
            Test_Soin.potion.get(0).affiche();
        }
        else {
            System.out.println("La potion 1 a été consommée");
        }
        if (Test_Soin.potion.get(1) != null){
            Test_Soin.potion.get(1).affiche();
        } else {
            System.out.println("La potion 2 a été consommée");
        }
        if (Test_Soin.potion.get(2) != null){
           Test_Soin.potion.get(2).affiche();
        }
        else {
            System.out.println("La potion 3 a été consommée");
        }
        if (Test_Soin.potion.get(3) != null){
            Test_Soin.potion.get(3).affiche();
        }
        else {
            System.out.println("La potion 4 a été consommée");
        }*/
    }
}
