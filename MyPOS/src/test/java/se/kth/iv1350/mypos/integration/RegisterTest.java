/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;

/**
 *
 * @author jojoa
 */
public class RegisterTest {
    
    public RegisterTest() {
         Register reg = new Register(new Amount(0));
         assertNotNull(reg);
    }

    @Test
    public void testAddRegister() {
       
    }
    
}
