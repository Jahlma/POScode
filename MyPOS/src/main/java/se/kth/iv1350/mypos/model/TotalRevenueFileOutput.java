/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jojoa
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private PrintWriter update;
     Amount totalOfAllSales = new Amount(0);
 public TotalRevenueFileOutput() {
    try {
            update = new PrintWriter(new FileWriter("totalSales.txt", true),true); 
        } catch (IOException e) {
            System.out.println("Kunde inte skriva till loggfilen.");
            }
        }
    
    
    
    @Override
    public void update(Amount total){
        if(update != null)
        update.println(total.add(totalOfAllSales).toString());
        totalOfAllSales = total;
    }
}
