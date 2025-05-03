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
import se.kth.iv1350.mypos.DTO.SaleDTO;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.model.Payment;
import se.kth.iv1350.mypos.model.SaleItem;

/**
 *
 * @author jojoa
 */
public class AccountingTest {
    
    public AccountingTest() {
    }

    @Test
    public void testUpdateAccountingInfo() {
        LocalTime time = LocalTime.now();
        Amount price = new Amount(25);
        Amount VAT = new Amount(50);
        Amount priceVAT = new Amount(50);
        Amount amount = new Amount(50);
        List<SaleItem> list = new ArrayList<>();
        Accounting acc = new Accounting(amount);
        SaleDTO sale = new SaleDTO(time,price,VAT,priceVAT,list);
        FinalSaleInfo finalSale = new FinalSaleInfo(sale);
        Payment paid = new Payment(new Amount(100));
        finalSale.pay(paid);
        Amount updatedAccountValue = acc.calculateForAccounting(finalSale);
        assertEquals(100.00, updatedAccountValue.getAmount());
        
    }

    @Test
    public void testCalculateForAccounting() {
        Amount start = new Amount(75);
        Accounting acc = new Accounting(start);

        SaleDTO saleDTO = new SaleDTO(LocalTime.now(), new Amount(30), new Amount(10), new Amount(100), new ArrayList<>());
        FinalSaleInfo finalSale = new FinalSaleInfo(saleDTO);
        Payment payment = new Payment(new Amount(100));
        finalSale.pay(payment);

        Amount result = acc.calculateForAccounting(finalSale);
        assertEquals(175, result.getAmount(), 0.001); // 100 
    }
    
    @Test
    public void testConstructorAccounting() {
        Amount amount = new Amount(0);
        Accounting acc = new Accounting(amount);
        assertNotNull(acc);
    }
}
