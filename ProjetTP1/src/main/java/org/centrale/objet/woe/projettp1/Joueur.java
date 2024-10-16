/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Random;
import java.util.Iterator;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui permet au joueur utiliser une personnage à partir d'une liste des
 * disponibles
 *
 * @author Fernando ROJAS et Augusto ARROJO
 */
public final class Joueur {

    HashMap<String, Class> perso_dispos;
    public Personnage perso_joueur;
    private Class classe_p;
    private ArrayList<Nourriture> inventaire;

    /**
     * Constructeur par default de la classe joueur
     */
    public Joueur() {
        perso_dispos = new HashMap<>(); //On crée une liste des classes qui sont disponibles pour choisir
        perso_dispos.put("archer", Archer.class);
        perso_dispos.put("guerrier", Guerrier.class);
        this.inventaire = new ArrayList<>();
    }

    /**
     * Constructeur par copie de la classe joueur
     *
     * @param perso_d
     * @param class_p
     * @param personnage
     * @param inventaire
     */
    public Joueur(HashMap<String, Class> perso_d, Class class_p, Personnage personnage, ArrayList<Nourriture> inventaire) {
        this.classe_p = class_p;
        this.perso_dispos = perso_d;
        this.perso_joueur = personnage;
        this.inventaire = inventaire;
    }

    /**
     * Méthode qui permet de choisir le personnage qui va gérer le joueur
     */
    public void choisir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez choisir une personnage entre les suivants : ");
        Set<String> cles = perso_dispos.keySet();
        for (String c : cles) {
            System.out.println(c);
        }

        //On demande le nom de la classe souhaité, s'il n'existe pas
        //On continue le boucle jusqu'avoir une bonne reponse
        boolean k = false;
        while (!k) {
            String perso = scanner.nextLine();
            k = cles.contains(perso.toLowerCase());

            if (k) {
                classe_p = perso_dispos.get(perso);
            } else {
                //Message affiché de au'on a tort est on tente enconre une fois
                System.out.println("Personnage pas reconnu, essayez encore une fois");
            }
        }

        //Demande du nom du personnage
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Écrivez le nom que vous voulez pour votre personnage :");
        System.out.println("(Si vous écrivez rien, un nom aléatoire sera fourni au personnage)");
        String nomPerso = scanner2.nextLine();
        if ("".equals(nomPerso)) {
            Random ale = new Random();
            switch (ale.nextInt(0, 4)) {
                case 0:
                    nomPerso = "Paul";
                    break;
                case 1:
                    nomPerso = "Louis";
                    break;
                case 2:
                    nomPerso = "Jean";
                    break;
                case 3:
                    nomPerso = "Marie";
                    break;
                default:
                    nomPerso = "Roman";
            }
        }

        Map<String, Nourriture> effets = new HashMap<>();

