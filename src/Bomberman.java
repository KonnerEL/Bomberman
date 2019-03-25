import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lgguzman
 */
public class Bomberman {
    public static final int UP = 0;
    public static final int RIGTH = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;    
    public static final int NONE = -1;
    Animation[] animations;
    public int x;
    public int y;
    public int vx;
    public int vy;
    String path;
    int currentDirection;
    int direction;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Bomberman(int x, int y, int vx, int vy, String path) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.path = path;
        this.currentDirection = RIGTH;
        this.direction = NONE;
        animations = new Animation[4];
    }

    public void loadPic() {
        String name[] = {"arriba", "adelante", "abajo", "atras"};
        for (int j = 0; j < 4; j++) {
            animations[j] = new Animation();
            for (int i = 1; i <= 5; i++) {
                animations[j].addScene(
                        new ImageIcon(
                                getClass().getResource(
                                        path + "//" + name[j] + i + ".png")).getImage(), 100);
            }
        }

    }

    public void draw(Graphics g) {
        g.drawImage(animations[currentDirection].getImage(), x - 5, y - 25, null);
    }

    public void move(long time, int[][] map) {
        if (direction != NONE) {
            currentDirection = direction;
            switch (direction) {
                case LEFT:{
                    x -= vx;
                    if (Colision(x, y, map)) x += vx;
                    break;
                }
                case RIGTH:{
                    x += vx;
                    if (Colision(x, y, map)) x -= vx;
                    break;
                }
                case DOWN:{
                    y += vy;
                    if (Colision(x, y, map)) y -= vy;
                    break;
                }
                case UP:{
                    y -= vy;
                    if (Colision(x, y, map))  y += vy;
                    break;
                }        
            }
        }

        if (direction != NONE) {
            animations[currentDirection].update(time);
        }
    }

    public boolean Colision(int x, int y, int map[][]) {
        boolean sw = false;
        if (map[y / 50][x / 50] == 1 || map[y / 50][x / 50] == 2) {
            sw = true;
        }
        if (map[y / 50][(x + 30) / 50] == 1 || map[y / 50][(x + 30) / 50] == 2) {
            sw = true;
        }
        if (map[(y + 20) / 50][(x + 30) / 50] == 1 || map[(y + 20) / 50][(x + 30) / 50] == 2) {
            sw = true;
        }
        if (map[(y + 20) / 50][x / 50] == 1 || map[(y + 20) / 50][x / 50] == 2) {
            sw = true;
        }
        return sw;
    }
    
    public void bomberNewPosition() {
        x = 50;
        y = 50;
        currentDirection = 0;
    }
    
}
