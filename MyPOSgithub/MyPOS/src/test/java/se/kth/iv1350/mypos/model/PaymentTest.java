/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jojoa
 */
public class PaymentTest {
    
    @Test
    public void TestPaymentConstructor() {
        Amount cash = new Amount(19);
        Payment paid = new Payment(cash);
        Amount totalPaid = paid.getCash();
        assertNotNull(paid);
        assertEquals(19.00, totalPaid.getAmount());
    }

   

    
    
}
