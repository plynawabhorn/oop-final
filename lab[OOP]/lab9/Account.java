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
public class Account {
    
protected double balance;
protected String name;

public Account(double a, String n){
  this.balance = a;
  this.name = n;
}
public void setName(String n){
  this.name = n;
}
public void deposit(double a){
  if(a>0){
    this.balance += a;
    System.out.println(a + " baht is deposited to "+ this.name +".");
  }else{
    System.out.println("Input number must be a positive integer.");
  }
}
public void withdraw(double a){
  if(a>0){
    if(this.balance - a > 0){
      this.balance -= a;
      System.out.println(a + " baht is withdrawn from "+ this.name +".");
    }else{
      System.out.println("Not enough money!");
    }
  }else{
    System.out.println("Input number must be a positive integer.");
  }
}
public String getName(){
  return this.name;
}
public double getBalance(){
  return this.balance;
}
public void showAccount(){
  System.out.println(this.name + " account has "+ this.balance +" baht.");
}
    
}
