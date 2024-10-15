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
 * CLasse permettant de gérer la création du monde ainsi, que l'emplacement des
 * différentes entités
 *
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
     * Array pour des nourriture
     */
    public ArrayList<Nourriture> consommable;

    /**
     * Array pour des nuages toxiques
     */
    public ArrayList<NuageToxique> nuage_toxique;
    /**
     * Taille du monde
     */
    public final static int TAILLE_WORLD = 50;
    /**
     * Joueur
     */
    private Joueur player;

    /**
     * Constructeur par défaut de World
     */
    public World() {
        this.crea = new ArrayList<>();
        this.obj = new ArrayList<>();
        this.nuage_toxique = new ArrayList<>();
        this.consommable = new ArrayList<>();
    }

    /**
     * Constructeur de World
     *
     * @param crea creature
     * @param obj objet
     * @param nuage nuage toxique
     * @param consom consommables
     */
    public World(ArrayList<Creature> crea, ArrayList<Objet> obj, ArrayList<NuageToxique> nuage, ArrayList<Nourriture> consom) {
        this.crea = crea;
        this.obj = obj;
        this.nuage_toxique = nuage;
        this.consommable = consom;
    }

    /**
     * Méthode permettant d'initialiser des creatures et des objets dans le
     * monde
     */
    public void creerMondeAlea() {
        Random generateurAleatoire = new Random();
        int nombre_min_crea = 50;
        int RandG, RandL, RandA, RandLo, RandP;
        //Creation des creatures aleatoires (minimum 50)
        do {
            RandG = generateurAleatoire.nextInt(10) + 50;
            RandL = generateurAleatoire.nextInt(10) + 50;
            RandA = generateurAleatoire.nextInt(10) + 50;
            RandLo = generateurAleatoire.nextInt(10) + 50;
            RandP = generateurAleatoire.nextInt(10) + 50;
        } while (RandG + RandL + RandA + RandLo + RandP < nombre_min_crea);

        for (int i = 0; i < RandG; i++) {
            crea.add(new Guerrier());
        }
        for (int i = 0; i < RandA; i++) {
            crea.add(new Archer());
        }
        for (int i = 0; i < RandL; i++) {
            crea.add(new Lapin());
        }
        for (int i = 0; i < RandP; i++) {
            crea.add(new Paysan());
        }
        for (int i = 0; i < RandLo; i++) {
            crea.add(new Loup());
        }
        //Définir la position des creatures
        int nombre_crea = crea.size();
        ArrayList<Point2D> vu = new ArrayList<>();
        for (int i = 0; i < nombre_crea; i++) {
            do {
                crea.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
            } while (vu.contains(crea.get(i).getPos()));
            vu.add(crea.get(i).getPos());
        }

        //Création des objets aleatoires (minimum 50)
        int nombre_min_obj = 50;
        int RandPS, RandN, RandNT, RandEp;
        do {
            RandPS = generateurAleatoire.nextInt(10) + 50;
            RandN = generateurAleatoire.nextInt(10) + 50;
            RandNT = generateurAleatoire.nextInt(10) + 50;
            RandEp = generateurAleatoire.nextInt(10) + 50;
        } while (RandPS + RandN + RandNT + RandEp < nombre_min_obj);

        for (int i = 0; i < RandPS; i++) {
            obj.add(new PotionSoin());
        }
        for (int i = 0; i < RandEp; i++) {
            obj.add(new Epee());
        }
        for (int i = 0; i < RandN; i++) {
            obj.add(new Nourriture());
        }
        for (int i = 0; i < RandNT; i++) {
            obj.add(new NuageToxique());
        }
        //Définir la position des objets
        int nombre_obj = obj.size();
        ArrayList<Point2D> vu_obj = new ArrayList<>();
        for (int i = 0; i < nombre_obj; i++) {
            do {
                obj.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
            } while (vu_obj.contains(obj.get(i).getPos()));
        }
    }

    /**
     * Methode pour afficher des creatures et des objets
     */
    public void affiche() {
        System.out.println("Creatures : ");
        int nombre_crea = crea.size();
        for (int i = 0; i < nombre_crea; i++) {
            crea.get(i).affiche();
        }

        System.out.println("Objets : ");
        int nombre_obj = obj.size();
        for (int i = 0; i < nombre_obj; i++) {
            obj.get(i).affiche();
        }

    }

    /**
     * Methode pour afficher les nombres de creatures et des objets
     */
    public void quantite_elements() {
        int nombre_crea = crea.size();
        int nombre_obj = obj.size();

        System.out.println("Il y a " + nombre_crea + " creatures et " + nombre_obj + " objets présent dans le monde !");
    }

    /**
     * Methode pour afficher des différentes creatures
     */
    public void affiche_protagoniste() {
        int p = 0;
        int g = 0;
        int l = 0;
        int a = 0;
        int lo = 0;
        for (Creature c : crea) {
            if ("Paysan".equals(c.getClass().getSimpleName())) {
                p += 1;
            }
            if ("Loup".equals(c.getClass().getSimpleName())) {
                lo += 1;
            }
            if ("Guerrier".equals(c.getClass().getSimpleName())) {
                g += 1;
            }
            if ("Archer".equals(c.getClass().getSimpleName())) {
                a += 1;
            }
            if ("Lapin".equals(c.getClass().getSimpleName())) {
                l += 1;
            }
        }
        System.out.println("Le monde contient " + g + " Guerriers");
        System.out.println("Le monde contient " + a + " Archers");
        System.out.println("Le monde contient " + p + " Paysans");
        System.out.println("Le monde contient " + l + " Lapins");
        System.out.println("Le monde contient " + lo + " Loups");

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

    /**
     * Méthode poue créer du joueur
     */
    public void createJoueur() {
        player = new Joueur();
        Point2D pos = new Point2D();
        player.choisir();
    }

    /**
     * Getter de l'attribut player
     *
     * @return Le joueur
     */
    public Joueur getJoueur() {
        return player;
    }

    /**
     * Getter de l'attribut crea
     *
     * @return La liste des créatures
     */
    public ArrayList<Creature> getCrea() {
        return crea;
    }

    /**
     * Méthode d'affichage du display avec la logique de test intégrée
     */
    public void afficheDisplay() {
        int x = TAILLE_WORLD;
        int y = TAILLE_WORLD;
        Point2D joueur = player.getPersonnage().getPos();
        String delimit = "";
        String nv_ligne = "";

        // Crée la ligne de séparation
        for (int i = -x; i < x; i++) {
            delimit += "____";
        }

        // Affiche chaque ligne du monde
        for (int j = -y; j < y; j++) {
            nv_ligne = "";
            System.out.println(delimit);
            for (int i = -x; i < x; i++) {
                nv_ligne += " ";
                Point2D pos = new Point2D(i, j);

                // Vérifie si c'est la position du joueur
                if (pos.equals(joueur)) {
                    nv_ligne += "|J|";  // Joueur
                } else {
                    boolean creatureTrouvee = false;

                    // Vérifie si une créature est présente à cette position
                    for (Creature c : crea) {
                        if (c.getPos().equals(pos)) {
                            switch (c.getClass().getSimpleName()) {
                                case "Guerrier":
                                    nv_ligne += "|G|";
                                    break;
                                case "Archer":
                                    nv_ligne += "|A|";
                                    break;
                                case "Paysan":
                                    nv_ligne += "|P|";
                                    break;
                                case "Lapin":
                                    nv_ligne += "|R|";
                                    break;
                                case "Loup":
                                    nv_ligne += "|L|";
                                    break;
                            }
                            creatureTrouvee = true;
                            break;  // Sortir de la boucle si une créature est trouvée
                        }
                    }

                    // Si aucune créature n'a été trouvée, vérifie pour un objet
                    if (!creatureTrouvee) {
                        boolean objetTrouve = false;
                        for (Nourriture o : consommable) {
                            if (o.getPos().equals(pos)) {
                                nv_ligne += "|O|";  // Objet
                                objetTrouve = true;
                                break;
                            }
                        }
                        // Si aucune créature ni objet n'a été trouvé, affiche un espace vide
                        if (!objetTrouve) {
                            nv_ligne += "| |";
                        }
                    }
                }
            }
            System.out.println(nv_ligne);
        }

        // Légende
        System.out.println("Légende : \tJ: Vous \t O: Objet \t G: Guerrier \t A: Archer \t P: Paysan \t R: Lapin \t L: Loup");
    } 
}
