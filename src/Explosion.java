
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KonnerEL
 */
public class Explosion {
    public int x;
    public int y;
    public static final int TAM = 50;
    public int map[][];
    public int explosion[][];
    public Image images[][];
    public long start;
    
    public Explosion(int x, int y, int map[][], long time) {
        this.x = x;
        this.y = y;
        this.map = map;
        this.start = time;
        explosion = new int[map.length][map.length];
        images = new Image[map.length][map.length];
    }
    
    public void generateMap() {
        int i = (int)x / 50;
        int j = (int)y / 50;
        explosion[i][j] = 3;
        boolean sw = true;
        for (int k = i + 1; k <= i + 2 && sw == true; k++) {
            if (map[j][k] == 0) {
                explosion[k][j] = 1;
            } else {
                if (map[j][k] == 1) {
                    map[j][k] = 0;
                    explosion[k][j] = 1;
                }  
                sw = false;
            }
        }
        
        sw = true;
        for (int k = i - 1; k >= i - 2 && sw == true; k--) {
            if (map[j][k] == 0) {
                explosion[k][j] = 1;
            } else {
                if (map[j][k] == 1) {
                    map[j][k] = 0;
                    explosion[k][j] = 1;
                } 
                sw = false;
            }
        }
        
        sw = true;
        for (int k = j + 1; k <= j + 2 && sw == true; k++) {
            if (map[k][i] == 0) {
                explosion[i][k] = 2;
            } else {
                if (map[k][i] == 1) {
                    map[k][i] = 0;
                    explosion[i][k] = 2;
                } 
                sw = false;
            }
        }
        
        sw = true;
        for (int k = j - 1; k >= j - 2 && sw == true; k--) {
            if (map[k][i] == 0) {
                //map[k][i] = 0;
                explosion[i][k] = 2;
            } else {
                if (map[k][i] == 1) {
                    map[k][i] = 0;
                    explosion[i][k] = 2;
                }  
                sw = false;
            }
        }
    }
    
    public void assignExplosion() {
        for (int i = 0; i < explosion.length; i++) {
            for (int j = 0; j < explosion.length; j++) {
                if (explosion[i][j] == 1) images[i][j] = new ImageIcon(getClass().getResource("Explosion1.png")).getImage();
                if (explosion[i][j] == 2) images[i][j] = new ImageIcon(getClass().getResource("Explosion2.png")).getImage();
                if (explosion[i][j] == 3) images[i][j] = new ImageIcon(getClass().getResource("Explosion3.png")).getImage();
            }
        }
    }
    
    public void draw(Graphics g) {
        for (int i = 0; i < explosion.length; i++) {
            for (int j = 0; j < explosion.length; j++) {
                if (explosion[i][j] != 0) {
                    g.drawImage(images[i][j], i*TAM, j*TAM, TAM, TAM, null);
                }
            }
        }
    }
    
    public boolean bombermanDead(int x1, int y1) {
        boolean sw = false;
        int i = (int) x1 / 50;
        int j = (int) y1 / 50;
        for (int k = 0; k < explosion.length && sw == false; k++) {
            for (int l = 0; l < explosion.length; l++) {
                if (explosion[i][j] != 0) sw = true;
            }
        }
        return sw;
    }
    
    public boolean enemyDead(int x1, int y1) {
        boolean sw = false;
        int i = (int) x1 / 50;
        int j = (int) y1 / 50;
        for (int k = 0; k < explosion.length && sw == false; k++) {
            for (int l = 0; l < explosion.length; l++) {
                if (explosion[i][j] != 0) sw = true;
            }
        }
        return sw;
    }

}
