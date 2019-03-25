import java.awt.Image;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lgguzman
 */
public class Animation {
    private ArrayList<Scene> scenes;
    private int currentScene;
    private long movieTime;
    private long totalTime;
    
    public synchronized  void start(){
        movieTime = 0;
        currentScene = 0;
    }
    
    
    public synchronized void addScene(Image i, long t){
        totalTime+=t;
        scenes.add(new Scene(i, totalTime));
    }
    
    public synchronized void update(long time){
        if(!scenes.isEmpty()){
            if(time > totalTime){
                movieTime=time%totalTime;
                currentScene=0;
            }else{
                movieTime = time;
            }
            while(movieTime > getScene(currentScene).endTime)
                currentScene++;
        }
    }
    
    private synchronized Scene getScene(int x){
        return scenes.get(x);
    }
    
    public synchronized Image getImage(){
        return  scenes.isEmpty()?null:getScene(currentScene).pic;
    }
    
    public Animation (){
        scenes = new ArrayList<>();
        totalTime=0;
        start();
    }
    
    private class Scene{
        Image pic;
        long endTime;
        
        public Scene (Image pic, long endTime ){
            this.pic=pic;
            this.endTime = endTime;
        }
    }
}
