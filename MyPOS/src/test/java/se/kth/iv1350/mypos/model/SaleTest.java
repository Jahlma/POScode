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
import se.kth.iv1350.mypos.DTO.ItemDTO;
import se.kth.iv1350.mypos.DTO.SaleDTO;

/**
 *
 * @author jojoa
 */
public class SaleTest {
    
    public SaleTest() {
    }

   
    
    @Test
    public void testAddItemToList(){
        Sale sale = new Sale();
        Amount quantity = new Amount(1);
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999; 
        Item item = new Item(name, VAT, price, identifier);
        ItemDTO itemDTO = item.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, quantity);
        assertNotNull(saleItemOne);
        assertEquals(saleItemOne.getQuantity(), quantity);
        assertEquals(saleItemOne.getName(), "Tjack");
    }
    
    @Test
    public void testAddSaleItemToList(){
        Sale sale = new Sale();
        Amount quantity = new Amount(1);
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999; 
        Item item = new Item(name, VAT, price, identifier);
        ItemDTO itemDTO = item.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, quantity);
        sale.addSaleItemToList(saleItemOne);
        List<SaleItem> list = sale.getSaleList();
        SaleItem saleItemCompare = list.getFirst();
        assertEquals(saleItemCompare.getName(), saleItemOne.getName());
    }
    
    @Test
    public void testCalculateTotalSaleAmountWithoutVAT(){
        Sale sale = new Sale();
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999;
        Amount priceV2 = new Amount(50);
        Amount VATV2 = new Amount(10);
        String nameV2 = "Sko";
        int identifierV2 = 998; 
        Item item = new Item(name, VAT, price, identifier);
        Item itemV2 = new Item(nameV2, VATV2, priceV2, identifierV2);
        ItemDTO itemDTO = item.toDTO();
        ItemDTO itemDTOV2 =  itemV2.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, new Amount(1));
        SaleItem saleItemTwo = sale.addItemToSale(itemDTOV2, new Amount(1));
        sale.addSaleItemToList(saleItemOne);
        sale.addSaleItemToList(saleItemTwo);
        Amount compare = sale.calculateTotalSaleAmountWithoutVAT();
        Amount excepted = new Amount(100);
        assertEquals(compare.getAmount(), excepted.getAmount());
    }
    
    @Test
    public void testCalculateTotalSaleAmountWithVAT(){
        Sale sale = new Sale();
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999;
        Amount priceV2 = new Amount(50);
        Amount VATV2 = new Amount(10);
        String nameV2 = "Sko";
        int identifierV2 = 998; 
        Item item = new Item(name, VAT, price, identifier);
        Item itemV2 = new Item(nameV2, VATV2, priceV2, identifierV2);
        ItemDTO itemDTO = item.toDTO();
        ItemDTO itemDTOV2 =  itemV2.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, new Amount(1));
        SaleItem saleItemTwo = sale.addItemToSale(itemDTOV2, new Amount(1));
        sale.addSaleItemToList(saleItemOne);
        sale.addSaleItemToList(saleItemTwo);
        Amount compare = sale.calculateTotalSaleAmountWithVAT();
        Amount excepted = new Amount(110);
        assertEquals(compare.getAmount(), excepted.getAmount(),001);
    }
    
    @Test
    public void TestCalculateTotalSaleVAT(){
        Sale sale = new Sale();
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999;
        Amount priceV2 = new Amount(50);
        Amount VATV2 = new Amount(10);
        String nameV2 = "Sko";
        int identifierV2 = 998; 
        Item item = new Item(name, VAT, price, identifier);
        Item itemV2 = new Item(nameV2, VATV2, priceV2, identifierV2);
        ItemDTO itemDTO = item.toDTO();
        ItemDTO itemDTOV2 =  itemV2.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, new Amount(1));
        SaleItem saleItemTwo = sale.addItemToSale(itemDTOV2, new Amount(1));
        sale.addSaleItemToList(saleItemOne);
        sale.addSaleItemToList(saleItemTwo);
        sale.calculateInfo();
        Amount compare = sale.calculateTotalSaleVAT();
        Amount excepted = new Amount(10);
        assertEquals(compare.getAmount(), excepted.getAmount(),001);
    }
    
    @Test
    public void testCalculateInfo(){
     Sale sale = new Sale();
        Amount price = new Amount(50);
        Amount VAT = new Amount(10);
        String name = "Tjack";
        int identifier = 999;
        Amount priceV2 = new Amount(50);
        Amount VATV2 = new Amount(10);
        String nameV2 = "Sko";
        int identifierV2 = 998; 
        Item item = new Item(name, VAT, price, identifier);
        Item itemV2 = new Item(nameV2, VATV2, priceV2, identifierV2);
        ItemDTO itemDTO = item.toDTO();
        ItemDTO itemDTOV2 =  itemV2.toDTO();
        SaleItem saleItemOne = sale.addItemToSale(itemDTO, new Amount(1));
        SaleItem saleItemTwo = sale.addItemToSale(itemDTOV2, new Amount(1));
        sale.addSaleItemToList(saleItemOne);
        sale.addSaleItemToList(saleItemTwo);
        sale.calculateInfo();
        Amount priceNoVAT = sale.getTotalPriceWithoutVAT();
        Amount priceVAT = sale.calculateTotalSaleAmountWithVAT();
        Amount totalVAT = sale.calculateTotalSaleVAT();
        double expectedOne = 100;
        double expectedTwo = 110; 
        double expectedThree = 10; 
        assertEquals(priceNoVAT.getAmount(), expectedOne, 0.0001);
        assertEquals(priceVAT.getAmount(), expectedTwo,0.0001);
        assertEquals(totalVAT.getAmount(), expectedThree,0.0001);
    }

    
    
}
