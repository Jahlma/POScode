/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

/**
 *Exception thrown if an operation based on business logic fails, could be wrong input or not exsisting item.
 *
 */
public class OperationFailedException extends RuntimeException {
    
/**
 *Constructs a new exception
 *@param message contains information of exception.
 */
    public OperationFailedException(String message){
        super(message);
    }
    
}
