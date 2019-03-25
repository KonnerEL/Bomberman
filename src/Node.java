/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KonnerEL
 */
public class Node {
    int number;
    int x, y;

    public Node(int x, int y, int number) {
        this.x = x;
        this.y = y;
        this.number = number;
    }
        
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
