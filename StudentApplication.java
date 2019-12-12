
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LAB207_70
 */
public class StudentApplication implements ActionListener {
    
    private int currentIndex = 0;
    private JFrame fr, fr2;
    private JPanel p1, p2, p3, p4;
    private JLabel lb1, lb2, lb3, lb4;
    private JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8;
    private JButton btn1, btn2, btn3, btn4, btn5;
    private ArrayList<Student> arrStd = new ArrayList();
    private Student std;
    
    private FileOutputStream fout;
    private ObjectOutputStream oout;
    private FileInputStream fin;
    private ObjectInputStream oin;

    public StudentApplication() {
        
        try {
            fin = new FileInputStream("data.dat");
            oin = new ObjectInputStream(fin);
            arrStd = (ArrayList) oin.readObject();
            currentIndex = arrStd.size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(StudentApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        currentIndex = arrStd.size()-1;
    }
    
    public void init() { 
        fr = new JFrame("Student Application");
        fr.setVisible(true);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 2));

        if (arrStd.size() == 0) {
            txt1 = new JTextField();
            txt2 = new JTextField();
            txt3 = new JTextField();
            txt4 = new JTextField();
        } else {
            txt1 = new JTextField(arrStd.get(arrStd.size()-1).getStd_id());
            txt2 = new JTextField(arrStd.get(arrStd.size()-1).getFirstname());
            txt3 = new JTextField(arrStd.get(arrStd.size()-1).getLastname());
            txt4 = new JTextField(arrStd.get(arrStd.size()-1).getGpa());
        }
        
        lb1 = new JLabel(" Student ID:");
        txt1.setEditable(false);
        
        lb2 = new JLabel(" First Name:");
        txt2.setEditable(false);
        
        lb3 = new JLabel(" Last Name:");
        txt3.setEditable(false);
        
        lb4 = new JLabel(" GPA:");
        txt4.setEditable(false);
        
        p1.add(lb1);
        p1.add(txt1);
        p1.add(lb2);
        p1.add(txt2);
        p1.add(lb3);
        p1.add(txt3);
        p1.add(lb4);
        p1.add(txt4);

        p2 = new JPanel();
        p2.setLayout(new FlowLayout());

        btn1 = new JButton("Prev");
        btn2 = new JButton("Next");
        btn3 = new JButton("Add");
        btn4 = new JButton("Exit");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        
        p2.add(btn1);
        p2.add(btn2);
        p2.add(btn3);
        p2.add(btn4);

        fr.add(p1);
        fr.add(p2, BorderLayout.SOUTH);

        fr.setSize(400, 150);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAdd() {
        std = new Student();
        fr2 = new JFrame("Add Student");
        fr2.setVisible(true);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(4, 2));

        lb1 = new JLabel(" Student ID:");
        txt5 = new JTextField();
        txt5.setEditable(true);

        lb2 = new JLabel(" First Name:");
        txt6 = new JTextField();
        txt6.setEditable(true);

        lb3 = new JLabel(" Last Name:");
        txt7 = new JTextField();
        txt7.setEditable(true);

        lb4 = new JLabel(" GPA:");
        txt8 = new JTextField();
        txt8.setEditable(true);

        p3.add(lb1);
        p3.add(txt5);
        p3.add(lb2);
        p3.add(txt6);
        p3.add(lb3);
        p3.add(txt7);
        p3.add(lb4);
        p3.add(txt8);

        p4 = new JPanel();
        p4.setLayout(new FlowLayout());

        btn5 = new JButton("OK");

        btn5.addActionListener(this);

        p4.add(btn5);

        fr2.add(p3);
        fr2.add(p4, BorderLayout.SOUTH);

        fr2.setSize(400, 150);
        fr2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StudentApplication().init();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btn1)) {
            if (currentIndex == 0) {
                System.out.println("first index");  
            } else {
                currentIndex--;
                txt1.setText(arrStd.get(currentIndex).getStd_id());
                txt2.setText(arrStd.get(currentIndex).getFirstname());
                txt3.setText(arrStd.get(currentIndex).getLastname());
                txt4.setText(arrStd.get(currentIndex).getGpa());
            }
        }
        
        if (e.getSource().equals(btn2)) {
            if (currentIndex == arrStd.size()-1) {
                System.out.println("last index");
            } else {
                currentIndex++;
                txt1.setText(arrStd.get(currentIndex).getStd_id());
                txt2.setText(arrStd.get(currentIndex).getFirstname());
                txt3.setText(arrStd.get(currentIndex).getLastname());
                txt4.setText(arrStd.get(currentIndex).getGpa());
            }
        }
        
        if (e.getSource().equals(btn3)) {
            this.initAdd();
        }
        
        if (e.getSource().equals(btn4)) {
            try {
                fout = new FileOutputStream("data.dat");
                oout = new ObjectOutputStream(fout);
                oout.writeObject(arrStd);
                System.out.println("Write to file successfully");
                oout.close();
                fout.close();
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentApplication.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(StudentApplication.class.getName()).log(Level.SEVERE, null, ex);
            } 
            fr.dispose();
        }

        if (e.getSource().equals(btn5)) {
            
            std.setStd_id(txt5.getText());
            std.setFirstname(txt6.getText());
            std.setLastname(txt7.getText());
            std.setGpa(txt8.getText());
            arrStd.add(std);
            
            txt1.setText(arrStd.get(arrStd.size()-1).getStd_id());
            txt2.setText(arrStd.get(arrStd.size()-1).getFirstname());
            txt3.setText(arrStd.get(arrStd.size()-1).getLastname());
            txt4.setText(arrStd.get(arrStd.size()-1).getGpa());
            
            currentIndex = arrStd.size()-1;
            fr2.dispose();
        }
    }

}
