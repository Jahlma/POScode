/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.startup;
import java.util.List;
import se.kth.iv1350.mypos.controller.Controller;
import se.kth.iv1350.mypos.integration.Accounting;
import se.kth.iv1350.mypos.integration.Discount;
import se.kth.iv1350.mypos.integration.Inventory;
import se.kth.iv1350.mypos.integration.ItemIdentifier;
import se.kth.iv1350.mypos.integration.Printer;
import se.kth.iv1350.mypos.integration.Register;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.view.View;

/**
 * Main procedure which represent first initiation of inventory, view and controller. Starts the procedure and calls all active operations. 
 * 
 */
public class Main {
    
    public static void main(String[] args){
    Inventory inv = new Inventory();
    Register reg = new Register(new Amount(0));
    Accounting acc = new Accounting(new Amount(0));
    Discount disc = new Discount();
    ItemIdentifier eitem = new ItemIdentifier();
    Printer print = new Printer();
    Controller contr = new Controller(eitem, print, inv, disc, reg, acc);
    View view = new View(contr);
    List<String> inventory;
    FinalSaleInfo finalSale;
    int amount;
    inventory = inv.initiateList();
    view.runFakeEX();
    view.scanningItem(1006);
    view.scanningItem(1002);
    view.scanningItem(1003);
    view.scanningItem(1001);
    view.scanningItem(1006);
    view.allItemScanned();
    view.finalizeSale();
    
    
    }
}
