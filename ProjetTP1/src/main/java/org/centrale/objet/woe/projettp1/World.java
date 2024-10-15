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
            consommable.add(new Nourriture());
        }
        for (int i = 0; i < RandNT; i++) {
            nuage_toxique.add(new NuageToxique());
        }
        //Définir la position des objets
        int nombre_obj = obj.size();
        ArrayList<Point2D> vu_obj = new ArrayList<>();
        for (int i = 0; i < nombre_obj; i++) {
            do {
                obj.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
            } while (vu_obj.contains(obj.get(i).getPos()));
        }
        //Définir la position des consommables
        int nombre_con = consommable.size();
        ArrayList<Point2D> vu_con = new ArrayList<>();
        for (int i = 0; i < nombre_con; i++) {
            do {
                consommable.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
            } while (vu_con.contains(consommable.get(i).getPos()));
        }

        //Définir la position des nuages toxiques
        int nombre_nua = nuage_toxique.size();
        ArrayList<Point2D> vu_nua = new ArrayList<>();
        for (int i = 0; i < nombre_nua; i++) {
            do {
                nuage_toxique.get(i).getPos().setPosition(generateurAleatoire.nextInt(TAILLE_WORLD), generateurAleatoire.nextInt(TAILLE_WORLD));
            } while (vu_nua.contains(nuage_toxique.get(i).getPos()));
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
     * @return Les creatures
     */
    public ArrayList<Creature> getCrea() {
        return crea;
    }

    /**
     * Getter de l'attribut Objet
     *
     * @return Les objets
     */
    public ArrayList<Objet> getObjet() {
        return obj;
    }

    /**
     * Getter de l'attribut nuage
     *
     * @return La liste des nuage toxiques
     */
    public ArrayList<NuageToxique> getNuage() {
        return nuage_toxique;
    }

    /**
     * Getter de l'attribut consommables
     *
     * @return La liste des consommables
     */
    public ArrayList<Nourriture> getConsommable() {
        return consommable;
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
        for (int i = 0; i < 1.5 * x; i++) {
            delimit += "____"; // A linha de separação agora é padronizada para 4 underscores
        }

// Affiche chaque ligne du monde
        for (int j = -y; j < y; j++) {
            nv_ligne = ""; // Réinitialise la ligne pour chaque nouvelle ligne
            System.out.println(delimit); // Affiche la ligne de séparation
            for (int i = -x; i < x; i++) {
                String disp_char = "| |"; // Par défaut, c'est une case vide avec longueur 3
                Point2D pos = new Point2D(i, j);

                // Vérifie si c'est la position du joueur
                if (pos.equals(joueur)) {
                    disp_char = "|J|";  // Joueur, toujours 3 caractères
                } else {
                    // Vérifie si des consommables sont présents
                    for (Nourriture c : consommable) {
                        if (c.getPos().equals(pos)) {
                            disp_char = "|C|";  // Consommable, 3 caractères
                            break;
                        }
                    }

                    // Vérifie si des objets sont présents
                    for (Objet o : obj) {
                        if (o.getPos().equals(pos)) {
                            disp_char = "|O|";  // Objet, 3 caractères
                            break;
                        }
                    }

                    // Vérifie si un nuage toxique est présent
                    for (NuageToxique n : nuage_toxique) {
                        if (n.getPos().equals(pos)) {
                            disp_char = "|N|";  // Nuage toxique, 3 caractères
                            break;
                        }
                    }

                    // Vérifie si une créature est présente à cette position
                    for (Creature c : crea) {
                        if (c.getPos().equals(pos)) {
                            switch (c.getClass().getSimpleName()) {
                                case "Guerrier" ->
                                    disp_char = "|G|";
                                case "Archer" ->
                                    disp_char = "|A|";
                                case "Paysan" ->
                                    disp_char = "|P|";
                                case "Lapin" ->
                                    disp_char = "|R|";
                                case "Loup" ->
                                    disp_char = "|L|";
                            }
                            break;  // Sortir de la boucle si une créature est trouvée
                        }
                    }
                }

                nv_ligne += disp_char;  // Concatène le caractère à la ligne actuelle, toujours 3 caractères
            }
            System.out.println(nv_ligne); // Affiche la ligne complète
        }

        // Légende
        System.out.println("Légende : \tJ: Vous \tO: Objet \tC: Consommable \t G: Guerrier \t A: Archer \t P: Paysan \t R: Lapin \t L: Loup");
    }
}
