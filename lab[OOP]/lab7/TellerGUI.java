
package javaapplication1;

import java.awt.*;
import javax.swing.*;

public class TellerGUI {
    private JFrame fr;
    private JLabel lb1, lb2;
    private JTextField tf1, tf2;
    private JButton b1, b2, b3;
    private JPanel p, i;
    
    public void init(){
        fr = new JFrame("Teller GUI");
        
        lb1 = new JLabel("Balance");
        tf1 = new JTextField("6000");
        tf1.setEditable(false);
        lb2 = new JLabel("Amount");
        tf2 = new JTextField();
        
        b1 = new JButton("Deposit");
        b2 = new JButton("Withdraw");
        b3 = new JButton("Exit");
        
        p = new JPanel();
        p.setLayout(new GridLayout(2, 2));
        p.add(lb1);
        p.add(tf1);
        
        p.add(lb2);
        p.add(tf2);
        
        i = new JPanel();
        i.setLayout(new FlowLayout());
        i.add(b1);
        i.add(b2);
        i.add(b3);
        
        fr.add(p, BorderLayout.NORTH);
        fr.add(i);
        
        
        fr.setSize(600, 600);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
        fr.pack();
    }
    
    
    
    public static void main(String[] args) {
        new TellerGUI().init();
    }
    
}
