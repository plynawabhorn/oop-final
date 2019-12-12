
package Lab11;

import java.io.*;

public class BalanceStorage {

    public static double getBalance() {
        double balance = 0;
        File f = new File("Balance.dat");
        try {
            if (f.exists()) {
                FileInputStream fin = new FileInputStream("Balance.dat");
                DataInputStream din = new DataInputStream(fin);
                balance = din.readDouble();
                din.close();
                fin.close();
            } else {
                balance = 9000;
            }
        } catch (Exception ex) {
            ex.toString();
        }
        return balance;
    }

    public static void saveBalance(double balance) {
        try {
            FileOutputStream fout = new FileOutputStream("Balance.dat");
            DataOutputStream dout = new DataOutputStream(fout);
            dout.writeDouble(balance);
            dout.close();
            fout.close();
        } catch (Exception ex) {
            ex.toString();
        }
    }
}
