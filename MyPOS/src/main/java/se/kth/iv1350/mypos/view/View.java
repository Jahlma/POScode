/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.view;

import java.util.Scanner;
import se.kth.iv1350.mypos.DTO.ItemDTO;
import se.kth.iv1350.mypos.DTO.SaleDTO;
import se.kth.iv1350.mypos.controller.Controller;
import se.kth.iv1350.mypos.exceptions.OperationFailedException;
import se.kth.iv1350.mypos.exceptions.SystemDownFailureException;
import se.kth.iv1350.mypos.logger.Logger;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.CustomerID;
import se.kth.iv1350.mypos.model.FinalSaleInfo;
import se.kth.iv1350.mypos.model.SaleObserver;
import se.kth.iv1350.mypos.model.TotalRevenueFileOutput;
import se.kth.iv1350.mypos.model.TotalRevenueView;

/**
 * A placeholder for the real view. It contains hardcoded executions to system operations in the controller.
 * 
 */
public class View{
    private Controller contr;
    private Logger logger;
   
    
    public View(Controller contr, Logger logger){
        this.contr = contr;
        this.logger = logger;
        SaleObserver consoleObserver = new TotalRevenueView();
        contr.addSaleObserver(consoleObserver);
    }
    
    public void runFakeEX() {
         
        startSale();
        scanningItem(1002);
        scanningItem(1004);
        scanningItem(1001);
        scanningItem(1000);
        scanningItem(1006);
        scanningItem(1006);
        scanningItem(2);
        scanningItem(1010);
        CustomerID customerOne = new CustomerID("Bosse Andersson", new Amount(1968));
        allItemScanned(false, customerOne);
        finalizeSale();
        
        startSale();
        scanningItem(1002);
        scanningItem(1004);
        scanningItem(1006);
        scanningItem(1003);
        scanningItem(1008);
        scanningItem(1007);
        CustomerID customerTwo = new CustomerID("John Guidetti", new Amount(1992));
        allItemScanned(true, customerTwo);
        finalizeSale();
       
    
    }
    
    private void scanningItem(int itemIdentifier){
    ItemDTO itemDTO;
        try{
            itemDTO = contr.scanning(itemIdentifier);
                if(itemDTO == null){
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("The product with identifier " + itemIdentifier + " already exsist in current sale please write the total amount of quantity of said product! ");
                    int quantityAsInt = scanner.nextInt();
                    Amount quantity = new Amount(quantityAsInt);
                    itemDTO = contr.itemAlreadyInSale(quantity, itemIdentifier);
                }
            System.out.println("One scan confirmed and completed:" + " Item " + itemDTO.getName() + " has been added " + " Price: " + itemDTO.getPrice() + " VAT " + itemDTO.getVAT());
        }
        catch(OperationFailedException e){
            System.out.println("Product with identifier " + itemIdentifier + " does not represent any item in system");
            logger.log("Identifier" + itemIdentifier + " was not identified as a product that represents an item. " + itemIdentifier + " is not part of item identifiers database. More information regarding exception: " + e.getMessage() );
        }
        catch(SystemDownFailureException e){
            System.out.println("Server was not reachable when scanning for item: " + itemIdentifier + ". Program could not complete operation, try agian");
            logger.log("When item with identifier " + itemIdentifier + " was scanned a system database failure was found. Root cause and affected system:  " + e.getMessage());
        }  
    } 
    
    private void allItemScanned(boolean askForDiscount, CustomerID id){
    SaleDTO sale;
    sale = contr.allItemScanned(askForDiscount, id);
    System.out.println("Operator has ended sale");
    System.out.println("Total amount to pay incl. VAT: " + sale.getTotalPriceWithVAT().getAmount() + " kr");
    }
    
    private void finalizeSale(){
    int pay;
    Amount amount;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter how much cash to pay with");
    pay = scanner.nextInt();
    amount = new Amount(pay);   
    contr.finalizeSale(amount);
    }
    
    private void startSale(){
    contr.saleStart();
    System.out.println("A new sale has been started by operator");
    }
    

}
