/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.mypos.DTO.SaleDTO;

/**
 * Stores and calculates information for the final sale and its attributes. 
 * 
 */
public class FinalSaleInfo {
    public Amount cashUsed;
    Sale sale; 
    private Amount change;
    private Amount paidAmount;
    private List<SaleObserver> saleObservers = new ArrayList<>(); 
    /**
    * Creates a new instance of a final sale.
    * @param SaleDTO is the final version of the completed sale with all information to it.
    */
    public FinalSaleInfo(Sale sale){
        this.sale = sale;
    }
    
    /**
    * Method calculates how much change the customer is eligible to.
    * @param cash represents cash given by customer to pay for sale.
    */
    public Amount calculateChange(Amount cash){
    Amount amountPaid;
    amountPaid = cash.sub(sale.totalPriceToPay);
    return amountPaid;
   
    }
    
    /**
    * Method updates how much customer has paid and what the change is.
    * @param paid represents the customers payment.
    */
    public void pay(Payment paid){
        change = calculateChange(paid.getCash());
        cashUsed = paid.getCash();
        paidAmount = sale.totalPriceToPay;
        notifyObservers(paidAmount);
        
    }
    
    /**
    * Method notifys all observers in program to update value.
    * @param total is total amount paid by customer.
    */
    private void notifyObservers(Amount total){
       for(SaleObserver obs : saleObservers){
           obs.update(total);
       }
    }
    
    public Amount getTotalAmountToPay(FinalSaleInfo finalSale){
        return sale.totalPriceToPay;
    }
    
    /**
    * Method creates a receipt 
    * @param finalSale represents the final sale and its information.
    */
    public Receipt createReceipt(FinalSaleInfo finalSale){
    return new Receipt(sale.getSaleTime(), paidAmount, change, sale.getTotalVAT(), sale.getSaleList(), sale.totalPriceWithVAT, sale.calculateAmountDiscount() );
    }
    
    public Amount getChange(){
    return change;
    }
    
    public Amount getPaid(){
    return sale.totalPriceToPay;
    }
    
    public SaleDTO getSaleDTO(){
    return sale.toSaleDTO();
    }
    
    /**
    * Method adds list of observers to class.
    * @param list is a list of observers.
    */
    public void addSaleObservers(List<SaleObserver> list){
        saleObservers.addAll(list); 
    }
   
}
