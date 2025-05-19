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
import se.kth.iv1350.mypos.DTO.SaleDTO;

/**
 *
 * @author jojoa
 */
public class FinalSaleInfoTest {
    
    public FinalSaleInfoTest() {
    }

    @Test
    public void testCalculateChange() {
        Amount cash = new Amount(100);
        LocalTime time = LocalTime.now();
        Amount priceNoVAT = new Amount(50);
        Amount VAT = new Amount(10);
        Amount priceWithVat = new Amount(55);
        Amount priceToPay = new Amount(55);
        List<SaleItem> list = new ArrayList<>();
        Sale sale = new Sale();
        sale.totalPriceWithVAT = priceWithVat;
        sale.totalPriceToPay = priceToPay;
        FinalSaleInfo finalsale = new FinalSaleInfo(sale);
        Amount change = finalsale.calculateChange(cash);
        Amount expectedChange = new Amount(45);
        assertEquals(change.getAmount(), expectedChange.getAmount());
    }

    @Test
    public void testPay() {
        Amount cash = new Amount(105);
        LocalTime time = LocalTime.now();
        Amount priceNoVAT = new Amount(50);
        Amount VAT = new Amount(10);
        Amount priceToPay = new Amount(60);
        Amount priceWithVat = new Amount(55);
        List<SaleItem> list = new ArrayList<>();
        Sale sale = new Sale();
        sale.saleTime = time;
        sale.totalPriceWithVAT = priceWithVat;
        sale.totalPriceWithoutVAT = priceNoVAT;
        sale.totalPriceToPay = priceToPay;
        sale.totalVAT = VAT;
        FinalSaleInfo finalsale = new FinalSaleInfo(sale);
        Payment paid = new Payment(cash);
        finalsale.pay(paid);
        assertEquals(45.00, finalsale.getChange().getAmount());
        assertEquals(60.00, finalsale.getPaid().getAmount());
    }

    @Test
    public void testCreateReceipt() {
        Amount cash = new Amount(100);
        LocalTime time = LocalTime.now();
        Amount priceNoVAT = new Amount(50);
        Amount VAT = new Amount(10);
        Amount priceWithVat = new Amount(55);
        List<SaleItem> list = new ArrayList<>();
        Sale sale = new Sale();
        sale.totalPriceWithVAT = priceWithVat;
        sale.totalPriceToPay = priceWithVat;
        FinalSaleInfo finalsale = new FinalSaleInfo(sale);
        Receipt rece = finalsale.createReceipt(finalsale);
        assertNotNull(rece);
        
    }

    
    
}
