/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package se.kth.iv1350.mypos.discountStrategy;

import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.CustomerID;

/**
 *
 * @author jojoa
 */
public interface DiscountStrategy {
    Amount discount(Amount totalSaleValue, boolean wanted, CustomerID id);
}
