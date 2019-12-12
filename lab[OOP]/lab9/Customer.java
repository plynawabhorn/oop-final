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
public class Customer {
    private String firstName, lastName;
 private CheckingAccount acct;

 public Customer (String f, String l, CheckingAccount a){
   this.firstName = f;
   this.lastName = l;
   this.acct =a;

 }
  public Customer (String f, String l){
   this(f,l,null);
 }
  public Customer (){
   this("","",null);

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
   if (acct == (null))
    return this.firstName + " " + this.lastName + "doesn’t have account.";
  else
    return "The " + this.firstName + " account has " + this.acct.getBalance() + " baht and " + this.acct.getCredit();
 }
 public boolean equals(Customer c){
   if(firstName.equals(c.getFirstName()) & lastName.equals(c.getLastName())){
     return true;
   }else{
     return false;
   }
 }
}
