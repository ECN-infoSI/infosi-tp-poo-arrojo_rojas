/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;
import java.util.Random;

/**
 *
 * @author Augusto Arrojo et Fernando ROJAS
 */
public class Monstre {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
    
    public Monstre (int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = new Point2D(p);
    }
    
    public Monstre (Monstre m) {
        this.ptVie = m.getPtVie();
        this.degAtt = m.getDegAtt();
        this.ptPar = m.getPtPar();
        this.pageAtt = m.getPageAtt();
        this.pagePar = m.getPagePar();
        this.distAttMax = m.getDistAttMax();
        this.pos = new Point2D (m.pos);
    }
    
    public Monstre ()
    {
        this.ptVie = 100;  // Valeur par défaut
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.distAttMax = 1;
        this.pos = new Point2D();  // Position par défaut (0, 0) 
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int pv) {
        this.ptVie = pv;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    public int getDistAttMax() {
        return distAttMax;
    }

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    public void deplace() {
        Random rand = new Random();
       
        int dx = rand.nextInt(); 
        int dy = rand.nextInt();

        this.pos.setPosition(dx, dy);
    }
    
    public void affiche(){
        this.pos.affiche();
    } 
}
