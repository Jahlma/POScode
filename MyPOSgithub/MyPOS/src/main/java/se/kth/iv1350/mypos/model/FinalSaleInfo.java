/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import se.kth.iv1350.mypos.DTO.SaleDTO;

/**
 * Stores and calculates information for the final sale and its attributes. 
 * 
 */
public class FinalSaleInfo {
    SaleDTO saleDTO; 
    Amount change;
    Amount paidAmount;
    
    /**
    * Creates a new instance of a final sale.
    * @param SaleDTO is the final version of the completed sale with all information to it.
    */
    public FinalSaleInfo(SaleDTO saleDTO){
        this.saleDTO = saleDTO;
    }
    
    /**
    * Method calculates how much change the customer is eligible to.
    * @param cash represents cash given by customer to pay for sale.
    */
    public Amount calculateChange(Amount cash){
    Amount amountPaid;
    amountPaid = cash.sub(saleDTO.getTotalPriceWithVAT());
    return amountPaid;
    }
    
    /**
    * Method updates how much customer has paid and what the change is.
    * @param paid represents the customers payment.
    */
    public void pay(Payment paid){
        change = calculateChange(paid.getCash());
        paidAmount = saleDTO.getTotalPriceWithVAT();
        
    }
    
    public Amount getTotalAmountToPay(FinalSaleInfo finalSale){
        return saleDTO.getTotalPriceWithVAT();
    }
    
    /**
    * Method creates a receipt 
    * @param finalSale represents the final sale and its information.
    */
    public Receipt createReceipt(FinalSaleInfo finalSale){
    return new Receipt(saleDTO.getSaleTime(), paidAmount, change, saleDTO.getTotalVAT(), saleDTO.getSaleList());
    }
    
    public Amount getChange(){
    return change;
    }
    
    public Amount getPaid(){
    return saleDTO.getTotalPriceWithVAT();
    }
    
   
}
