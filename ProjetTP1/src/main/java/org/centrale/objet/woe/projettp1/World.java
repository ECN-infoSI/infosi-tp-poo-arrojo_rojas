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
    /**
     * HashMap pour du monde
    */
    public HashMap<Object,Point2D> world;
    /**
     * Array pour des Robins
    */
    public Archer robin;
    /**
     * Array pour des Paysans
    */
    public Paysan peon;
    /**
     * Array pour des Lapins
    */
    public Lapin bugs;
    /**
     * Array pour des Creatures
    */
    public ArrayList<Creature> crea;
    /**
     * Array pour des Potions de Soin
    */
    public ArrayList<PotionSoin> potion;
    /**
     * Array pour des Espee
    */
    public ArrayList<Epee> sword;
    
    /**
     * Taille du monde
    */
    public final static int TAILLE_WORLD = 50; 
    
    /**
     * Constructeur par défaut de World
    */
    public World(){
        //world = new HashMap();
        crea = new ArrayList<>();
        sword = new ArrayList<>();
        potion = new ArrayList<>();
        Archer robin = new Archer();
    	Paysan peon = new Paysan();
    	Lapin bugs1 = new Lapin();
    	Guerrier grosBill = new Guerrier();
    	Loup wolfie = new Loup();
        crea.add(robin);
    	crea.add(peon);
    	crea.add(bugs1);
    	crea.add(grosBill);
    	crea.add(wolfie);
        PotionSoin ps = new PotionSoin();
        Epee epee = new Epee();
        potion.add(ps);
        sword.add(epee);
    }
    
    /**
     * Constructeur de World
     * @param crea creature
     * @param potion potion
     * @param sword sword
     */
    public World(ArrayList<Creature> crea, ArrayList<PotionSoin> potion, ArrayList<Epee> sword) {
        this.crea = crea;
        this.potion = potion;
        this.sword = sword;
    }
    
    /**
     * Méthode permettant d'initialiser les positions des objets dans le monde
    */
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        
   	int nombre_crea = crea.size();
    	ArrayList<Point2D> vu = new ArrayList<>();
    	for (int i = 0 ; i < nombre_crea ; i++){
        	crea.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	while (vu.contains(crea.get(i).getPos())) {
                    crea.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	}
        	vu.add(crea.get(i).getPos());
    	}
        int nombre_potion = potion.size();
    	ArrayList<Point2D> vu_potion = new ArrayList<>();
    	for (int i = 0 ; i < nombre_potion ; i++){
        	potion.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	while (vu_potion.contains(potion.get(i).getPos())) {
                    potion.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	}
        	vu_potion.add(potion.get(i).getPos());
    	}
        int nombre_sword = sword.size();
    	ArrayList<Point2D> vu_sword = new ArrayList<>();
    	for (int i = 0 ; i < nombre_sword ; i++){
        	sword.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	while (vu_potion.contains(sword.get(i).getPos())) {
                    sword.get(i).getPos().setPosition(generateurAleatoire.nextInt(101)-50,generateurAleatoire.nextInt(101)-50);
        	}
        	vu_sword.add(sword.get(i).getPos());
    	}
        
          
        /*int i = 0;
        
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
        }     */
    }
    
    /**
     * Methode pour afficher potion, espée et creatures
    */
    public void affiche() {
        int nombre_crea = crea.size();
        for (int i = 0 ; i < nombre_crea ; i++){
            crea.get(i).affiche();
        }
        int nombre_potion = potion.size();
        for (int i = 0 ; i < nombre_potion ; i++){
            potion.get(i).affiche();
        }
        int nombre_sword = sword.size();
        for (int i = 0 ; i < nombre_sword ; i++){
            sword.get(i).affiche();
        }
        
    }
    
    /**
     * Méthode pour soigner 
    */
    public void soigne(){
    	ArrayList<Integer> a_supprimer = new ArrayList<>();
    	for (int i = 0 ; i < potion.size() ; i++){
            for (int j = 0; j < crea.size(); j++){
                if (crea.get(j).getPos().equals(potion.get(i).getPos())) {
                    crea.get(j).setPtVie(crea.get(j).getPtVie() + potion.get(i).getValeur_soin());
                     a_supprimer.add(i);
                }
            }
    	}
        
        for (int k = 0; k < potion.size(); k++) {
            if (a_supprimer.contains(k)){
                potion.set(k, null);
            }
        }
    }
}
