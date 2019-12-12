/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

/**
 *
 * @author LAB205_44
 */
public class Bank {

    private Account acct[];
    private int numAcct;
    public Bank(){
        acct = new Account[10];
    }
    public void addAccount(Account ac){
        acct[numAcct] = ac;
        numAcct += 1;
    }
    public int getNumAccount(){ 
        return numAcct;
    }
    public Account getAccount(int index){
        return acct[index];
    }
}
