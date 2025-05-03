/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jojoa
 */
public class ReceiptTest {
    
    public ReceiptTest() {
    }

    @Test
    public void testReceiptConstructor() {
        Amount cash = new Amount(100);
        LocalTime time = LocalTime.now();
        Amount priceNoVAT = new Amount(50);
        Amount VAT = new Amount(10);
        Amount priceWithVat = new Amount(55);
        List<SaleItem> list = new ArrayList<>();
        Amount change = new Amount(45);
        Receipt rece = new Receipt(time, priceWithVat, change, VAT, list);
        assertNotNull(rece);
        assertEquals(rece.getPaid().getAmount(), 55.00 );
        assertEquals(rece.getVAT().getAmount(), 10.00);
    }

   
    
}
