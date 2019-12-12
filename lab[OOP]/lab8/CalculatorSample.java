
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorSample implements ActionListener {

    private JFrame fr;
    private JPanel p;
    private JTextField txt;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16;
    private double num1 = 0;
    private String text1 = "";

    public void init() {
        // Construct Object
        fr = new JFrame("My Calculator ");
        p = new JPanel();
        txt = new JTextField();
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn10 = new JButton("0");
        btn11 = new JButton("c");
        btn12 = new JButton("+");
        btn13 = new JButton("-");
        btn14 = new JButton("x");
        btn15 = new JButton("/");
        btn16 = new JButton("=");

        p.setLayout(new GridLayout(4, 4));
        p.add(btn7);
        p.add(btn8);
        p.add(btn9);
        p.add(btn12);

        p.add(btn4);
        p.add(btn5);
        p.add(btn6);
        p.add(btn13);

        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        p.add(btn14);

        p.add(btn10);
        p.add(btn11);
        p.add(btn16);
        p.add(btn15);

        fr.add(txt, BorderLayout.NORTH);
        fr.add(p, BorderLayout.CENTER);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(500, 650);
        fr.setVisible(true);
        fr.pack();

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);

        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);

        btn9.addActionListener(this);
        btn10.addActionListener(this);
        btn11.addActionListener(this);
        btn12.addActionListener(this);

        btn13.addActionListener(this);
        btn14.addActionListener(this);
        btn15.addActionListener(this);
        btn16.addActionListener(this);

    }

    public static void main(String[] args) {

        new CalculatorSample().init();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(btn1)) {
            txt.setText(txt.getText() + "1");
        }
        if (e.getSource().equals(btn2)) {
            txt.setText(txt.getText() + "2");
        }
        if (e.getSource().equals(btn3)) {
            txt.setText(txt.getText() + "3");
        }
        if (e.getSource().equals(btn4)) {
            txt.setText(txt.getText() + "4");
        }
        if (e.getSource().equals(btn5)) {
            txt.setText(txt.getText() + "5");
        }
        if (e.getSource().equals(btn6)) {
            txt.setText(txt.getText() + "6");
        }
        if (e.getSource().equals(btn7)) {
            txt.setText(txt.getText() + "7");
        }
        if (e.getSource().equals(btn8)) {
            txt.setText(txt.getText() + "8");
        }
        if (e.getSource().equals(btn9)) {
            txt.setText(txt.getText() + "9");
        }
        if (e.getSource().equals(btn10)) {
            txt.setText(txt.getText() + "0");
        }

        if (e.getSource().equals(btn11)) {
            num1 = 0;
            txt.setText("");
        }
        if (e.getSource().equals(btn12)) {
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
            text1 = "+";
        }
        if (e.getSource().equals(btn13)) {
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
            text1 = "-";
        }
        if (e.getSource().equals(btn14)) {
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
            text1 = "*";
        }
        if (e.getSource().equals(btn15)) {
            num1 = Double.parseDouble(txt.getText());
            txt.setText("");
            text1 = "/";
        }
        if (e.getSource().equals(btn16)) {
            if (text1.equals("+")) {
                num1 += Double.parseDouble(txt.getText());
            }
            if (text1.equals("-")) {
                num1 -= Double.parseDouble(txt.getText());
            }
            if (text1.equals("*")) {
                num1 *= Double.parseDouble(txt.getText());
            }
            if (text1.equals("/")) {
                num1 /= Double.parseDouble(txt.getText());
            }
            txt.setText(num1 + "");
        }
    }
}
