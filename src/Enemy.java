
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
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
public class Enemy {
    public static final int UP = 0;
    public static final int RIGTH = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public int direction;
    public int x;
    public int y;
    public int vx;
    public int vy;
    public int map[][];
    public static final int TAM = 50;
    public Image image;
    
    public Enemy(int x, int y, int vx, int vy, int type, int map[][]) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.map = map;
        direction = 0;
        image = new ImageIcon(getClass().getResource("enemy_level" + type + ".gif")).getImage();
    }
    
    public void draw(Graphics g) {
        g.drawImage(image, x, y, TAM, TAM, null);
    }
    
    public void move(ArrayList<Node> nodes, int map[][]) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (x == nodes.get(i).x) {
                if (y < nodes.get(i).y) direction = 2;
                else direction = 0;
            }
            if (y == nodes.get(i).y) {
                if (x < nodes.get(i).x) direction = 1;
                else direction = 3;
            } 
        }
        switch(direction) {
            case LEFT:{
                x -= vx;
                if (Colision(x, y, map)) {
                    x += vx;
                    vx *= -1;
                }

                break;
            }
            case RIGTH:{
                x += vx;
                if (Colision(x, y, map)) {
                   x -= vx;
                   vx = -vx;
                }
                break;
            }
            case DOWN:{
                y += vy;
                if (Colision(x, y, map)) {
                    y -= vy;
                    vy *= -1;
                }
                break;
            }
            case UP:{
                y -= vy;
                if (Colision(x, y, map)) {
                    y += vy;
                    vy = -vy;
                }
                break;
            }        
        }
    }
    
    public boolean Colision(int x, int y, int map[][]) {
        boolean sw = false;
        if (map[y / 50][x / 50] == 1 || map[y / 50][x / 50] == 2) {
            sw = true;
        }
        if (map[y / 50][(x + 42) / 50] == 1 || map[y / 50][(x + 42) / 50] == 2) {
            sw = true;
        }
        if (map[(y + 42) / 50][(x + 42) / 50] == 1 || map[(y + 42) / 50][(x + 42) / 50] == 2) {
            sw = true;
        }
        if (map[(y + 42) / 50][x / 50] == 1 || map[(y + 42) / 50][x / 50] == 2) {
            sw = true;
        }
        return sw;
    }
    
    public boolean bomberDead(int x1, int y1) {
        int i = (int) x1 / 50;
        int j = (int) y1 / 50;
        int k = (int) x / 50;
        int l = (int) y / 50;
        if (i == k && j == l) {
            return true;
        }
        else return false;
    }
    
}
