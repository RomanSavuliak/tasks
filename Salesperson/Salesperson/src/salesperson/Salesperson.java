/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesperson;

/**
 *
 * @author 
 */
public class Salesperson {
    private double comission; // comission %
    private double fixedSalary; //salary

    public Salesperson(double comission, double fixedSalary) { // constructor with parameters
        this.comission = comission;
        this.fixedSalary = fixedSalary;
    }

    public Salesperson() { // constructor without parameters
        comission = 15; 
        fixedSalary = 50000;  //fixed salary = 50 000$
    }
    
    public double calculate(double totalSales){  // returns total annual compensation of a salesperson
        return totalSales * (comission / 100) + fixedSalary; // fixed salary + total sales * comission
    }
    
}
