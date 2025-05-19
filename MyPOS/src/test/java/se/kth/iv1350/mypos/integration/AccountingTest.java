/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.integration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import se.kth.iv1350.mypos.DTO.SaleDTO;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.model.Payment;
import se.kth.iv1350.mypos.model.Sale;
import se.kth.iv1350.mypos.model.SaleItem;

/**
 *
 * @author jojoa
 */
public class AccountingTest {
    Accounting acc;
    public AccountingTest() {
    }
    
     @BeforeEach
    public void setup() {
        acc = Accounting.getAccounting();
        acc.totalAmountMadeBySale = new Amount(0);
    }

    @Test
    public void testUpdateAccountingInfo() {
        LocalTime time = LocalTime.now();
        Amount price = new Amount(25);
        Amount VAT = new Amount(50);
        Amount priceVAT = new Amount(50);
        Amount amount = new Amount(50);
        List<SaleItem> list = new ArrayList<>();
        acc.totalAmountMadeBySale = amount;
        Sale sale = new Sale();
        sale.totalPriceWithVAT = priceVAT;
        sale.totalPriceToPay = priceVAT;
        FinalSaleInfo finalSale = new FinalSaleInfo(sale);
        Payment paid = new Payment(new Amount(100));
        finalSale.pay(paid);
        Amount updatedAccountValue = acc.calculateForAccounting(finalSale.getSaleDTO());
        assertEquals(100.00, updatedAccountValue.getAmount());
        
    }

    @Test
    public void testCalculateForAccounting() {
       
        Sale sale = new Sale();
        sale.saleTime = LocalTime.now();
        sale.totalPriceWithVAT = new Amount(100);
        sale.totalVAT = new Amount(10);
        sale.totalPriceWithoutVAT = new Amount(30);
        sale.totalPriceToPay = new Amount(100);
        FinalSaleInfo finalSale = new FinalSaleInfo(sale);
        Payment payment = new Payment(new Amount(100));
        finalSale.pay(payment);

        Amount result = acc.calculateForAccounting(finalSale.getSaleDTO());
        assertEquals(100, result.getAmount(), 0.001); // 100 
    }
    
    @Test
    public void testConstructorAccounting() {
        
        Accounting acc = Accounting.getAccounting();
        assertNotNull(acc);
    }
}
