/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
*/
package org.centrale.objet.woe.projettp1;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


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
        int Total_PV = 0;
            
        ArrayList<Creature> crea = new ArrayList<>();
        ArrayList<Objet> obj = new ArrayList<>();
        
        /*PotionSoin Ps1 = new PotionSoin();
        obj.add(Ps1);
        Epee Ep1 = new Epee();
        obj.add(Ep1);*/
                   
            
        World wrld = new World(crea,obj);
        wrld.creerMondeAlea(); 
        
        Random alea = new Random();
        int RandG = alea.nextInt(50);
        int RandL = alea.nextInt(50);
        int RandA = alea.nextInt(50);
        int RandLo = alea.nextInt(50);
        int RandP = alea.nextInt(50);
        for (int i=0;i<RandG;i++) {
            crea.add(new Guerrier());
        }
        for (int i=0;i<RandA;i++) {
            crea.add(new Archer());
        }
        for (int i=0;i<RandL;i++) {
            crea.add(new Lapin());
        }
        for (int i=0;i<RandP;i++) {
            crea.add(new Paysan());
        }
        for (int i=0;i<RandLo;i++) {
            crea.add(new Loup());
        }
            
        for (Creature c : wrld.crea) {
            Total_PV += c.getPtVie();
        }
        wrld.affiche_protagoniste();
        System.out.println("Le nombre total de PV est " + Total_PV);
       
        //wrld.affiche();
        
            /*Test Conteneur */
        ArrayList<Creature> listCrea = new ArrayList<>();
        int tailleListCrea = 100;
        for (int i = 0; i < tailleListCrea; i++) {
            listCrea.add(new Guerrier());
        }
             
        long debutN = System.nanoTime();
        int PVTest1=0;
        for (Creature c : listCrea) {
            PVTest1 += c.getPtVie();
        }
        long finN = System.nanoTime();
        System.out.println("Temps ecoulé en ns pour calculer les PV totaux avec un tableau avec itérateur : " + (finN-debutN));
            
        long debutN2 = System.nanoTime();
        int PVTest2=0;
        for (int i = 0; i < tailleListCrea; i++) {
            PVTest2 += listCrea.get(i).getPtVie();
        }
        long finN2 = System.nanoTime();
        System.out.println("Temps ecoulé en ns pour calculer les PV totaux avec un tableau avec parcours basé sur la taille : " + (finN2-debutN2));
            
        LinkedList<Creature> listLinkCrea = new LinkedList<>();
        for (int i = 0; i <= tailleListCrea; i++) {
            listLinkCrea.add(new Guerrier());
        }
             
        long debutN3 = System.nanoTime();
        int PVTest3=0;
        for (Creature c : listLinkCrea) {
            PVTest3 += c.getPtVie();
        }
        long finN3 = System.nanoTime();
        System.out.println("Temps ecoulé en ns pour calculer les PV totaux avec une liste chainée avec itérateur : " + (finN3-debutN3));
            
        long debutN4 = System.nanoTime();
        int PVTest4 = 0;
        for (int i = 0; i < tailleListCrea; i++) {
            PVTest4 += listLinkCrea.get(i).getPtVie();
        }
        long finN4 = System.nanoTime();
        System.out.println("Temps ecoulé en ns pour calculer les PV totaux avec une liste chainée avec parcours basé sur la taille : " + (finN4-debutN4));
    
        // Check database
        DatabaseTools database = new DatabaseTools ();
        database.getConnection();
    }
}
