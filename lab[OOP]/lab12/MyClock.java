package lab12;

import java.awt.Font;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class MyClock extends JLabel implements Runnable{

    @Override
    public void run() {
        int sec = 55;
        int min = 59;
        int hour = 0;
        while(true){
            try {
                
                
                Font font = new Font("Courier", Font.BOLD,36);
                setFont(font);
                
                String x = String.format("%02d : %02d : %02d", hour, min, sec);
                setText(x);
                
                sec +=1;
                if(sec==60){
                    min += 1;
                    sec = 0;}
                if(min==60){
                    hour +=1;
                    min =0;
                }
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

//    @Override
//    public void run() {
//        while(true){
//            
//            try {
//                Calendar d = Calendar.getInstance();
//                int sec = d.get(Calendar.SECOND);
//                int min = d.get(Calendar.MINUTE);
//                int hour = d.get(Calendar.HOUR_OF_DAY);
//                
//                Font font = new Font("Courier", Font.BOLD,36);
//                setFont(font);
//                
//                String x = String.format("%02d : %02d : %02d", hour, min, sec);
//                setText(x);
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(MyClock.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//    }
    
}
