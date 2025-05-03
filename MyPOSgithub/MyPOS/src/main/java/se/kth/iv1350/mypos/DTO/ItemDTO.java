/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.DTO;
import se.kth.iv1350.mypos.model.Amount;

/**
 * Represents an item in DTO form to pass between layer.
 */
public class ItemDTO {
    final private String name;
    final private Amount VAT;
    final private Amount price;
    final private int identifier;
 
    
    /**
    * Creates a new instance of an itemDTO. 
    * @param name represents the name of an item.
    * @param VAT represents the tax included with the item.
    * @param price represents the singular value of an item.
    * @param indetifier identifies item form eachother.
    */
    public ItemDTO(String name, Amount VAT, Amount price, int identifier){
        this.name = name;
        this.VAT = VAT; 
        this.price = price;
        this.identifier = identifier;
    }
    
    public int getID(){
       return identifier;
    }
    
     public String getName(){
        return name;
    }
     
    public Amount getPrice(){
    return price;
    }
    
     public Amount getVAT(){
    return VAT;
    }
}
