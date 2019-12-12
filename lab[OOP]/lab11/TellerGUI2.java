package Lab11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TellerGUI2 {

    private JFrame frame;
    private JPanel panel1, panel2;
    private JButton b1, b2, b3;
    private JTextField tf_balance, tf_amount;
    private JLabel balance, amount, commands;
    double balances = 6000;

    public void init() {
        //from balancestorage
        balances = BalanceStorage.getBalance();
        //frame
        frame = new JFrame("Teller GUI");
        // label balance
        balance = new JLabel("Balance");
        amount = new JLabel("Amount");
        // textfield
        tf_balance = new JTextField();
        tf_amount = new JTextField();
        tf_amount.setText("0");
        tf_balance.setEditable(false);
        tf_balance.setText(balances + "");
        //button
        b1 = new JButton("Deposit");
        b2 = new JButton("Withdraw");
        b3 = new JButton("Exit");
        //button event
        b1.addActionListener(new ActionHandler());
        b2.addActionListener(new ActionHandler());
        b3.addActionListener(new ActionHandler());
        //panel1
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(balance);
        panel1.add(tf_balance);
        panel1.add(amount);
        panel1.add(tf_amount);
        // panel2
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        panel2.add(b1);
        panel2.add(b2);
        panel2.add(b3);
        //commands
        commands = new JLabel("Command", JLabel.CENTER);
        //import in program
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(commands, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setBounds(750, 400, 300, 140);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TellerGUI2().init();
    }

    public class ActionHandler implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            double total = Double.parseDouble(tf_balance.getText());
            double want = Double.parseDouble(tf_amount.getText());
            BalanceStorage.saveBalance(balances);
            if (ev.getSource().equals(b2)) {
                if (total - want < 0) {
                    commands.setText("Not Enough!");
                } else {
                    balances = balances - want;
                    tf_balance.setText(balances + "");
                    commands.setText("Withdraw : " + want);
                }
            } else if (ev.getSource().equals(b1)) {
                balances = balances + want;
                tf_balance.setText(balances + "");
                commands.setText("Deposit : " + want);
            } else if (ev.getSource().equals(b3)) {
                System.exit(0);
            }
        }
    }
}
