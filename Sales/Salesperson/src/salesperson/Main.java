/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesperson;
import java.util.Scanner;
/**
 *
 * @author 
 */
public class Main { //a controlling class is where the main function resides

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //main function
        Scanner sc = new Scanner(System.in);  // scanner
       System.out.print("Enter annual sales : ");
       Salesperson salesperson = new Salesperson(sc.nextDouble()); // create new object
       System.out.println("Total annual compensation : " + salesperson.calculate()); // print total annual compensation of a salesperson
       printTable(salesperson);
    }
    public static void printTable(Salesperson salesperson){
               System.out.println("Total Sales : " + salesperson.getTotalSales());
       for ( double i = salesperson.getTotalSales(); i  <= salesperson.getTotalSales() / 2 + salesperson.getTotalSales(); i+= 5000 ){
                  System.out.println("Total Compensation");
                  System.out.println(i);
                  System.out.println(salesperson.calculate(i));
       }
    }
}
