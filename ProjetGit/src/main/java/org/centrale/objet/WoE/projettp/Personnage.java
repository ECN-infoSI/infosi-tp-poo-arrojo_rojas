/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE.projettp;
import java.util.Random;

/**
 * Classe creátion des personnages pour le jeu World of ECN
 * @author Augusto Arrojo et Fernando ROJAS
 * @version 2.0
 */


class Personnage extends Creature {
    private String nom;
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    private int distAttMax;
    private Point2D pos;
    
    /*
    * Crée un personnage
    * @param nom    Nom du personnage
    * @param ptVie  Points de vie restants du personnage
    * @param degAtt dégradation attendu au personnage
    * ...
    * @param pos Position du personnage dans le monde
    */
    
    public Personnage (String N, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p){
        this.nom = N;
        this.ptVie = pV;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
        this.distAttMax = dMax;
        this.pos = p;
    }
    
    /*
    * Crée un personnage à partir d'un personnage
    * @param Personnage Personnage à instancier
    */
    
    public Personnage (Personnage perso) {
        this.nom = perso.getNom();
        this.ptVie = perso.getPtVie();
        this.degAtt = perso.getDegAtt();
        this.ptPar = perso.getPtPar();
        this.pageAtt = perso.getPageAtt();
        this.pagePar = perso.getPagePar();
        this.distAttMax = perso.getDistAttMax();
        this.pos = perso.pos;
    }
    
    /*
    * Crée un personnage sans paramètres
    * @return Personnage(100,10,5,1,1,1,Point2D())
    */
    
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
    
    /*
    * Récupère le nom du personnage
    */
    
    public String getNom() {
        return nom;
    }
    
    /*
    * Permet de déclarer le nom du personnage
    * @param n  String contenant le nouveau nom du personnage
    */

    public void setNom(String n) {
        this.nom = n;
    }
    
    /*
    * Récupère les points de vie du personnage à l'instant
    */

    public int getPtVie() {
        return ptVie;
    }
    
    /*
    * Permet de déclarer les points de vie du personnage
    * @param ptVie  Nouveaux points de vie du personnage
    */

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    
    /*
    * Récupère le degAtt du personnage
    * @return les
    */

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
        
        do{
           dx = rand.nextInt(2)-1;
           dy = rand.nextInt(2)-1;
        } while (dx == 0 && dy == 0);

        this.pos.translate(dx, dy);
    }
    
    public void affiche(){
        this.pos.affiche();
    } 
}
