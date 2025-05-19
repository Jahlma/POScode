/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import java.time.LocalTime;
import java.util.List;

/**
 * Represents receipt of final sale, includes all parameters used on receipt.
 * 
 */
public class Receipt {
    LocalTime timeOfSale;
    Amount paid;
    Amount change; 
    Amount vat;
    Amount priceWithoutDiscount;
    Amount totalDiscountSaved;
    List<SaleItem> information;
    
    /**
    * Method creates an instance of a new receipt.
    * @param timeOfSale represents when sale was finished
    * @param paid represents how much was paid. 
    * @param change what change was calculated
    * @param vat is the total vat for whole sale.
    * @param information is the sale list which contains all information of every item and quantity of sale.
    * @param priceWithOutDiscount is the total price without discount.
    * @param totalAmountSubtractedWithDiscount is the amount sale cost with discount included.
    */
    public Receipt(LocalTime timeOfSale, Amount paid, Amount change, Amount vat, List<SaleItem> information, Amount priceWithOutDiscount, Amount totalAmountSubtractedWithDiscount){
    this.timeOfSale = timeOfSale;
    this.paid = paid;
    this.change = change;
    this.vat = vat;
    this.information = information;
    this.priceWithoutDiscount = priceWithOutDiscount;
    this.totalDiscountSaved = totalAmountSubtractedWithDiscount;
    
    
    
}
    public LocalTime getTimeOfSale(){
    return timeOfSale;
    }
    
     public Amount getPaid(){
    return paid;
    }
     
    public Amount getChange(){
    return change;
    }
    
    public List<SaleItem> getInformation(){
    return information;
    }
    
    public Amount getVAT(){
    return vat; 
    }
    
    public Amount getTotal(){
    return priceWithoutDiscount; 
    }
    
    public Amount getDiscountSaved(){
    return totalDiscountSaved; 
    }
    
}
