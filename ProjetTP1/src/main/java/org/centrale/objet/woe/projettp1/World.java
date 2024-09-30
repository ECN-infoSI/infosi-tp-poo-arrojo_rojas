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
     * Array pour des Creatures
    */
    public ArrayList<Creature> crea;
    /**
     * Array pour des objets
    */
    public ArrayList<Objet> obj;
    /**
     * Taille du monde
    */
    public final static int TAILLE_WORLD = 50; 
    
    /**
     * Constructeur par défaut de World
    */
    public World(){
        //world = new HashMap();
        int taille = TAILLE_WORLD;
        crea = new ArrayList<>();
        obj = new ArrayList<>();
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
        obj.add(ps);
        obj.add(epee);
    }
    
    /**
     * Constructeur de World
     * @param crea creature
     * @param obj objet
    */
    public World(ArrayList<Creature> crea, ArrayList<Objet> obj) {
        this.crea = crea;
        this.obj = obj;
    }
    
    /**
     * Méthode permettant d'initialiser les positions des objets dans le monde
    */
    public void creerMondeAlea(){
        Random generateurAleatoire = new Random();
        
   	int nombre_crea = crea.size();
    	ArrayList<Point2D> vu = new ArrayList<>();
    	for (int i = 0; i < nombre_crea; i++){
        	do {
                    crea.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD),generateurAleatoire.nextInt(TAILLE_WORLD));
        	} while (vu.contains(crea.get(i).getPos()));
        	vu.add(crea.get(i).getPos());
    	}
        
        int nombre_obj = obj.size();
        ArrayList<Point2D> vu_obj = new ArrayList<>();
        for (int i = 0; i < nombre_obj; i++) {
                do {
                    obj.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
                } while (vu_obj.contains(obj.get(i).getPos()));
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
     * Methode pour afficher creatures et objets
    */
    public void affiche() {
        int nombre_crea = crea.size();
        for (int i = 0 ; i < nombre_crea ; i++){
            crea.get(i).affiche();
        }
        int nombre_obj = obj.size();
        for (int i = 0 ; i < nombre_obj ; i++){
            obj.get(i).affiche();
        }
        
    }
    
    /**
     * Méthode pour soigner 
    */
    public void soigne() {
        ArrayList<Integer> a_supprimer = new ArrayList<>();

        // Itera sobre os objetos na lista 'obj'
        for (int i = 0; i < obj.size(); i++) {
            // Verifica se o objeto na posição 'i' é uma instância de 'Potion'
            if (obj.get(i) instanceof PotionSoin) {
                PotionSoin potion = (PotionSoin) obj.get(i);  // Downcast para 'Potion'

                // Itera sobre as criaturas na lista 'crea'
                for (int j = 0; j < crea.size(); j++) {
                    // Verifica se a posição da criatura e da poção são iguais
                    if (crea.get(j).getPos().equals(potion.getPos())) {
                        // Cura a criatura com o valor de cura da poção
                        crea.get(j).setPtVie(crea.get(j).getPtVie() + potion.getValeur_soin());

                        // Adiciona o índice da poção à lista de remoção
                        a_supprimer.add(i);
                    }
                }
            }
        }
        // Remove as poções utilizadas
        for (int k = 0; k < obj.size(); k++) {
            if (a_supprimer.contains(k)) {
                obj.set(k, null); // Remove a poção ao definir como 'null'
            }
        }
    }
    
    public boolean caseLibre(Point2D pos) {
        int nombre_crea = crea.size();
        for(int i = 0; i < nombre_crea; i++) {
            if (crea.get(i).getPos() == pos) {
                return false;
            }
        }
        return true;       
    }
}
