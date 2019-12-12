/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefinal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author 61070020
 */
public class BookGUI implements MouseListener {

    int count = 0;
    JFrame frame;
    JPanel panel, panel2, panel3;
    JLabel nameLabel, priceLabel, typeLabel;
    JTextField nameTextField, priceTextField, indexTextField;
    JButton prevBtn, nextBtn, addBtn, updateBtn, deleteBtn;
    JComboBox tcb;
    ArrayList<Info> info = new ArrayList<Info>();
    FileOutputStream fout;
    ObjectOutputStream oout;
    FileInputStream fin;
    ObjectInputStream oin;

    public void init() {
        frame = new JFrame();
        panel = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        nameLabel = new JLabel("  Name");
        priceLabel = new JLabel("  Price");
        typeLabel = new JLabel("  Type");
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        indexTextField = new JTextField();
        prevBtn = new JButton("<<<");
        nextBtn = new JButton(">>>");
        addBtn = new JButton("Add");
        updateBtn = new JButton("Update");
        deleteBtn = new JButton("Delete");
        tcb = new JComboBox();
        tcb.addItem("General");
        tcb.addItem("Computer");
        tcb.addItem("Math&Sci");
        tcb.addItem("Photo");
        addBtn.addMouseListener(this);
        updateBtn.addMouseListener(this);
        deleteBtn.addMouseListener(this);
        prevBtn.addMouseListener(this);
        nextBtn.addMouseListener(this);
        indexTextField.setText(count + "");
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(typeLabel);
        panel.add(tcb);
        panel2.add(prevBtn);
        panel2.add(indexTextField);
        panel2.add(nextBtn);
        indexTextField.setPreferredSize(new Dimension(50, 20));
        panel3.add(addBtn);
        panel3.add(updateBtn);
        panel3.add(deleteBtn);
        panel.setLayout(new GridLayout(3, 2));
        panel2.setLayout(new FlowLayout());
        panel3.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 200);
        // FOR ข้อ 2
//        try {
//            File f = new File("data.dat");
//            if (f.exists()) {
//                fout = new FileOutputStream("data.dat");
//                oout = new ObjectOutputStream(fout);
//                info.add(new Info(null, "General", null));
//                info.add(new Info("JAVA", "Computer", 240.0));
//                info.add(new Info("PYTHON", "Computer", 400.0));
//                info.add(new Info("C++", "Computer", 380.0));
//                info.add(new Info("PHP", "Computer", 120.0));
//                oout.writeObject(info);
//                oout.close();
//                fout.close();
//            } else {
//                fout = new FileOutputStream("data.dat");
//                oout = new ObjectOutputStream(fout);
//                info.add(new Info(null, "General", null));
//                info.add(new Info("JAVA", "Computer", 240.0));
//                info.add(new Info("PYTHON", "Computer", 400.0));
//                info.add(new Info("C++", "Computer", 380.0));
//                info.add(new Info("PHP", "Computer", 120.0));
//                oout.writeObject(info);
//                oout.close();
//                fout.close();
//            }
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        }
       // FOR ข้อ 3
        try {
            File f = new File("data.dat");
            if (f.exists() == false) {
                fout = new FileOutputStream("data.dat");
                oout = new ObjectOutputStream(fout);
                info.add(new Info(null, "General", null));
                oout.writeObject(info);
                oout.close();
                fout.close();
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        try {
            fin = new FileInputStream("data.dat");
            oin = new ObjectInputStream(fin);
            info = (ArrayList<Info>) oin.readObject();
            oin.close();
            fin.close();
        } catch (EOFException ex) {
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        updateInfo();
        if (me.getSource() == addBtn) {
            AddNewBook add = new AddNewBook();
            add.init();
        }
        if (me.getSource() == prevBtn) {
            if (count == 0) {
                count = 0;
            } else if (count - 1 == 0) {
                count = 1;
            } else {
                count--;
                showInfo();
            }
        }
        if (me.getSource() == nextBtn) {
            if (count + 1 > info.size() - 1) {
                count = info.size() - 1;
            } else {
                count++;
                showInfo();
            }

        }
        if (me.getSource() == deleteBtn) {
            deleteBook();
        }
        if (me.getSource() == updateBtn) {
            updateBook();
        }
    }

    @Override
    public void mousePressed(MouseEvent me
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent me
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent me
    ) {

    }

    @Override
    public void mouseExited(MouseEvent me
    ) {

    }

    public void showInfo() {
        indexTextField.setText(count + "");
        try {;
            fin = new FileInputStream("data.dat");
            oin = new ObjectInputStream(fin);
            info = (ArrayList<Info>) oin.readObject();
            oin.close();
            fin.close();
        } catch (EOFException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
        nameTextField.setText(info.get(count).getName());
        priceTextField.setText(info.get(count).getPrice() + "");
        tcb.setSelectedItem(info.get(count).getType());
    }

    public void deleteBook() {
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
            if (count == info.size()) {
                info.remove(count - 1);
                count -= 2;

            } else {
                info.remove(count);
                count--;
            }
            JOptionPane.showMessageDialog(null, "Done it.", "Delete Command", JOptionPane.PLAIN_MESSAGE);
            showInfo();
            oout.writeObject(info);
            oout.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
        }
    }

    public void updateBook() {
        String name = nameTextField.getText();
        Double price = Double.parseDouble(priceTextField.getText());
        String type = tcb.getSelectedItem().toString();
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
            info.set(count, new Info(name, type, price));
            JOptionPane.showMessageDialog(null, "Done it.", "Update Command", JOptionPane.PLAIN_MESSAGE);
            showInfo();
            oout.writeObject(info);
            oout.close();
            fout.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
        }
    }

    public void updateInfo() {
        try {
            fin = new FileInputStream("data.dat");
            oin = new ObjectInputStream(fin);
            info = (ArrayList<Info>) oin.readObject();
            oin.close();
            fin.close();
        } catch (EOFException ex) {
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
}
