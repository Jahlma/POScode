/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

/**
 *
 * Collects and represent what customer paid.
 */
public class Payment {
    Amount cash;
    Amount toPay;
    
    /**
    * Creates a new instance of a payment.
    * @param cash represents cash given by customer to pay for sale.
    */
    public Payment(Amount cash){
    this.cash = cash;
    }
    
    
    public void getToPay(FinalSaleInfo finalSale){
    toPay = finalSale.getTotalAmountToPay(finalSale);
    
    }
    
    public Amount getCash(){
    return cash;
    }
    
    public Amount getTotalAmountPaid(){
    return toPay;
    }
}
