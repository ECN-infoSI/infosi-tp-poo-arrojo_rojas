package org.centrale.objet.woe.projettp1;

import static org.centrale.objet.woe.projettp1.World.TAILLE_WORLD;

/**
 * Classe qui gère les ensembles de deux entiers représentant les coordonnées
 * (x, y) d'une entité dans le jeu.
 *
 * @author Augusto ARROJO et Fernando ROJAS
 */
class Point2D {

    private int PosX;
    private int PosY;

    /**
     * Constructeur de Point2D
     *
     * @param x Coordonnée selon x
     * @param y Coordonnée selon y
     */
    public Point2D(int x, int y) {
        this.PosX = x;
        this.PosY = y;
    }

    /**
     * Constructeur de copie
     *
     * @param p Point à recopier
     */
    public Point2D(Point2D pos) {
        this.PosX = pos.getX();
        this.PosY = pos.getY();
    }

    /**
     * Constructeur par défaut
     */
    public Point2D() {
        this.PosX = 0;
        this.PosY = 0;
    }

    /**
     * Méthode pour obtenir la position x
     *
     * @return la position x
     */
    public int getX() {
        return this.PosX;
    }

    /**
     * Méthode pour obtenir la position y
     *
     * @return la position y
     */
    public int getY() {
        return this.PosY;
    }

    /**
     * Méthode pour obtenir les coordonnées d'un point
     *
     * @return Les coordonnées x,y
     */
    public int[] getPosition() {
        return new int[]{PosX, PosY}; // Utilisation de la notation simplifiée
    }

    /**
     * Méthode pour définir la position x
     *
     * @param x la position x
     */
    public void setX(int x) {
        this.PosX = x;
    }

    /**
     * Méthode pour définir la position y
     *
     * @param y la position y
     */
    public void setY(int y) {
        this.PosY = y;
    }

    /**
     * Méthode pour définir la position x et y
     *
     * @param x la position x
     * @param y la position y
     */
    public void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    /**
     * Méthode pour déplacer la position
     *
     * @param dx la variation de la position x
     * @param dy la variation de la position y
     */
    public void translate(int dx, int dy) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
    }

    /**
     * Méthode pour afficher la position
     */
    public void affiche() {
        System.out.println("Position: [" + this.getX() + ", " + this.getY() + "]");
    }

    /**
     * Méthode pour calculer la distance entre deux points
     *
     * @param p Point avec lequel mesurer la distance
     * @return Distance entre les deux points
     */
    public float distance(Point2D p) {
        // Calcul de la distance entre deux points en utilisant la formule de la distance euclidienne
        return (float) Math.sqrt(Math.pow(this.getX() - p.getX(), 2) + Math.pow(this.getY() - p.getY(), 2));
    }

    /**
     * Méthode pour vérifier l'égalité entre deux points
     *
     * @param p Point à comparer
     * @return true si les coordonnées sont égales, sinon false
     */
    public boolean equals(Point2D p) {
        return (this.PosX == p.PosX && this.PosY == p.PosY);
    }

    /**
     * Méthode vérifiant si une position donnée est valide pour un déplacement
     * dans le monde. Cette méthode vérifie d'abord si la position est hors des
     * limites du monde, puis si elle est déjà occupée par une autre créature.
     *
     * @param monde Le monde dans lequel se fait le déplacement
     * @return true si la position est valide et libre, false si elle est hors
     * des limites ou occupée
     */
    public boolean check_deplacement(World monde) {
        // Vérifie si la position est en dehors des limites du monde
        if (this.getX() >= TAILLE_WORLD || this.getY() >= TAILLE_WORLD || this.getX() < 0 || this.getY() < 0) {
            return false;
        }

        // Vérifie si une créature occupe déjà cette position
        for (Creature creature : monde.getCrea()) {
            if (creature.getPos().equals(this)) {
                return false;
            }
        }

        // Si la position est libre et dans les limites, retourne true
        return true;
    }
}
