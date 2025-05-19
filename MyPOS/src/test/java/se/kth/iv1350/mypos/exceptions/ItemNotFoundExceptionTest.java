/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.DTO.ItemDTO;
import se.kth.iv1350.mypos.controller.Controller;
import se.kth.iv1350.mypos.integration.Accounting;
import se.kth.iv1350.mypos.integration.Discount;
import se.kth.iv1350.mypos.integration.Inventory;
import se.kth.iv1350.mypos.integration.ItemIdentifier;
import se.kth.iv1350.mypos.integration.Printer;
import se.kth.iv1350.mypos.integration.Register;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.Sale;

/**
 *
 * @author jojoa
 */
public class ItemNotFoundExceptionTest {
    
    
    public ItemNotFoundExceptionTest() {
    }

    @Test
    public void ItemNotFoundExceptionThrownTest() {
        
        ItemIdentifier eitem = new ItemIdentifier();
        eitem.initiateList();
      
        try{
        eitem.lookupItem(3); 
        
        fail("Exception was not caught as expected");
        }
        catch(ItemNotFoundException | ItemIdentifierDatabaseException e){
         assertTrue(e.getMessage().contains("Item with ID"));
        }
    }
    
    @Test
    public void ItemNotFoundExceptionNotThrownTest() {
        
        ItemIdentifier eitem = new ItemIdentifier();
        eitem.initiateList();
        try{
        boolean found = eitem.lookupItem(1006); 
        assertTrue(found);
        
        }
        catch(ItemNotFoundException | ItemIdentifierDatabaseException e){
         fail("Exception was thrown when it was a correct ID");
        }
    }
    
}
