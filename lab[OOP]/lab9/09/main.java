/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09;

/**
 *
 * @author LAB205_43
 */
public class main {
    public static void main(String[] args) {
Account a1 = new Account(5000, "Sommai");
 Account a2 = new Account(3000, "Somchai");
 Account a3 = new Account(900, "Somsri");

 Bank myBank = new Bank();
 myBank.addAccount(a1);
 myBank.addAccount(a2);
 myBank.addAccount(a3);

 System.out.println("Number of Account: " + myBank.getNumAccount());
 myBank.getAccount(0).showAccount();
 System.out.println("Deposit 500...");
 myBank.getAccount(0).deposit(500);
 myBank.getAccount(0).showAccount();
 System.out.println("Show all accounts");
 System.out.println("==============================");
 for(int i=0; i<myBank.getNumAccount(); i++){
 myBank.getAccount(i).showAccount();
 }
}
    
    
}
