package lab12;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends MyClock implements Runnable{

 public static void main(String[] args) {
        JFrame fr = new JFrame("My Clock");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        t.start();

        fr.add(clock);
        fr.setSize(230, 125);
        fr.setVisible(true);
    }
}
