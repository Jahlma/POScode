/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

/**
 * Datatype to represent amount of money used in sale operation.
 * 
 */
public class Amount {
    private double value;
    
    /**
    * Method creates a new instance of a Amount
    * @param value represents the value that will be converted from double to Amount.
    */
    public Amount(double value){
        if(value < 0){
            throw new IllegalArgumentException("Amount could not be negative"); 
        }
        this.value = value; 
    }
    
    /**
    * Method adds two Amount types together.
    * @param other represents the other Amount type to be added
    */
    public Amount add(Amount other){
         return new Amount(this.value + other.value);
    }
    
    public double getAmount(){
         return value;
    }
    
    /**
    * Method subtracts two Amount types from eachother.
    * @param other represents the other Amount type to be subtracted.
    */
    public Amount sub(Amount other){
         return new Amount(this.value - other.value);
    }
    
    /**
    * Method calculates the relative percentage between two Amount types.
    * @param other represents the other Amount type to be used in calculation.
    */
    public Amount convertToPrecentage(Amount other){
         return new Amount((this.value / other.value)*100);
    }
    
    /**
    * Method calculates the product of two Amount types.
    * @param other represents the other Amount type to be used in calculation.
    */
    public Amount multiply(Amount other){
         return new Amount(this.value * other.value);
     }
     
    /**
    * Method converts a Amount type to String
    * 
    */
    @Override
    public String toString(){
        return String.format("%.2f", value);
    }
}

