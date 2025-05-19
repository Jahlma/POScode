/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package se.kth.iv1350.mypos.integration;


import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.mypos.DTO.SaleDTO;
import se.kth.iv1350.mypos.exceptions.InventoryDatabaseException;
import se.kth.iv1350.mypos.model.Amount;
import se.kth.iv1350.mypos.model.Item;

/**
 * Creates an instance of a external inventory database. 
 * 
 */
public class Inventory {
    private List<String> listOfItems;
    private List<Integer> indexList;
    public Inventory(){
        listOfItems = new ArrayList<>();
        indexList = new ArrayList<>();
    }
    
    /**
    * Method initiate what is to be used an represent the external inventory system.
    * 
    */
    public List<String> initiateList(){
        listOfItems.add("1001,Mjölk,15.90,12");
        listOfItems.add("1002,Bröd,24.50,12");
        listOfItems.add("1003,Ägg,32.00,12");
        listOfItems.add("1004,Smör,39.90,12");
        listOfItems.add("1005,Ost,59.00,12");
        listOfItems.add("1006,Kaffe,72.00,25");
        listOfItems.add("1007,Choklad,22.90,25");
        listOfItems.add("1008,Toapapper,49.90,25");
        listOfItems.add("1009,Diskmedel,34.50,25");
        listOfItems.add("1010,Socker,18.90,12");
        return listOfItems;
    }
    
    /**
    * Method is used to collect and return an item from a identifier
    * @param itemIdentifier itemIdentifier of an item.
    */
    public Item getInfoOfItem(int itemIdentifier) throws InventoryDatabaseException{
    String itemString;
    Item item;
    if(itemIdentifier == 1009){
        throw new InventoryDatabaseException("Database that holds information of inventory and item information is not available. System could not be reached");
    }
    itemString = findRightItem(listOfItems, itemIdentifier);
    return item = createItemFromString(itemString);
    }
    
    /**
    * Method is used create an new instance of an item from a string.
    * @param itemString String collected from external inventory system.
    */
    public Item createItemFromString(String itemString) {
    String[] parts = divideString(itemString);
    int id = convertToIntegerFromString(parts,0);
    String name = parts[1];
    Amount price = new Amount(convertToDoubleFromString(parts,2)); 
    Amount vat = new Amount(convertToDoubleFromString(parts,3));
    return new Item(name, vat, price, id); 
    }
    
    /**
    * Method is used to go through inventory and find right index to collect right string for specified item.  
    * @param listOfItems Represents external inventory as a list with strings
    * @param identifier Represents identifier for item to fetch.
    */
    private String findRightItem(List<String> listOfItems, int identifier){
        String[] partsIndex;
        for(String item : listOfItems){
        partsIndex = divideString(item);    
        indexList.add(convertToIntegerFromString(partsIndex, 0));
        }
            for(int i = 0; i < indexList.size(); i++){
               if(identifier == indexList.get(i)){
                   return listOfItems.get(i);
               }                  
           }          
        return null;       
    }
            


    /**
    * Method checks if the item identifier exist in the inventory
    * @param itemIdentifier hold information of final sale.
    */
    public boolean itemExists(int itemIdentifier) {
        String[] parts;
        int id;
        for (String item : listOfItems) {
            parts = divideString(item);
            id = convertToIntegerFromString(parts,0);
            if (id == itemIdentifier) {
                return true;
            }
        }
    return false;
    }
    
    public List<String> updateInventoryInfo(SaleDTO saledto){
        return listOfItems;
    }
    
    /**
    * Method takes a String and divides it at every comma.
    * @param item a string that gets divided. 
    */
    public String[] divideString(String item){
       String[] parts;
       parts = item.split(",");
       return parts;
    }
    
    /**
    * Method takes a part of a String and converts it to a type int.
    * @param parts string array of divided string
    * @param i index used for array
    */
    public int convertToIntegerFromString(String[] parts, int i){
        
        return Integer.parseInt(parts[i]);
         
    }
     
    /**
    * Method takes a part of a String and converts it to a type double.
    * @param parts string array of divided string
    * @param i index used for array
    */
     public double convertToDoubleFromString(String[] parts, int i){
        
        return Double.parseDouble(parts[i]);
         
    }
}





