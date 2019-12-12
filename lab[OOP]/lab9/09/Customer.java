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
public class Customer{
 private String firstName, lastName;
 private int numOfAccount();
 private Account acct[];

 public Account getAccount(int index){
     
 }
 public addAccount(Account acct){
     acct[numOfAccount] = acct;
     numOfAccount += 1;
 }
 public getNumOfAccount(){
     return numOfAccount;
 }
  public Customer (String f, String l){
   acct = new Account[5];
 }
  public Customer (){
   acct = new Account[5];

 }
 public void setFirstName(String f){
   this.firstName = f;
 }
 public void setLastName(String l){
   this.lastName = l;
 }
 public void setFirstName(CheckingAccount a){
   this.acct = a;
 }
 public String getFirstName(){
   return this.firstName;
 }
 public String getLastName(){
   return this.lastName;
 }
 public CheckingAccount getAcct(){
   return this.acct;
 }
 public String toString(){
     for (int i = 0; i < acct.length; i++) {
         System.out.println(acct[i] +);
         
     }
 }
 public boolean equals(Customer c){
   if(firstName.equals(c.getFirstName()) & lastName.equals(c.getLastName())){
     return true;
   }else{
     return false;
   }
 }
}