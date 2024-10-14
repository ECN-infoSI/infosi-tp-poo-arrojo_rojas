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
     * Taille du monde
     */
    public final static int TAILLE_WORLD = 50;

    /**
     * Constructeur par défaut de World
     */
    public World() {
        crea = new ArrayList<>();
        obj = new ArrayList<>();
    }

    /**
     * Constructeur de World
     *
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
    public void creerMondeAlea() {
        Random generateurAleatoire = new Random();
        int nombre_min_crea = 50;
        int RandG, RandL, RandA, RandLo, RandP;
        //Création des creatures aleatoires (minimum 50)
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
     * Getter de l'attribut crea
     *
     * @return La liste des créatures
     */
    public ArrayList<Creature> getCrea() {
        return crea;
    }
}
