import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends JPanel implements Runnable
{
    JLabel label;
    Thread thread;
    long time;
    public Timer()
    {
        setSize(70, 50);   
        setBackground(Color.BLACK);
        label = new JLabel("00:00");
        label.setFont(new Font(Font.SERIF, Font.BOLD, 50));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.BLACK);
        label.setOpaque(true);
        add(label);
        setVisible(true);
        start();
        time = System.currentTimeMillis();
    }

    public void run(){
        try
        {
            while(true)
            {
                String min, sec = "";
                long secs = (System.currentTimeMillis() - time) % 60000 / 1000;
                long mins = (System.currentTimeMillis() - time) / 60000;
                if (mins < 10) min = "0" + mins;
                else min = "" + mins;
                if (secs < 10) sec = "0" + secs;
                else sec = "" + secs;
                label.setText("Time: " + min + ":" + sec);
                Thread.sleep(1000);
            }
        }catch(Exception e){}
    }

    public void start() {
        thread = new Thread( this );
        thread.start();
    }

    public void stop(){
        thread.stop();
    }
    
}