/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author KonnerEL
 */
public class World3 extends JFrame {
    Random random;
    String paths[] = {"block1.png", "block2.png", "block3.png", "block4.png"};
    int LIFE;
    Canvas canvas;
    ArrayList<Bomb> bombs;
    ArrayList<Enemy> enemies;
    SoundPlayer soundplayer;
    Timer timer;
    int[][] map = {
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 0, 0, 0, 1, 1, 1, 0, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 1, 2, 0, 2},
        {2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 2},
        {2, 0, 2, 0, 2, 0, 2, 0, 2, 1, 2},
        {2, 1, 0, 0, 0, 1, 0, 0, 0, 1, 2},
        {2, 1, 2, 0, 2, 0, 2, 1, 2, 1, 2},
        {2, 0, 1, 1, 1, 0, 0, 0, 0, 1, 2},
        {2, 0, 2, 0, 2, 1, 2, 0, 2, 0, 2},
        {2, 0, 0, 1, 1, 1, 1, 0, 0, 0, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    };
    Render render;
    Bomberman j1;
    long start;


    public void iniKeyListener() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_LEFT: {
                        j1.setDirection(Bomberman.LEFT);
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        j1.setDirection(Bomberman.DOWN);
                        break;
                    }
                    case KeyEvent.VK_UP: {
                        j1.setDirection(Bomberman.UP);
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        j1.setDirection(Bomberman.RIGTH);
                        break;
                    }     
                    case KeyEvent.VK_SPACE: {
                        int x = j1.x;
                        int y = j1.y;
                        bombs.add(new Bomb(((int) x / 50) * 50, ((int) y / 50) * 50, System.currentTimeMillis()));
                    }
                }
            }
            
            @Override
            public void keyReleased(KeyEvent ke) {
                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_LEFT: {
                        j1.setDirection(Bomberman.NONE);
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        j1.setDirection(Bomberman.NONE);
                        break;
                    }
                    case KeyEvent.VK_UP: {
                        j1.setDirection(Bomberman.NONE);
                        break;
                    }
                    case KeyEvent.VK_RIGHT: {
                        j1.setDirection(Bomberman.NONE);
                        break;    
                    }
                }
            }
        });
    }

    public World3() {
        setSize(551, 696);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        canvas = new Canvas();
        random = new Random();
        bombs = new ArrayList();
        enemies = new ArrayList();
        LIFE = 3;
        JLabel label1 = new JLabel();
        label1.setFont(new Font("Serif", Font.PLAIN, 20));
        label1.setForeground(Color.BLACK);
        timer = new Timer();
        label1.setOpaque(true);
        label1.setVisible(true);
        add(label1);
        add(timer);
        soundplayer = new SoundPlayer(1);
        soundplayer.loadSound();
        soundplayer.start();
        soundplayer.playLoop();
        canvas.setSize(556, 669);
        add(canvas);
        int rnd = random.nextInt(3);
        String path = paths[rnd];
        render = new Render(map, path);
        j1 = new Bomberman(50, 50, 7, 7, "BomberBlanco");
        iniKeyListener();
        j1.loadPic();
        setResizable(false);
        setFocusable(true);
        setVisible(true);
        enemies.add(new Enemy(450, 50, 2, 2, 3, map));
        enemies.add(new Enemy(50, 450, 2, 2, 3, map));
        enemies.add(new Enemy(450, 450, 2, 2, 3, map));
        new Thread(new Runnable() {
            @Override
            public void run() {
                canvas.createBufferStrategy(2);
                start = System.currentTimeMillis();
                Boolean sw = false;
                boolean sw2 = false;
                boolean sw3 = false;
                while (true && !sw) {
                    label1.setText("      Vidas: " + LIFE + "                                        Nivel 3");
                    Graphics g = canvas.getBufferStrategy().getDrawGraphics();
                    try {
                        g.setColor(Color.BLACK);
                        g.fillRect(0, 0, 646, 669);
                        render.draw(g); 
                        if (enemies.size() > 0) {
                            for (int i = 0; i < enemies.size(); i++) {
                                int x = ((int) j1.x / 50) * 50;
                                int y = ((int) j1.y / 50) * 50;
                                Graph gh = new Graph(map);
                                gh.loadGraph();
                                gh.shortestPathDijkstra(gh.nearestNode(enemies.get(i).x, enemies.get(i).y));
                                gh.getPath(gh.nearestNode(enemies.get(i).x, enemies.get(i).y), gh.nearestNode(j1.x, j1.y));
                                gh.addPath(x, y);
                                enemies.get(i).move(gh.path, map);
                                if (enemies.get(i).bomberDead(j1.x, j1.y)) {
                                    JOptionPane.showMessageDialog(null, "Haz perdido una Vida", "Atención", JOptionPane.WARNING_MESSAGE);
                                    j1.bomberNewPosition();
                                    LIFE -= 1;  
                                }
                                enemies.get(i).draw(g);
                            }
                        }
                        
                        if (LIFE > 0) {
                            j1.move(System.currentTimeMillis() - start, map);
                            j1.draw(g); 
                            if (bombs.size() > 0) {
                                for (int i = 0; i < bombs.size(); i++) {
                                    long time = System.currentTimeMillis() - bombs.get(i).start;
                                    if (time <= 3000) {
                                        bombs.get(i).loadPic();
                                        bombs.get(i).draw(g);
                                    } else {
                                        SoundPlayer sp = new SoundPlayer(2);
                                        sp.loadSound();
                                        sp.start();
                                        Explosion ex = new Explosion(bombs.get(i).x, bombs.get(i).y, map, System.currentTimeMillis());
                                        ex.generateMap();
                                        ex.assignExplosion();
                                        ex.draw(g);
                                        map = ex.map;
                                        render = new Render(map, path); 
                                        bombs.remove(i);
                                        if (ex.bombermanDead(j1.x, j1.y)) {
                                            SoundPlayer sp2 = new SoundPlayer(3);
                                            sp2.loadSound();
                                            sp2.start();
                                            j1.bomberNewPosition();
                                            JOptionPane.showMessageDialog(null, "Has perdido una Vida", "Atención", JOptionPane.WARNING_MESSAGE);
                                            LIFE--;
                                        }
                                        for (int j = 0; j < enemies.size(); j++) {
                                            if (ex.enemyDead(enemies.get(j).x, enemies.get(j).y)) {
                                                SoundPlayer sp3 = new SoundPlayer(4);
                                                sp3.loadSound();
                                                sp3.start();
                                                enemies.remove(j);  
                                            }
                                        }
                                    } 
                                }
                            }
                        } 
                        if (LIFE == 0) {
                            sw = true;
                            sw3 = true;
                            JOptionPane.showMessageDialog(null, "Game Over", "Alerta", JOptionPane.ERROR_MESSAGE);
                            label1.setText("      Vidas: " + 0 + "                                        Nivel 3");
                            timer.stop();
                            soundplayer.stop();
                        }
                        if (zeroBlocks() && sw2 == false) {
                            door(path);
                            sw2 = true;
                        }
                        canvas.getBufferStrategy().show();
                        if (isUnderDoor(j1.x, j1.y) && sw == false) {
                            sw = true;
                        }
                        Thread.sleep(40); 
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!sw3) {
                    soundplayer.stop();
                }
                if (sw && !sw3) {
                    JOptionPane.showMessageDialog(null, "Enhorabuena, has ganado", "Atención", JOptionPane.INFORMATION_MESSAGE);
                    soundplayer.stop();
                    timer.stop();
                }
            }
        }).start();
    }

    public boolean zeroBlocks() {
        boolean sw = true;
        for (int i = 0; i < map.length && sw == true; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] != 2 && map[i][j] != 0 && map[i][j] != 3) {
                    sw = false;
                }
            }
        }
        return sw;
    }
    
    public void door(String path) {
        Random rnd1 = new Random();
        int x = (int) (rnd1.nextDouble() * 450 + 50);
        Random rnd2 = new Random();
        int y = (int) (rnd2.nextDouble() * 450 + 50);
        while (map[(int) x / 50][(int) y / 50] == 2) {
            rnd1 = new Random();
            x = (int) (rnd1.nextDouble() * 450 + 50);
            rnd2 = new Random();
            y = (int) (rnd2.nextDouble() * 450 + 50);
        }
        map[(int) y / 50][(int) x / 50] = 3;
        render = new Render(map, path);
    }
    
    public boolean isUnderDoor(int x1, int y1) {
        boolean sw = false;
        if (map[y1 / 50][x1 / 50] == 3) {
            sw = true;
        }
        if (map[y1 / 50][(x1 + 30) / 50] == 3) {
            sw = true;
        }
        if (map[(y1 + 20) / 50][(x1 + 30) / 50] == 3) {
            sw = true;
        }
        if (map[(y1 + 20) / 50][x1 / 50] == 3) {
            sw = true;
        }
        return sw;
    }
}
