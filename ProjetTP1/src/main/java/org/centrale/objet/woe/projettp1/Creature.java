/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui gère les créatures du jeu.
 * Cette classe est abstraite et doit être étendue par des classes spécifiques représentant différents types de créatures.
 * 
 * @author Augusto ARROJO et Fernando ROJAS
 */
public abstract class Creature extends ElementDeJeu implements Deplacable {

    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
    private Map<String, Nourriture> effets;

    /**
     * Constructeur de la créature.
     * 
     * @param pV   Points de vie de la créature.
     * @param dA   Dégâts d'attaque de la créature.
     * @param pPar Points de parade de la créature.
     * @param paAtt Pourcentage de chance de toucher avec une attaque.
     * @param paPar Pourcentage de chance de parer une attaque.
     * @param p    Position de la créature.
     * @param effets Liste des effets subis par la créature.
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p, Map<String, Nourriture> effets) {
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.pos = new Point2D(p);
        this.effets = new HashMap<>();
    }

    /**
     * Constructeur de copie de la créature.
     * 
     * @param c La créature à copier.
     */
    public Creature(Creature c) {
        this.ptVie = c.getPtVie();
        this.degAtt = c.getDegAtt();
        this.ptPar = c.getPtPar();
        this.pageAtt = c.getPageAtt();
        this.pagePar = c.getPagePar();
        this.pos = new Point2D(c.pos);
        this.effets = new HashMap<>();
    }

    /**
     * Constructeur par défaut de la créature.
     */
    public Creature() {
        this.ptVie = 100;  // Valeur par défaut
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.pos = new Point2D();  // Position par défaut (0, 0) 
        this.effets = new HashMap<>();
    }

    /**
     * Obtient les points de vie de la créature.
     * 
     * @return Le nombre de points de vie de la créature.
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Définit les points de vie de la créature.
     * 
     * @param pv Le nombre de points de vie de la créature.
     */
    public void setPtVie(int pv) {
        this.ptVie = pv;
    }

    /**
     * Obtient les dégâts infligés par une attaque.
     * 
     * @return Le nombre de dégâts infligés par une attaque.
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Définit les dégâts infligés par une attaque.
     * 
     * @param degAtt Le nombre de dégâts infligés par une attaque.
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Obtient les points de parade de la créature.
     * 
     * @return Le nombre de points de parade de la créature.
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Définit les points de parade de la créature.
     * 
     * @param ptPar Le nombre de points de parade de la créature.
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Obtient le pourcentage de chance de toucher avec une attaque.
     * 
     * @return Le pourcentage de chance de toucher avec une attaque.
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Définit le pourcentage de chance de toucher avec une attaque.
     * 
     * @param pageAtt Le pourcentage de chance de toucher avec une attaque.
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Obtient le pourcentage de chance de parer une attaque.
     * 
     * @return Le pourcentage de chance de parer une attaque.
     */
    public int getPagePar() {
        return pagePar;
    }
    
    /**
     * Obtient la liste des effets affectant la créature.
     * 
     * @return La liste des effets affectant la créature.
     */
    public Map<String, Nourriture> getEffets() {
        return effets;
    }

    /**
     * Définit la liste des effets affectant la créature.
     * 
     * @param effets Liste des effets affectant la créature.
     */
    public void setEffets(Map<String, Nourriture> effets) {
        this.effets = effets;
    }
    
    // Méthode pour supprimer un effet
    public void removeEffet(String nomEffet) {
        if (effets.containsKey(nomEffet)) {
            effets.remove(nomEffet); // Supprime l'effet du mapa
            System.out.println("Effet " + nomEffet + " supprimé."); // Message de confirmation
        } else {
            System.out.println("Effet " + nomEffet + " introuvable."); // Message si l'effet n'existe pas
        }
    }

    
    /**
     * Définit le pourcentage de chance de parer une attaque.
     * 
     * @param pagePar Le pourcentage de chance de parer une attaque.
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Déplace la créature de manière aléatoire dans le monde.
     */
    public void deplacer() {
        Random rand = new Random();
        int dx = 0;
        int dy = 0;

        // Assurez-vous que dx et dy sont simultanément non différents de zéro
        do {
            dx = rand.nextInt(2) - 1;
            dy = rand.nextInt(2) - 1;
        } while (dx == 0 && dy == 0);

        this.pos.translate(dx, dy);
    }

    /**
     * Affiche les attributs de la créature.
     */
    public void affiche() {
        System.out.println(this.getClass().getSimpleName() + ": " + Arrays.toString(this.getPos().getPosition()) + " | " + this.getPtVie() + " point(s) de vie");
    }

    @Override
    /**
     * Déplace la créature dans le monde en effectuant un mouvement aléatoire.
     * Le déplacement est effectué tant que la nouvelle position est valide.
     * 
     * @param monde Le monde dans lequel la créature se déplace.
     */
    public void deplacer(World monde) {
        Random Alea = new Random();
        Point2D nouvellePos = new Point2D(this.getPos()); // Copie de la position actuelle

        int r1 = 0, r2 = 0;
        do {
            // Génère un déplacement aléatoire entre -1 et 1 pour x et y
            r1 = Alea.nextInt(3) - 1;
            r2 = Alea.nextInt(3) - 1;

            // Applique temporairement la translation sur la nouvelle position
            nouvellePos.translate(r1, r2); // Applique la translation

            // Continue tant que le déplacement n'est pas nul (r1 == 0 et r2 == 0) ou que la position est invalide
        } while ((r1 == 0 && r2 == 0) || !nouvellePos.check_deplacement(monde));

        // Met à jour la position de l'objet si la nouvelle position est valide
        this.getPos().translate(r1, r2);
    }
}
