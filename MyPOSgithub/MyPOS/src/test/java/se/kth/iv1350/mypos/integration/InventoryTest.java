/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.model.Item;

/**
 *
 * @author jojoa
 */
public class InventoryTest {
    
    public InventoryTest() {
    }

    @Test
    public void testNotNullInitiateList() {
        Inventory inv = new Inventory();
        List<String> list = inv.initiateList();
        assertNotNull(list);                    
        assertEquals(10, list.size());          
    }
    
     @Test
    public void testIfInitiateListContainsRightInfo() {
        Inventory inv = new Inventory();
        List<String> list = inv.initiateList();
        assertTrue(list.contains("1005,Ost,59.00,12"));
    }
    
    @Test
    public void testGetRightInfoOfItem(){
        String stringExpected = "1001,Mjölk,15.90,12";
        Item itemExpected = new Item("Mjölk", new Amount(12), new Amount(15.90), 1001);
        Inventory inv = new Inventory();
        List<String> list = inv.initiateList();
        Item item; 
        item = inv.createItemFromString(stringExpected);
        assertEquals(itemExpected.getName(), item.getName());
        assertEquals(itemExpected.getID(), item.getID());
        assertEquals(itemExpected.getPrice().getAmount(), item.getPrice().getAmount(), 0.001);
        assertEquals(itemExpected.getVAT().getAmount(), item.getVAT().getAmount(), 0.001);
    }

   @Test
    public void testGetRightInfoOfItemNotNull(){
        String stringExpected = "1001,Mjölk,15.90,12";
        Item itemExpected = new Item("Mjölk", new Amount(12), new Amount(15.90), 1001);
        Inventory inv = new Inventory();
        List<String> list = inv.initiateList();
        Item item; 
        item = inv.createItemFromString(stringExpected);
        assertNotNull(item);
    }
    @Test
    public void TestCreateItemFromStringContainsRightInfo() {
        Inventory inv = new Inventory();
        String string = "1001,Mjölk,15.90,12";
        Item item = inv.createItemFromString(string);
    }
    
    public void TestItemExsist(){
        String stringExpected = "1001,Mjölk,15.90,12";
        Item itemExpected = new Item("Mjölk", new Amount(12), new Amount(15.90), 1001);
        int itemIdentifier = 1006;
        Inventory inv = new Inventory();
        boolean found = inv.itemExists(itemIdentifier);
        assertTrue(found);
    }
    
    public void TestDivideString(){
        Inventory inv = new Inventory();
        String stringExpected = "1001,Mjölk,15.90,12";
        String[] divideString = inv.divideString(stringExpected);
        String vat = divideString[3];
        assertEquals(vat,"12");
    }
    
    public void TestConvertToIntegerFromString(){
        Inventory inv = new Inventory();
        String string = "1001,Mjölk,15.90,12";
        String[] divideString = inv.divideString(string);
        int stringToInt = inv.convertToIntegerFromString(divideString, 0);
        int integer = 1001;
        assertEquals(integer, stringToInt);
    }
    
    public void TestConvertToDoubleFromString(){
        Inventory inv = new Inventory();
        String string = "1001,Mjölk,15.90,12";
        String[] divideString = inv.divideString(string);
        double stringToDouble = inv.convertToDoubleFromString(divideString, 0);
        double dou = 1001;
        assertEquals(dou, stringToDouble);
    }
}
