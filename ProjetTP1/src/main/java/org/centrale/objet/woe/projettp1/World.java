/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Map;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Iterator;

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
        int nombre_min_crea = TAILLE_WORLD;
        int RandG = 0, RandL = 0, RandA = 0, RandLo = 0, RandP = 0;
        //Creation des creatures aleatoires (minimum 50)
        do {
            //RandG = generateurAleatoire.nextInt(2 * nombre_min_crea / 5);
            RandL = generateurAleatoire.nextInt(nombre_min_crea);
            //RandA = generateurAleatoire.nextInt(2 * nombre_min_crea / 5);
            RandLo = generateurAleatoire.nextInt(nombre_min_crea);
            RandP = generateurAleatoire.nextInt(nombre_min_crea);
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
            RandPS = generateurAleatoire.nextInt(2 * nombre_min_obj / 4);
            RandN = 5 * generateurAleatoire.nextInt(2 * nombre_min_obj / 4);
            RandNT = generateurAleatoire.nextInt(2 * nombre_min_obj / 4);
            RandEp = generateurAleatoire.nextInt(2 * nombre_min_obj / 4);
        } while (RandPS + RandN + RandNT + RandEp < nombre_min_obj);

        for (int i = 0; i < RandPS; i++) {
            obj.add(new PotionSoin());
        }
        for (int i = 0; i < RandEp; i++) {
            obj.add(new Epee());
        }
        for (int i = 0; i < RandN / 2; i++) {
            consommable.add(Nourriture.creerNourriture("Fromage magique"));
            consommable.add(Nourriture.creerNourriture("Baguette"));
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
     * Méthode pour soigner des espée et potions
     */
    public void soigne_obj() {
        ArrayList<Objet> toRemove = new ArrayList<>();
        for (Objet object : obj) {
            if (object instanceof PotionSoin) {
                PotionSoin potion = (PotionSoin) object;
                if (player.getPersonnage().getPos().equals(potion.getPos())) {
                    player.getPersonnage().setPtVie(player.getPersonnage().getPtVie() + potion.getValeur_soin());
                    System.out.println("Vous avez ramassé un potion qui a vous donné " + potion.getValeur_soin() + " point(s) de vie");
                    toRemove.add(object);
                } else {
                    for (Creature creature : crea) {
                        if (creature.getPos().equals(potion.getPos())) {
                            creature.setPtVie(creature.getPtVie() + potion.getValeur_soin());
                            toRemove.add(object);
                        }
                    }
                }
            } else if (object instanceof Epee) {
                Epee epee = (Epee) object;
                if (player.getPersonnage().getPos().equals(epee.getPos())) {
                    player.getPersonnage().setDegAtt(player.getPersonnage().getDegAtt() + epee.getBonus_att());
                    System.out.println("Vous avez ramassé une epée qui a vous donné " + epee.getBonus_att() + " point(s) de attaque");
                    toRemove.add(object);
                } else {
                    for (Creature creature : crea) {
                        if (creature.getPos().equals(epee.getPos())) {
                            creature.setDegAtt(creature.getDegAtt() + epee.getBonus_att());
                            toRemove.add(object);
                        }
                    }
                }
            }
        }
        obj.removeAll(toRemove);
    }

    /**
     * Méthode poue créer du joueur
     */
    public void createJoueur() {
        player = new Joueur();
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

    public void utiliser(Scanner sc) {
        if (player.getInventaire().isEmpty()) {
            System.out.println("Votre inventaire est vide. Vous ne pouvez rien utiliser.");
        } else {
            System.out.println("Choisissez un objet à utiliser :");
            player.affiche_inventaire();

            System.out.println("Choisissez 0 pour ne rien faire");
            boolean choixValide = false;

            while (!choixValide) {
                int objetChoisi = sc.nextInt();
                sc.nextLine(); // Effacer le buffer

                if (objetChoisi == 0) {
                    System.out.println("Aucune action n'a été réalisée.");
                    choixValide = true;
                } else if (objetChoisi > 0 && objetChoisi <= player.getInventaire().size()) {
                    Map<String, List<Nourriture>> mapInventaireGroup = new HashMap<>();
                    for (Nourriture obj : player.getInventaire()) {
                        mapInventaireGroup.computeIfAbsent(obj.getNom(), k -> new ArrayList<>()).add(obj);
                    }

                    int index = 1;
                    for (Map.Entry<String, List<Nourriture>> entry : mapInventaireGroup.entrySet()) {
                        if (index == objetChoisi) {
                            List<Nourriture> objetsDisponibles = entry.getValue();
                            int quantiteAUtiliser = -1;

                            while (quantiteAUtiliser < 0 || quantiteAUtiliser > objetsDisponibles.size()) {
                                System.out.println("Combien de " + entry.getKey() + " voulez-vous utiliser ? (maximum : " + objetsDisponibles.size() + ")");
                                quantiteAUtiliser = sc.nextInt();
                                sc.nextLine();
                                if (quantiteAUtiliser <= 0 || quantiteAUtiliser > objetsDisponibles.size()) {
                                    System.out.println("Quantité invalide. Veuillez choisir une quantité correcte.");
                                }
                            }

                            Nourriture objetAUtiliser = objetsDisponibles.get(0);

                            // Applique l'effet au personnage en utilisant la quantité choisie
                            objetAUtiliser.est_utilise(player.getPersonnage(), quantiteAUtiliser);

                            // Imprime la durée du effet
                            int duree = objetAUtiliser.getNbToursEffet(); // Assurez-vous que cette méthode existe
                            System.out.println("L'effet durera pour " + duree + " tour(s).");

                            // Supprime les objets utilisés de l'inventaire
                            for (int h = 0; h < quantiteAUtiliser; h++) {
                                player.getInventaire().remove(objetsDisponibles.remove(0));
                            }

                            System.out.println("Vous avez utilisé " + quantiteAUtiliser + " " + entry.getKey() + "(s)");
                            afficherEffets(objetAUtiliser);

                            choixValide = true;
                            break;
                        }
                        index++;
                    }
                } else {
                    System.out.println("Choix invalide. Veuillez choisir un numéro correct.");
                }
            }
        }
    }

    private void afficherEffets(Nourriture objetAUtiliser) {
        System.out.println("Effets :");
        if (objetAUtiliser.getModifPtVie() != 0) {
            System.out.println("Points de vie : " + objetAUtiliser.getModifPtVie());
        }
        if (objetAUtiliser.getModifDegAtt() != 0) {
            System.out.println("Dégâts d'attaque : " + objetAUtiliser.getModifDegAtt());
        }
        if (objetAUtiliser.getModifPageAtt() != 0) {
            System.out.println("Pourcentage d'attaque : " + objetAUtiliser.getModifPageAtt());
        }
        if (objetAUtiliser.getModifPagePar() != 0) {
            System.out.println("Pourcentage de parade : " + objetAUtiliser.getModifPagePar());
        }
        if (objetAUtiliser.getModifPtPar() != 0) {
            System.out.println("Points de parade : " + objetAUtiliser.getModifPtPar());
        }
    }

    public void combattre(Scanner sc) {
        int k = 0;
        int j = -1;
        ArrayList<Integer> indiceCrea = new ArrayList<>();
        System.out.println(player.getPersonnage().getDistAttMax());

        for (Creature c : crea) {
            j++;
            if (c.getPos().distance(player.getPersonnage().getPos()) <= player.getPersonnage().getDistAttMax()) {
                k++;
                System.out.println("Créature " + k);
                c.affiche();
                indiceCrea.add(j);
            }
        }

        if (k != 0) {
            System.out.println("Choisissez une créature à combattre");
            boolean combatValide = false;

            while (!combatValide) {
                int creaCombattu = sc.nextInt();
                sc.nextLine(); // Effacer le buffer

                if (creaCombattu > 0 && creaCombattu <= indiceCrea.size()) {
                    Personnage perso = player.getPersonnage();
                    Creature cible = crea.get(indiceCrea.get(creaCombattu - 1));

                    // Combattre
                    ((Combattant) perso).combattre(cible);

                    combatValide = true; // Termine la validation du combat après une seule action
                } else {
                    System.out.println("Choix invalide. Veuillez choisir un numéro de créature valide.");
                }
            }
        } else {
            System.out.println("Pas de créature à portée");
        }
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
        System.out.println("Légende : \t J: Vous \t E: Épée \t O: Potion \t C: Nourriture \t G: Guerrier \t A: Archer \t P: Paysan \t R: Lapin \t L: Loup \t N: Nuage Toxique");
    }

    public void gerer_effet() {
        int PtVieBonus = 0;
        int DegAttBonus = 0;
        int PageAttBonus = 0;
        int PageParBonus = 0;
        int PtParBonus = 0;
        // Traiter les effets du joueur
        for (Map.Entry<String, Nourriture> entry : player.getPersonnage().getEffets().entrySet()) {
            String key = entry.getKey();
            Nourriture effet = entry.getValue();
            // Ajouter les bonus des effets en cours
            PtVieBonus += effet.getModifPtVie();     // Bonus de points de vie
            DegAttBonus += effet.getModifDegAtt();   // Bonus de dégats d'attaque
            PageAttBonus += effet.getModifPageAtt(); // Bonus de pourcentage d'attaque
            PageParBonus += effet.getModifPagePar(); // Bonus de pourcentage de parade
            PtParBonus += effet.getModifPtPar();     // Bonus de points de parade

            // Gérer la durée restante de l'effet
            int t = effet.getNbToursEffet();
            if ((t - 1) > 0) {
                effet.setNbToursEffet(t - 1); // Décrémenter le nombre de tours restants
            } else {
                System.out.println("Le effet du/de" + effet.getNom() + "a fini");
                player.getPersonnage().removeEffet(key); // Supprimer l'effet a fini
            }
        }

        // Mettre à jour les attributs du personnage avec les bonus
        player.getPersonnage().setPtVie(player.getPersonnage().getPtVie() + PtVieBonus);          // Appliquer le bonus de points de vie
        player.getPersonnage().setDegAtt(player.getPersonnage().getDegAtt() + DegAttBonus);       // Appliquer le bonus de dégats d'attaque
        player.getPersonnage().setPageAtt(player.getPersonnage().getPageAtt() + PageAttBonus);    // Appliquer le bonus de pourcentage d'attaque
        player.getPersonnage().setPagePar(player.getPersonnage().getPagePar() + PageParBonus);    // Appliquer o bônus de pourcentage de parade
        player.getPersonnage().setPtPar(player.getPersonnage().getPtPar() + PtParBonus);          // Appliquer o bônus de points de parade

    }

    /**
     * Méthode effectuant les tours de jeu
     *
     * @param tourJeu Le nombre de tours de jeu max
     */
    public void tour_de_jeu(int tourJeu) {
        Scanner sc = new Scanner(System.in); // Créez le scanner une fois
        while (true) {
            this.afficheDisplay(); // Affiche l'état actuel du jeu
            System.out.println("Tour : " + (tourJeu + 1)); // Affiche le numéro du tour

            Iterator<Creature> iterator = crea.iterator();
            while (iterator.hasNext()) {
                Creature c = iterator.next();

                if (c instanceof Loup && c.getPos().distance(player.getPersonnage().getPos()) <= 1 && c.getPtVie() > 0) {
                    ((Loup) c).combattre(player.getPersonnage());
                } else {
                    c.deplacer(this); // Déplace les créatures
                }

                if (c.getPtVie() <= 0) {
                    iterator.remove(); // Utilisez l'itérateur pour supprimer l'élément
                }
            }
            
            for (NuageToxique n : nuage_toxique) {
                n.combattre(player.getPersonnage()); // Gère les combats avec les nuages toxiques
            }
            player.ramasser(this); // Permet au joueur de ramasser des objets
            soigne_obj();
                        
            System.out.println("Le joueur (" + player.getPersonnage().getClass().getSimpleName() + ") est en position : X = " + player.getPersonnage().getPos().getX()
                    + " et Y = " + player.getPersonnage().getPos().getY()
                    + " avec " + player.getPersonnage().getPtVie() + " point(s) de vie"); // Affiche l'état du joueur
            gerer_effet();
            
            // Permettre uniquement une action par tour
            boolean actionValide = false; // Initialise la flag d'action valide

            while (!actionValide) {
                System.out.println("Choisissez une action : deplace | combattre | utiliser | sortie");
                String action = sc.nextLine();

                switch (action) {
                    case "deplace":
                        player.deplaceJoueur(this);
                        actionValide = true;
                        break;
                    case "utiliser":
                        utiliser(sc);
                        actionValide = true;
                        break;
                    case "combattre":
                        combattre(sc);
                        actionValide = true;
                        break;
                    case "sortie":
                        System.exit(0); // Termine le programme avec succès
                    default:
                        System.out.println("Commande invalide !");
                        break;
                }
            }

            // Vérifie si la liste des créatures est vide après le combat
            if (crea.isEmpty()) {
                System.out.println("Vous avez vaincu toutes les créatures ! Vous êtes victorieux !");
                System.exit(0); // Termine le programme avec succès
            }

            if (player.getPersonnage().getPtVie() <= 0) {
                System.out.println("Vous êtes mort ! C'est dommage");
                System.exit(0); // Termine le programme avec succès
            }
            tourJeu += 1;
        }
    }

}
