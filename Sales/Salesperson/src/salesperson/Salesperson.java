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
    private double totalSales;

    public Salesperson(double comission, double fixedSalary) { // constructor with parameters
        this.comission = comission;
        this.fixedSalary = fixedSalary;
    }

    public Salesperson(double totalSales) { // constructor without parameters
        this.totalSales = totalSales;
        comission = 15; 
        fixedSalary = 50000;  //fixed salary = 50 000$
    }
    
    public double getTotalSales(){
        return totalSales;
    }
    
    public double calculate(){  // returns total annual compensation of a salesperson
            if ( totalSales >= 80000 && totalSales < 120000 )
                return totalSales * (comission / 100) + fixedSalary;
        else
                if ( totalSales >= 120000 )
                    return totalSales * (comission / 100) * 1.25 + fixedSalary; // fixed salary + total sales * comission
            else
                    return fixedSalary;
    }
    
        public double calculate(double totalSales){  // returns total annual compensation of a salesperson
            if ( totalSales >= 80000 && totalSales < 120000 )
                return totalSales * (comission / 100) + fixedSalary;
        else
                if ( totalSales >= 120000 )
                    return totalSales * (comission / 100) * 1.25 + fixedSalary; // fixed salary + total sales * comission
            else
                    return fixedSalary;
    }
    
}
