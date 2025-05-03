/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;

/**
 * Represent total amount collected from different sales.
 * 
 */
public class Accounting {
    Amount totalAmountMadeBySale;
    
    /**
    * Creates new instance of Accounting database.
    * @param startAmount start amount of value made by sales. Should be 0 in this instance.
    */
    public Accounting(Amount startAmount){
    this.totalAmountMadeBySale = startAmount; 
    }
   
    /**
    * Updates the value of amount made by sales.
    * @param finalSale hold information of final sale.
    */
    public Amount updateAccountingInfo(FinalSaleInfo finalSale){
    return totalAmountMadeBySale = calculateForAccounting(finalSale);
    }
    
    /**
    * Method calculates what value to update
    * @param finalSale hold information of final sale.
    */
    public Amount calculateForAccounting(FinalSaleInfo finalSale){
        return finalSale.getPaid().add(totalAmountMadeBySale);
    }
}
