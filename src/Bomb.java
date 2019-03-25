
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
public class Bomb {
    public static final int TAM = 50;
    public int x;
    public int y;
    public long start;
    public Animation animation;
    public Image image;
    
    public Bomb(int x, int y, long start) {
        this.x = x;
        this.y = y;
        this.start = start;
        animation = new Animation();
        image = new ImageIcon(getClass().getResource("Bomb.png")).getImage();
    }
    
    public void loadPic() {
        animation = new Animation();
        animation.addScene(
                        new ImageIcon(
                                getClass().getResource(
                                        "Bomb.png")).getImage(), 100);
    }
    
    public void draw(Graphics g) {
        g.drawImage(animation.getImage(), x, y, TAM, TAM, null);
    }
    
    
    public void move(long time) {
        animation.update(time);
    }
}
