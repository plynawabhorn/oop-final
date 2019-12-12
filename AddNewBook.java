/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 61070020
 */
public class AddNewBook implements MouseListener {

    JFrame frame;
    JPanel panel, panel2;
    JLabel nameLabel, priceLabel, typeLabel;
    JTextField nameTextField, priceTextField;
    JComboBox tcb;
    JButton insertBtn;
    ArrayList<Info> info = new ArrayList<Info>();
    FileOutputStream fout;
    ObjectOutputStream oout;
    FileInputStream fin;
    ObjectInputStream oin;
    
    public void init() {
        frame = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
        nameLabel = new JLabel(" Name");
        priceLabel = new JLabel(" Price");
        typeLabel = new JLabel(" Type");
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        insertBtn = new JButton("Insert");
        insertBtn.addMouseListener(this);
        tcb = new JComboBox();
        tcb.addItem("General");
        tcb.addItem("Computer");
        tcb.addItem("Math&Sci");
        tcb.addItem("Photo");
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(typeLabel);
        panel.add(tcb);
        panel.setLayout(new GridLayout(3,2));
        panel2.add(insertBtn);
        panel2.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setSize(300,150);
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        String name = nameTextField.getText();
        Double price = Double.parseDouble(priceTextField.getText());
        String type = tcb.getSelectedItem().toString();
        if (me.getSource() == insertBtn) {
            try {
                try {
                    fin = new FileInputStream("data.dat");
                    oin = new ObjectInputStream(fin);
                    info = (ArrayList<Info>) oin.readObject();
                    oin.close();
                    fin.close();
                } catch (EOFException ex) {
                }
                fout = new FileOutputStream("data.dat");
                oout = new ObjectOutputStream(fout);
                info.add(new Info(name, type, price));
                oout.writeObject(info);
                oout.close();
                fout.close();
                JOptionPane.showMessageDialog(null, "Done it.", "", JOptionPane.PLAIN_MESSAGE);
                frame.setVisible(false);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            } catch (IOException ex) {
                System.out.println(ex.toString());
            } catch (ClassNotFoundException ex) {
            }
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
}
