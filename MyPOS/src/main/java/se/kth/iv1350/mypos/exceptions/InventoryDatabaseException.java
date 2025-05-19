/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

/**
 *
 * Exception thrown when program is having trouble to connect or reach inventory database.
 */
public class InventoryDatabaseException extends SystemDownFailureException{
    
    
    /**
     * Constructs a new InventoryDataBaseException.
    * @param message contains information of exception. 
    * 
    */
    public InventoryDatabaseException(String message){
        super(message); 
    }
    
   
}
