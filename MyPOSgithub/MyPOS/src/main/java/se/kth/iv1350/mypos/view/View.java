/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.view;

import java.util.Scanner;
import se.kth.iv1350.mypos.controller.Controller;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.FinalSaleInfo;

/**
 * A placeholder for the real view. It contains hardcoded executions to system operations in the controller.
 * 
 */
public class View {
    private Controller contr; 
    
    public View(Controller contr){
    this.contr = contr;
    }
    
    public void runFakeEX() {
        
        contr.saleStart();
        System.out.println("A new sale has been started by operator");
    
    }
    
    public void scanningItem(int itemIdentifier){
    String toShow;
    toShow = contr.scanning(itemIdentifier);
    System.out.println("One scan confirmed and completed:" +  toShow ); 
    } 
    
    public FinalSaleInfo allItemScanned(){
    FinalSaleInfo finalSale;
    finalSale = contr.allItemScanned();
    System.out.println("Operator has ended sale");
    return finalSale;
    }
    
    public void finalizeSale(){
    int pay;
    Amount amount;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter how much cash to pay with");
    pay = scanner.nextInt();
    amount = new Amount(pay);   
    contr.finalizeSale(allItemScanned(), amount);
    }
}
