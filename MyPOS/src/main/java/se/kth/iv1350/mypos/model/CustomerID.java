/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

/**
 * Represents a customers identity with name and DOB.
 * 
 */
public class CustomerID {
    String name;
    Amount birthYear;
    
    /**
    * Constructs a new CustomerID.
    * @param name is name of customer.
    * @param birthYear is DOB of customer
    */
    public CustomerID(String name, Amount birthYear){
        this.name = name;
        this.birthYear = birthYear; 
    }
    
    
    
    public String getName(){
    return name;
    }
    
     public Amount getBirthYear(){
    return birthYear;
    }
}
