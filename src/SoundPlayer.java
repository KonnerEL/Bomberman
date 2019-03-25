import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KonnerEL
 */
public class SoundPlayer {
    Clip clip;
    AudioInputStream audiostream;
    String sound;
    public SoundPlayer(int type) {
        switch(type) {
            case 1: {
                sound = "Super_Bomberman.wav"; 
                break;
            }
            case 2: {
                sound = "Grenade.wav"; 
                break;
            }
            case 3: {
                sound = "Pain.wav";
            }
            case 4: {
                sound = "Scream.wav";
            }
        }
    }
    
    public void loadSound() {
        try {
            clip = AudioSystem.getClip();         
            audiostream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(sound));
            clip.open(audiostream);
        } catch(Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public void start() {
        clip.start(); 
    }
    
    public void stop() {
        clip.stop();
    }
    
    public void playLoop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
