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
import java.util.Scanner;

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
    public final static int TAILLE_WORLD = 10;
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
        int nombre_min_crea = 0;
        int RandG = 0, RandL = 0, RandA = 0, RandLo = 0, RandP = 0;
        //Creation des creatures aleatoires (minimum 50)
        do {
            RandG = generateurAleatoire.nextInt(10) + nombre_min_crea / 5;
            RandL = generateurAleatoire.nextInt(10) + nombre_min_crea / 5;
            RandA = generateurAleatoire.nextInt(10) + nombre_min_crea / 5;
            RandLo = generateurAleatoire.nextInt(10) + nombre_min_crea / 5;
            RandP = generateurAleatoire.nextInt(10) + nombre_min_crea / 5;
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
        int nombre_min_obj = TAILLE_WORLD;
        int RandPS, RandN, RandNT, RandEp;
        do {
            RandPS = generateurAleatoire.nextInt(10) + nombre_min_obj / 4;
            RandN = generateurAleatoire.nextInt(10) + nombre_min_obj / 4;
            RandNT = generateurAleatoire.nextInt(10) + nombre_min_obj / 4;
            RandEp = generateurAleatoire.nextInt(10) + nombre_min_obj / 4;
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

        System.out.println("Consommables : ");
        int nombre_con = consommable.size();
        for (int i = 0; i < nombre_con; i++) {
            consommable.get(i).affiche();
        }

        System.out.println("Nuage Toxique : ");
        int nombre_nua = nuage_toxique.size();
        for (int i = 0; i < nombre_nua; i++) {
            nuage_toxique.get(i).affiche();
        }
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
        player.choisir();
        Point2D pos = new Point2D();
        player.getPersonnage().setPos(pos);
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
        int x = TAILLE_WORLD; // Taille du monde sur l'axe X
        int y = TAILLE_WORLD; // Taille du monde sur l'axe Y
        Point2D joueur = player.getPersonnage().getPos(); // Position du joueur
        StringBuilder delimit = new StringBuilder();
        StringBuilder nv_ligne;

        // Crée la ligne de séparation
        for (int i = 0; i < 1.5 * x; i++) {
            delimit.append("____"); // Ligne de séparation
        }

        // Affiche chaque ligne du monde (de haut en bas)
        for (int j = 0; j < y; j++) { // Itération de 0 jusqu'à la valeur maximale de y
            nv_ligne = new StringBuilder(); // Réinitialise la ligne pour chaque nouvelle ligne
            System.out.println(delimit); // Affiche la ligne de séparation

            for (int i = 0; i < x; i++) { // Itération de 0 jusqu'à la valeur maximale de x
                String disp_char = "| |"; // Par défaut, une cellule vide
                Point2D pos = new Point2D(i, j); // Position actuelle sur la carte

                // Vérifie si c'est la position du joueur
                if (pos.equals(joueur)) {
                    disp_char = "|J|"; // Joueur
                } else {
                    // Vérifie pour les consommables
                    for (Nourriture c : consommable) {
                        if (c.getPos().equals(pos)) {
                            disp_char = "|C|"; // Consommable
                            break;
                        }
                    }

                    // Vérifie pour les objets
                    for (Objet o : obj) {
                        if (o.getPos().equals(pos)) {
                            switch (o.getClass().getSimpleName()) {
                                case "Epee" ->
                                    disp_char = "|E|"; // Épée
                                case "PotionSoin" ->
                                    disp_char = "|O|"; // Potion
                            }
                            break; // Quitte la boucle si un objet est trouvé
                        }
                    }

                    // Vérifie pour les nuages toxiques
                    for (NuageToxique n : nuage_toxique) {
                        if (n.getPos().equals(pos)) {
                            disp_char = "|N|"; // Nuage toxique
                            break;
                        }
                    }

                    // Vérifie pour les créatures
                    for (Creature c : crea) {
                        if (c.getPos().equals(pos)) {
                            switch (c.getClass().getSimpleName()) {
                                case "Guerrier" ->
                                    disp_char = "|G|"; // Guerrier
                                case "Archer" ->
                                    disp_char = "|A|"; // Archer
                                case "Paysan" ->
                                    disp_char = "|P|"; // Paysan
                                case "Lapin" ->
                                    disp_char = "|R|"; // Lapin
                                case "Loup" ->
                                    disp_char = "|L|"; // Loup
                            }
                            break; // Quitte la boucle si une créature est trouvée
                        }
                    }
                }

                nv_ligne.append(disp_char); // Concatène le caractère à la ligne actuelle
            }
            System.out.println(nv_ligne); // Affiche la ligne complète
        }

        // Légende
        System.out.println("Légende : \t J: Vous \t E: Épée \t O: Potion \t C: Consommable \t G: Guerrier \t A: Archer \t P: Paysan \t R: Lapin \t L: Loup \t N: Nuage Toxique");
    }

    public boolean check_deplacement(Point2D pos) {
        if (pos.getX() > TAILLE_WORLD || pos.getY() > TAILLE_WORLD || pos.getX() < 0 || pos.getY() < 0) {
            return false;
        }
        int nombre_crea = crea.size();
        for (int i = 0; i < nombre_crea; i++) {
            if (crea.get(i).getPos().equals(pos)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode de déplacement du joueur
     *
     * @return true si le jouer a deplacé
     */
    public void deplaceJoueur() {
        Scanner sc = new Scanner(System.in);
        Point2D pos = player.getPersonnage().getPos(); // position initial du jouer
        int x, y;

        System.out.println("Rentrez une direction: ");
        System.out.println("N | NE | E | SE | S | SO | O | NO");

        while (true) {
            String direction = sc.nextLine().toUpperCase();

            // Réinitialiser les variables x et y pour chaque nouvelle entrée
            x = 0;
            y = 0;

            switch (direction) {
                case "N":
                    y = -1;
                    break;
                case "NE":
                    x = 1;
                    y = -1;
                    break;
                case "E":
                    x = 1;
                    break;
                case "SE":
                    x = 1;
                    y = 1;
                    break;
                case "S":
                    y = 1;
                    break;
                case "SO":
                    x = -1;
                    y = 1;
                    break;
                case "O":
                    x = -1;
                    break;
                case "NO":
                    x = -1;
                    y = -1;
                    break;
                default:
                    System.out.println("Direction invalide");
                    continue; // Retour au début de la boucle
            }

            Point2D newPos = new Point2D(pos.getX() + x, pos.getY() + y); // Nouvelle position

            if (!check_deplacement(newPos)) {
                System.out.println("Position invalide ou case déjà occupée");
            } else {
                player.getPersonnage().getPos().translate(x, y); // met à jour la position du joueur
                break;
            }
        }
    }

    /**
     * Méthode effectuant les tours de jeu
     *
     * @param tourJeu Le nombre de tours de jeu max
     */
    public void tour_de_jeu(int tourJeu) {
        Scanner sc = new Scanner(System.in); // Créez le scanner une fois
        int PtVieBonus;

        for (int i = 0; i < tourJeu;i++) { // Remover o incremento de i aqui
            PtVieBonus = 0;
            this.afficheDisplay();
            System.out.println("Tour " + (i+1));
            // Traiter les effets du joueur
            for (String s : player.getPersonnage().getEffets().keySet()) {
                PtVieBonus += player.getPersonnage().getEffets().get(s).getModifPtVie();
                int t = player.getPersonnage().getEffets().get(s).getNbToursEffet();
                if ((t - 1) > 0) {
                    player.getPersonnage().getEffets().get(s).setNbToursEffet(t - 1);
                } else {
                    player.getPersonnage().getEffets().remove(s);
                }
            }

            PtVieBonus += player.getPersonnage().getPtVie();
            player.getPersonnage().setPtVie(PtVieBonus);
            System.out.println("Le joueur est en position : X = " + player.getPersonnage().getPos().getX()
                    + " et Y = " + player.getPersonnage().getPos().getY()
                    + " avec " + player.getPersonnage().getPtVie() + " point(s) de vie");
            boolean actionValide = true; // Inicializa a flag de ação válida
            boolean show_error = true;
            do {
                if (!actionValide && show_error) {
                    System.out.println("Commande invalide !");
                }
                System.out.println("Choisissez une action");
                System.out.println("deplace | combattre | utiliser");
                String action = sc.nextLine();
                switch (action) {
                    case "deplace":
                        deplaceJoueur();
                        actionValide = true; // Ação válida se o jogador se deslocar
                        break;
                    case "utiliser":
                        if (player.getInventaire().isEmpty()) {
                            System.out.println("Votre inventaire est vide. Vous ne pouvez rien utiliser."); // Informe que o inventário está vazio
                            show_error = false;
                        } else {
                            System.out.println("Choisissez un objet à utiliser :");
                            player.affiche_inventaire(); // Affiche l'inventaire du joueur

                            System.out.println("Choisissez 0 pour ne rien faire");
                            int objetConsomme = sc.nextInt();
                            if (objetConsomme > 0 && objetConsomme <= player.getInventaire().size()) {
                                player.getInventaire().get(objetConsomme - 1).est_utilise(player.getPersonnage()); // Utilise l'objet sélectionné
                                player.getInventaire().remove(objetConsomme - 1); // Retire l'objet de l'inventaire
                                actionValide = true; // Ação válida
                            }
                        }
                        break;
                    case "combattre":
                        int k = 0; // Compteur de créatures à portée
                        int j = -1; // Indice de la créature
                        ArrayList<Integer> indiceCrea = new ArrayList<>(); // Liste des indices de créatures
                        System.out.println("Les créatures à portée d'attaque sont :");
                        for (Creature c : crea) {
                            j++;
                            if (c.getPos().distance(player.getPersonnage().getPos()) <= player.getPersonnage().getDistAttMax()) {
                                k++;
                                System.out.println("Créature " + k); // Affiche la créature en portée
                                c.affiche(); // Affiche les détails de la créature
                                indiceCrea.add(j); // Ajoute l'indice à la liste
                            }
                        }
                        if (k != 0) {
                            System.out.println("Choisissez une créature à combattre");
                            int creaCombattu = sc.nextInt();
                            if (creaCombattu > 0 && creaCombattu <= indiceCrea.size()) { // Vérifie si l'indice est valide
                                Personnage perso = player.getPersonnage();
                                ((Combattant) perso).combattre(crea.get(indiceCrea.get(creaCombattu - 1))); // Engage le combat avec la créature
                                actionValide = true; // Action valide
                            }
                        } else {
                            System.out.println("Pas de créature à portée"); // Pas de créatures à attaquer
                        }
                        break;
                    default:
                        actionValide = false;
                        break;
                }
            } while (!(actionValide));
            for (Creature c : crea) {
                c.deplace(this); // Déplace les créatures
            }
            for (NuageToxique n : nuage_toxique) {
                n.deplace(this);
            }            
        }
    }

}
