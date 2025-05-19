/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.integration.Inventory;


/**
 *
 * @author jojoa
 */
public class InventoryDatabaseExceptionTest {
    
    @Test
    public void testInventoryDatabaseExceptionThrown() {
       Inventory inv = new Inventory();
        inv.initiateList();
        InventoryDatabaseException thrown = assertThrows(InventoryDatabaseException.class, () -> inv.getInfoOfItem(1009));
        assertTrue(thrown.getMessage().contains("Database that holds information of inventory and item information is not available"));
    }
}
