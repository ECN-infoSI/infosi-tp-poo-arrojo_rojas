/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;
import java.util.Random;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui permet au joueur utiliser une personnage à partir d'une liste des disponibles
 * @author Fernando ROJAS et Augusto ARROJO
 */
public class Joueur {
    HashMap<String,Class> perso_dispos; 
    Personnage perso_joueur;
    Class classe_p;
    private static Random random = new Random();
    
    /**
     * Constructeur de la classe Epee
     * @param perso_dispos Hashmap qui contient les classes de personnages qui sont disponibles à choisir
     */ 
    public Joueur(){ 
        perso_dispos = new HashMap<>(); //On crée une liste des classes qui sont disponibles pour choisir
        perso_dispos.put("archer", Archer.class);
        perso_dispos.put("guerrier", Guerrier.class);
    }
    /**
     * Méthode qui permet de choisir le personnage qui va gérer le joueur
     */
    public void choisir(){
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("Veuillez choisir une personnage entre les suivants");
        Set<String> cles = perso_dispos.keySet();
        for (String c : cles) {
            System.out.println(c);
        }
        
        //On demande le nom de la classe souhaité, s'il n'existe pas
        //On continue le boucle jusqu'avoir une bonne reponse
        boolean k = true;
        while (k){
        String perso = scanner.nextLine();
        k = cles.contains(perso.toLowerCase());
        
        if (k){
            classe_p = perso_dispos.get(perso);
        }
        else {
            //Message affiché de au'on a tort est on tente enconre une fois
            System.out.println("Personnage pas reconnu, essayez encore une fois");
        }
        }
        
        //Demande du nom du personnage
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Écrivez le nom que vous voulez pour votre personnage :  ? : ");
        System.out.println("(Si vous écrivez rien, un nom aléatoire sera fourni au personnage)");
        String nomPerso = scanner2.nextLine();
        if ("".equals(nomPerso)){
            nomPerso = "Personnage";
        }
            
        //Création personnage aléatoire
        System.out.println("Création du personnage en cours ... ");
        
        if (classe_p == Archer.class){
             // Générer des valeurs aléatoires spécifiques pour Archer
            int ptVie = genererAleatoire(50, 80);    // Vie moins élevée pour Archer
            int degAtt = genererAleatoire(20, 40);   // Dégâts d'attaque moins élevés
            int ptPar = genererAleatoire(10, 30);    // Points de défense plus faibles
            int pageAtt = genererAleatoire(10, 20);  // Points d'attaque plus élevés
            int pagePar = genererAleatoire(5, 15);   // Points de parade plus faibles
            int distAttMax = genererAleatoire(5, 10); // Distance d'attaque plus élevée
            int nbFleches = genererAleatoire(10, 30); // Nombre de flèches
            Point2D pos = new Point2D(genererAleatoire(0, TAILLE_WORLD), genererAleatoire(0, TAILLE_WORLD));  
            
        
            // Création de l'archer
            Archer archer = new Archer(nomPerso, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, nbFleches);
            perso_joueur = (Archer) archer;
        }
        else if (classe_p == Guerrier.class){
            // Générer des valeurs aléatoires spécifiques pour Guerrier
            int ptVie = genererAleatoire(80, 120);  // Vie plus élevée pour Guerrier
            int degAtt = genererAleatoire(30, 50);  // Dégâts d'attaque plus élevés pour Guerrier
            int ptPar = genererAleatoire(20, 40);   // Points de défense plus élevés
            int pageAtt = genererAleatoire(5, 15);  // Points d'attaque dans une gamme moyenne
            int pagePar = genererAleatoire(10, 20); // Points de parade dans une gamme moyenne
            int distAttMax = genererAleatoire(1, 3); // Distance d'attaque faible
            Point2D pos = new Point2D(genererAleatoire(0, TAILLE_WORLD), genererAleatoire(0, TAILLE_WORLD));

            // Création du Guerrier
            Guerrier guerrier = new Guerrier(nomPerso, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos);
            perso_joueur = (Guerrier) guerrier;
        }
        
        System.out.println("Création du personnage finalisé");
    }
    
    public static int genererAleatoire(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }
    
    
}