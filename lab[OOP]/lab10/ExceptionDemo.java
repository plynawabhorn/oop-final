/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_56
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            double x1, x2, root;
            root = (b*b)-(4*a*c);
            x1 = ((-b)+Math.sqrt(root))/(2*a);
            x2 = ((-b)-Math.sqrt(root))/(2*a);
            System.out.println(x1);
            System.out.println(x2);
        }
        catch(NumberFormatException ex){
                System.out.println("Please input data in number format only.");
        } 
        catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Please enter 3 numbers as a, b, and c respectively.");
        }
    }
    
}
