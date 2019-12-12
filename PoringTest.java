/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LAB207_40
 */
public class PoringTest implements MouseListener {

    JFrame frame;
    JPanel panel;
    JButton addBtn;
    int count = 1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void init() {
        frame = new JFrame();
        panel = new JPanel();
        addBtn = new JButton("Add");
        addBtn.addMouseListener(this);
        panel.add(addBtn);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(100, 80);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

//    public void shaking(JFrame frame) {
//        final int originalX = frame.getLocationOnScreen().x;
//        final int originalY = frame.getLocationOnScreen().y;
//
//        try {
//            Thread.sleep(500);
//            frame.setLocation(originalX, originalY + VIBRATION_VELOCITY);
//            Thread.sleep(500);
//            frame.setLocation(originalX, originalY - VIBRATION_VELOCITY);
//            Thread.sleep(500);
//            frame.setLocation(originalX + VIBRATION_VELOCITY, originalY);
//            Thread.sleep(500);
//            frame.setLocation(originalX, originalY);
//
//        } catch (Exception err) {
//            err.printStackTrace();
//        }
//    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == addBtn) {
            PoringClass por = new PoringClass();
            por.init(count);
            Thread t = new Thread(por);
            t.start();
            count++;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
