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
import se.kth.iv1350.mypos.logger.FileLogger;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.Sale;
import se.kth.iv1350.mypos.model.SaleObserver;
import se.kth.iv1350.mypos.model.TotalRevenueFileOutput;
import se.kth.iv1350.mypos.view.View;

/**
 *
 * @author jojoa
 */
public class SystemDownFailureExceptionTest {
    private Controller contr;
    private Sale sale;
    private ItemDTO itemDTO;
    private Inventory inv;
    
    
    public SystemDownFailureExceptionTest() {
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
    
    SystemDownFailureException thrown = assertThrows(SystemDownFailureException.class, () -> contr.scanning(1010));
    SystemDownFailureException thrown2 = assertThrows(SystemDownFailureException.class, () -> contr.scanning(1009));
    assertTrue(thrown.getMessage().contains("something went wrong when trying to access item identifier database"));
    assertTrue(thrown2.getMessage().contains("something went wrong when trying to access inventory database"));
        
        
    }
    
}
