/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.mypos.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jojoa
 */
public class AmountTest {
    
    public AmountTest() {
    }

    @Test
    public void testAdd() {
        Amount first = new Amount(50);
        Amount second = new Amount(50);
        Amount expected = new Amount(100);
        Amount both = first.add(second);
        assertEquals(both.getAmount(), expected.getAmount());
        
    }
    
    public void testSub() {
        Amount first = new Amount(50);
        Amount second = new Amount(50);
        Amount expected = new Amount(0);
        Amount both = first.sub(second);
        assertEquals(both.getAmount(), expected.getAmount());
        
    }
    
    public void testMultiply() {
        Amount first = new Amount(50);
        Amount second = new Amount(2);
        Amount expected = new Amount(100);
        Amount both = first.multiply(second);
        assertEquals(both.getAmount(), expected.getAmount());
        
    }
    
    
    public void testConstructorAmount(){
        double value = 50;
        Amount first = new Amount(value);
        double get = first.getAmount();
        assertEquals(get, first);
    }
    
    public void testConvertToPercentage() {
        Amount first = new Amount(50);
        Amount second = new Amount(25);
        Amount expected = new Amount(1.5);
        Amount both = first.convertToPrecentage(second);
        assertEquals(both.getAmount(), expected.getAmount());
        
    }
    
    public void TestToString(){
        Amount first = new Amount(50);
        String string = "50";
        String expectedString = first.toString();
        assertEquals(string,expectedString);
    }
    

    
}
