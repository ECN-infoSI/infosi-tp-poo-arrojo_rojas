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
public class Personnage {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
    
    public Personnage (String N, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        this.nom = N;
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = new Point2D(p);
    }
    
    public Personnage (Personnage perso) {
        this.nom = perso.getNom();
        this.ptVie = perso.getPtVie();
        this.degAtt = perso.getDegAtt();
        this.ptPar = perso.getPtPar();
        this.pageAtt = perso.getPageAtt();
        this.pagePar = perso.getPagePar();
        this.distAttMax = perso.getDistAttMax();
        this.pos = new Point2D (perso.pos);
    }
    
    public Personnage ()
    {
        this.nom = "Inconnu";
        this.ptVie = 100;  // Valeur par défaut
        this.degAtt = 10;
        this.ptPar = 5;
        this.pageAtt = 1;
        this.pagePar = 1;
        this.distAttMax = 1;
        this.pos = new Point2D();  // Position par défaut (0, 0) 
    }
    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
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
       
        int dx = rand.nextInt(2) - 1;
        int dy = rand.nextInt(2) - 1;

        this.pos.translate(dx, dy);
    }
    
    public void affiche(){
        this.pos.affiche();
    } 
}
