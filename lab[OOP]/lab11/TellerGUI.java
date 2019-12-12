import java.awt.*;
import javax.swing.*;

public class TellerGUI {

    private JFrame fr;
    private JPanel p1, p2, p3, p4;
    private JTextField txt1, txt2;
    private JLabel lbl1, lbl2, lbl3;
    private JButton btn1, btn2, btn3;

    public void init() {
        // Construct Object

        fr = new JFrame("Teller GUI");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        txt1 = new JTextField("6000");
        txt2 = new JTextField();
        lbl1 = new JLabel("  Balance");
        lbl2 = new JLabel("  Amount");
        lbl3 = new JLabel("...");
        btn1 = new JButton("Deposit");
        btn2 = new JButton("Withdraw");
        btn3 = new JButton("Exit");

        txt1.setEditable(false);

        fr.setLayout(new GridLayout(4, 1));
        p1.setLayout(new GridLayout(1, 2));
        p2.setLayout(new GridLayout(1, 2));
        p3.setLayout(new FlowLayout());

        p1.add(lbl1);
        p1.add(txt1);

        p2.add(lbl2);
        p2.add(txt2);

        p3.add(btn1);
        p3.add(btn2);
        p3.add(btn3);

        p4.add(lbl3);
        fr.add(p1);
        fr.add(p2);
        fr.add(p3);
        fr.add(p4);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400, 200);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new TellerGUI().init();
    }

}