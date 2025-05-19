/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.DTO;

import java.time.LocalTime;
import java.util.List;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.SaleItem;

/**
 * Represents one sale in DTO form to pass between layer. Used for the final version of sale.
 * 
 */
public class SaleDTO {
    final private LocalTime saleTime;
    final private Amount totalPriceWithoutVAT;
    final private Amount totalVAT;
    final private Amount totalPriceWithVAT; 
    final private List<SaleItem> saleItemList; 
    final private Amount totalPriceToPay;
    
    /**
    * Creates a new instance of a SaleDTO.
    * @param saleTime represents the actual time when sale is made.
    * @param totalPriceWithoutVAT represents the whole sales price without VAT expenses added. 
    * @param totalVAT totalVAT shows how many percent of the sale with VATs price is from VAT.
    * @param totalPriceWithVAT represents the whole sales price with VAT expenses included.
    * @param saleItemList list that contains items and quantity of final sale. 
    */
    public SaleDTO(LocalTime saleTime, Amount totalPriceWithoutVAT, Amount totalVAT, Amount totalPriceWithVAT, List<SaleItem> saleItemList, Amount totalPriceToPay){
        this.saleTime = saleTime;
        this.totalPriceWithoutVAT = totalPriceWithoutVAT;
        this.totalVAT = totalVAT;
        this.totalPriceWithVAT = totalPriceWithVAT;
        this.saleItemList = saleItemList;
        this.totalPriceToPay = totalPriceToPay; 
    }
    
    public LocalTime getSaleTime(){
     return saleTime;
    }
    
    public Amount getTotalPriceWithoutVAT(){
    return totalPriceWithoutVAT;
    }
     
    public Amount getTotalPriceWithVAT(){
    return totalPriceWithVAT;
    }
      
    public Amount getTotalVAT(){
    return totalVAT;
    }
       
    public List<SaleItem> getSaleList(){
    return saleItemList;
    }
    
    public Amount getTotalPriceToPay(){
    return totalPriceToPay; 
    }
    
}
