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
public class CheckingAccount extends Account{
 private double credit;

  public CheckingAccount (){
   super(0,"");
   this.credit = 0.0;
 }

 public CheckingAccount (double a, String n, double c){
   super(a,n);
   this.credit = c;
 }

 public void setCredit(double a){
   this.credit = a;
 }
 public double getCredit(){
   return this.credit;
 }

public void withdraw(double a){
  if(a>0){
    if(this.balance - a > 0){
      this.balance -= a;
      System.out.println(a + " baht is withdrawn from "+ this.name +" and your credit balance is "+ this.credit +".");
    }else if(this.balance + credit - a > 0){
      this.credit -= (a - this.balance);
      this.balance = 0;
      System.out.println(a + " baht is withdrawn from "+ this.name +" and your credit balance is "+ this.credit +".");
    }else{
      System.out.println("Not enough money!");
    }
  }else{
    System.out.println("Input number must be a positive integer.");
  }
}
public String toString(){
  return "The" + this.name + " account has" + this.balance + " baht and "+ this.credit + "credits." ;
}
public void withdraw(int a){
  this.withdraw(a);
}

}