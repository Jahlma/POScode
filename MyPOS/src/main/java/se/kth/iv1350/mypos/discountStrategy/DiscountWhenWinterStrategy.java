/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.discountStrategy;

import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.CustomerID;

/**
 *
 * @author jojoa
 */
public class DiscountWhenWinterStrategy implements DiscountStrategy {
    
     public Amount discount(Amount totalSaleValue, boolean wanted, CustomerID id){
         double year = 1975;
         Amount discountPrice = totalSaleValue;
         if(id.getBirthYear().getAmount() >= year ){
             discountPrice = calculateDiscount(discountPrice, new Amount(0.7));
         }
         if(id.getName().equals("John Guidetti")){
           discountPrice = calculateDiscount(discountPrice, new Amount(0.5));
           return discountPrice;
         }
         return discountPrice;
     }
     
     
     public Amount calculateDiscount(Amount totalSaleValue, Amount percentage){
     totalSaleValue = totalSaleValue.multiply(percentage);
     return totalSaleValue;
     }
}
