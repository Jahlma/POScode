/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.controller;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.DTO.ItemDTO;
import se.kth.iv1350.mypos.integration.Accounting;
import se.kth.iv1350.mypos.integration.Discount;
import se.kth.iv1350.mypos.integration.Inventory;
import se.kth.iv1350.mypos.integration.ItemIdentifier;
import se.kth.iv1350.mypos.integration.Printer;
import se.kth.iv1350.mypos.integration.Register;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.model.Item;
import se.kth.iv1350.mypos.model.Sale;
import se.kth.iv1350.mypos.model.SaleItem;
import java.io.ByteArrayInputStream;
import se.kth.iv1350.mypos.model.Receipt;

/**
 *
 * @author jojoa
 */
public class ControllerTest {
    private Controller contr;
    private Sale sale;
    private ItemDTO itemDTO;
    private Inventory inv;
    public ControllerTest() {
    }

   
    
    @BeforeEach
    public void setUP(){
        Amount price = new Amount(56.90);
        Amount VAT = new Amount(12);
        itemDTO = new ItemDTO("Kaffe",VAT,price,1006);
        inv = new Inventory();
        inv.initiateList();
        Register reg = new Register(new Amount(0));
        Accounting acc = new Accounting(new Amount(0));
        Discount disc = new Discount();
        ItemIdentifier eitem = new ItemIdentifier();
        Printer print = new Printer();
        contr = new Controller(eitem, print, inv, disc, reg, acc);
        
        
    }
    
    @Test
    public void testSaleStart() {
        
    }
    
    @AfterEach
    public void tearDown(){
    
    }

    @Test
    public void testNotValidItemScanning() {
        contr.saleStart();
        int itemidentifier = 90;
       
        assertThrows(IllegalArgumentException.class, ()->{contr.scanning(itemidentifier);});
        
    }

    @Test
    public void testScanning() {
        String actuallOut;
        String expectedOut;
        int itemIdentifier = 1006;
        contr.saleStart();
        actuallOut = contr.scanning(itemIdentifier);
        expectedOut = "Kaffe";
        assertTrue(actuallOut.contains(expectedOut));
        
    }
    
    @Test
    public void testItemAlreadyInSaleScanning() {
        String input = "2\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int itemIdentifier = 1006; 
        contr.saleStart();
        contr.scanning(itemIdentifier);
        contr.scanning(itemIdentifier); 
        List<SaleItem> list = contr.getSale().getSaleList();
        double quantity = 0;
        for(SaleItem item : list){
            if(item.getItemDTO().getID() == itemIdentifier){
                if(item.getItemDTO().getID() != 1){
                    quantity = item.getQuantity().getAmount();
                }
            }
            
        }
              
        assertEquals(2, quantity);
        
    }
    
    @Test
    public void testAllItemScanned() {
        contr.saleStart();
        int itemidentifier = 1006;
        contr.scanning(itemidentifier);
        FinalSaleInfo finalsale = contr.allItemScanned();
       
        assertNotNull(finalsale);
        
    }
    
    
    @Test
    public void testPaymentChangeFinalizeSale(){
        contr.saleStart();
        contr.scanning(1003);
        contr.scanning(1002);
        Amount cash = new Amount(700);
        FinalSaleInfo finalSale = contr.allItemScanned();
        double expectedChange = 636.72;
        contr.finalizeSale(finalSale, cash);
        assertEquals(expectedChange, finalSale.getChange().getAmount(), 0.01);
    }
    
    @Test
    public void testPaymentPaidFinalizeSale(){
        contr.saleStart();
        contr.scanning(1003);
        contr.scanning(1002);
        Amount cash = new Amount(700);
        FinalSaleInfo finalSale = contr.allItemScanned();
        double expectedPaid = 63.28;
        contr.finalizeSale(finalSale, cash);
        assertEquals(expectedPaid, finalSale.getPaid().getAmount(), 00.1);
    }
    
    @Test
    public void testReceiptCreatedFinalizeSale(){
        contr.saleStart();
        contr.scanning(1003);
        contr.scanning(1002);
        Amount cash = new Amount(700);
        FinalSaleInfo finalSale = contr.allItemScanned();
        Receipt receipt = finalSale.createReceipt(finalSale);
        contr.finalizeSale(finalSale, cash);
        assertNotNull(receipt);
    }
}
