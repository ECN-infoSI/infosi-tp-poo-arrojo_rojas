/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

import java.util.Random;

/**
 * Classe gérant les créatures
 * @author Augusto ARROJO et Fernando ROJAS
 */

public class Creature {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
    
    public Creature (int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = new Point2D(p);
    }
    
    public Creature (Creature c) {
        this.ptVie = c.getPtVie();
        this.degAtt = c.getDegAtt();
        this.ptPar = c.getPtPar();
        this.pageAtt = c.getPageAtt();
        this.pagePar = c.getPagePar();
        this.distAttMax = c.getDistAttMax();
        this.pos = new Point2D (c.pos);
    }
    
    public Creature ()
    {
        this.ptVie = 100;  // Valeur par défaut
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.distAttMax = 1;
        this.pos = new Point2D();  // Position par défaut (0, 0) 
    }
    
    /**
     * 
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     *
     * @param pv
     */
    public void setPtVie(int pv) {
        this.ptVie = pv;
    }

    /**
     *
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     *
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     *
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     *
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
     *
     */
    public void affiche(){
        this.pos.affiche();
    } 
}