        if (classe_p == Archer.class) {
            // Générer des valeurs aléatoires spécifiques pour Archer
            int ptVie = genererAleatoire(50, 80);    // Vie moins élevée pour Archer
            int degAtt = genererAleatoire(20, 40);   // Dégâts d'attaque moins élevés
            int ptPar = genererAleatoire(10, 30);    // Points de défense plus faibles
            int pageAtt = genererAleatoire(10, 20);  // Points d'attaque plus élevés
            int pagePar = genererAleatoire(5, 15);   // Points de parade plus faibles
            int distAttMax = genererAleatoire(0, 5); // Distance d'attaque plus élevée
            int nbFleches = genererAleatoire(10, 30); // Nombre de flèches
            Point2D pos = new Point2D(genererAleatoire(0, TAILLE_WORLD-1), genererAleatoire(0, TAILLE_WORLD-1));

            // Création de l'archer
            perso_joueur = new Archer(nomPerso, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets, nbFleches);
            perso_joueur.getPos().setPosition(pos.getX(), pos.getY());
            perso_joueur.setNom(nomPerso);
        } else if (classe_p == Guerrier.class) {
            // Générer des valeurs aléatoires spécifiques pour Guerrier
            int ptVie = genererAleatoire(80, 100);  // Vie plus élevée pour Guerrier
            int degAtt = genererAleatoire(30, 50);  // Dégâts d'attaque plus élevés pour Guerrier
            int ptPar = genererAleatoire(20, 40);   // Points de défense plus élevés
            int pageAtt = genererAleatoire(5, 15);  // Points d'attaque dans une gamme moyenne
            int pagePar = genererAleatoire(10, 20); // Points de parade dans une gamme moyenne
            int distAttMax = 1; // Distance d'attaque faible
            Point2D pos = new Point2D(genererAleatoire(0, TAILLE_WORLD-1), genererAleatoire(0, TAILLE_WORLD-1));
            // Création du Guerrier
            perso_joueur = new Guerrier(nomPerso, ptVie, degAtt, ptPar, pageAtt, pagePar, distAttMax, pos, effets);
            perso_joueur.getPos().setPosition(pos.getX(), pos.getY());
            perso_joueur.setNom(nomPerso);
        }
        System.out.println("Le personnage " + perso_joueur.getNom() + " pertinent à classe " + perso_joueur.getClass().getSimpleName() + " a été crée");
    }

    /**
     * Méthode pour gérer des nombres aleatoires
     *
     * @param min nombre minimum
     * @param max nombre maximum
     * @return Les point de vie du joueur
     */
    public static int genererAleatoire(int min, int max) {
        Random alea = new Random();
        return alea.nextInt(max - min + 1) + min;
    }

    /**
     * Getter de l'attribut point de vie
     *
     * @return Les point de vie du joueur
     */
    public int getPtVie() {
        return perso_joueur.getPtVie();
    }    
    /**
     * Getter de l'attribut personnage 
     * @return Le personnage du joueur
     */
    public Personnage getPersonnage() {
        return perso_joueur;
    }

    public void setPersonnage(Personnage perso) {
        perso_joueur = perso;
    }

    /**
     * Getter de l'attribut inventaire
     *
     * @return L'inventaire du joueur
     */
    public ArrayList<Nourriture> getInventaire() {
        return inventaire;
    }

    /**
     * Setter de l'attribut inventaire
     *
     * @param inventaire Le nouveau inventaire du joueur
     */
    public void setInventaire(ArrayList<Nourriture> inventaire) {
        this.inventaire = inventaire;
    }

    /**
     * Méthode d'affichage de l'inventaire du joueur
     */
    public void affiche_inventaire() {
        System.out.println("L'inventaire du joueur contient :");

        if (this.inventaire.isEmpty()) {
            System.out.println("L'inventaire est vide.");
        } else {
            // Utilisez un HashMap pour compter les occurrences de chaque objet
            Map<String, Integer> compteurObjets = new HashMap<>();

            // Compter les occurrences de chaque élément
            for (Nourriture obj : this.inventaire) {
                String nom = obj.getNom();
                compteurObjets.put(nom, compteurObjets.getOrDefault(nom, 0) + 1);
            }

            // Afficher les éléments avec leur nombre
            int numero = 1;
            for (Map.Entry<String, Integer> entry : compteurObjets.entrySet()) {
                System.out.println("Numéro " + numero + " : " + entry.getKey() + " (x" + entry.getValue() + ")");
                numero++;
            }
        }
    }

    /**
     * Méthode de ramassage d'un objet par le joueur
     *
     * @param monde Le monde dans lequel évolue le joueur
     */
    public void ramasser(World monde) {
        Iterator<Nourriture> iterator_n = monde.getConsommable().iterator();

        while (iterator_n.hasNext()) {
            Nourriture n = iterator_n.next();
            if (this.getPersonnage().getPos().equals(n.getPos())) {
                n.getPos().setPosition(-1, -1);
                this.getInventaire().add(n);
                System.out.println("Vous avez ramassé un(e) " + n.getNom());
                iterator_n.remove(); // Remove o item de forma segura
            }
        }
    }
}
