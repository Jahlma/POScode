/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.mypos.DTO.ItemDTO;
import se.kth.iv1350.mypos.DTO.SaleDTO;
/**
 * Represents ongoing sale. Keeps track of what current item is scanned and how many.
 * 
 */
public class Sale {
    public LocalTime saleTime;
    public Amount totalPriceWithoutVAT;
    public Amount totalVAT;
    public Amount totalPriceWithVAT;
    public Amount totalPriceToPay;
    public Receipt receipt; 
    public List<SaleItem> saleItemList; 
    
    /**
    * Creates an new instance of a sale.
    * 
    */
    public Sale() {
        saleItemList = new ArrayList<>();
    }
   
    /**
    * Method creates a saleItem 
    * @param itemDTO represents an item and all its information.
    * @param quantity represents how many of a certain item is in sale.    
    */
    public SaleItem addItemToSale(ItemDTO itemDTO, Amount quantity){
        return new SaleItem(itemDTO, quantity);
    }
    
    /**
    * Method adds one saleitem to the list of a sale.
    * @param saleItem contains one item and its quantity in sale.
    * 
    */
    public Sale addSaleItemToList(SaleItem saleItem){
    this.saleItemList.add(saleItem);
    return this;
    }
    
    /**
    * Method collects all information of a sale
    * 
    */
   public Sale calculateInfo(){
     this.saleTime = LocalTime.now();
     this.totalPriceWithoutVAT = calculateTotalSaleAmountWithoutVAT();
     this.totalPriceWithVAT = calculateTotalSaleAmountWithVAT();
     this.totalVAT = calculateTotalSaleVAT();
     
     return this;   
       
   }
   
   /**
    * Method calculates what value the sale is without adding VAT in calculation. 
    * 
    */
   public Amount calculateTotalSaleAmountWithoutVAT(){
       Amount itemPrice = new Amount(0);
       Amount totalPrice = new Amount(0);
       for(SaleItem item : saleItemList){
           
           itemPrice = item.getItemDTO().getPrice();
           totalPrice = totalPrice.add(itemPrice.multiply(item.getQuantity()));
           
       }
       return totalPrice;
   }
    
    /**
    * Method calculates what value the sale is with adding VAT in calculation. 
    * 
    */
    public Amount calculateTotalSaleAmountWithVAT(){
       Amount vatAmount = new Amount(0);
       Amount total = new Amount(0);
       for(SaleItem item : saleItemList){
           Amount price = item.getItemDTO().getPrice();
           Amount vat = item.getItemDTO().getVAT();
           
           double vatValue = price.getAmount() * ((vat.getAmount() / 100.0)+1);
           vatAmount = new Amount(vatValue);
          total = total.add(vatAmount.multiply(item.getQuantity()));
       }
       return total;
   }
    
    public boolean lookupItem(ItemDTO itemDTO){
        for( SaleItem  item : saleItemList ){
            if(item.getItemDTO().getID() == itemDTO.getID()){
                return true;
                }
            }
        return false; 
    }
    
    /**
    * Method calculates what the total VAT is for the whole sale 
    * 
    */
    public Amount calculateTotalSaleVAT(){
         totalVAT = (totalPriceWithVAT.sub(totalPriceWithoutVAT));
         totalVAT = totalVAT.convertToPrecentage(totalPriceWithoutVAT);
         return totalVAT;
    }
    
    /**
    * Method calculates what the total sale is with discount added.
    * 
    */
    public Amount calculateAmountDiscount(){
        Amount saved = totalPriceWithVAT.sub(totalPriceToPay); 
        return saved;
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
    
    /**
    * Method creates and returns a saleDTO. 
    * 
    */
    public SaleDTO toSaleDTO(){
        return new SaleDTO(this.getSaleTime(),
                           this.getTotalPriceWithoutVAT(),
                           this.getTotalVAT(), 
                           this.getTotalPriceWithVAT(), 
                           this.getSaleList(),
                           this.getTotalPriceToPay());
    }
    
    
}
