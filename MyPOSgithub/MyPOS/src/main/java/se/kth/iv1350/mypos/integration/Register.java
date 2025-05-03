/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;


/**
 * Keeps track of current amount in register at POS.
 * 
 */
public class Register {
    public Amount valueInRegister;
   
    /**
    * Method creates an new instance of a register.
    * @param valueInRegister start amount of registers value contained.
    */
    public Register(Amount valueInRegister){
        this.valueInRegister = valueInRegister;
    }
    
    /**
    * Method updates new amount in register after a sale is made.
    * @param finalSale contains information to calculate what to add to to register.
    */
    public Register AddRegister(FinalSaleInfo finalSale){
        valueInRegister = valueInRegister.add(finalSale.getChange());
        return new Register(valueInRegister);
    }
}
