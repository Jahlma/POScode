/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.DTO.ItemDTO;

/**
 *
 * @author jojoa
 */
public class SaleItemTest {
    
    public SaleItemTest() {
    }

    @Test
    public void testSaleItemConstructor() {
        ItemDTO itemDTO = new ItemDTO("Bröd", new Amount(12), new Amount(24.50), 1002);
        Amount quantity = new Amount(2);
        SaleItem saleItem = new SaleItem(itemDTO, quantity);

        assertNotNull(saleItem);
        assertEquals(itemDTO, saleItem.getItemDTO());
        assertEquals(quantity, saleItem.getQuantity());   
    }

    

    @Test
    public void testGetTotalPriceWithQuantity() {
        Amount price = new Amount(20);
        Amount quantity = new Amount(3);
        ItemDTO itemDTO = new ItemDTO("Choklad", new Amount(6), price, 1007);
        SaleItem saleItem = new SaleItem(itemDTO, quantity);

        Amount expectedTotal = price.multiply(quantity);
        assertEquals(expectedTotal.getAmount(), saleItem.getTotalPriceWithQuantity().getAmount());    
    }
    
}
