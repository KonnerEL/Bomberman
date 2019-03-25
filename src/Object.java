/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author KonnerEL
 */
public class Object {

    public static final int TAM = 50;
    public int type;
    public int x;
    public int y;
    public Image image;

    public Object(int x, int y, int type, String path) {
        this.type = type;
        this.x = x;
        this.y = y;
        switch (type) {
            case 1:{
                image = new ImageIcon(getClass().getResource("destructibleBlock.png")).getImage();
                break;
            }
            case 2:{
                image = new ImageIcon(getClass().getResource(path)).getImage();
                break;
            }
            case 3:{
                image = new ImageIcon(getClass().getResource("door.jpg")).getImage();
            }
        }
    }
    
    public void draw(Graphics g) {
        g.drawImage(image, x, y, TAM, TAM, null);
    }
}
