/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;

/**
 *
 * @author KonnerEL
 */
public class Render {
    int mat[][];
    Object objects[][];
    
    public Render(int mat[][], String path){
        this.mat = mat;
        objects = new Object[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                objects[i][j]= new Object(j*Object.TAM,i*Object.TAM,mat[i][j],path);
            }
            
        }
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                objects[i][j].draw(g);
            }
        }   
    } 
}
