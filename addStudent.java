/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author LAB207_40
 */
public class addStudent implements MouseListener {

    JFrame frame = new JFrame("Add New Student");
    JLabel stuLabel = new JLabel(" Student ID:");
    JLabel firstLabel = new JLabel(" First Name:");
    JLabel lastLabel = new JLabel(" Last Name:");
    JLabel gpaLabel = new JLabel(" GPA:");
    JTextField stuText = new JTextField();
    JTextField firstText = new JTextField();
    JTextField lastText = new JTextField();
    JTextField gpaText = new JTextField();
    JButton okBtn = new JButton("OK");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    ArrayList<Student> stu = new ArrayList<Student>();

    public void init() {

        panel.add(stuLabel);

        panel.add(stuText);

        panel.add(firstLabel);

        panel.add(firstText);

        panel.add(lastLabel);

        panel.add(lastText);

        panel.add(gpaLabel);

        panel.add(gpaText);

        panel.setLayout(
                new GridLayout(4, 2));

        okBtn.addMouseListener(this);

        panel2.add(okBtn);

        panel2.setLayout(
                new FlowLayout());
        frame.add(panel, BorderLayout.CENTER);

        frame.add(panel2, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(
                400, 200);
        frame.setVisible(
                true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String stu_id = stuText.getText();
        String first = firstText.getText();
        String last = lastText.getText();
        Double gpa = Double.parseDouble(gpaText.getText());

        Student s = new Student(stu_id, first, last, gpa);
        if (e.getSource() == okBtn) {
            FileOutputStream fout;
            ObjectOutputStream oout;
            FileInputStream fin;
            ObjectInputStream oin;
            try {
                try{
                fin = new FileInputStream("data.dat");
                oin = new ObjectInputStream(fin);
                stu = (ArrayList<Student>) oin.readObject();
                oin.close();
                fin.close();
                }catch(EOFException ex){
                    }
                fout = new FileOutputStream("data.dat");
                oout = new ObjectOutputStream(fout);
                stu.add(s);
                oout.writeObject(stu);
                oout.close();
                fout.close();
                
                frame.setVisible(false);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            } catch (IOException ex) {
                System.out.println(ex.toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(addStudent.class.getName()).log(Level.SEVERE, null, ex);
            }

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
