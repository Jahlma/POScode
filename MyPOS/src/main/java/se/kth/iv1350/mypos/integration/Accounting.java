/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import se.kth.iv1350.mypos.DTO.SaleDTO;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;

/**
 * Represent total amount collected from different sales.
 * 
 */
public class Accounting {
    private static final Accounting INSTANCE = new Accounting(new Amount(0));
    Amount totalAmountMadeBySale;
    
    /**
    * Creates new instance of Accounting database.
    * @param startAmount start amount of value made by sales. Should be 0 in this instance.
    */
    private Accounting(Amount startAmount){
    this.totalAmountMadeBySale = new Amount(0); 
    }
   
    /**
    * Updates the value of amount made by sales.
    * @param saledto hold information of final sale.
    */
    public Amount updateAccountingInfo(SaleDTO saledto){
    return totalAmountMadeBySale = calculateForAccounting(saledto);
    }
    
    public static Accounting getAccounting(){
    return INSTANCE; 
    }
    
    
    /**
    * Method calculates what value to update
    * @param saledto hold information of final sale.
    */
    public Amount calculateForAccounting(SaleDTO saledto){
        return saledto.getTotalPriceToPay().add(totalAmountMadeBySale);
    }
}
