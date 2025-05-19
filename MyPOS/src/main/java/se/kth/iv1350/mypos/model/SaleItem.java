/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;
import se.kth.iv1350.mypos.DTO.ItemDTO;

/**
 * Shows quantity of specific item in sale. 
 * 
 */
public class SaleItem {
    public Amount quantity; 
    private ItemDTO itemDTO; 
    
    /**
    * Creates a new instance of a saleitem. 
    * @param itemDTO represents an item and its information.
    * @param quantity is number of items of the same kind in sale.
    */
    public SaleItem(ItemDTO itemDTO, Amount quantity){
        this.quantity = quantity;
        this.itemDTO = itemDTO; 
    }
    
    public ItemDTO getItemDTO(){
    return itemDTO;
    }
    
    public String getName(){
    return itemDTO.getName();
    }
    
    public Amount getQuantity(){
        return quantity; 
    }
    
    public Amount getPrice(){
    return itemDTO.getPrice();
    }
    
     /**
    * Method calculates total value of a specific item with quantity. 
    * 
    */
    public Amount getTotalPriceWithQuantity(){
    return (itemDTO.getPrice().multiply(getQuantity()));
    }
}

