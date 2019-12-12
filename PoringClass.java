/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LAB207_40
 */
public class PoringClass extends PoringTest implements MouseListener, WindowListener, Runnable {

    JFrame frame;
    JPanel panel, panel2;
    JLabel poring, num;
    Random rand = new Random();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;
    Boolean chk = true;
    private final int VIBRATION_VELOCITY = rand.nextInt(20);

    public void init(int count) {
        frame = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
        poring = new JLabel();
        num = new JLabel(count + "");
        poring.addMouseListener(this);
        poring.setIcon(new ImageIcon("p96.png"));
        panel.add(poring);
        panel2.add(num);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.EAST);
        frame.setVisible(true);
        frame.setSize(160, 140);
        frame.setLocation(rand.nextInt(screenWidth), rand.nextInt(screenHeight));
        frame.setDefaultCloseOperation(0);
    }

    @Override
    public void windowOpened(WindowEvent we) {

    }

    @Override
    public void windowClosing(WindowEvent we) {

    }

    @Override
    public void windowClosed(WindowEvent we) {

    }

    @Override
    public void windowIconified(WindowEvent we) {

    }

    @Override
    public void windowDeiconified(WindowEvent we) {

    }

    @Override
    public void windowActivated(WindowEvent we) {

    }

    @Override
    public void windowDeactivated(WindowEvent we) {

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == poring) {
            chk = false;
            frame.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    @Override
    public void run() {
        while(true){
        try {
            int x = frame.getX();
            int y = frame.getY();
            int randomX = rand.nextInt(20);
            int randomY = rand.nextInt(20);
            if(randomX < 10){
                x -= randomX;
            } else{
                x += randomX-10;
            }
            if(randomY < 10){
                y -= randomY;
            } else{
                y += randomY-10;
            }
            frame.setLocation(x, y);
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(PoringClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
