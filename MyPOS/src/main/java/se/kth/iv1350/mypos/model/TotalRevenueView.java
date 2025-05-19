/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.model;

/**
 *
 * @author jojoa
 */
public class TotalRevenueView implements SaleObserver{
    Amount totalOfAllSales = new Amount(0);
    @Override
    public void update(Amount total){
        totalOfAllSales =  total.add(totalOfAllSales);
        System.out.println("Display that shows total made by all sales: " + totalOfAllSales.toString());
    }
}
