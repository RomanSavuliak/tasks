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
       Salesperson salesperson = new Salesperson(); // create new object
       System.out.print("Enter annual sales : ");
       System.out.println("Total annual compensation : " + salesperson.calculate(sc.nextDouble())); // print total annual compensation of a salesperson
    }
    
}
