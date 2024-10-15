/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui gére les créatures
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
     * Constructeur de creature
     *
     * @param pV Point de vie du creature
     * @param dA Dégâts d'attaque du creature
     * @param pPar Points de parade du creature
     * @param paAtt Pourcentage de chance de toucher avec une creature
     * @param paPar Pourcentage de chance de parer une creature
     * @param pos Position du creature
     * @param effets Liste des effets subis par la créature
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.pos = new Point2D(p);
        this.effets = new HashMap<>();
    }

    /**
     * Constructeur de copie de creature
     *
     * @param c à copier
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
     * Constructeur par défaut de creature
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
     * Méthode pour obtenir la vie de creature
     *
     * @return Le nombre de point de vie de la créature
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Méthode pour définir la vie de creature
     *
     * @param pv Le nombre de point de vie de la créature
     */
    public void setPtVie(int pv) {
        this.ptVie = pv;
    }

    /**
     * Méthode pour obtenir les dégâts infligés par une attque
     *
     * @return Le nombre de dégâts infligés par une attque
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Méthode pour définir les dégâts infligés par une attque
     *
     * @param degAtt Le nombre de dégâts infligés par une attaque
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Méthode pour obtenir les dégâts évités par une parade
     *
     * @return Le nombre de dégâts évités par une parade
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Méthode pour définir les dégâts évités par une parade
     *
     * @param ptPar Le nombre de dégâts évités par une parade
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Méthode pour obtenir le pourcentage de chance de toucher avec une attaque
     *
     * @return la pourcentage de chance de toucher avec une attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Méthode pour définir le pourcentage de chance de toucher avec une attaque
     *
     * @param pageAtt la pourcentage de chance de toucher avec une attaque
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Méthode pour obtenir le pourcentage de chance de parer une attaque
     *
     * @return Le pourcentage de chance de parer une attaque
     */
    public int getPagePar() {
        return pagePar;
    }
    
    /**
     * Getter de l'attribut effets
     * @return La liste des effets affectant la créature
     */
    public Map<String, Nourriture> getEffets() {
        return effets;
    }

    /**
     * Setter de l'attribut effets
     * @param effets Liste des effets affectant la créature
     */
    public void setEffets(Map<String, Nourriture> effets) {
        this.effets = effets;
    }
    
 
    /**
     * Méthode pour définir le pourcentage de chance de parer une attaqu
     *
     * @param pagePar Le pourcentage de chance de parer une attaque
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Méthode pour obtenir la position de la créature
     *
     * @return la position de la créature
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Méthode pour définir la position de la créature
     *
     * @param pos la position de la créature
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Méthode qui permet deplacer la créature
     */
    public void deplace() {
        Random rand = new Random();
        int dx = 0;
        int dy = 0;

        // Assurez que dx et dy sont simultanément non différent de zero
        do {
            dx = rand.nextInt(2) - 1;
            dy = rand.nextInt(2) - 1;
        } while (dx == 0 && dy == 0);

        this.pos.translate(dx, dy);
    }

    /**
     * Méthode pour afficher les attributs correspondant à la créature
     */
    public void affiche() {
        System.out.println(this.getClass().getName() + " | " + this.getPtVie() + " point(s) de vie");
        this.pos.affiche();
    }

    public boolean check_deplacement(World world) {
        ArrayList<Creature> crea = world.getCrea();
        int nombre_crea = crea.size();
        for (int i = 0; i < nombre_crea; i++) {
            if (crea.get(i).getPos() == pos || Math.abs(crea.get(i).getPos().getX()) > 50 || Math.abs(crea.get(i).getPos().getY()) > 50) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode pour déplacer une créature
     *
     * @return true si la créature peut se déplacer | false sinon
     */
    @Override
    public boolean deplace(World monde) {
        Random Alea = new Random();
        Point2D testPosition;

        // Geração de uma posição válida aleatória
        do {
            int r1 = Alea.nextInt(3) - 1;
            int r2 = Alea.nextInt(3) - 1;
            testPosition = new Point2D(this.getPos());
            testPosition.translate(r1, r2);
        } while (testPosition.equals(this.getPos())); // Garante que a posição gerada não seja a mesma

        // Verifica se a nova posição está dentro dos limites do mundo
        if (Math.abs(testPosition.getX()) >= TAILLE_WORLD || Math.abs(testPosition.getY()) >= TAILLE_WORLD) {
            return false;
        }

        // Verifica se outra criatura já está na nova posição
        for (Creature c : monde.getCrea()) {
            if (c.getPos().equals(testPosition)) {
                return false;
            }
        }

        // Se passou pelas verificações, move a criatura para a nova posição
        this.getPos().setPosition(testPosition.getX(), testPosition.getY());
        return true;
    }
}
