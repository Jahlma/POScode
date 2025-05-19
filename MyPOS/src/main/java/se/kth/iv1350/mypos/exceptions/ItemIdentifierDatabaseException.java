/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

/**
 *
 * Exception thrown if the program is not able to reach ItemIdentifiersDatabse.
 */
public class ItemIdentifierDatabaseException extends SystemDownFailureException{
    
    /**
    * Constructs a new ItemIdentifierDataBaseException.
    * @param message contains information of exception. 
    * 
    */
    public ItemIdentifierDatabaseException(String message){
        super(message);
    }
}
