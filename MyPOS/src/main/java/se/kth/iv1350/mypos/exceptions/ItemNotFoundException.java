/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

/**
 *Exception thrown when an item is not found in database of item identifiers.
 * 
 */
public class ItemNotFoundException extends RuntimeException {
    
    
    /**
     * Constructs a new ItemNotFoundException.
    * @param message contains information of exception. 
    * 
    */
    public ItemNotFoundException(String message){
        super(message); 
    } 
    
}
