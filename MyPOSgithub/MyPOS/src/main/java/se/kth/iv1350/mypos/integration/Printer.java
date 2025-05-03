/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.integration;
import se.kth.iv1350.mypos.model.Receipt;
import se.kth.iv1350.mypos.model.SaleItem;

/**
 * Prints the receipt for the finals sale. 
 * 
 */
public class Printer {
    
    /**
    * Method prints receipt with all asked information.
    * @param receipt contains all information to show in receipt.
    */
    public void printReceipt(Receipt receipt){
        System.out.println("- - - - - - - - - - - - - - - - - - Begin receipt - - - - - - - - - - - - - - - - - - -");
    
        System.out.println("Time of sale: " + receipt.getTimeOfSale());
        System.out.println();
    
    
        for (SaleItem item : receipt.getInformation()) {
        System.out.printf("%-15s %3sx %-10.10s SEK   %-10.10s SEK%n", 
            item.getName(), 
            item.getQuantity(), 
            item.getPrice(),  
            item.getTotalPriceWithQuantity());  
        }

   
        System.out.println();
        System.out.printf("Total:  %.10s SEK%n", receipt.getPaid());
        System.out.printf("VAT:    %.10s PROCENT%n", receipt.getVAT());
        System.out.printf("Change: %.10s SEK%n", receipt.getChange());
    
        System.out.println("- - - - - - - - - - - - - - - - - - End receipt - - - - - - - - - - - - - - - - - - -");

    }
    
    
    
}
