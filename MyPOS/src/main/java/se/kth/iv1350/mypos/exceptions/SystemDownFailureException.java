/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

/**
 *Exception thrown if an operation fails because of a failure in the system/program.
 */

public class SystemDownFailureException extends Exception{
    /**
    *Constructs a new exception
    *@param message contains information of exception.
    */
    public SystemDownFailureException(String message){
        super(message);
    }
    
   
}
