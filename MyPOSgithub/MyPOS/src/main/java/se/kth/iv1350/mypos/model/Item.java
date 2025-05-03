/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;
import se.kth.iv1350.mypos.DTO.ItemDTO;

/**
 * One item with name, price and tax declared, also has one specific identifier number.
 * 
 */
public class Item {
    private String name;
    private Amount VAT;
    private Amount price;
    private int identifier; 
    
    /**
    * Method calculates how much change the customer is eligible to.
    * @param name represents an items name.
    * @param VAT represents its tax as a percentage.
    * @param price represents the value of the item.
    * @param identifier identifier number for item. 
    */
    public Item(String name, Amount VAT, Amount price, int identifier){
        this.name = name;
        this.VAT = VAT; 
        this.price = price;
        this.identifier = identifier;
    }
    
    public String getName(){
        return name;
    }
    
    public Amount getVAT(){
        return VAT;
    }
    
    public Amount getPrice(){
       return price;
    }
    
    public int getID(){
       return identifier;
    }
    
    /**
    * Method converts a item to a DTO.
    * @param item represents an item with all its information. 
    */
    public ItemDTO toDTO() {
    return new ItemDTO(this.getName(), this.getVAT(), this.getPrice(), this.getID());
}
}
