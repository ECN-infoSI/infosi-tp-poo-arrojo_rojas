/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;

import java.util.Random;

/**
 * Classe qui gére les créatures
 * @author Augusto ARROJO et Fernando ROJAS
*/
public abstract class Creature extends ElementDeJeu implements Deplacable {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private Point2D pos;
   
    /**
     * Constructeur de creature
     * @param pV Point de vie du creature
     * @param dA Dégâts d'attaque du creature
     * @param pPar Points de parade du creature
     * @param paAtt Pourcentage de chance de toucher avec une creature
     * @param paPar Pourcentage de chance de parer une creature
     * @param p Position du creature
    */
    public Creature (int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.pos = new Point2D(p);
    }
    
    /**
     * Constructeur de copie de creature
     * @param c à copier
    */
    public Creature (Creature c) {
        this.ptVie = c.getPtVie();
        this.degAtt = c.getDegAtt();
        this.ptPar = c.getPtPar();
        this.pageAtt = c.getPageAtt();
        this.pagePar = c.getPagePar();
        this.pos = new Point2D (c.pos);
    }
    
    /**
     * Constructeur par défaut de creature
    */
    public Creature ()
    {
        this.ptVie = 100;  // Valeur par défaut
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.pos = new Point2D();  // Position par défaut (0, 0) 
    }
    
    /**
     * Méthode pour obtenir la vie de creature
     * @return Le nombre de point de vie de la créature
    */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Méthode pour définir la vie de creature
     * @param pv Le nombre de point de vie de la créature
    */
    public void setPtVie(int pv) {
        this.ptVie = pv;
    }

    /**
     * Méthode pour obtenir les dégâts infligés par une attque
     * @return Le nombre de dégâts infligés par une attque
    */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Méthode pour définir les dégâts infligés par une attque
     * @param degAtt Le nombre de dégâts infligés par une attaque
    */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Méthode pour obtenir les dégâts évités par une parade
     * @return Le nombre de dégâts évités par une parade
    */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Méthode pour définir les dégâts évités par une parade
     * @param ptPar Le nombre de dégâts évités par une parade
    */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Méthode pour obtenir le pourcentage de chance de toucher avec une attaque
     * @return la pourcentage de chance de toucher avec une attaque
    */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Méthode pour définir le pourcentage de chance de toucher avec une attaque
     * @param pageAtt la pourcentage de chance de toucher avec une attaque
    */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Méthode pour obtenir le pourcentage de chance de parer une attaque
     * @return Le pourcentage de chance de parer une attaque
    */
    public int getPagePar() {
        return pagePar;
    }

    /**
     * Méthode pour définir le pourcentage de chance de parer une attaqu
     * @param pagePar Le pourcentage de chance de parer une attaque
    */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     * Méthode pour obtenir la position de la créature
     * @return la position de la créature
    */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Méthode pour définir la position de la créature
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
    public void affiche(){
        System.out.println(this.getClass().getName() + " | " + this.getPtVie() + " point(s) de vie");
        this.pos.affiche();
    } 
}
