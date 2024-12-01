package com.example.demo;


public class Map {
    private int ligne;
    private int colonne;
    int[][]m;
    private Robot r;
    public Map(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        m=new int[ligne][colonne];
    }

    public int getColonne() {
        return colonne;
    }

    public int ligne() {
        return ligne;
    }
    public void addObstacle(Obstacle ob) {
        Point pos=ob.getPosition();
        if(isValidPosition(pos)) {
            m[pos.x][pos.y]=1;
        }
        else {
            System.out.println("cette position n'est pas valide pour cette map");
        }
    }
    public void addCharginPoint(Point pos) {
        if(isValidPosition(pos)) {
            m[pos.x][pos.y]=2;
        }
        else {
            System.out.println("cette position n'est pas valide pour cette map");
        }
    }
    public void setRobot(Robot rob) {
        r=rob;
        m[r.position.x][r.position.y]=-1;
    }
    public void afficher() {
        for(int i=0;i<ligne;i++) {
            for(int j=0;j<colonne;j++) {
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
    }
    public boolean isValidPosition(Point point) {
        return point.x >= 0 && point.x < ligne &&
                point.y >= 0 && point.y < colonne;
    }
}
