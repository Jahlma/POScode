/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.controller.Controller;
import se.kth.iv1350.mypos.integration.Accounting;
import se.kth.iv1350.mypos.integration.Discount;
import se.kth.iv1350.mypos.integration.Inventory;
import se.kth.iv1350.mypos.integration.ItemIdentifier;
import se.kth.iv1350.mypos.integration.Printer;
import se.kth.iv1350.mypos.integration.Register;
import se.kth.iv1350.mypos.model.Amount;

/**
 *
 * @author jojoa
 */
public class OperationFailedExceptionTest {
    
    public OperationFailedExceptionTest() {
    }

    @Test
    public void SystemDownFailureExceptionThrownTest() {
        
    Inventory inv = new Inventory();
    Register reg = new Register(new Amount(0));
    Accounting acc = Accounting.getAccounting();
    Discount disc = new Discount();
    ItemIdentifier eitem = new ItemIdentifier();
    eitem.initiateList();
    Printer print = Printer.getPrinter();
    Controller contr = new Controller(eitem, print, inv, disc, reg, acc);
    contr.saleStart();
    
    OperationFailedException thrown = assertThrows(OperationFailedException.class, () -> contr.scanning(2));
    assertTrue(thrown.getMessage().contains("Scanned item not found in current database for item identifiers"));
   
        
        
    }
    
}
