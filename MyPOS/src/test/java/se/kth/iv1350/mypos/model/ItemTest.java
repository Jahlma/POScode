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
public class ItemTest {
    
    public ItemTest() {
    }

    @Test
    public void testItemConstructor() {
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999; 
        Item item = new Item(name, VAT, price, identifier);
        assertNotNull(item);
        assertEquals(50.00, price.getAmount() );
        assertEquals(10, VAT.getAmount());
        assertEquals("Tjack", name);
        assertEquals(999, identifier);
    }

    @Test
    public void testToDTO(){ 
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999; 
        Item item = new Item(name, VAT, price, identifier);
        ItemDTO itemDTO = item.toDTO();
        assertNotNull(itemDTO);
        assertEquals(50.00,itemDTO.getPrice().getAmount());
        assertEquals(10,itemDTO.getVAT().getAmount());
        assertEquals("Tjack",itemDTO.getName());
        assertEquals(999,itemDTO.getID());
    }

   
    
}
