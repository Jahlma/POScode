/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.integration.ItemIdentifier;

/**
 *
 * @author jojoa
 */
public class ItemIdentifierDatabaseExceptionTest {
    
    public ItemIdentifierDatabaseExceptionTest() {
    }

    @Test
    public void testItemIdentifierDatabaseExceptionThrown() {
        ItemIdentifier eitem = new ItemIdentifier();
        eitem.initiateList();
       ItemIdentifierDatabaseException thrown = assertThrows(ItemIdentifierDatabaseException.class, () -> eitem.lookupItem(1010));
        assertTrue(thrown.getMessage().contains("Database that holds information of active item identifiers is not available"));
    }
       
}
